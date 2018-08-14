const router = require('express').Router();
var mysql = require('mysql');
var dbconfig = require('../config/database');
var conn = mysql.createConnection(dbconfig);

conn.connect();

router.get('/', function(req, res){

    conn.query("select * from Users;", function(err, rows){
        if(err){
            console.log(err);
            res.send(err);
        }

        res.send(rows);
    });
});

router.post('/login/', function(req, res){
    console.log(req.body.email);
    var email = req.body.email;

    var selectQuery = "select u.RawID as 'userId', " +
                    "  		 kg.RawID as 'groupId', " +
                    "        kg.GroupName as 'groupName', " +
                    "        (select count(*) " +
                    "        from GroupJoin " +
                    "        where GroupID = kg.RawID) as 'groupUserCount', " +
                    "        (select count(*) " +
                    "        from Votes " +
                    "        where GroupID = kg.RawID and IsComplete = 1) as 'completeVotes', " +
                    "        (select count(*) " +
                    "        from Votes " +
                    "        where GroupID = kg.RawID and IsComplete = 0) as 'notCompleteVotes', " +
                    "        u.RegDate as 'regDate', " +
                    "        u.LastLoginDate as 'lastLoginDate' " +
                    "from Users as u " +
                    "left outer join GroupJoin as gj on u.RawID = gj.UserID " +
                    "left outer join KP_Groups as kg on gj.GroupID = kg.RawID " +
                    "left outer join Votes as v on v.GroupID = kg.RawID " +
                    "where u.EMail = '" + email+ "' " +
                    "group by userId, groupId, groupName, groupUserCount, completeVotes, notCompleteVotes;";

    conn.query(selectQuery, function(err, rows) {
        if(err){
            console.log(selectQuery);
            res.send(err);
        }

        console.log(rows[0].userId + " " + rows[0].regDate+ " " + typeof(rows[0].lastLoginDate));
        var isfirst;
        if(rows[0].regDate.toString() == rows[0].lastLoginDate.toString()) {
            isfirst = true;
        }
        else {
            isfirst = false;
        }

        if(rows[0].groupName != null) {
            res.send(ResultSuccess(isfirst, rows[0].userId, GetResult(rows)));
        }
        else {
            res.send(ResultSuccess(isfirst, rows[0].userId, null));
        }
        
    });
});

var GetResult = function(rows) {
    var array = [];
    if(rows.length > 0 ) {
        for(var i = 0; i < rows.length; i++) {
            var row = {
                "groupId": rows[i].groupId,
                "groupName": rows[i].groupName,
                "groupUserCount": rows[i].groupUserCount,
                "completeVotes": rows[i].completeVotes,
                "notCompleteVotes": rows[i].notCompleteVotes
            }
            array.push(row);
        }   

    return array;
    }
}

var ResultSuccess = function(isfirst,userid, grouplist) {
    var result = 
    {
        "isFirst": isfirst,
        "userId" : userid,
        "groupList": grouplist
    }

    return result;
};

module.exports = router;
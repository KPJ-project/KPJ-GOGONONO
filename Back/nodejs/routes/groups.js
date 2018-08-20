const router = require('express').Router();
var mysql = require('mysql');
var dbconfig = require('../config/database');
var conn = mysql.createConnection(dbconfig);

conn.connect();

router.get('/', function(req,res) {
    conn.query("select * from KP_Groups;" , function(err, rows) {
        if(err) {
            console.log(err);
            res.send(err);
        }

        res.send(rows);
    });
});

// 그룹 만들기
router.post('/', function(req, res) {
    var groupname = req.body.groupName;
    var groupcode = req.body.groupCode;
    var userid = req.body.userId;

    var checkquery = "select * from KP_Groups where GroupCode = ?;";
    conn.query(checkquery, groupcode, function(err, rows){
        if(err) {
            console.log(err);
            res.send({"state": "dbConnect fail", "err": err});
        }
        if(rows.length > 0) {
            console.log(rows);
            res.send(AddSuccess(false, "중복 코드"));
        }
        else {
            console.log("생성가능");
            var groupParams = [groupname, groupcode, userid];
            var insertGroup = "INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ( ?, ?, ?, NOW(), NOW());";

            conn.query(insertGroup, groupParams, function(err, rows) {
                if(err) {
                    console.log(err);
                    res.send({"state": "KP_Groups insert fail", "err": err});
                }

                var joinParams = [rows.insertId, userid];
                var insertJoin = "INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (?, ?, NOW(), NOW());"
                conn.query(insertJoin, joinParams, function(err, rows){ 
                    if(err) {
                        console.log(err);
                        res.send({"state": "GroupJoin insert fail", "err": err});
                    }

                    console.log(rows);
                    res.send(AddSuccess(true, "모임 생성 성공"));
                });
            })
        }
        
    });
});

var CheckDuplicateCode = function(groupcode, callback) {
    console.log(groupcode);
    var checkquery = "select * from KP_Groups where GroupCode = ?;";
    var result;

    conn.query(checkquery, groupcode, function(err, rows) {
        if( err ) {
            console.log(err);
        }

        console.log(rows.length);
        if(rows.length > 0) {
            result = true;
        }
        else {
            restul = false;
        }
    });

    callback(result);
};


var AddSuccess = function(isSuccess, msg) {
    var result = {
        "isSuccess": isSuccess,
        "msg": msg
    };

    return result;
};

module.exports = router;
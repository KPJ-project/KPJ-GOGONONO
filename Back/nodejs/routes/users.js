const router = require('express').Router();
var mysql = require('mysql');
var dbconfig = require('../config/database');
var conn = mysql.createConnection(dbconfig);

conn.connect();

router.get('/', function(req, res){

    conn.query("select * from users;", function(err, rows){
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

    var selectQuery = "select * from users where email = '" + email+ "';";

    conn.query(selectQuery, function(err, rows) {
        if(err){
            console.log(selectQuery);
            res.send(err);
        }

        res.send(rows);
    });
});


module.exports = router;
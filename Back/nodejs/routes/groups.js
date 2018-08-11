const router = require("express").Router()
var mysql = require("mysql")
var dbconfig = require("../config/database")
var conn = mysql.createConnection(dbconfig)

conn.connect()

router.get("/", function(req, res) {
  conn.query("select * from kp_groups;", function(err, rows) {
    if (err) {
      console.log(err)
      res.send(err)
    }

    res.send(rows)
  })
})

module.exports = router

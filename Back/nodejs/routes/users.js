const router = require("express").Router()
var mysql = require("mysql")

var connection = mysql.createConnection({
  host: process.env.RDS_HOSTNAME,
  user: process.env.RDS_USERNAME,
  password: process.env.RDS_PASSWORD,
  port: process.env.RDS_PORT
})

connection.connect(function(err) {
  if (err) {
    console.error("Database connection failed: " + err.stack)
    return
  }

  console.log("Connected to database.")
})

connection.end()

conn.connect()

router.get("/", function(req, res) {
  conn.query("select * from users;", function(err, rows) {
    if (err) {
      console.log(err)
      res.send(err)
    }

    res.send(rows)
  })
})

module.exports = router

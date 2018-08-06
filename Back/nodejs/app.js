var express = require('express');
var app = express();

app.set('port',3000);

app.get('/', function(req, res) {
    res.send('GOGONONO API SERVER!');
});

app. listen(app.get('port'), function(){
    console.log('gogonono express server listening on port ' + app.get('port'));
});
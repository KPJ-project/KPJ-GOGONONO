var express = require('express');
var YAML = require('yamljs');
var swaggerUi = require('swagger-ui-express');
var swaggerDocument = YAML.load('./swagger.yaml');
var app = express();

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

app.set('port',3000);

app.get('/', function(req, res) {
    res.send('GOGONONO API SERVER!');
});

// 모임 관련 api
app.use('/groups', require('./routes/groups'));

// 유저 관련 api
app.use('/users', require('./routes/users'));

app. listen(app.get('port'), function(){
    console.log('gogonono express server listening on port ' + app.get('port'));
});
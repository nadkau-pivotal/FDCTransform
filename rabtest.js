var amqp = require('amqp');





var connection = amqp.createConnection(host: '192.168.109.51'
, port: 5672
, login: '82bf2d53-b95e-4251-98a9-90a805a0a5d8'
, password: 'fo15m71f5dssvcra9129vo0tgk'
, connectionTimeout: 10000
, vhost: 'e4d2c272-5dc7-4e36-80b8-5a798514120a');

// Wait for connection to become established.
connection.on('ready', function () {
  console.log("waiting for messages")
  // Use the default 'amq.topic' exchange
  connection.queue('hello', function (q) {
      // Catch all messages
      console.log("waiting for messages in queue")
      q.bind('#');

      // Receive messages
      q.subscribe(function (message) {
        // Print messages to stdout
        console.log(message);

      });
  });
});

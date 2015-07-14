
XD-CSV-JSON
===================
 
Steps for taking a csv file, converting it to JSON and streaming it to Gemfire through SpringXD.  What happens is that SpringXD File source monitors a directory for items to stream, then isolates each line of csv using a splitter.  In the custom Java module the String is separated into the individual values and then put into a HashMap.  This Map is returned as the payload to the SpringXD stream and then uses the built in transformer to convert the Map Object to Json.  Then the json is sent to Gemfire using the built in gemfire-json-server.  

Things to note
-This was built specifically for the orders data set contained in this repo, if you want to use a different data set you need to change the csvTransformer module.  
-This has only been tested on a single node SpringXD and Gemfire instance, to scale up you're going to need to do some testing on a larger system.  

Steps

1. Build the transformation files
> cd csvTransformationModule
>
> mvn clean package
 
2. upload your module to springxd
> module upload --name csvTransformer --type processor /target/csvtojson-0.0.1-SNAPSHOT.jar 


3. Deploy your stream

> stream create --name orderTransform --definition "file --outputType=text/plain | splitter --expression=payload.split('\\n') | csvTransformer | object-to-json | gemfire-json-server --host=localhost --port=41111 --useLocator=true --regionName=orderTest --keyExpression=payload.getField('orderID')" --deploy


4 Move your orders file into the directory that spring xd is monitoring
> cp orders.tsv /tmp/xd/input/orderTransform/


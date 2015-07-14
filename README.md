
XD-CSV-JSON
===================
 
Steps

1. Build the transformation files
> cd csvTransformationModule
> mvn clean package
 
2. upload your module to springxd
> module upload --name csvTransformer --type processor /target/translator-0.0.1-SNAPSHOT.jar 


3. Deploy your stream

> stream create --name orderTransform --definition "file --outputType=text/plain | splitter --expression=payload.split('\\n') | csvTransformer | object-to-json | gemfire-json-server --host=localhost --port=41111 --useLocator=true --regionName=orderTest --keyExpression=payload.getField('orderID')" --deploy


4 Move your orders file into the directory that spring xd is monitoring
> cp orders.tsv /tmp/xd/input/orderTransform/


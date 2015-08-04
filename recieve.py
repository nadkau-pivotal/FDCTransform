#!/usr/bin/env python
import pika

# connection = pika.BlockingConnection(pika.ConnectionParameters(
#         host='192.168.109.51',username='82bf2d53-b95e-4251-98a9-90a805a0a5d8',
#         password='fo15m71f5dssvcra9129vo0tgk',vhost='e4d2c272-5dc7-4e36-80b8-5a798514120a'))
credentials= pika.PlainCredentials('82bf2d53-b95e-4251-98a9-90a805a0a5d8','fo15m71f5dssvcra9129vo0tgk')
connection = pika.BlockingConnection(pika.ConnectionParameters("192.168.109.51",5672,
"e4d2c272-5dc7-4e36-80b8-5a798514120a",credentials))
channel = connection.channel()





channel.queue_declare(queue='hello')

def callback(ch,method,properties,body):
	print " [x] Recieved %r" % (body,)

channel.basic_consume(callback,queue='hello',no_ack=True)
print ' [*] Waiting for messaces.'
channel.start_consuming()

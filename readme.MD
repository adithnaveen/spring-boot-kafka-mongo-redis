# This file contins all the command for starting service. 


Softwares links 
---------------------

https://kafka.apache.org/downloads 

https://redis.io/download

https://www.mongodb.com/download-center/community

Tutorials 
--------------------------------

https://spring.io/guides



Apache Kafka 
-------------------------------------------------------------------------------------------------------------


Step 1 : Create ZooKeeper 
	.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Step 2: Start Kafka Server 
	.\bin\windows\kafka-server-start.bat .\config\server.properties

Step 3: Create Topic (You can create multiple topics) 
	.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic topic1

Step 4: Create a Producer 
	.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic topic1

Step 5: Create a Consumer 
	(there are various options, you can get from the specific partition 
		by given --partition 1 )
	.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1 --from-beginning
	
Setp 6(Optional) : Show the topics which are running 
	.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list
	
Step 7 : To Delete the topic 
	.\bin\windows\kafka-topics.bat --zookeeper  localhost:2181 --topic topic1 --delete

Step 8: isr -> Insync Replicas 	(Get the description of the particular topic)
	.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --describe --topic topic1



Redis 
------------------------------------------------------------------------------------------------


https://redis.io/download

to start redis server 
> ./src/redis-server

to start redis 
> ./src/redis-cli



Mongodb 
------------------------------------------------------------------------------------------------
to start mongod 
> mongod --dbpath <path> --port <number>

-- to open the client (in another terminal)
> mongo 

Class Notes 
---------------------------------

SpringBoot 
MicroService - SpringBoot 
NoSQL DB - ~ MongoDB
Messaging - ~ Kafka 
Cahcing - ~ Redis 


AppServer - private
DBServer - private 
API Gateway - public 

950 - 1100 / per sec (DBMS - mysql, oracle, DB2) - ACID 
~10000 / per sec (NoSQL - mongodb, cassandra etc) - no ACID 
Cache - Redis/Memcache - (key/value paid) - NO ACID 


---------------------------------------------
server.port=8761
spring.application.name=eureka-naming-server
----------------------------------------------
2181 - zookeepr 
9092 - kafka 
27107 - MongoDB 
6379 - redis 
8761 - server.port [Eureka]
9090 - product service 
8765 - zuul [API Gateway]



redis has src folder dont look for ./bin 

Kafka - rabbit mq, open mq, mq series, tibco 


windows : c:\data 
unis /data 

http://localhost:9090/products  - product-service 
http://localhost:9190 - employee-service 
http://localhost:9290 - login-service 


http://localhost:8765/product-service/api/products 
http://localhost:8765/employee-service/api/employees
http://localhost:8765/login-service/api/validate 







 



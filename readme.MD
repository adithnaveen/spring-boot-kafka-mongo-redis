# this file contins all the command for starting service. 

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



redis 
------------------------------------------------------------------------------------------------


mongodb 

------------------------------------------------------------------------------------------------

//package com.example.ls_task;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class mongoApp {
////    System.out.println("Connecting to DB...");
////    List<MongoCredential> credentialsList = new ArrayList<>();
////    //Use username, authtication database and password in MongoCredential object
////    MongoCredential creds = MongoCredential.createCredential("db_user", "admin", "db_password".toCharArray());
////credentialsList.add(creds);
////    ServerAddress serverAddress = new ServerAddress("localhost", 27017); //host and port
////    MongoClient mongoClient = new MongoClient(serverAddress, credentialsList);
////System.out.println("Connected to MongoDB...");
//
////    MongoClient mongoClient = new MongoClient("localhost", 27017);
////    mongoClient.getDatabaseNames().forEach(System.out::println)
//}

//{
//  "employees": [
//    {
//      "_id":"60d868c9a3a4ab476bd79430",
//      "name":"Roni Bonim",
//      "companyId":"60d86c3ea3a4ab476bd79431",
//      "phone":"05099983765",
//      "address":"Rothschild 22 Tel Aviv",
//      "picture":"",
//      "dateStart":{
//        "$date":{
//          "$numberLong":"1624741200000"
//        }
//      },
//      "employeeType":"watching"
//    },
//    {
//      "_id":"60d86d18a3a4ab476bd79432",
//      "name":"Alex Shvarts",
//      "companyId":"60d86df5a3a4ab476bd79433",
//      "phone":"05099983765",
//      "address":"Trumpeldor 1 Petach Tikva",
//      "picture":"",
//      "dateStart":{
//        "$date":{
//          "$numberLong":"1624914000000"
//        }
//      },
//      "employeeType":"admin"
//    }
//  ]
//}

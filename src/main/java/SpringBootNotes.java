public class SpringBootNotes {
}

/*
                                            What is SpringBoot:
It is a framework for building applications in the Java programming language.
Spring Boot makes it easy to create stand-alone,production-grade Spring based Applications that you can just run.

The core Spring framework already reduces boilerplate code and provides a lot of helpful features for Java applications.
However,Spring Boot takes this convenience to the next level by focusing specifically on reducing the effort required to set up and configure a Spring application.
While Spring does simplify many tasks like:
-creating web applications
-working with databases
-managing transactions and more,
But setting up a Spring project can still involve quite a bit of manual configuation.
Without Spring Boot,setting up a basic Restful API requires manual configuration.
we need to manually set up the Spring application context in the main method.

This is where Spring Boot steps in:
-Auto-Configuaration
-Standalone Applications
We use the "@SpringBootApplication" annotation on thr main class. This single annotation replaces the need for setting up a manual SpringApplication context.
We no longed need to explicitly create an application context using "AnnotationConfigApplicationContext" as Spring Boot handles that behind the scenes.
We use SpringApplication.run()to start the application,and Spring Boot takes care of configuring the embedded web server and other necessary components.
The @SpringBootApplication annotation alone brings in a lot of pre-configured features,including automatic component scanning and embedded server configuration,which would have required more steps in a traditional Spring setup.

***************************************************************************************************************************************************************************

                                              ORM(Object Relational Mapping)
ORM is a technique used to map Java objects to database tables
It allows developers to work with databases using object-oriented programming concepts,making it easier to interact with relational databases.
Consider a java class User and a database table users.
ORM framework like hibernate can map the fields in the user class to columns in the users table, making ir easier to insert,update,retrieve and delete records.

**********************************************************************************************************************************************************************

                                            JPA(Java Persistence API)  (persistance = permenantly stores the data)
JPA= A way to achieve ORM,includes interfaces and annotations that you use in your Java classes, requires a persistance provider (ORM tools) for implementation.
To use JPA, you need a persistance provider.A persistance provider is a specific implementation of the JPA specification
Example of JPA persistance include Hibernate,EclipseLink,and OpenJPA.
These providers implement the  JPA interfaces and provide the underlying functionality to interact with databses.

***********************************************************************************************************************************************************************

                                             Spring Data JPA
It is built on top of the JPA(Java Persistance API) but it is not a JPA implementation itself.
Instead,it simplifies working with JPA by providing higher-level abstractions and utilites.
However,to use Spring Data JPA effectively,you still need a JPA implementation,
such as Hibernate,EclipseLink, or another JPA-complimant provider,to handle the actual database interactions.

JPA is primarily designed for woking with relational databaes, where data is stored in tables with a predefined schema
MongoDB,on the other hand,is a NOSQL databse that used a different data model,typilcally based on collection of documents,
which are schema-less or have flexible schemas.
This fundamental difference in data models and storage structurs is why
"JPA is not used with MongoDB"

In the case of MongoDB,you dont have a traditional JPA persistance provider..
MongoDB is a NoSQL database and "Spring Data MongoDB" serves as the "persistence provider"for MongoDB.
It provides the necessary abstractions and implementations to work with MongoDB in a Spring application.
"Query Method DSL and Criteria API" are two different ways to interact with a database when using Spring Data JPA for relational databases and
Spring Data MongoDB for MongoDB databases.
Spring Data JPA is a part of the Spring Framework that simplifies data access in Java applications,
while Spring Data MongoDB provides similar functionality for MongoDB.
Query Method DSL is a simple and convenient way to create queries based on method naming conventions,
while the "Criteria API" offers a more dynamic and programmatic approach for building complex and custom queries.

***********************************************************************************************************************************************************************
 */
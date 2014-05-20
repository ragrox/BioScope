package com.bioscope.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.bioscope.config.SpringMongoConfig;
 

//import org.springframework.context.support.GenericXmlApplicationContext;
 
public class App {
 
    public static void main(String[] args) {
 
	// For XML
	//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
 
	// For Annotation
	ApplicationContext ctx = 
             new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
 
/*	User user = new User();
	user.setUserName("Raghav");
	// save
	mongoOperation.save(user);
	String searchTerm = "the";
	Query searchUserQuery = new Query(Criteria.where("movieName").regex(searchTerm ,"i"));

	List<Movie> movieResult = mongoOperation.find(searchUserQuery, Movie.class);
	System.out.println(movieResult.size());
	// now user object got the created id.
	System.out.println("1. user : " + user);
 
	// query to search user
	 searchUserQuery = new Query(Criteria.where("userName").is("Raghav"));
 
	// find the saved user again.
	User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	System.out.println("2. find - savedUser : " + savedUser);
 
	// update password
	mongoOperation.updateFirst(searchUserQuery, 
                         Update.update("password", "new password"),User.class);
 
	// find the updated user object
	User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
 
	System.out.println("3. updatedUser : " + updatedUser);
 
	// delete
	mongoOperation.remove(searchUserQuery, User.class);
 
	// List, it should be empty now.
	List<User> listUser = mongoOperation.findAll(User.class);
	System.out.println("4. Number of user = " + listUser.size());*/
 
    }
 
}
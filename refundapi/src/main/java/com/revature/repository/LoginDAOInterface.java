package com.revature.repository;

import java.util.List;

import com.revature.entities.Login;

public interface LoginDAOInterface {
    /*
     * This interface is where I will declare the methods that I need to test. All methods I create here will by default be considered public and abstract
     * 
     * public: can be accessed anywhere
     * abstract: the implementation for the method must be handled elsewhere
     */

     // creates
     /*
       I chose the Book return type because Hibernate has an easy way of returning the generated ID so I can add it to my newUser and return it as the result 
       which makes for an easy validation in my tests

       I chose the Login object (refering to entity "Login.java") to be my parameter because it provides an easy way for me to get both the username and 
       user_password into the database. It can also hold the newly generated ID and I can check it to make sure my method is working correctly
      */

    //creates
     Login addUser(Login newUser);
     

    // reads
     List<Login> getAllUsers();


    //  // updates
     Login updateUser(Login updatedUser); 

     // deletes
     boolean removeUser(Login userToBeDeleted);  


}

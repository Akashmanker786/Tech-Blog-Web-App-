package com.techblog.dao;

import com.techblog.entities.User;
import  java.sql.*;

public class UserDao {
       private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
       
     // method to insert user data into database;
    
     public boolean saveUser(User user){
          boolean flag = false;
         
          try {
            
             String query = "insert into user_register(name,email,password,gender,about) values (?,?,?,?,?)";
             
             PreparedStatement pstmt = this.con.prepareStatement(query);
             
             pstmt.setString(1,user.getName());
             pstmt.setString(2,user.getEmail());
             pstmt.setString(3,user.getPassword());
             pstmt.setString(4,user.getGender());
             pstmt.setString(5,user.getAbout());
              
             pstmt.executeUpdate();
             flag = true;
          } 
         catch (Exception e) {
            System.out.println(e);
         }
        
          return flag;
     }
     
     // fetching user in DB by email and password
     
     public User getUserByEmailAndPassword(String email,String password){
         User user  = null;
         
         try {
             
             String query = "Select * from user_register where email=? and password=?";
             
             PreparedStatement pstmt = con.prepareStatement(query);
             pstmt.setString(1, email);
             pstmt.setString(2,password);
             
            ResultSet set = pstmt.executeQuery();
            
            if(set.next()){
                user = new User();
                
//                data from db
                 String name = set.getString("name");
//                  setting to user object
                 user.setName(name);
                 
                 user.setId(set.getInt("id"));
                 user.setEmail(set.getString("email"));
                 user.setPassword(set.getString("password"));
                 user.setGender(set.getString("gender"));
                 user.setAbout(set.getString("about"));
                 user.setDateTime(set.getTimestamp("r_date"));
                 user.setProfile(set.getString("profile"));
                
            }
            
            
         } catch (Exception e) {
          System.out.println(e);
         }
         
         
      return user;
     }
     
     public boolean updateUser(User user){
         boolean flag = false;
         try {
             
             String query = "update user_register set name=? , email=? , password=? , gender=?, about=? , profile=? where id = ? ";
              
             PreparedStatement pstmt = con.prepareStatement(query);
             
             pstmt.setString(1,user.getName());
             pstmt.setString(2,user.getEmail());
             pstmt.setString(3,user.getPassword());
             pstmt.setString(4,user.getGender());
             pstmt.setString(5,user.getAbout());
             pstmt.setString(6,user.getProfile());
             pstmt.setInt(7,user.getId());
                          
             pstmt.executeUpdate();
             flag = true;
             
         } catch (Exception e) {
           System.out.println(e);
         }
         
       return flag;
     }
      
     
//        method to get user by userId
        public User getUserByUserId(int userId){
            User user = null;
            
            try {
                
            String query = "select * from user_register where id=?";
            
            PreparedStatement pst = this.con.prepareStatement(query);
            
            pst.setInt(1, userId);
            
           ResultSet set =  pst.executeQuery();
           
           if(set.next()){
             user = new User();
                
//                data from db
                 String name = set.getString("name");
//                  setting to user object
                 user.setName(name);
                 
                 user.setId(set.getInt("id"));
                 user.setEmail(set.getString("email"));
                 user.setPassword(set.getString("password"));
                 user.setGender(set.getString("gender"));
                 user.setAbout(set.getString("about"));
                 user.setDateTime(set.getTimestamp("r_date"));
                 user.setProfile(set.getString("profile"));  
               
           }
           
           
            } catch (Exception e) {
              e.printStackTrace();
            }
            
                    
            return user;
        }
     
}










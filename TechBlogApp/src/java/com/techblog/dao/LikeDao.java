package com.techblog.dao;

import java.sql.*;

public class LikeDao {

    Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }

//   method to insert likes on database 
    public boolean insertLike(int pId, int uId) {

        boolean flag = false;

        try {
            String query = "insert into likes(pId,uId) values (?,?)";

            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setInt(1, pId);
            pstmt.setInt(2, uId);
            pstmt.executeUpdate();

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    
    public int  countLikeOnPost(int pId) {

        int count = 0;

        try {

            String query = "Select count(*) from likes where pId = ? ";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, pId);
            
            ResultSet set = pst.executeQuery();

            if (set.next()) {
                count = set.getInt("count(*)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
      return count;
    }

    
    public boolean isLikedByUser(int pId,int uId){
        boolean flag = false;
        
        try {
            PreparedStatement pst = this.con.prepareStatement("select * from likes where pId = ? and uId = ?");
            
            pst.setInt(1, pId);
            pst.setInt(2, uId);
            
            ResultSet set = pst.executeQuery();
            
            if(set.next()){
              flag = true;     
            }
        } 
           catch (Exception e) {
          e.printStackTrace();
        }
        
        return flag;
    }
    
    public boolean deleteLike(int pId , int uId){
        boolean flag = false;
        
        try {
             
            PreparedStatement pst = this.con.prepareStatement("delete from likes where pId=? and uId=? ");
            
             pst.setInt(1, pId);
             pst.setInt(2, uId);
             
             pst.executeUpdate();
             flag = true;
             
        } catch (Exception e) {
           e.printStackTrace();
        }
        return flag;
    }
    
    
}

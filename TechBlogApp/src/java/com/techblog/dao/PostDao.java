package com.techblog.dao;

import com.techblog.entities.Categories;
import com.techblog.entities.Posts;
import java.sql.*;
import java.util.*;

public class PostDao {

    Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Categories> getAllCategories() {
        ArrayList<Categories> list = new ArrayList<>();

        try {
            String query = "Select * from categories";

            Statement stmt = this.con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int cId = set.getInt("cId");
                String cName = set.getString("cName");
                String cDiscription = set.getString("cDiscription");

                Categories c = new Categories(cId, cName, cDiscription);

                list.add(c);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

//   method to add post data into db
    public boolean addPost(Posts post) {
        boolean flag = false;

        try {

            String query = "insert into posts(pId,pTitle,pContent,pPic,catId,userId) values (?,?,?,?,?,?)";

            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setInt(1, post.getpId());
            pstmt.setString(2, post.getpTitle());
            pstmt.setString(3, post.getpContent());
            pstmt.setString(4, post.getpPic());
            pstmt.setInt(5, post.getCatId());
            pstmt.setInt(6, post.getuserId());

            pstmt.executeUpdate();
            flag = true;

        } catch (Exception e) {
            System.out.println(e);
        }

        return flag;
    }

    //method to fetch all posts from DB
    public List<Posts> getAllPosts() {
        List<Posts> list = new ArrayList<Posts>();

        try {

            String query = "select * from posts order by pId desc";
            Statement stmt = this.con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int pId = set.getInt("pId");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int catId = set.getInt("catId");
                int userId = set.getInt("userId");

                Posts post = new Posts(pId, pTitle, pContent, pPic, pDate, catId, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Posts> getPostByCatId(int catId) {
        List<Posts> list = new ArrayList<>();

        try {

            String query = "select * from posts where catId=?";

            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setInt(1, catId);

            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                int pId = set.getInt("pId");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int userId = set.getInt("userId");

                Posts post = new Posts(pId, pTitle, pContent, pPic, pDate, catId, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Posts getPostByPostId(int pId) {
        Posts post = null;
        try {

            String query = "select * from posts where pId = ?";
            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setInt(1, pId);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {

                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int userId = set.getInt("userId");
                int catId = set.getInt("catId");

                post = new Posts(pId, pTitle, pContent, pPic, pDate, catId, userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }
}

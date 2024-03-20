/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.techblog.servlets;

import com.techblog.Helper.ConnectionProvider;
import com.techblog.Helper.Helper;
import com.techblog.dao.PostDao;
import com.techblog.entities.Posts;
import com.techblog.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.io.File;

/**
 *
 * @author Akash Manker
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
//            taking form input from user

            int cId = Integer.parseInt(request.getParameter("cId"));            
            String pTitle = request.getParameter("pTitle");
            String pContent = request.getParameter("pContent");
            Part part  = request.getPart("pImage");
            String imageName = part.getSubmittedFileName();
            
//            getting user id who is posting
              HttpSession session = request.getSession();
              User user = (User) session.getAttribute("currentUser");
              
              int userId = user.getId();
              
               Posts post = new Posts(pTitle, pContent, imageName,null, cId, userId);
               
//               send post object to PostDao to save data into db
                PostDao pDao = new PostDao(ConnectionProvider.getConnection());
                
               if( pDao.addPost(post)){
                   
                    String path = request.getServletContext().getRealPath("/") + "BlogImages" + File.separator + part.getSubmittedFileName();
                    out.println(); 
                    Helper.saveFile(part.getInputStream(), path);
                   out.println("done");
                   
               }
               else{
                   out.println("error");
               }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

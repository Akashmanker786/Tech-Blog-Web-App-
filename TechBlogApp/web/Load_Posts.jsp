<%@page  import="com.techblog.entities.User , com.techblog.entities.Message" %>
<%@page  import="com.techblog.entities.Posts , java.util.* , com.techblog.Helper.* ,com.techblog.dao.*" %>



<div class="row">
    <% 
        
         User u = (User) session.getAttribute("currentUser");
         
      PostDao pd = new PostDao(ConnectionProvider.getConnection());
  
      List<Posts> post = null; 
       
      int cid = Integer.parseInt(request.getParameter("cid"));
      
      if(cid == 0){
                  post   =    pd.getAllPosts();
        }
        else{
               post =  pd.getPostByCatId(cid);
        }
      
        if(post.size()==0){
         out.println("<h4 class='display-4 text-center' >NO Posts in this Category</h4>");
        }
        
       for(Posts p : post){
   
    %>
    <div class="col-md-6  mt-3">
        <div class="card">
            <div class="card-body" style="text-align: left">
                <img class="card-img-top mb-2" src="BlogImages/<%= p.getpPic() %>" alt="image not found"/>
                <b><%= p.getpTitle() %></b>
                <p><%= p.getpContent() %></p>
                <a href="show_post_detail.jsp?pId=<%= p.getpId() %>" class="btn btn-outline-primary btn-sm">Read More</a>
            </div>

            <% 
                         
                LikeDao ld = new LikeDao(ConnectionProvider.getConnection());
                
            %>

            <div class="card-footer primary-background" >
                <a href="#" onclick="doLike(<%= p.getpId()%>,<%= u.getId() %>)" class="btn btn-outline-light btn-sm mr-4"><i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%= ld.countLikeOnPost(p.getpId()) %></span></a>
                <a href="#" class="btn btn-outline-light btn-sm mr-4"><i class="fa fa-commenting-o"></i><span>100</span></a>
                <a href="#" class="btn btn-outline-light btn-sm mr-4"><i class="fa fa-share-square-o"></i><span>100</span></a>
            </div>
        </div>
    </div>     
    <%
     }


    %>
</div>
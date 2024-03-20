

<%@page  import="com.techblog.entities.Message" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>


        <link href="CSS/MyCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .banner-background{
                clip-path: polygon(50% 0, 100% 0, 100% 45%, 100% 88%, 78% 90%, 54% 99%, 22% 91%, 0 100%, 0 47%, 0 0);
            }
        </style>

    </head>

    <body>
        <!--navbar-->
        <%@include  file="My_navbar.jsp" %>


        <!--main login form-->
        <main class="d-flex align-items-center  primary-background banner-background" style="height: 70vh">

            <div class="container">

                <div class="row">

                    <div class="col-md-4 offset-md-4">

                        <div class="card">

                            <div class="card-header text-center primary-background text-white">
                                <span class="fa fa-user-plus fa-3x"></span>
                                <h4>Login here</h4>
                            </div>

                            <% 
                                Message m = (Message) session.getAttribute("msg");      
                            
                                if(m != null){
                                
                            %>
                            
                            <div class="alert <%= m.getCssClass() %>" role="alert">
                                <%= m.getContent() %>
                            </div>

                            <%
                                  session.removeAttribute("msg");
                                }
                            %>

                            <div class="card-body">
                                <form action="LoginServlet" method="POST">
                                    <div class="form-group">
                                        <label for="userEmail">Email address</label>
                                        <input name="userEmail" required="" type="email" class="form-control" id="userEmail" aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="userPassword">Password</label>
                                        <input name="userPassword" required="" type="password" class="form-control" id="userPassword" placeholder="Password">
                                    </div>

                                    <div class="container text-center"> 
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </form>
                            </div>


                        </div>

                    </div>


                </div>

            </div>


        </main>






        <!--        javaSrcipt -->

        <script src="https://code.jquery.com/jquery-3.7.1.slim.min.js" integrity="sha256-kmHvs0B+OpCW5GVHUNjv9rOmY0IvSIRcf7zGUDTDQM8=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="JavaScript/MyJavaSrcipt.js" type="text/javascript"></script>

    </body>
</html>

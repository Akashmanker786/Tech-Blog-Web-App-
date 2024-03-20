
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Something went wrong</title>


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

        <div class="container text-center">
            <img src="images/computer.png" class="img-fluid"  />  
            <br>
            <h3 class="display-3">Sorry! Something went wrong...</h3>

            <a href="index.jsp"><button class="btn  btn-lg primary-background text-white mt-3">Home</button>
            </a>
        </div>

    </body>
</html>

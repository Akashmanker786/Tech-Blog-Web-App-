
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>

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

        <main class=" primary-background p-2 banner-background ">

            <div class="container ">

                <div class="row">

                    <div class="col-md-6 offset-md-3">

                        <div class="card ">

                            <div class="card-header text-center primary-background">
                                <span class="fa fa-3x fa-user-circle"></span>
                                <br>
                                <h5>Register here</h5>
                            </div>


                            <div class="card-body">
                                <form id="regi-form" action="RegisterServlet" method="POST">

                                    <div class="form-group">
                                        <label for="user_name">User name</label>
                                        <input  name="user_name" type="text" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Enter user name">
                                    </div>


                                    <div class="form-group">
                                        <label for="user_email">Email address</label>
                                        <input name="user_email" type="email" class="form-control" id="user_email" aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>


                                    <div class="form-group">
                                        <label for="user_password">Password</label>
                                        <input name="user_password" type="password" class="form-control" id="user_password" placeholder="Password">
                                    </div>



                                    <div class="form-group">
                                        <label for="user_gender">Select gender</label>
                                        <br>
                                        <input type="radio"  id="user_gender" name="user_gender" value="Male" >Male
                                        <input type="radio"  id="user_gender" name="user_gender" value="Female" >Female       
                                    </div>


                                    <div class="form-group">
                                        <textarea name="user_about" class = "form-control "id=""  rows="3" placeholder="Enter something about yourself" ></textarea>  
                                    </div>


                                    <div class="form-check">
                                        <input name="user_check" type="checkbox" class="form-check-input" id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Agree to terms and Conditions</label>
                                    </div>
                                    <br>

                                    <div class="text-center">
                                        <div class="container" id="loader" style="display: none;">
                                            <span class="fa fa-refresh fa-spin fa-2x" ></span>
                                            <h4>Please wait...</h4>
                                        </div>
                                        <br>
                                        <button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>
                                    </div> 
                                </form>
                            </div>

                            <div class="card-footer">

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

        <script src="https://code.jquery.com/jquery-3.7.1.js"  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>



        <script>
            $(document).ready(function () {
                console.log("Document loaded...");


                $('#regi-form').on('submit', function (event) {
                    event.preventDefault();


                    $("#submit-btn").hide();
                    $("#loader").show();

//                     saving Form data into form variable
                    let form = new FormData(this);

//                     now sending to register servlet
                    $.ajax({
                        url: "RegisterServlet",
                        type: 'POST',
                        data: form,

                        success: function (data, textStatus, jqXHR) {
                            console.log(data);

                            $("#submit-btn").show();
                            $("#loader").hide();

                            if (data.trim() === 'done')
                            {
                                swal("Registered Successfully Redirecting to login page")
                                        .then((value) => {
                                            window.location = "Login_page.jsp"
                                        });
                            } else {
                                swal(data);
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $("#submit-btn").show();
                            $("#loader").hide();

                            swal("Something went wrong please try-again");


                        },

                        processData: false,
                        contentType: false

                    });


                });


            });
        </script>

    </body>
</html>

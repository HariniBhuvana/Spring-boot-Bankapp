<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body >


<%@ include file="header.jsp" %>

<div class="row m-2">
    <div class="col-md-6 mt-5 ml-5 mr-0 mb-5">
        <div class="card" style="width: 23rem; ">
            <div class="card-body">
                <h3>Your Money. Your Way</h3>
                
                <form action="login.do" method="post">
                    <div class="form-group input-group-md">
                        <label for="exampleInputEmail1">Customer ID</label>
                        <input type="number" name="custId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Customer ID">
                    </div>
                    <div class="form-group input-group-md">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm btn-block">Submit</button><br>
                    <c:if test="${requestScope.success == false}">
                    <div class="alert alert-danger" role="alert">
						<b>Customer not found!!!!</b>
					</div>
					</c:if>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-5 mt-5">
       <h1>Earn 5% Interest..</h1>
        <marquee behavior="scroll" direction="left">
    <img src="/indian-rbi-flag.jpeg" width="500" height="200" alt="Natural" />
    </marquee>
    <marquee direction="right">
    <img src="/Rupee_new_note.jpg" width="500" height="200" alt="Natural" />
    
  </marquee>
    </div>
</div>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
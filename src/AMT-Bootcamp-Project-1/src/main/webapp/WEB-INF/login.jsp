<%-- 
  - Author: Yosra Harbaoui
  - Date: October 2017
  - Description: Login page to grant access to generate page
  --%>
  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>AMT Bootcamp • Login</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">AMT Bootcamp • Login</div>
      <div class="card-body">
        <form method="post" action="${pageContext.request.contextPath}/login"> 
          <c:if test = "${not empty error}">
            <div class="alert alert-danger">
                <strong>${error}</strong>
            </div>
          </c:if>
          <div class="form-group">
            <label for="username">Username</label>
            <input class="form-control" id="username" name="username" type="text" placeholder="Username">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input class="form-control" id="password" name="password" type="password" placeholder="Password">
          </div>
          <input class="btn btn-primary btn-block" type="submit" value="Login">
        </form>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/vendor/popper/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/static/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
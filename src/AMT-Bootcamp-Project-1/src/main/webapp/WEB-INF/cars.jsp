<%-- 
  - Author: Yosra Harbaoui
  - Date: October 2017
  - Description: page to manage a list of cars: edit and delete  
  --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>AMT Bootcamp • Cars</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/static/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index">AMT Bootcamp</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Cars">
          <a class="nav-link" href="cars">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Cars</span>
          </a>
        </li>                       
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Administration">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Administration</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="generate">Generate</a>
            </li>
          </ul>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">  
        <li class="nav-item">
            <c:choose>
              <c:when test = "${not empty sessionScope.session}">  
                <a class="nav-link" href="logout"><i class="fa fa-fw fa-sign-out"></i>Logout</a>
              </c:when>
              <c:otherwise>
                <a class="nav-link" href="login"><i class="fa fa-fw fa-sign-in"></i>Login</a>
              </c:otherwise>
            </c:choose>
        </li>
      </ul>         
    </div>
  </nav>

  <div class="content-wrapper">
    <div class="container-fluid">
         <h1>All cars <a class="btn btn-primary" href="add">Add new car</a></h1>
      <div class="card mb-3">
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Brand</th>
                  <th>Model</th>
                  <th>Color</th>
                  <th>Options</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Id</th>
                  <th>Brand</th>
                  <th>Model</th>
                  <th>Color</th>
                  <th>Options</th>
                </tr>
              </tfoot>
              <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>
                        ${car.id}
                        </td>
                        <td>
                        ${car.brand}
                        </td>
                        <td>
                        ${car.model}
                        </td>
                        <td>
                        ${car.color}
                        </td>
                        <td>
                        <a href="edit?id=${car.id}" title="Edit"><img src="${pageContext.request.contextPath}/static/img/table_edit.png" alt="Edit" height="16" width="16"></a>
                        <!--<a href="delete?id=${car.id}" title="Delete" onclick="return confirm('Are you sure you want to delete this entry ?');"><img src="${pageContext.request.contextPath}/static/img/table_row_delete.png" alt="Delete" height="16" width="16"></a>-->
                        <a data-toggle="modal" data-car-id="${car.id}" data-target="#exampleModal"><img src="${pageContext.request.contextPath}/static/img/table_row_delete.png" alt="Delete" height="16" width="16"></a>
                        </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>        
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
              Are you sure you want to delete this entry ?
          </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" id="deleteLink" href="delete">Delete</a>
          </div>
        </div>
      </div>
    </div>
    
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright Yosra © 2017</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>      

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/popper/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/static/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/static/js/sb-admin-charts.min.js"></script>
    
    <script>
    // Call the dataTables jQuery plugin
    $(document).ready(function() {
        $('#dataTable').DataTable({
            "columnDefs": [
              { "orderable": false, "targets": 4 }
            ]
        });
    });
    
    $('#exampleModal').on('show.bs.modal', function (e) {
        var id = $(e.relatedTarget).data('car-id');
        $("#deleteLink").attr("href", "delete?id=" + id);
    });
    </script>
  </div>
</body>

</html>
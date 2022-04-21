<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>GarzaSoft|Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-proyecto.css">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">

        <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/bootstrap.min.css"> -->

        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>
        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 
    </head>
    

    <%@page import="modelo.beans.Persona"%>
    <%@page import="modelo.beans.Usuario"%>

    <body id="page-top">


            <jsp:include page="../../components/slide-bar.jsp?llamarPagina=${infoProyecto.getIdtb_proyecto()}" flush="true"/>

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                    <!-- Begin Page Content -->
                    <div class="container-fluid ">


                        <!--Usuario-->
                        <div class="row mb-4">

                            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-3  text-center">
                                <img src="${pageContext.request.contextPath}/img/dashboard/proyecto.png" alt="Proyecto">
                            </div>

                            <div class="col">

                                <dl class="row">
                                    <td>
                                        <h1 class="font-weight-bold">Información General</h1>
                                    </td>
                                </dl>
                            </div>
                        </div>


                        <div>

                            <script>
                                abrirUrl('${pageContext.request.contextPath}/pages/dashboard-proyecto/informaciondelproyecto.jsp', 'cont');
                            </script>

                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true" onclick="abrirUrl('${pageContext.request.contextPath}/pages/dashboard-proyecto/informaciondelproyecto.jsp', 'cont')">Información de Proyecto</button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" onclick="abrirUrl('${pageContext.request.contextPath}/pages/dashboard-proyecto/${(infoProyecto.getTarea()==null)?"informaciondemodulos":"informaciontarea"}.jsp', 'cont')">${(infoProyecto.getTarea()==null)?"Información de CheckList":"Información de tarea"}</button>
                                </li>
                            </ul>
                            
                        </div>

                        <div id="cont"></div>

                    </div>
                </div>

            <!-- Bootstrap core JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
            <script src="${pageContext.request.contextPath}/js/demo/chart-pie-demo.js"></script>

            <!-- Option 1: Bootstrap Bundle with Popper -->
            <script src="${pageContext.request.contextPath}/src/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
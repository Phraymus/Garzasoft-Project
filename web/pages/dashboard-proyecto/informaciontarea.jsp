<!DOCTYPE html>
<html lang="es">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>GarzaSoft|Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-tarea.css" type="text/css">

    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/bootstrap.min.css"> -->

        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>
        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

    </head>

    <body id="page-top">

        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <div class="container" id="">
                    <div class="row justify-content-md-center">
                        <div class="col-xxl-auto">
                            <div class="" id="">
                                <h5 id="tarea" class="text-md-left" style="color:black;">${infoProyecto.getNombre()}</h5>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container-lg">
                    <div id="container" class="align-items-lg-center">

                        <table class="row justify-content-md-center">
                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Nombre de la tarea</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark">${infoProyecto.getNombre()}</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Descripcion</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark"><textarea class="form-control" id="floatingTextarea2"
                                                                              style="height: 150px" readonly>${infoProyecto.getTarea_descripcion()}</textarea></h5>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Estado</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark">${(infoProyecto.getEstado().equals("P"))?"Pendiente":(infoProyecto.getEstado().equals("E"))?"En proceso":"Terminado"}</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Cliente</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark">${infoCliente.getNombre()} ${infoCliente.getApellido_paterno()} ${infoCliente.getApellido_materno()}</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Fecha de inicio</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark"><fmt:formatDate value = "${infoProyecto.getFecha_inicio()}" pattern = "dd/MM/yyyy"/></h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 class="mt-3" id="texto-datos-tarea">Fecha de termino</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3 ml-3 text-dark"><fmt:formatDate value = "${infoProyecto.getFecha_fin()}" pattern = "dd/MM/yyyy"/></h5>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="mb-5"></div>
                </div>
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
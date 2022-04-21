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
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-avance.css" type="text/css">

    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/bootstrap.min.css"> -->

    <!--JQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!--functions for open windows-->
    <script src="${pageContext.request.contextPath}/js/functions.js"></script>
    

    <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 
</head>

<body id="page-top">


        <jsp:include page="../../components/slide-bar.jsp?llamarPagina=${infoProyecto.getIdtb_proyecto()}" flush="true"/>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                <!-- Begin Page Content -->

                <div class="container-fluid ">
                    <div class="row">
                        <div class="col-lg col-md-offset-2">
                            <div class="card">
                                <div class="card-body d-flex justify-content-between align-items-center">

                                    <a alt="Responsive image" href="#"><img id="imagen-garzasoft" src="${pageContext.request.contextPath}/img/requerimiento/GarzaSoft.png"></a>

                                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                                        <i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div>
                    <h2 class="ml-5 font-weight-bold" style="color:black">${infoProyecto.getNombre()}</h2>
                </div>

                <div id="containera" class="row">
                    <div id="container1" class="col-md-5">

                        <div>
                            <div class="row">
                                <div id="lista-datos" class="col-sm-4">Cliente: </div>
                                <div class="col-sm-6">
                                    ${infoCliente.getNombre()} ${infoCliente.getApellido_paterno()} ${infoCliente.getApellido_materno()}
                                </div>
                            </div>
                        </div>

                        <div>
                            <div class="row">
                                <div id="lista-datos" class="col-sm-4">Programador: </div>
                                <div class="col-sm-6">
                                    ${infoProgramador.getNombre()} ${infoProgramador.getApellido_paterno()} ${infoProgramador.getApellido_materno()}
                                </div>
                            </div>
                        </div>

                    </div>



                    <div id="container1" class="col-md-4 col-md-offset-4">
                        <div id="progreso">
                            <div id="item1">Avance: </div>
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" style="width: ${infoAvance}%;" aria-valuenow="${infoAvance}" aria-valuemin="0" aria-valuemax="100">${infoAvance}%
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="table-responsive w-100 p-3">
                    <c:forEach var="modulos" items="${mapModulos}">
                    <table id="table-requerimiento" class="table table-responsive-xxl table-hover">
                        <thead id="cabeza-table" class="table-light">
                            <tr class="table table-bordered">
                                <th id="table-id" class="col-1 table-id"> ID </th>
                                <th id="table-name" class="col-10">${modulos.key.getNombre()}</th>
                                <th colspan="4"><span id="table-status" class="badge bg-${(modulos.key.getEstado().equals("P"))?"danger":(modulos.key.getEstado().equals("E"))?"warning":"success"}">${(modulos.key.getEstado().equals("P"))?"Pendiente":(modulos.key.getEstado().equals("E"))?"En proceso":"Finalizado"}</span>
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr class="table-light table-responsive-xxl">
                                <td scope="row" class="font-weight-bold ">001</td>
                                <td scope="col" class="font-weight-bold">Nombre requerimiento</td>
                                <td scope="col" class="font-weight-bold"> Fecha inicio </td>
                                <td scope="col" class="font-weight-bold"> Fecha fin </td>
                                <td scope="col" class="font-weight-bold">Progreso</td>
                                <td scope="col" class="font-weight-bold"> Estado</td>

                            </tr>
                            <c:forEach var="requerimientos" items="${modulos.value}">
                            <tr>
                                <td scope="row">${requerimientos.getIdtb_requerimiento()}</td>
                                <td>${requerimientos.getNombre()}</td>
                                <td scope="row"><fmt:formatDate value = "${requerimientos.getFecha_inicio()}" pattern = "dd/MM/yyyy"/></td>
                                        <td scope="row"><fmt:formatDate value = "${requerimientos.getFecha_fin()}" pattern = "dd/MM/yyyy"/></td>
                                <td>
                                    <div class="progress progress-xs">
                                        <div class="progress-bar progress-bar-danger" style="width: ${(requerimientos.getEstado().equals("P"))?"0":(requerimientos.getEstado().equals("E"))?"50":"100"}%"></div>
                                    </div>
                                </td>
                                <td> <span id="table-status" class="badge bg-${(requerimientos.getEstado().equals("P"))?"danger":(requerimientos.getEstado().equals("E"))?"warning":"success"}">${(requerimientos.getEstado().equals("P"))?"Pendiente":(requerimientos.getEstado().equals("E"))?"En proceso":"Finalizado"}</span> </td>

                            </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                    </c:forEach>
                </div>


                <div class="progress vertical">
                    <div class="progress-bar bg-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="height: 40%">
                        <span class="sr-only">40%</span>
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
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



        <script>
        function informacion_modal2(id, titulo, mensaje, accion, anterior) {
            $('#confirmacion-modal').modal('show');
            document.getElementById("titulo-confirmacion-modal").innerHTML = titulo;
            document.getElementById("mensaje-confirmacion-modal").innerHTML = mensaje;
            document.frmConfirmacionModal.action = accion + "&txtEstado=" + document.getElementById(id).value+"&llamado=VReq";
            document.getElementById(id).value=anterior;
        }
        </script>

        <jsp:include page="../../components/slide-bar.jsp?llamarPagina=${infoProyecto.getIdtb_proyecto()}" flush="true"/>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                <!-- Begin Page Content -->

                <div class="container-fluid " id="div-garzasoft">
                    <div class="row">
                        <div class="col-lg col-md-offset-2">
                            <div class="card">
                                <div class="card-body d-flex justify-content-between align-items-center">

                                    <a alt="Responsive image" href="#"><img id="imagen-garzasoft"
                                                                            src="${pageContext.request.contextPath}/img/requerimiento/GarzaSoft.png"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="container" id="parte-inicial">
                    <div class="row justify-content-md-center">
                        <div class="col col-auto imagen-tarea">
                            <img id="imagen-tarea" src="${pageContext.request.contextPath}/img/dashboard/tarea.png">
                        </div>
                        <div class="col-xxl-auto">
                            <div class="contenedor-titulo" id="title-tarea">
                                <h5 id="tarea" class="text-md-left textodelproyecto">${infoProyecto.getNombre()}</h5>
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
                                    <h5 class="mt-3 ml-3 text-dark">${infoProyecto.getTarea()}</h5>
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
                                    <select id="estado${infoProyecto.getIdtb_proyecto()}" 
                                    onChange="informacion_modal2(
                                                            'estado${infoProyecto.getIdtb_proyecto()}', 
                                                            'Cambiar estado',
                                                            '¿Está seguro de cambiar el estado de la tarea?',
                                                            '${pageContext.request.contextPath}/ProyectoController?btnEnviar=doUpdateEstadoProyecto&idProyecto=${infoProyecto.getIdtb_proyecto()}&llamado=tar',
                                                            '${infoProyecto.getEstado()}')" 
                                    class="badge form-control ml-3"  name="tareas">
                                        <option class="bg-danger text-light" value="P">Pendiente</option>
                                        <option class="bg-warning text-dark" value="E" select>En Proceso</option>
                                        <option class="bg-success" value="F">Finalizado</option>
                                    </select>
                                    <script>document.getElementById("estado${infoProyecto.getIdtb_proyecto()}").value = "${infoProyecto.getEstado()}" </script>
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

        <!-- Modal Eliminar Módulo -->
        <jsp:include page="../../components/confirmacion-modal.jsp" flush="true"/>

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
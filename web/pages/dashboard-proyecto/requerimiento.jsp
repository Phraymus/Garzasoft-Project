<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-requerimiento.css" type="text/css">

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
        <!-- Page Wrapper -->

            <jsp:include page="../../components/slide-bar.jsp?llamarPagina=${infoProyecto.getIdtb_proyecto()}" flush="true"/>

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                    <!-- Begin Page Content -->
                    <div class="container-fluid ">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4 col">
                            <div class="col-10">
                                <div class="container" id="parte-inicial">
                                    <div class="row justify-content-md-center">
                                        <div class="col col-auto imagen-tarea">
                                            <img id="imagen-tarea" src="${pageContext.request.contextPath}/img/dashboard/Requerimiento.png"
                                                 style="height: 80px;">
                                        </div>
                                        <div class="col-xxl-auto">
                                            <div class="contenedor-titulo" id="title-tarea">
                                                <h3 id="requerimiento" class="text-md-left textodelproyecto">Checklist</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>


                    </div>


                    <div id="table-checlist">

                        <div class="table-responsive w-100 p-3">

                            <c:forEach var="modulos" items="${mapModulos}">
                            <table class='table table-responsive-xxl table-hover'>


                                <thead class='table-light '>
                                    <tr id='table-requerimiento' class='table-active bg-primary'>
                                        <th id='table-id' class='col-1 table-id '>
                                            
                                        </th>
                                        <th id='table-name' class='col-10'>
                                            ${modulos.key.getNombre()}
                                        </th>
                                        <th colspan='3'><span id='table-status' class='badge bg-danger'>
                                            ${(modulos.key.getEstado().equals("P"))?"Pendiente":(modulos.key.getEstado().equals("P"))?"En progreso":"Terminado"}
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='table-light table-responsive-xxl'>
                                        <td scope='row' class='font-weight-bold '>ID</td>
                                        <td scope='col' class='font-weight-bold'>Nombre requerimiento</td>
                                        <td scope='col' class='font-weight-bold'> Fecha inicio </td>
                                        <td scope='col' class='font-weight-bold'> Fecha fin </td>
                                        <td scope='col' class='font-weight-bold'> Estado</td>
                                    </tr>                                                    

                                    <c:forEach var="requerimientos" items="${modulos.value}">
                                    <tr>
                                        <td scope="row">${requerimientos.getIdtb_requerimiento()}</td>
                                        <td scope="row">${requerimientos.getNombre()}</td>
                                        <td scope="row"><fmt:formatDate value = "${requerimientos.getFecha_inicio()}" pattern = "dd/MM/yyyy"/></td>
                                        <td scope="row"><fmt:formatDate value = "${requerimientos.getFecha_fin()}" pattern = "dd/MM/yyyy"/></td>

                                        <td>
                                            <select id="estado${requerimientos.getIdtb_requerimiento()}" onChange="informacion_modal2(
                                                            'estado${requerimientos.getIdtb_requerimiento()}'
                                                            , 'Cambiar estado',
                                                            '¿Está seguro de cambiar el estado del requerimiento?',
                                                            '${pageContext.request.contextPath}/ProyectoController?btnEnviar=doUpdateEstadoRequerimiento&idProyecto=${modulos.key.getTb_proyecto_id()}&idRequerimiento=${requerimientos.getIdtb_requerimiento()}',
                                                            '${requerimientos.getEstado()}')" class="badge form-control" style="width: 100px" name="tareas">
                                                <option class="bg-danger text-light" value="P">Pendiente</option>
                                                <option class="bg-warning text-dark" value="E">En Proceso</option>
                                                <option class="bg-success" value="F">Finalizado</option>
                                            </select>
                                            <script>document.getElementById("estado${requerimientos.getIdtb_requerimiento()}").value = "${requerimientos.getEstado()}"</script>
                                        </td> 
                                    </tr>
                                    </c:forEach>

                                </tbody>

                            </table>
                           </c:forEach>
                        </div>

                    </div>


                    <div id="cont"></div>

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
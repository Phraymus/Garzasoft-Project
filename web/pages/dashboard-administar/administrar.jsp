<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/dashboard-administar/ventana.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/dashboard-administar/editarmodulo.css">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-requerimiento.css" type="text/css">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">


        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        

        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>

        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

    </head>


    <script>
        function informacion_modal(id, titulo, mensaje, accion) {
            $('#confirmacion-modal').modal('show');
            document.getElementById("titulo-confirmacion-modal").innerHTML=titulo;
            document.getElementById("mensaje-confirmacion-modal").innerHTML=mensaje;
            document.getElementById("idObjetoModal").innerHTML=id;
            document.frmConfirmacionModal.action=accion;
        }

        function informacion_modal2(id, titulo, mensaje, accion) {
            $('#confirmacion-modal').modal('show');
            document.getElementById("titulo-confirmacion-modal").innerHTML=titulo;
            document.getElementById("mensaje-confirmacion-modal").innerHTML=mensaje;
            document.frmConfirmacionModal.action=accion+"&txtEstado="+document.getElementById(id).value;
        }

        function modulo(accion,nombre,id,idProyecto) {
            if(accion=="add"){
                $('#Modulo').modal('show');
                document.frmModulo.action="${pageContext.request.contextPath}/ProyectoController?btnEnviar=doPutModulo&idProyecto="+idProyecto;
                document.getElementById("nombreModulo").value=""; 
                document.getElementById("tituloModulo").innerHTML="Añadir Módulo";  
                document.getElementById("btnModulo").value="Agregar"; 
            }else{
                $('#Modulo').modal('show'); 
                document.frmModulo.action="${pageContext.request.contextPath}/ProyectoController?btnEnviar=doUpdateModulo&idProyecto="+idProyecto+"&idModulo="+id;
                document.getElementById("nombreModulo").value=nombre; 
                document.getElementById("contModulo").value=id; 
                document.getElementById("tituloModulo").innerHTML="Editar Módulo";  
                document.getElementById("btnModulo").value="Guardar Cambios";
            }
        }

        function requerimiento(accion, nombre, fecha_inicio, fecha_fin, id, idModulo, idProyecto) {
            if(accion=="add"){
                $('#Requerimiento').modal('show');
                document.frmRequerimiento.action="${pageContext.request.contextPath}/ProyectoController?btnEnviar=doPutRequerimiento&idModulo="+idModulo+"&idProyecto="+idProyecto;
                document.getElementById("nombreRequerimiento").value="";
                document.getElementById("fechaInicioRequerimiento").value="";
                document.getElementById("fechaFinRequerimiento").value="";  
                document.getElementById("tituloRequerimiento").innerHTML="Añadir Requerimiento";  
                document.getElementById("btnRequerimiento").value="Agregar";  
            }else{
                $('#Requerimiento').modal('show');
                document.frmRequerimiento.action="${pageContext.request.contextPath}/ProyectoController?btnEnviar=doUpdateRequerimiento&idModulo="+idModulo+"&idProyecto="+idProyecto+"&idRequerimiento="+id;
                document.getElementById("nombreRequerimiento").value=nombre;
                document.getElementById("fechaInicioRequerimiento").value=fecha_inicio;
                document.getElementById("fechaFinRequerimiento").value=fecha_fin;  
                document.getElementById("tituloRequerimiento").innerHTML="Editar Requerimiento";  
                document.getElementById("btnRequerimiento").value="Guardar Cambios";  
            }
        }

    </script>

    <body id="page-top">


        <jsp:include page="../../components/slide-bar.jsp?llamarPagina=proy" flush="true"/>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                <!-- Begin Page Content -->
                <div class="container-fluid ">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4 col">
                        <h1 class="h3 mb-0 text-gray-800">Administrar proyecto: ${infoProyecto.getNombre()}</h1>
                        <div>
                            <a href="javascript:modulo('add','','','${infoProyecto.getIdtb_proyecto()}','')"  style="color:#00C2CB" class="text-success text-lg font-weight-bold"><i class="fas fa-plus fa-sm mr-2" ></i>Añadir Módulo</a>
                        </div>

                    </div>

                </div>


                <div class="table-responsive w-100 p-3">
                    <c:forEach var="modulos" items="${mapModulos}">

                        <table class="mt-3 table table-responsive-xxl taover">

                            <thead class="table-light " >
                                <tr id="table-requerimiento" class="table-active" style="background-color:#00449c;">
                                    <th id="table-id" class="col-1 table-id ">  </th>
                                    <th id="table-name" class="col-10">${modulos.key.getNombre()}</th>
                                    <th colspan="3"></th>
                                    <td>
                                        <a href="javascript:modulo('edit','${modulos.key.getNombre()}','${modulos.key.getIdtb_modulo()}','${infoProyecto.getIdtb_proyecto()}')" class="btn btn-sm btn-circle bg-warning text-white"><i class="fas fa-pen"></i></a>
                                    </td>
                                    <td>
                                        <a href="javascript:informacion_modal('${modulos.key.getIdtb_modulo()}'
                                        ,'Eliminar Modulo',
                                        '¿Está seguro de eliminar el módulo y todos sus requerimientos?',
                                        '${pageContext.request.contextPath}/ProyectoController?btnEnviar=doDeleteModulo&idProyecto=${modulos.key.getTb_proyecto_id()}&idModulo=${modulos.key.getIdtb_modulo()}')" class="btn btn-sm btn-circle bg-danger text-white"><i class="fas fa-trash"></i></a>
                                    </td>
                                </tr>
                            </thead>

                            <tbody>
                                <tr class="table-light table-responsive-xxl">
                                    <td scope="row" class="font-weight-bold ">Codigo</td>
                                    <td scope="col" class="font-weight-bold">Nombre requerimiento</td>
                                    <td scope="col" class="font-weight-bold"> Fecha inicio </td>
                                    <td scope="col" class="font-weight-bold"> Fecha fin </td>

                                    <td scope="col" class="font-weight-bold"> Estado</td>
                                    <td colspan="4"></td>
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
                                                    ,'Cambiar estado',
                                                    '¿Está seguro de cambiar el estado del requerimiento?',
                                                    '${pageContext.request.contextPath}/ProyectoController?btnEnviar=doUpdateEstadoRequerimiento&idProyecto=${modulos.key.getTb_proyecto_id()}&idRequerimiento=${requerimientos.getIdtb_requerimiento()}')" class="badge form-control" style="width: 100px" name="tareas">
                                                    <option class="bg-danger text-light" value="P">Pendiente</option>
                                                    <option class="bg-warning text-dark" value="E">En Proceso</option>
                                                    <option class="bg-success" value="F">Finalizado</option>
                                            </select>
                                            <script>document.getElementById("estado${requerimientos.getIdtb_requerimiento()}").value = "${requerimientos.getEstado()}"</script>
                                        </td> 
                                        <td>

                                            <a href="javascript:requerimiento(
                                                'edit',
                                                '${requerimientos.getNombre()}',
                                                '<fmt:formatDate value = "${requerimientos.getFecha_inicio()}" pattern = "yyyy-MM-dd"/>',
                                                '<fmt:formatDate value = "${requerimientos.getFecha_inicio()}" pattern = "yyyy-MM-dd"/>',
                                                '${requerimientos.getIdtb_requerimiento()}',
                                                '${modulos.key.getIdtb_modulo()}',
                                                '${modulos.key.getTb_proyecto_id()}'
                                                )" class="btn btn-sm btn-circle bg-warning text-white"><i class="fas fa-pen"></i></a>

                                        </td>  
                                        <td>
                                            <a href="javascript:informacion_modal('${requerimientos.getIdtb_requerimiento()}',
                                            'Eliminar Requerimiento',
                                            '¿Está seguro de eliminar el requerimiento?',
                                            '${pageContext.request.contextPath}/ProyectoController?btnEnviar=doDeleteRequerimiento&idProyecto=${modulos.key.getTb_proyecto_id()}&idRequerimiento=${requerimientos.getIdtb_requerimiento()}')" class="btn btn-sm btn-circle bg-danger text-white"><i class="fas fa-trash"></i></a>
                                        </td>

                                    </tr>
                                </c:forEach>


                            </tbody>
                        </table>
                        <a href="javascript:requerimiento('add','','','','','${modulos.key.getIdtb_modulo()}','${modulos.key.getTb_proyecto_id()}')" class="text-success text-lg font-weight-bold text-right"><i class="fas fa-plus fa-sm mr-2"></i>Añadir Requerimiento</a>
                    </c:forEach>

                </div>



                <div id="cont"></div>

            </div>
        </div>




        <!-- Modal Eliminar Módulo -->
        <jsp:include page="../../components/confirmacion-modal.jsp" flush="true"/>


        <!-- Modal Añadir Modulo -->

        <div id="Modulo" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 id="tituloModulo" class="modal-title">Añadir Módulo</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>

                    <form name="frmModulo" action="${pageContext.request.contextPath}/UsuarioController?btnEnviar=putUserTrabajador" method="post">
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <input class="d-none" name="txtIdModulo" id="contModulo">
                                    <td>
                                        <h5 class="mt-3">Nombre del módulo</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input id="nombreModulo" name="txtNombre" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" >
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-danger mb-3" data-bs-dismiss="modal" value="Cancelar">
                            <input id="btnModulo" type="submit" class="btn btn-success mb-3" value="Agregar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal Añadir Requerimiento -->

        <div id="Requerimiento" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 id="tituloRequerimiento" class="modal-title">Añadir Requerimiento</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>

                    <form name="frmRequerimiento" action="${pageContext.request.contextPath}/RequerimientoController?btnEnviar=doPut&idModulo=" method="post">
                        <div class="modal-body">
                            <table>
                                <input class="d-none" name="txtIdModulo" id="contRequerimiento">
                                <tr>
                                    <td>
                                        <h5 class="mt-3">Nombre del requerimiento</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input id="nombreRequerimiento" name="txtNombre" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" >
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h5 class="mt-3">Fecha de inicio</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input id="fechaInicioRequerimiento" name="txtFechaInicio" class="form-control ml-1 mt-3 text-dark" type="date" >
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h5 class="mt-3">Fecha de fin</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input id="fechaFinRequerimiento" name="txtFechaFin" class="form-control ml-1 mt-3 text-dark" type="date" >
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-danger mb-3" data-bs-dismiss="modal" value="Cancelar">
                            <input id="btnRequerimiento" type="submit" onclick="agregarRequerimiento()" class="btn btn-success mb-3" value="Agregar">
                        </div>
                    </form>
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
        
        <script src="popup.js"></script>
        <script src="popup1.js"></script>
    </body>   
</html> 
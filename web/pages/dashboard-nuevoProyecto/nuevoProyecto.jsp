
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>GarzaSoft|Dashboard</title>

        <!--Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
        <!--Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-requerimiento.css" type="text/css">


        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/datatables/datatables.css"/>




    </head>

    <body id="page-top">
        
        <script>
            function getPersona(cont, open) {
                id = document.getElementById(open).value;
                document.getElementById(cont).innerHTML = "<option>Cargando...</option>"
                abrirUrl('${pageContext.request.contextPath}/CRUDGestionUsuarioController?btnEnviar=getDepartamentos&idPais=' + id, cont);
            }
            
            function tipoProyecto() {
                
                if (document.getElementById("cmbProyectoAdd").value == "Desarrollo") {
                    document.getElementById("SAdd").className = "d-none";
                    document.getElementById("DAdd").className = "";
                    document.getElementById("DesAdd").className = "d-none";
                } else {
                    document.getElementById("SAdd").className = "";
                    document.getElementById("DAdd").className = "d-none";
                    document.getElementById("DesAdd").className = "";
                }
            }

            function clientes() {
                abrirUrl('${pageContext.request.contextPath}/UsuarioController?btnEnviar=getClientes&llamado=nuevo', 'contCliente');
                $('#modalCliente').modal('show');
            }

            function trabajadores() {
                abrirUrl('${pageContext.request.contextPath}/UsuarioController?btnEnviar=getTrabajadores&llamado=nuevo', 'contTrabajador');
                $('#modalTrabajador').modal('show');
            }

            function seleccionarCliente(id, nombre, apellidoPaterno, apellidoMaterno) {
                $('#modalCliente').modal('hide');
                document.getElementById("nombreCliente").value=nombre+" "+apellidoPaterno+" "+apellidoMaterno;
                document.getElementById("idCliente").value=id;
            }

            function seleccionarTrabajador(id, nombre, apellidoPaterno, apellidoMaterno) {
                $('#modalTrabajador').modal('hide');
                document.getElementById("nombreTrabajador").value=nombre+" "+apellidoPaterno+" "+apellidoMaterno;
                document.getElementById("idTrabajador").value=id;
            }
        </script>


             <jsp:include page="../../components/slide-bar.jsp?llamarPagina=newPro" flush="true"/>

             <!--Content Wrapper--> 
            <div id="content-wrapper" class="d-flex flex-column">

                 <!--Main Content--> 
                <div id="content">

                    <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                     <!--Begin Page Content--> 
                    <div class="row justify-content-center align-items-center" >
                        <div class="col-12 ml-3" >
                            <h3 class="text-dark ml-3" style="margin-left: 3px;">Crear nuevo proyecto</h3>
                        </div>

                        <hr style="width: 85%; height: 0.2%; margin-top: 0%;" noshade="noshade">

                    <form action="${pageContext.request.contextPath}/ProyectoController?btnEnviar=doPut" method="post" >
                        <div class="container-fluid ">
                            <div class="d-md-flex align-items-center mb-4">
                                <div class="col-xl-9 col-md-9 col-sm-12">
                                    <table>
                                        <tr>
                                            <td>
                                                <h5 class="mt-3">Nombre</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>

                                            <td>
                                                <input class="form-control ml-3 mt-3 text-dark" type="text" name="txtNombreProyecto" value="">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h5 class="mt-3">Trabajador</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <div class="input-group w-100 ml-3 mt-3 ">
                                                    <input class="d-none" id="idTrabajador" name="txtTrabajador">
                                                    <input id="nombreTrabajador" type="text" class="form-control" placeholder="Haga clic en el ícono." aria-label="Input group example" aria-describedby="basic-addon1" disabled>
                                                    <span class="input-group-text" id="basic-addon1" onclick="trabajadores()">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16" >
                                                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
                                                        </svg>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h5 class="mt-3">Cliente</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <div class="input-group w-100 ml-3 mt-3 ">
                                                    <input class="d-none" id="idCliente" name="txtCliente">
                                                    <input id="nombreCliente" type="text" class="form-control" placeholder="Haga clic en el ícono." aria-label="Input group example" aria-describedby="basic-addon1" disabled>
                                                    <span class="input-group-text" id="basic-addon1" onclick="clientes()">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16" >
                                                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
                                                        </svg>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="width:250px;">
                                                <h5 class="mt-3">Fecha de inicio</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <input name="txtFechaInicio" class="form-control ml-3 mt-3 text-dark" type="date"  value="2">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h5 class="mt-3">Fecha de termino</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <input name="txtFechaFin" class="form-control ml-3 mt-3 text-dark" type="date" value="">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h5 class="mt-3">Tipo de proyecto</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <select name="txtTipoProyecto" id="cmbProyectoAdd" onchange="javascript:tipoProyecto()" class=" ml-3 mt-3 form-control">
                                                    <option value="Desarrollo">
                                                        Desarrollo
                                                    </option>
                                                    <option value="Soporte">
                                                        Soporte
                                                    </option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr id="DAdd">
                                            <td>
                                                <h5 class="mt-3">Checklist</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <input name="txtChecklist" class="form-control ml-3 mt-3 text-dark" type="text">
                                            </td>
                                        </tr>


                                        <tr id="SAdd" class="d-none">
                                            <td>
                                                <h5 class="mt-3">Tarea</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <input name="txtTarea" class="form-control ml-3 mt-3 text-dark" type="text">
                                            </td>
                                        </tr>


                                        <tr class="d-none" id="DesAdd">
                                            <td>
                                                <h5 class="mt-3">Descripción</h5>
                                            </td>
                                            <td>
                                                <h5 class="mt-3">:</h5>
                                            </td>
                                            <td>
                                                <input name="txtDescripcion" class="form-control ml-3 mt-3 text-dark" type="text">
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-row bd-highlight justify-content-center">
                        <div class="p-2 bd-highlight">
                            <button type="submit" class="btn btn-primary">Crear</button>
                        </div>

                        <div class="p-2 bd-highlight">
                            <button type="button" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                    </form>
                    </div>

                    


                    <!--Modal Seleccionar cliente-->
                    <div class="modal fade" id="modalCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Seleccionar Cliente</h5>
                                    <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body pt-0">
                                    <div id="contCliente">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                    
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--Modal Seleccionar cliente-->
                    <div class="modal fade" id="modalTrabajador" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Seleccionar Trabajador</h5>
                                    <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body pt-0">
                                    <div id="contTrabajador">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                    
                                </div>
                            </div>
                        </div>
                    </div>


                    


                </div>
            </div>

         <!--Bootstrap core JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

         <!--Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

         <!--Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>

         <!--Page level plugins--> 
        <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>

         <!--Page level custom scripts--> 
        <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/demo/chart-pie-demo.js"></script>

         <!--Option 1: Bootstrap Bundle with Popper--> 
        <script src="${pageContext.request.contextPath}/src/js/bootstrap.bundle.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/dashboard-nuevoProyecto/nuevoProyecto.js"></script>
        

        <script src="${pageContext.request.contextPath}/datatables/datatables.js"></script>

    </body>

</html>


<%-- 
    Document   : nuevoProyecto
    Created on : 22/03/2022, 12:07:47 AM
    Author     : ESTUDIANTE
--%>

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
        <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link rel="stylesheet" href="../../css/layout-dashboard.css">
        <!--Custom styles for this template-->
        <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../../css/layout-requerimiento.css" type="text/css">

         <link rel="stylesheet" href="../../src/css/bootstrap.min.css"> 

        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="../../js/functions.js"></script>

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
                } else {
                    document.getElementById("SAdd").className = "";
                    document.getElementById("DAdd").className = "d-none";
                }
            }
        </script>

        <!--Page Wrapper -->
        <div id="wrapper">

            <!--Sidebar -->
            <ul class="navbar-nav bg-navbar-lateral sidebar sidebar-dark accordion" id="accordionSidebar">

                <!--Sidebar - Brand -->
                <a class="sidebar-brand text-dark d-flex align-items-center justify-content-center logo" href="../dashboard-inicio/dashboard.html">
                    <div class="sidebar-brand-icon ml-3">
                        <img src="../../img/logos/GarzaSoft.png">
                    </div>
                    <div class="sidebar-brand-text  mx-3">
                        <Strong>Dashboard</Strong>
                    </div>
                </a>

                <!--Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="../dashboard-inicio/dashboard.html">
                        <i class="fas fa-fw fa-home"></i>
                        <span>Inicio</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                 <!--Heading--> 
                <div class="sidebar-heading">
                    Usuario
                </div>

                 <!--Nav Item - Pages Collapse Menu--> 

                 <!--Nav Item - Charts--> 
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="../dashboard-usuario/dashboard.html">
                        <i class="fas fa-fw fa-user"></i>
                        <span>Usuario</span></a>
                </li>

                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="../dashboard-gestionarUsuario/dashboard.html ">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Gestionar Usuarios</span></a>
                </li>


                 <!--Divider--> 
                <hr class="sidebar-divider">

                 <!--Heading--> 
                <div class="sidebar-heading">
                    Proyecto
                </div>

                 <!--Nav Item - Pages Collapse Menu--> 
                <li class="nav-item">
                    <a class="nav-link collapsed bg-navbar-lateral-items" data-toggle="collapse" data-target="#proyecton1" aria-expanded="true" aria-controls="collapseTwo" href="#">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Proyecto de manzanas</span>
                    </a>
                    <div id="proyecton1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-navbar-lateral py-2 collapse-inner rounded">
                            <a class="collapse-item " href="../dashboard-proyecto/dashboard.html">Informacion General</a>
                            <a class="collapse-item " href="#">Administrar</a>
                            <a class="collapse-item " href="#">Calendario</a>
                            <a class="collapse-item " href="../dashboard-proyecto/requerimiento.html">Requerimiento</a>
                            <a class="collapse-item " href="../dashboard-proyecto/avance-requerimiento.html">Avance</a>
                        </div>
                    </div>
                </li>

                <li class="nav-item active">
                    <a class="nav-link bg-navbar-lateral-items" href="../dashboard-nuevoProyecto/nuevoProyecto.html">
                        <i class="fas fa-fw fa-plus" style="color: #00C2CB;"></i>
                        <span style="color: #00C2CB;"><strong>Nuevo Proyecto</strong></span></a>
                </li>


                 <!--Divider--> 
                <hr class="sidebar-divider">

                 <!--Heading--> 
                <div class="sidebar-heading">
                    Soporte
                </div>

                 <!--soporte--> 
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="../dashboard-contacto/contacto.html">
                        <i class="fas fa-fw fa-phone"></i>
                        <span>Contacto</span></a>
                </li>


                 <!--Divider--> 
                <hr class="sidebar-divider d-none d-md-block">

                 <!--Sidebar Toggler (Sidebar)--> 
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
             <!--End of Sidebar--> 

             <!--Content Wrapper--> 
            <div id="content-wrapper" class="d-flex flex-column">

                 <!--Main Content--> 
                <div id="content">

                     <!--Topbar--> 
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                         <!--Sidebar Toggle (Topbar)--> 
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                         <!--Topbar Search--> 
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Busquedad de proyectos por nombre o código" aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <a class="btn btn-primary" href="../dashboard-busqueda/resultado.html">
                                        <i class="fas fa-search fa-sm"></i>
                                    </a>
                                </div>
                            </div>
                        </form>

                         <!--Topbar Navbar--> 
                        <ul class="navbar-nav ml-auto">

                             <!--Nav Item - Search Dropdown (Visible Only XS)--> 
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                 <!--Dropdown - Messages--> 
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Busquedad de proyectos por nombre o código" aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <a class="btn btn-primary" href="../dashboard-busqueda/resultado.html">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                             <!--Nav Item - Alerts--> 
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                     <!--Counter - Alerts--> 
                                    <span class="badge badge-danger badge-counter">5+</span>
                                </a>
                                 <!--Dropdown - Alerts--> 
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Notificaciones
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-primary">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">Febrero 02, 2022</div>
                                            <span class="font-weight-bold">Reunión de checkList!</span>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-success">
                                                <i class="fas fa-donate text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">Febrero 01, 2022</div>
                                            Se te ha asignado a un proyecto!
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-warning">
                                                <i class="fas fa-exclamation-triangle text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">Febrero 1, 2022</div>
                                            Pronta finalización de plazo para terminar requerimiento.
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Mostrar todas las
                                        alertas</a>
                                </div>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                             <!--Nav Item - User Information--> 
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                    <img class="img-profile rounded-circle" src="../../img/undraw_profile.svg">
                                </a>
                                 <!--Dropdown - User Information--> 
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Perfil
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Editar perfil
                                    </a>
                                     <a class="dropdown-item" href="#">
                                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Activity Log
                                    </a> 
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="../login.html" data-target="#logoutModal">
                                        data-toggle="modal"
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                     <!--End of Topbar--> 

                     <!--Begin Page Content--> 
                    <div class="row justify-content-start align-items-center" style="margin-left: 7%;">
                        <div class="col-5">
                            <h3 class="text-dark">Crear nuevo proyecto</h3>
                        </div>
                    </div>

                    <hr style="width: 85%; height: 0.2%; margin-top: 0%;" noshade="noshade">

                    <form action="${pageContext.request.contextPath}/NuevoProyectoServlet" method="post" enctype="multipart/form-data">
                        <div class="container-fluid">
                            <div class="d-md-flex align-items-center justify-content-end mb-4">
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
                                                <input class="form-control ml-3 mt-3 text-dark" type="text" name="txtNombreProyecto" value="Proyecto1">
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
                                                    <input name="txtNombreTrabajador" type="text" class="form-control" placeholder="Nombre del Trabajador" aria-label="Input group example" aria-describedby="basic-addon1">
                                                    <span class="input-group-text" id="basic-addon1" data-bs-toggle="modal" data-bs-target="#modalTrabajador">
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
                                                    <input name="txtNombreCliente" type="text" class="form-control" placeholder="Nombre del Cliente" aria-label="Input group example" aria-describedby="basic-addon1">
                                                    <span class="input-group-text" id="basic-addon1" data-bs-toggle="modal" data-bs-target="#modalCliente">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16" >
                                                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
                                                        </svg>
                                                    </span>
                                                </div>
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
                                                <input class="form-control ml-3 mt-3 text-dark" type="date" name="tsFechaInicio" value="2022-02-22">
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
                                                <input class="form-control ml-3 mt-3 text-dark" type="date" name="tsFechaTermino" value="2022-04-08">
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
                                    </table>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="modal fade" id="modalCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Agregar Cliente</h5>

                                </div>
                                <div class="modal-body pt-0">
                                    <div class="input-group pb-3">
                                        <input class="form-control bg-white small" type="search" placeholder="Busqueda de trabajadores" aria-controls="example"> 
                                            <div class="input-group-append">
                                                <a class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </a>
                                            </div>
                                    </div>
                                    
                                    <select name="txtPersona" id="cmbPaisesAdd" onchange="getDepartamentos('cmbDepartamentosAdd', 'cmbPaisesAdd')" class=" ml-1 mt-3 form-control">
                                            <option value="0">
                                                Seleccione
                                            </option>

                                            <c:forEach var="pais" items="${lstPersonas}">
                                                <option value="${pais.getIdtb_pais()}">
                                                    ${pais.getNombre()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    
                                    <div class="container-fluid mt-3">
                                        <div class="d-md-flex align-items-start justify-content-between mb-4">
                                            <div class="table-responsive w-100 p-3">

                                                <table id="example" class="table table-striped" style="width:100%">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col" class="font-weight-bold">Nombres</th>
                                                            <th scope="col" class="font-weight-bold">Apellidos Paterno</th>
                                                            <th scope="col" class="font-weight-bold">Apellido Materno</th>
                                                            <th scope="col" class="font-weight-bold">N° Identificacion</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </div>

                                        </div>
                                    </div>

                                    
                                    <table class="table table-sm table-responsive-lg table-hover" id="table-clientes">
                                        <thead>
                                            <tr>
                                                <th scope="col">Nombres</th>
                                                <th scope="col">Apellido paterno</th>
                                                <th scope="col">Apellido materno</th>
                                                <th scope="col">IDENTIFICACION</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td scope="row"></td>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td scope="row"></td>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td scope="row"></td>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary">Seleccionar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="modalTrabajador" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Agregar Trabajador</h5>

                                </div>
                                <div class="modal-body">
                                    <table class="table table-sm table-responsive-lg table-hover" id="table-clientes">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>

                                                <th scope="col">Nombres</th>
                                                <th scope="col">Apellido paterno</th>
                                                <th scope="col">Apellido materno</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td scope="row"></td>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td scope="row"></th>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td scope="row"></td>

                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary">Seleccionar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="d-flex flex-row bd-highlight justify-content-center">
                        <div class="p-2 bd-highlight">
                            <button type="button" class="btn btn-primary">Crear</button>
                        </div>

                        <div class="p-2 bd-highlight">
                            <button type="button" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>


                </div>
            </div>
        </div>

         <!--Bootstrap core JavaScript-->
        <script src="../../vendor/jquery/jquery.min.js"></script>
        <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

         <!--Core plugin JavaScript-->
        <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

         <!--Custom scripts for all pages-->
        <script src="../../js/sb-admin-2.min.js"></script>

         <!--Page level plugins--> 
        <script src="../../vendor/chart.js/Chart.min.js"></script>

         <!--Page level custom scripts--> 
        <script src="../../js/demo/chart-area-demo.js"></script>
        <script src="../../js/demo/chart-pie-demo.js"></script>

         <!--Option 1: Bootstrap Bundle with Popper--> 
        <script src="../../src/js/bootstrap.bundle.min.js"></script>

        <script src="../../js/dashboard-nuevoProyecto/nuevoProyecto.js"></script>

    </body>

</html>

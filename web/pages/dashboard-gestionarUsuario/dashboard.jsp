<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>GarzaSoft|Dashboard</title>

        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-dashboard.css">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-proyecto.css">

    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/bootstrap.min.css"> -->

        <!--JQuery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/datatables/datatables.css"/>


    </head>

    <body id="page-top">



        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-navbar-lateral sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand text-dark d-flex align-items-center justify-content-center logo" href="${pageContext.request.contextPath}/dashboard-inicio/dashboard.html">
                    <div class="sidebar-brand-icon ml-3">
                        <img src="${pageContext.request.contextPath}/img/logos/GarzaSoft.png">
                    </div>
                    <div class="sidebar-brand-text  mx-3">
                        <Strong>Dashboard</Strong>
                    </div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard-inicio/dashboard.html">
                        <i class="fas fa-fw fa-home"></i>
                        <span>Inicio</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Usuario
                </div>

                <!-- Nav Item - Pages Collapse Menu -->

                <!-- Nav Item - Charts -->
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard-usuario/dashboard.html">
                        <i class="fas fa-fw fa-user"></i>
                        <span>Usuario</span></a>
                </li>

                <li class="nav-item active bg-navbar-lateral-items">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard-gestionarUsuario/dashboard.html ">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Gestionar Usuarios</span></a>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Proyecto
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed bg-navbar-lateral-items" data-toggle="collapse" data-target="#proyecton1" aria-expanded="true" aria-controls="collapseTwo" href="#">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Proyecto de manzanas</span>
                    </a>
                    <div id="proyecton1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-navbar-lateral py-2 collapse-inner rounded">
                            <a class="collapse-item " href="${pageContext.request.contextPath}/dashboard-proyecto/dashboard.html">Informacion General</a>
                            <a class="collapse-item " href="#">Administrar</a>
                            <a class="collapse-item " href="#">Calendario</a>
                            <a class="collapse-item " href="${pageContext.request.contextPath}/dashboard-proyecto/requerimiento.html">Requerimiento</a>
                            <a class="collapse-item " href="${pageContext.request.contextPath}/dashboard-proyecto/avance-requerimiento.html">Avance</a>
                        </div>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link bg-navbar-lateral-items" href="${pageContext.request.contextPath}/dashboard-nuevoProyecto/nuevoProyecto.html">
                        <i class="fas fa-fw fa-plus" style="color: #00C2CB;"></i>
                        <span style="color: #00C2CB;"><strong>Nuevo Proyecto</strong></span></a>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Soporte
                </div>

                <!-- soporte -->
                <li class="nav-item bg-navbar-lateral-items">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard-contacto/contacto.html">
                        <i class="fas fa-fw fa-phone"></i>
                        <span>Contacto</span></a>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Busquedad de proyectos por nombre o código" aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard-busqueda/resultado.html">
                                        <i class="fas fa-search fa-sm"></i>
                                    </a>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Busquedad de proyectos por nombre o código" aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard-busqueda/resultado.html">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">5+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
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
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Mostrar todas las alertas</a>
                                </div>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                    <img class="img-profile rounded-circle" src="${pageContext.request.contextPath}/img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Perfil
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Editar perfil
                                    </a>
                                    <!-- <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Activity Log
                                </a> -->
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/login.html" data-target="#logoutModal">
                                        <!--data-toggle="modal"-->
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid ">

                        <!-- Usuario
                        <div class="row mb-4">
    
                            <div class="col-sm-6 col-md-6 col-lg-3 col-xl-3  text-center">
                                <img src="${pageContext.request.contextPath}/img/dashboard/usuario.png" alt="Usuario">
                            </div>
    
                            <div class="col">
    
                                <dl class="row">
                                    <h2 class="col-sm-12 col-md-12 col-lg-12 col-xl-3 font-weight-bold">beceo2001sds</h2>
                                    <dd class="col-sm-12 col-md-12 col-lg-12 col-xl-2 display-6"><small>Administrador</small></dd>
                                </dl>
                                <dl class="row">
                                    <dt class="col-sm-3">bcarrascoo@outlook.com</dt>
                                </dl>
    
                            </div>
                        </div> -->

                        <!--Usuario-->
                        <div class="row mb-4">

                            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-3  text-center">
                                <img src="${pageContext.request.contextPath}/img/dashboard-gestionarUsuario/logo.png" alt="Proyecto">
                            </div>

                            <div class="col">

                                <dl class="row">
                                    <td>
                                        <h2 class="font-weight-bold">Gestión de usuarios</h2>
                                    </td>
                                </dl>
                            </div>
                        </div>


                        <div>

                            

                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true" onclick="abrirUrl('${pageContext.request.contextPath}/pages/dashboard-gestionarUsuario/trabajadores-general.jsp', 'cont')">Trabajadores</button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" onclick="abrirUrl('${pageContext.request.contextPath}/pages/dashboard-gestionarUsuario/clientes-general.html', 'cont')">Clientes</button>
                                </li>
                            </ul>

                            <!-- <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">Tab1</div>
                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">tab2</div>
                            </div> -->

                            <!-- <ul class="nav nav-tabs">
    
                                <li class="nav-item" role="presentation">
    
                                    <a class="nav-link" role="tab" aria-selected="false" href="#" onclick="abrirUrl('informaciondelacuenta.html', 'cont')">Informacion de la cuenta</a>
    
                                </li>
    
                                <li class="nav-item" role="presentation">
    
                                    <a class="nav-link" role="tab" href="#" aria-selected="false" onclick="abrirUrl('editarperfil.html', 'cont')">Editar perfil</a>
    
                                </li>
    
                            </ul> -->
                        </div>

                        <div id="cont"></div>

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

            <script src="//code.jquery.com/jquery-3.5.1.js"></script>

            <script src="${pageContext.request.contextPath}/datatables/datatables.js"></script>

            <script>
                abrirUrl('${pageContext.request.contextPath}/pages/dashboard-gestionarUsuario/trabajadores-general.jsp', 'cont');
            </script>
    </body>

</html>
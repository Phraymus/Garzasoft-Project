<!-- Page Wrapper -->
<% String pagina=request.getParameter("llamarPagina"); %>

<%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

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
        <li class="nav-item <%=(pagina.equals("ini"))?"active":""%> bg-navbar-lateral-items">
            <a class="nav-link" href="${pageContext.request.contextPath}/pages/dashboard-inicio/dashboard.jsp">
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
        <li class="nav-item <%=(pagina.equals("usu"))?"active":""%> bg-navbar-lateral-items">
            <a class="nav-link " href="${pageContext.request.contextPath}/pages/dashboard-usuario/dashboard.jsp">
                <i class="fas fa-fw fa-user"></i>
                <span>Usuario</span></a>
        </li>

        <li class="nav-item <%=(pagina.equals("gest"))?"active":""%> bg-navbar-lateral-items">
            <a class="nav-link" href="${pageContext.request.contextPath}/pages/dashboard-gestionarUsuario/dashboard.jsp">
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
        <li class="nav-item <%=(pagina.equals("proy"))?"active":""%>">
            <a class="nav-link collapsed bg-navbar-lateral-items" data-toggle="collapse" data-target="#proyecton1" aria-expanded="true" aria-controls="collapseTwo" href="#">
                <i class="fas fa-fw fa-folder"></i>
                <span>Proyecto de manzanas</span>
            </a>
            <div id="proyecton1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-navbar-lateral py-2 collapse-inner rounded">
                    <a class="collapse-item " href="${pageContext.request.contextPath}/pages/dashboard-proyecto/dashboard.html">Informacion General</a>
                    <a class="collapse-item " href="${pageContext.request.contextPath}/pages/dashboard-administar/administrar.jsp">Administrar</a>
                    <a class="collapse-item " href="#">Calendario</a>
                    <a class="collapse-item " href="${pageContext.request.contextPath}/pages/dashboard-proyecto/requerimiento.html">Requerimiento</a>
                    <a class="collapse-item " href="${pageContext.request.contextPath}/pages/dashboard-proyecto/avance-requerimiento.html">Avance</a>
                </div>
            </div>
        </li>

        <li class="nav-item <%=(pagina.equals("newPro"))?"active":""%>">
            <a class="nav-link bg-navbar-lateral-items" href="${pageContext.request.contextPath}/pages/dashboard-nuevoProyecto/nuevoProyecto.jsp">
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

<%@page import="modelo.beans.Persona"%>
<%@page import="modelo.beans.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Wrapper -->
<% 
    String pagina = request.getParameter("llamarPagina");
    Usuario usuario= (Usuario)session.getAttribute("userSession");
    Persona persona= (Persona)session.getAttribute("personaSession");
%>

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
        <li class="nav-item <%=(pagina.equals("ini")) ? "active" : ""%> bg-navbar-lateral-items">
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
        <li class="nav-item <%=(pagina.equals("usu")) ? "active" : ""%> bg-navbar-lateral-items">
            <a class="nav-link " href="${pageContext.request.contextPath}/pages/dashboard-usuario/dashboard.jsp">
                <i class="fas fa-fw fa-user"></i>
                <span>Usuario</span></a>
        </li>

        <li class="nav-item <%=(pagina.equals("gest")) ? "active" : ""%> bg-navbar-lateral-items <%=(usuario.getPerfil_usuario().equals("A"))?"":"d-none"%>">
            <a class="nav-link" href="${pageContext.request.contextPath}/pages/dashboard-gestionarUsuario/dashboard.jsp">
                <i class="fas fa-fw fa-cog"></i>
                <span>Gestionar Usuarios</span></a>
        </li>


        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Proyectos de desarrollo
        </div>
        <!-- Nav Item - Pages Collapse Menu -->
        <c:forEach var="proyectos" items="${listProyectos}">
            <li id="proy${proyectos.getIdtb_proyecto()}" class="nav-item ${(proyectos.getTarea()!=null)?"d-none":""} ">
                <a class="nav-link collapsed bg-navbar-lateral-items" data-toggle="collapse" data-target="#proyecton${proyectos.getIdtb_proyecto()}" aria-expanded="true" aria-controls="collapseTwo" href="#">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>${proyectos.getNombre()}</span>
                </a>
                <div id="proyecton${proyectos.getIdtb_proyecto()}" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-navbar-lateral py-2 collapse-inner rounded">
                        <a class="collapse-item " href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVInf&idProyecto=${proyectos.getIdtb_proyecto()}">Informacion General</a>
                        <a class="collapse-item <%=(usuario.getPerfil_usuario().equals("A"))?"":"d-none"%> " href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVAdm&idProyecto=${proyectos.getIdtb_proyecto()}">Administrar</a>
                        <a class="collapse-item " href="#">Calendario</a>
                        <a class="collapse-item <%=(usuario.getPerfil_usuario().equals("T"))?"":"d-none"%>" href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVReq&idProyecto=${proyectos.getIdtb_proyecto()}">CheckList</a>
                        <a class="collapse-item " href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVAvan&idProyecto=${proyectos.getIdtb_proyecto()}">Avance</a>
                    </div>
                </div>
            </li>

        </c:forEach>

        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Proyectos de soporte
        </div>

        <c:forEach var="proyectos" items="${listProyectos}">
            <li id="proys${proyectos.getIdtb_proyecto()}" class="nav-item ${(proyectos.getTarea()==null)?"d-none":""} ">
                <a class="nav-link collapsed bg-navbar-lateral-items" data-toggle="collapse" data-target="#proyectos${proyectos.getIdtb_proyecto()}" aria-expanded="true" aria-controls="collapseTwo" href="#">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>${proyectos.getNombre()}</span>
                </a>
                <div id="proyectos${proyectos.getIdtb_proyecto()}" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-navbar-lateral py-2 collapse-inner rounded">
                        <a class="collapse-item " href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVInf&idProyecto=${proyectos.getIdtb_proyecto()}">Informacion General</a>
                        <a class="collapse-item <%=(usuario.getPerfil_usuario().equals("A"))?"":"d-none"%> " href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVAdm&idProyecto=${proyectos.getIdtb_proyecto()}">Administrar</a>
                        <a class="collapse-item " href="#">Calendario</a>
                        <a class="collapse-item <%=(usuario.getPerfil_usuario().equals("T"))?"":"d-none"%>" href="${pageContext.request.contextPath}/ProyectoController?btnEnviar=getVTar&idProyecto=${proyectos.getIdtb_proyecto()}">Tarea</a>
                        <a class="collapse-item " href="${pageContext.request.contextPath}/pages/dashboard-proyecto/avance-requerimiento.html">Avance</a>
                    </div>
                </div>
            </li>
        </c:forEach>

        <li class="nav-item <%=(pagina.equals("newPro")) ? "active" : ""%> <%=(usuario.getPerfil_usuario().equals("A"))?"":"d-none"%>">
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

    <script>document.getElementById("proy<%=pagina%>").className += " active";</script>
    <script>document.getElementById("proys<%=pagina%>").className += " active";</script>


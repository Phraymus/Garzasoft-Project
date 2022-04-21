<%@page import="modelo.beans.Usuario"%>
<%@page import="modelo.beans.Persona"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-proyecto.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-usuario.css">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/bootstrap.min.css"> -->

    <!--functions for open windows-->
        <script src="${pageContext.request.contextPath}/js/functions.js"></script>

    <!--JQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!--functions for open windows-->
    <script src="${pageContext.request.contextPath}/js/functions.js"></script>

    <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

</head>
<script>
            $(function () {
                $('#file').on('change', function () {
                    file = $(this)[0].files[0];
                    var reader = new FileReader();
                    reader.onload = (function (theFile) {
                        return function (e) {
                            document.getElementById('imagenUsuario').src = e.target.result;
                        };
                    })(file);
                    reader.readAsDataURL(file);
                })
            });

            function editPassword() {
                $('#editPassword').modal('show');
                var codigo;
                abrirUrl('${pageContext.request.contextPath}/NotificacionesController?btnEnviar=doCodigo&idUsuario=${userSession.getIdtb_usuario()}', codigo);
            }
</script>

<body id="page-top">

        <jsp:include page="../../components/slide-bar.jsp?llamarPagina=usu" flush="true"/>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <jsp:include page="../../components/top-bar.jsp" flush="true"/>

                <!-- Begin Page Content -->

                <div id="contenedor-todo">
                    <div class="row">
                        <div class="col-md-4 col-sm-12 m-auto" id="" style="background-color: white;
    height: 650px;
    box-shadow: 0 0 40px rgb(224, 224, 224);">
                            <div class="container-fluid" id="contenedor-datos">
                                <div class="justify-content-md-center">
                                    <div id="imagen-pefil">
                                            <div id="imagen-usuario-contenedor">
                                                <img class="w-75 rounded-circle" id="" src="${pageContext.request.contextPath}/PersonaController?btnEnviar=getImage&id=${personaSession.getIdtb_persona()}">
                                            </div>
                                            <div id="imagen-button-change"><button id="camara-icon"><a data-toggle="modal" data-target="#fotoModal"><i id="icono-camara" class="fa fa-camera"></i></a></button></div>
                                            <div id="usuario-rol">${(userSession.getPerfil_usuario().equals("A"))?"Administrador":(userSession.getPerfil_usuario().equals("T"))?"Trabajador":"Cliente"}</div>
                                            <div id="usuario-nombre" class="text-dark">${userSession.getNombre()}</div>
                                    </div>

                                    <div>
                                        <div id="nombre-div-encabezdo">Número de identificación: </div>
                                        <div> ${personaSession.getNumero_identificacion()}</div>
                                    </div>
                                    <div>
                                        <div id="nombre-div-encabezdo">${(userSession.getPerfil_usuario().equals("C"))?"Nombre Empresa:":""} </div>
                                        <div> ${(userSession.getPerfil_usuario().equals("C"))?clienteSession.getNombreEmpresa():""}</div>
                                    </div>
                                    <div>
                                        <div id="nombre-div-encabezdo">${(userSession.getPerfil_usuario().equals("C"))?"RUC:":""} </div>
                                        <div> ${(userSession.getPerfil_usuario().equals("C"))?clienteSession.getRuc():""}</div>
                                    </div>
                                </div>


                            </div>
                        </div>

                        <div class="col-md-7 col-sm-12 m-auto" id="tabla-blanca-2">
                            <div id="perfl-titulo">
                                EDITAR PERFIL
                            </div>
                            <form action="${pageContext.request.contextPath}/UsuarioController?btnEnviar=setUser" method="post">
                                <div>
                                <div class="container">
                                    <div class="row justify-content-md-start" id="contenedo">
                                            <div class="col">
                                                <div id="datos-nombre">Nombres:</div>
                                                <input name="txtNombres" type="text" class="form-control" id="input-nombre" value="${personaSession.getNombre()}">

                                                <div id="datos-nombre">Apellido paterno:</div>
                                                <input name="txtApellidoPaterno" type="text" class="form-control" id="input-nombre" value="${personaSession.getApellido_paterno()}">

                                                <div id="datos-nombre">Apellido materno:</div>
                                                <input name="txtApellidoMaterno" type="text" class="form-control" id="input-nombre" value="${personaSession.getApellido_materno()}">
                                            </div>
                                            <div class="col">
                                                <div id="datos-nombre">E-mail:</div>
                                                <input name="txtCorreo" type="email" class="form-control" id="input-nombre" value="${personaSession.getCorreo()}">

                                                <div id="datos-nombre">Télefono:</div>
                                                <input name="txtTelefono" type="text" class="form-control" id="input-nombre" value="${telefonoSession.getNumero()}">

                                                <div id="datos-nombre">Contraseña:</div>
                                                <div class="input-group mb-3" id="contraseña-container">
                                                    <input type="password" class="form-control" id="text-pssword"
                                                        aria-label="" aria-describedby="basic-addon1" placeholder="Haga clic en el ícono" disabled>
                                                    <div class="input-group-prepend" id="boton-password">
                                                        <button class="btn btn-outline-secondary" type="button"><a href="javascript:editPassword()"><i
                                                                class="fa fa-unlock-alt"></i></a></button>
                                                    </div>
                                                </div>
 
                                            </div>
                                            
                                        </div>


                                        <div class="container">
                                            <div class="row justify-content-md-center" id="contenedo">
                                                 
                                                <button type="submit" class="btn btn-success" id="botonesGurdar">Guardar</button>
                                                <button type="button" class="btn btn-danger" id="botonesGurdar">Cancelar</button>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                            </form>

                        </div>

                </div>

        
        <!-- Modal Cambiar Foto -->

        <div id="fotoModal" class="modal fade" >
            <div class="modal-dialog">
                <div class="modal-content">
                        <div class="modal-header">
                            <h4 id="titulo-confirmacion-modal" class="modal-title">Actualizar foto</h4>
                            <button type="button" class="close mr-1" style="width:50px" data-dismiss="modal" aria-label="Close">
                                &times;
                            </button>
                        </div>
                        <form name="frmConfirmacionModal" action="${pageContext.request.contextPath}/UsuarioController?btnEnviar=setUserFoto" method="post" enctype="multipart/form-data">
                        <div class="modal-body">
                                <div class="align-content-center">
                                    <div id="imagen-titulo-encabezado">Imagen de perfil</div>
                                    <div id="imagen-usuario-contenedor-modal">
                                        <img class="w-50 rounded-circle" id="imagenUsuario" src="${pageContext.request.contextPath}/PersonaController?btnEnviar=getImage&id=${personaSession.getIdtb_persona()}">
                                    </div>
                                    <div class="custom-file">
                                        <input id="file" type="file" name="txtImagen" aria-label="Archivo">
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" id="botonesfoto" class="btn btn-success">Guardar</button>
                            <button data-dismiss="modal" id="botonesfoto" class="btn btn-danger">Cancelar</button>    
                        </div>
                        </form>
                </div>
            </div>
        </div>

        <!-- Modal Cambiar Contraseña -->

        <div id="editPassword" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar contraseña</h4>
                        <button class="close mr-1" style="width:50px" onclick="$('#editPassword').modal('hide');">
                                &times;
                            </button>
                    </div>

                    <div class="modal-body">
                        <table class="mr-3 ml-2">
                            <tr>
                                <td>
                                    <h5 class="mt-3">Ingrese su nueva contraseña</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>

                                <td>
                                    <div class="input-group">
                                        <span class="input-group-text" id="basic-addon1"><i
                                                class="fas fa-key fa-sm text-dark-50"></i></span>
                                        <input type="password" class="form-control text-dark" type="text">
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <h5 class="mt-3">Repetir contraseña</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>

                                <td>
                                    <div class="input-group">
                                        <span class="input-group-text" id="basic-addon1"><i
                                                class="fas fa-key fa-sm text-dark-50"></i></span>
                                        <input type="password" class="form-control text-dark" type="text">
                                    </div>

                                </td>
                            </tr>

                            <tr>
                                <td class="text-justify" colspan="5">
                                    <p class="mt-3">Ingrese el código enviado a su teléfono. <a href="">Reenviar código</a></p>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <h5 class="mt-3">Codigo</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>

                                <td>
                                    <div class="input-group">
                                        <span class="input-group-text" id="basic-addon1">123</span>
                                        <input type="text" class="form-control text-dark" type="text">
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button onclick="$('#editPassword').modal('hide');" class="btn btn-danger mb-3 ml-lg-5 ml-md-5 ml-sm-2">Cancelar</button> 
                        <input type="button" class="btn btn-success mb-3 ml-lg-5 ml-md-5 ml-sm-2" value="Guardar cambios">
                    </div>
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
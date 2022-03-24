<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin-2.min.css">
        <title>
            Inicio de sesión
        </title>

        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>

    <body onkeypress="if (event.keyCode == 13) {
                autentificar();
            }">

        <script>
            function autentificar() {
                document.frmLogin.submit();
            }

            function error() {
                Swal.fire({
                    icon: 'error',
                    title: 'No autentificado',
                    text: 'Usuario o contraseña incorrectos',
                })
            }
        </script>

        <%
            if (request.getAttribute("respuesta") != null) {
                out.print("<script>error()</script>");
            }
        %>
        <div class="login-container">
            <img class="image-container" src="${pageContext.request.contextPath}/img/login/imagen.png" alt="login">
            <div class="login-info-container bg-white">
                <a href="../index.html"><img src="${pageContext.request.contextPath}/img/login/logo.png" alt="gazasoft-img"></a>
                <h1 class="title font-weight-bold">INICIO DE SESION</h1>
                <p>¡Ingresa tus datos!</p>
                <form action="${pageContext.request.contextPath}/UsuarioController?btnEnviar=autentificarUsuario" method="post" class="inputs-container" name="frmLogin">
                    <div>
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                        </svg>
                        <input name="txtUser"  class="input" type="text" id="txtUsuario" placeholder="Usuario"></span>
                    </div>
                    <div>
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-key-fill" viewBox="0 0 16 16">
                        <path d="M3.5 11.5a3.5 3.5 0 1 1 3.163-5H14L15.5 8 14 9.5l-1-1-1 1-1-1-1 1-1-1-1 1H6.663a3.5 3.5 0 0 1-3.163 2zM2.5 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                        </svg>
                        <input name="txtPassword" class="input" type="password" id="txtPassword" placeholder="Contraseña"></span>
                    </div>

                    <a class="btn btn-primary" href="javascript:autentificar()">Iniciar Sesión</a>
                    <p>¿Olvidaste tu contraseña? <span class="span"><a>Clic aquí</a></span></p>
                </form>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


    </body>

</html>
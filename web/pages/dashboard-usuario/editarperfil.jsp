<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>informaciondelacuenta</title>
    <%@page contentType="text/html"%>
    <%@page pageEncoding="UTF-8"%> 
</head>

<body>
    <script>
        function tipoIdentificacion() {
            if (document.getElementById("cmbIdentificacionEdit").value == "N") {
                document.getElementById("EEdit").className = "d-none";
                document.getElementById("NEdit").className = "";
            } else {
                document.getElementById("EEdit").className = "";
                document.getElementById("NEdit").className = "d-none";
            }

            if (document.getElementById("cmbIdentificacionAdd").value == "N") {
                document.getElementById("EAdd").className = "d-none";
                document.getElementById("NAdd").className = "";
            } else {
                document.getElementById("EAdd").className = "";
                document.getElementById("NAdd").className = "d-none";
            }
        }

        $(function() {
            $('#file').on('change', function() {
                file = $(this)[0].files[0];
                var reader = new FileReader();
                reader.onload = (function(theFile) {
                    return function(e) {
                        document.getElementById('fotoEditarUsuario').src = e.target.result;
                    };
                })(file);
                reader.readAsDataURL(file);
            })
        });

        document.getElementById('fotoEditarUsuario').src = "${pageContext.request.contextPath}/img/dashboard/usuario.png"
    </script>
    <div class="container-fluid">
        <div class="d-md-flex align-items-start justify-content-between mb-4">
            <div class="col-xl-9 col-md-9 col-sm-12">
                <table>
                    <tr>
                        <td>
                            <h5 class="mt-3">Nombre de usuario</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>

                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="ADBECEO2001" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class="mt-3">Nombres</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="BRAYAN DANIEL">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class="mt-3">Apellido paterno</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="CARRASCO">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class="mt-3">Apellido materno</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="OCAÑA">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <h5 class="mt-3">Correo</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="email" value="bcarrascoo@outlook.com">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class="mt-3">Tipo de identificacion</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <select id="cmbIdentificacionEdit" onchange="javascript:tipoIdentificacion()" class=" ml-3 mt-3 form-control">
                                <option value="N">
                                    Nacional
                                </option>
                                <option value="E">
                                    Extranjero
                                </option>
                            </select>
                        </td>
                    </tr>

                    <tr id="NEdit">
                        <td>
                            <h5 class="mt-3">DNI</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="73135470" minlength="8" maxlength="8" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                        </td>
                    </tr>

                    <tr id="EEdit" class="d-none">
                        <td>
                            <h5 class="mt-3">Carnet de extranjería</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="73135470" minlength="12" maxlength="12" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <h5 class="mt-3">Telefono</h5>
                        </td>
                        <td>
                            <h5 class="mt-3">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="902521511" minlength="9" maxlength="9" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class=" mt-3 ">Nombre de la empresa</h5>
                        </td>
                        <td>
                            <h5 class="mt-3 ">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="GARZASOFT">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5 class="mt-3 ">RUC</h5>
                        </td>
                        <td>
                            <h5 class="mt-3 ">:</h5>
                        </td>
                        <td>
                            <input class="form-control ml-3 mt-3 text-dark" type="text" value="10603645948" minlength="11" maxlength="11" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                        </td>
                    </tr>
                </table>
            </div>

            <div class="col-xl-4 text-center">
                <a href="javascript:editarContrasenia()" class="btn btn-primary shadow-sm mt-3"><i
                    class="fas fa-key fa-sm text-white-50"></i> Cambiar Contraseña</a>

                <img id="fotoEditarUsuario" class="d-none d-lg-inline-block mt-5 w-50 h-50" src="${pageContext.request.contextPath}/img/dashboard/usuario.png" alt="Usuario">

                <br class="d-none d-lg-inline-block mt-5">
                <div>
                    <input id="file" type="file" style="display: none;">
                    <label for="file" class="btn btn-md btn-primary shadow-sm mt-3"><i
                                    class="fas fa-upload fa-sm text-white-50"></i> Cargar imagen</label>
                </div>
            </div>
        </div>

        <input type="button" class="btn btn-success mb-3 ml-lg-5 ml-md-5 ml-sm-2" value="Guardar cambios">
        <input type="button" class="btn btn-danger mb-3 ml-lg-5 ml-md-5 ml-sm-2" value="Cancelar">


        <!-- Modal Cambiar Contraseña -->

        <div id="editPassword" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar contraseña</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
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
                                    <p class="mt-3">Ingrese el código enviado a su correo electrónico. <a href="">Reenviar código</a></p>
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
                        <input type="button" class="btn btn-danger mb-3 ml-lg-5 ml-md-5 ml-sm-2" data-bs-dismiss="modal" value="Cancelar">
                        <input type="button" class="btn btn-success mb-3 ml-lg-5 ml-md-5 ml-sm-2" value="Guardar cambios">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 

    </head>

    <body>
        <script>
            $(function () {
                $('#file').on('change', function () {
                    file = $(this)[0].files[0];
                    var reader = new FileReader();
                    reader.onload = (function (theFile) {
                        return function (e) {
                            document.getElementById('fotoNuevoUsuario').src = e.target.result;
                        };
                    })(file);
                    reader.readAsDataURL(file);
                })
            });

            $(function () {
                $('#file').on('change', function () {
                    file = $(this)[0].files[0];
                    var reader = new FileReader();
                    reader.onload = (function (theFile) {
                        return function (e) {
                            document.getElementById('fotoEditarUsuario').src = e.target.result;
                        };
                    })(file);
                    reader.readAsDataURL(file);
                })
            });

            $(document).ready(function () {
                $('#example').DataTable({
                    //para cambiar el lenguaje a español
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros",
                        "zeroRecords": "No se encontraron resultados",
                        "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                        "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                        "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                        "sSearch": "Buscar:",
                        "oPaginate": {
                            "sFirst": "Primero",
                            "sLast": "Último",
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior"
                        },
                        "sProcessing": "Procesando...",
                    }
                });
            });


            function editUser() {
                $('#editUser').modal('show');
                document.getElementById('fotoEditarUsuario').src = "${pageContext.request.contextPath}/img/dashboard/usuario.png"
            }

            function addUser() {
                $('#addUser').modal('show');
                document.getElementById('fotoNuevoUsuario').src = "${pageContext.request.contextPath}/img/dashboard/usuario.png"
            }

            function deleteUser() {
                $('#deleteUser').modal('show');
            }

            function editPassword() {
                $('#addUser').modal('hide');
                $('#editUser').modal('hide');
                $('#editPassword').modal('show');
            }


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
            function getDepartamentos(cont, open) {
                id = document.getElementById(open).value;
                document.getElementById(cont).innerHTML = "<option>Cargando...</option>"
                abrirUrl('${pageContext.request.contextPath}/CRUDGestionUsuarioController?btnEnviar=getDepartamentos&idPais=' + id, cont);
            }

            function getCiudades(cont, open) {
                id = document.getElementById(open).value;
                document.getElementById(cont).innerHTML = "<option>Cargando...</option>"
                abrirUrl('${pageContext.request.contextPath}/CRUDGestionUsuarioController?btnEnviar=getCiudades&idDepartamento=' + id, cont);
            }
        </script>


        <div class="container-fluid mt-3">
            <div class="d-md-flex align-items-start justify-content-between mb-4">
                <div class="table-responsive w-100 p-3">

                    <table id="example" class="table table-striped" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col" class="font-weight-bold">Nombre Usuario</th>
                                <th scope="col" class="font-weight-bold">Nombres</th>
                                <th scope="col" class="font-weight-bold">Apellidos Paterno</th>
                                <th scope="col" class="font-weight-bold">Apellido Materno</th>
                                <th scope="col" class="font-weight-bold">N° Identificacion</th>
                                <th scope="col" class="font-weight-bold"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>beceo2001</td>
                                <td>BRAYAN DANIEL</td>
                                <td>CARRASCO</td>
                                <td>OCAÑA</td>
                                <td>73135470</td>
                                <td>
                                    <a class="btn btn-sm btn-circle bg-warning text-white" href="javascript:editUser()"><i class="fas fa-pen"></i></a>
                                    <a class="btn btn-sm btn-circle bg-danger text-white" href="javascript:deleteUser()"><i class="fas fa-trash"></i></a>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>

            </div>
        </div>


        <!-- Modal Nuevo Usuario Trabajador -->

        <div id="addUser" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Agregar usuario trabajador</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>

                    <form action="${pageContext.request.contextPath}/CRUDGestionUsuarioController?btnEnviar=putUser" method="post" enctype="multipart/form-data">
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <td>
                                        <h5 class="mt-3">Nombres</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input name="txtNombres" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" >
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
                                        <input name="txtApellidoPaterno" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text">
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
                                        <input name="txtApellidoMaterno" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text">
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
                                        <input name="txtCorreo" class="form-control ml-1 mt-3 text-dark" type="email">
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
                                        <select name="txtTipoIdentificacion" id="cmbIdentificacionAdd" onchange="javascript:tipoIdentificacion()" class=" ml-1 mt-3 form-control">
                                            <option value="N">
                                                Nacional
                                            </option>
                                            <option value="E">
                                                Extranjero
                                            </option>
                                        </select>
                                    </td>
                                </tr>

                                <tr id="NAdd">
                                    <td>
                                        <h5 class="mt-3">DNI</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input name="txtDni" class="form-control ml-1 mt-3 text-dark" type="text" minlength="8" maxlength="8" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                                    </td>
                                </tr>

                                <tr id="EAdd" class="d-none">
                                    <td>
                                        <h5 class="mt-3">Carnet de extranjería</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <input name="txtCarnet" class="form-control ml-1 mt-3 text-dark" type="text" value="" minlength="12" maxlength="12" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
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
                                        <input name="txtTelefono" class="form-control ml-1 mt-3 text-dark" type="text" minlength="9" maxlength="9" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h5 class="mt-3">País:</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <select name="txtPais" id="cmbPaisesAdd" onchange="getDepartamentos('cmbDepartamentosAdd', 'cmbPaisesAdd')" class=" ml-1 mt-3 form-control">
                                            <option value="0">
                                                Seleccione
                                            </option>

                                            <c:forEach var="pais" items="${lstPaises}">
                                                <option value="${pais.getIdtb_pais()}">
                                                    ${pais.getNombre()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h5 class="mt-3">Departamento:</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <select name="txtDepartamento" id="cmbDepartamentosAdd" onchange="getCiudades('cmbCiudadesAdd', 'cmbDepartamentosAdd')" class=" ml-1 mt-3 form-control">
                                            <option value="0">
                                                Seleccione
                                            </option>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h5 class="mt-3">Ciudad:</h5>
                                    </td>
                                    <td>
                                        <h5 class="mt-3">:</h5>
                                    </td>
                                    <td>
                                        <select name="txtCiudad" id="cmbCiudadesAdd" onchange="" class=" ml-1 mt-3 form-control">
                                            <option value="0">
                                                Seleccione
                                            </option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <div class="col-xl-12 text-center">
                                <div class="col-xl-12">
                                    <a href="javascript:editPassword()" class="btn btn-primary shadow-sm mt-3"><i class="fas fa-key  fa-sm text-white-50"></i>
                                        Cambiar Contraseña</a>
                                </div>

                                <div class="col-xl-12">
                                    <img id="fotoNuevoUsuario" class="d-none d-lg-inline-block mt-5 w-25 h-25" src="${pageContext.request.contextPath}/img/dashboard/usuario.png" alt="Usuario">

                                    <br class="d-none d-lg-inline-block mt-5">
                                    <div>
                                        <input name="txtImagen" id="file" type="file" style="display: none;">
                                        <label for="file" class="btn btn-md btn-primary shadow-sm mt-3"><i
                                                class="fas fa-upload fa-sm text-white-50"></i> Cargar imagen</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-danger mb-3" data-bs-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-success mb-3" value="Agregar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal Editar Usuario Trabajador -->

        <div id="editUser" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar usuario trabajador</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>

                    <div class="modal-body">
                        <table>
                            <tr>
                                <td>
                                    <h5 class="">Nombre de usuario</h5>
                                </td>
                                <td>
                                    <h5 class="">:</h5>
                                </td>

                                <td>
                                    <div class="input-group ml-1">
                                        <span class="input-group-text" id="basic-addon1"><i
                                                class="fas fa-user fa-sm text-dark-50"></i></span>
                                        <input style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control  text-dark" value="ADBECEO2001" disabled>
                                    </div>
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
                                    <input style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" value="BRAYAN DANIEL">
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
                                    <input style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" value="CARRASCO">
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
                                    <input style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text" value="OCAÑA">
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
                                    <input class="form-control ml-1 mt-3 text-dark" type="email" value="bcarrascoo@outlook.com">
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
                                    <select id="cmbIdentificacionEdit" onchange="javascript:tipoIdentificacion()" class=" ml-1 mt-3 form-control">
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
                                    <input class="form-control ml-1 mt-3 text-dark" type="text" value="73135470" minlength="8" maxlength="8" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
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
                                    <input class="form-control ml-1 mt-3 text-dark" type="text" value="73135470" minlength="12" maxlength="12" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
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
                                    <input class="form-control ml-1 mt-3 text-dark" type="text" value="902521511" minlength="9" maxlength="9" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 class="mt-3">País:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <select id="cmbIdentificacionAdd" onchange="" class=" ml-1 mt-3 form-control">
                                        <option value="0">
                                            Seleccione
                                        </option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <h5 class="mt-3">Departamento:</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <select id="cmbIdentificacionAdd" onchange="" class=" ml-1 mt-3 form-control">
                                        <option value="0">
                                            Seleccione
                                        </option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <h5 class="mt-3">Ciudad</h5>
                                </td>
                                <td>
                                    <h5 class="mt-3">:</h5>
                                </td>
                                <td>
                                    <input style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" class="form-control ml-1 mt-3 text-dark" type="text">
                                </td>
                            </tr>
                        </table>
                        <div class="col-xl-12 text-center">
                            <div class="col-xl-12">
                                <a href="javascript:editPassword()" class="btn btn-primary shadow-sm mt-3"><i class="fas fa-key  fa-sm text-white-50"></i>
                                    Cambiar Contraseña</a>
                            </div>

                            <div class="col-xl-12">
                                <img id="fotoEditarUsuario" class="d-none d-lg-inline-block mt-5 w-25 h-25" src="${pageContext.request.contextPath}/img/dashboard/usuario.png" alt="Usuario">

                                <br class="d-none d-lg-inline-block mt-5">
                                <div>
                                    <input id="file" type="file" style="display: none;">
                                    <label for="file" class="btn btn-md btn-primary shadow-sm mt-3"><i
                                            class="fas fa-upload fa-sm text-white-50"></i> Cargar imagen</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-danger mb-3" data-bs-dismiss="modal" value="Cancelar">
                        <input type="button" class="btn btn-success mb-3" value="Guardar cambios">
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal Eliminar Usuario Trabajador -->

        <div id="deleteUser" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar usuario trabajador</h4>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <h4 class="ml-3 mt-2">¿Esta seguro de eliminar al usuario?</h4>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-success mb-3" data-bs-dismiss="modal" value="No">
                        <input type="button" class="btn btn-danger mb-3" value="Si">
                    </div>
                </div>
            </div>
        </div>

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


    </body>

</html>
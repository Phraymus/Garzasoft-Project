<!DOCTYPE html>
<html lang="es">

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>informaciondemodulos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout-avance.css" type="text/css">
    <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 
</head>

<body>
        <div class="table-responsive w-100 p-3">
        <table id="table-modulos" class="table table-responsive-xxl table-hover">
            <thead id="cabeza-table" class="table-light">
                <tr class="table table-bordered">
                    <th id="table-id" class="col-1 table-id"> ID </th>
                    <th id="table-name" class="col-10">NOMBRE MÓDULO</th>
                    <th id="table-estado" class="col-10">ESTADO</th>
                    </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="modulos" items="${mapModulos}">

                <tr class="table-light table-responsive-xxl">
                    <td scope="row" class="font-weight-bold ">${modulos.key.getIdtb_modulo()}</td>
                    <td scope="col" class="font-weight-bold">${modulos.key.getNombre()}</td>
                    <td scope="col" class="font-weight-bold">${(modulos.key.getEstado().equals("P"))?"Pendiente":(modulos.key.getEstado().equals("P"))?"En progreso":"Terminado"}</td>
                </tr>
                </c:forEach>

            </tbody>

        </table>
    </div>



</body>

</html>
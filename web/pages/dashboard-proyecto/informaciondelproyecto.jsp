<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="modelo.beans.Proyecto"%>
<%@page import="modelo.dao.ProyectoDAO"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>informaciondelproyecto</title>
    <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%> 
</head>

    
<body>
    
    <table>
        <tr>
            <td>
                <h5 class="mt-3">Nombre de proyecto</h5>
            </td>
            <td>
                <h5 class="mt-3">:</h5>
            </td>
            <td>
                <h5 class="mt-3 ml-3 text-dark">${infoProyecto.getNombre()}</h5>
            </td>
        </tr>
        <tr>
            <td>
                <h5 class="mt-3">Estado</h5>
            </td>
            <td>
                <h5 class="mt-3">:</h5>
            </td>
            <td>
                <h5 class="mt-3 ml-3 text-dark">${(infoProyecto.getEstado().equals("P"))?"Pendiente":(infoProyecto.getEstado().equals("E"))?"En proceso":"Terminado"}</h5>
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
                <h5 class="mt-3 ml-3 text-dark"><fmt:formatDate value = "${infoProyecto.getFecha_inicio()}" pattern = "dd/MM/yyyy"/></h5>
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
                <h5 class="mt-3 ml-3 text-dark"><fmt:formatDate value = "${infoProyecto.getFecha_fin()}" pattern = "dd/MM/yyyy"/></h5>
            </td>
        </tr>
        <tr>
            <td>
                <h5 class="mt-3">Programador</h5>
            </td>
            <td>
                <h5 class="mt-3">:</h5>
            </td>
            <td>
                <h5 class="mt-3 ml-3 text-dark">${infoProgramador.getNombre()} ${infoProgramador.getApellido_paterno()} ${infoProgramador.getApellido_materno()}</h5>
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
                <h5 class="mt-3 ml-3 text-dark">${infoCliente.getNombre()} ${infoCliente.getApellido_paterno()} ${infoCliente.getApellido_materno()}</h5>
            </td>
        </tr>
    </table>
</body>

</html>
<!-- <dl class="row ">
    <dt class="col-sm-3 ">Description lists</dt>
    <dd class="col-sm-9 ">A description list is perfect for defining terms.</dd>
  
    <dt class="col-sm-3 ">Term</dt>
    <dd class="col-sm-9 ">
      <p>Definition for the term.</p>
      <p>And some more placeholder definition text.</p>
    </dd>
</dl> -->
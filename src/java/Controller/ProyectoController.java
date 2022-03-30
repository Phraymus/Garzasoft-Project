/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import config.Information;
import config.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.Cliente;
import modelo.beans.Modulo;
import modelo.beans.Proyecto;
import modelo.beans.Requerimiento;
import modelo.logic.ClienteLogic;
import modelo.logic.ProyectoLogic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author phraymus
 */
@WebServlet(name = "ProyectoController", urlPatterns = {"/ProyectoController"})
public class ProyectoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProyectoLogic proyectoLogic = new ProyectoLogic();
    ClienteLogic clienteLogic = new ClienteLogic();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("btnEnviar").equals("getVAdm")) {
                getVAdm(request, response);
            }
            if (request.getParameter("btnEnviar").equals("getProy")) {
                getProy(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doPutRequerimiento")) {
                doPutRequerimiento(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doUpdateRequerimiento")) {
                doUpdateRequerimiento(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doUpdateEstadoRequerimiento")) {
                doUpdateEstadoRequerimiento(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doPutModulo")) {
                doPutModulo(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doUpdateModulo")) {
                doUpdateModulo(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doPut")) {
                doPut(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doDeleteRequerimiento")) {
                doDeleteRequerimiento(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doDeleteModulo")) {
                doDeleteModulo(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /*Funcion que me va a retornar lista de modulos a partir de un id proyecto*/
    public void getProy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("idProyecto"));

        JSONArray jsonArray = new JSONArray();
        JSONObject json;
        JSONParser jsonParser = new JSONParser();

        LinkedHashMap<Modulo, ArrayList<Requerimiento>> mapModulos = new LinkedHashMap<>();

        try {
            String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + "/ModuloController?btnEnviar=doList&idProyecto=" + id);
            Object obj = jsonParser.parse(respuesta);
            json = (JSONObject) obj;

            jsonArray = (JSONArray) json.get("modulos");

            Iterator<Object> iterator = jsonArray.iterator();

            while (iterator.hasNext()) {
                String modulos = iterator.next().toString();
                obj = jsonParser.parse(modulos);
                json = (JSONObject) obj;
                Modulo modulo = new Modulo(Integer.parseInt(json.get("id").toString()), json.get("nombre").toString(), json.get("estado").toString(), Integer.parseInt(json.get("tb_proyecto_id").toString()));

                ArrayList<Requerimiento> requerimientos = new ArrayList<>();

                jsonArray = (JSONArray) json.get("requerimientos");

                Iterator<Object> iterator1 = jsonArray.iterator();
                while (iterator1.hasNext()) {
                    String requerimientoString = iterator1.next().toString();
                    obj = jsonParser.parse(requerimientoString);
                    json = (JSONObject) obj;
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                    Requerimiento requerimiento = new Requerimiento(Integer.parseInt(json.get("id").toString()), json.get("nombre").toString(), json.get("estado").toString(), new java.sql.Timestamp(formatoFecha.parse(json.get("fecha_inicio").toString()).getTime()), new java.sql.Timestamp(formatoFecha.parse(json.get("fecha_fin").toString()).getTime()), Integer.parseInt(json.get("tb_modulo_id").toString()));
                    requerimientos.add(requerimiento);
                }
                mapModulos.put(modulo, requerimientos);
            }
            request.setAttribute("mapModulos", mapModulos);
            request.setAttribute("infoProyecto", proyectoLogic.buscar(id));
        } catch (ParseException ex) {
        } catch (java.text.ParseException ex) {
        }

    }

    public void getVAdm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        RequestDispatcher rd = request.getRequestDispatcher("pages/dashboard-administar/administrar.jsp");

        try ( PrintWriter out = response.getWriter()) {
            getProy(request, response);
            rd.forward(request, response);
        }
    }

    public void doPutRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        String nombre = Utilities.getParameter(request.getParameter("txtNombre"));
        String fecha_inicio = request.getParameter("txtFechaInicio");
        String fecha_fin = request.getParameter("txtFechaFin");
        String idModulo = request.getParameter("idModulo");

        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/RequerimientoController?btnEnviar=doPut&txtNombre=%s&txtFechaInicio=%s&txtFechaFin=%s&idModulo=%s", nombre, fecha_inicio, fecha_fin, idModulo));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }

    }

    public void doUpdateRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {

        String idRequerimiento = request.getParameter("idRequerimiento");
        String nombre = Utilities.getParameter(request.getParameter("txtNombre"));
        String fecha_inicio = request.getParameter("txtFechaInicio");
        String fecha_fin = request.getParameter("txtFechaFin");
        String idModulo = request.getParameter("idModulo");

        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/RequerimientoController?btnEnviar=doUpdate&idRequerimiento=%s&txtNombre=%s&txtFechaInicio=%s&txtFechaFin=%s&idModulo=%s",idRequerimiento, nombre, fecha_inicio, fecha_fin, idModulo));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }
    
    public void doUpdateEstadoRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {

        String idRequerimiento = request.getParameter("idRequerimiento");
        String estado = Utilities.getParameter(request.getParameter("txtEstado"));
        
        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/RequerimientoController?btnEnviar=doUpdateEstado&idRequerimiento=%s&txtEstado=%s",idRequerimiento, estado));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }

    public void doPutModulo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        String nombre = Utilities.getParameter(request.getParameter("txtNombre"));
        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/ModuloController?btnEnviar=doPut&txtNombre=%s&idProyecto=%s", nombre, idProyecto));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }
    
    public void doUpdateModulo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        
        String idModulo= request.getParameter("idModulo");
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        String nombre = Utilities.getParameter(request.getParameter("txtNombre"));
        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/ModuloController?btnEnviar=doUpdate&idModulo=%s&txtNombre=%s&idProyecto=%s",idModulo, nombre, idProyecto));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }

    public void doDeleteRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {

        int idRequerimiento = Integer.parseInt(request.getParameter("idRequerimiento"));

        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/RequerimientoController?btnEnviar=doDelete&idRequerimiento=%s", idRequerimiento));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }

    public void doDeleteModulo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {

        int idModulo = Integer.parseInt(request.getParameter("idModulo"));

        String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + String.format("/ModuloController?btnEnviar=doDelete&idModulo=%s", idModulo));

        if (respuesta.equals("true")) {
            response.sendRedirect("ProyectoController?btnEnviar=getVAdm&idProyecto="+request.getParameter("idProyecto"));
        } else {
            System.out.println("false");
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        try {
            String nombre = request.getParameter("txtNombreProyecto");

            int cliente = Integer.parseInt(request.getParameter("txtCliente"));
            int trabajador = Integer.parseInt(request.getParameter("txtTrabajador"));

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            java.sql.Timestamp fecha_inicio = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaInicio")).getTime());
            java.sql.Timestamp fecha_fin = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaFin")).getTime());

            String checkList = request.getParameter("txtChecklist");
            String tarea = request.getParameter("txtTarea");
            String descripcion = request.getParameter("txtDescripcion");
            Proyecto proyecto = null;
            Cliente clienteObj = clienteLogic.buscar(cliente);

            if (request.getParameter("txtTipoProyecto").equals("Desarrollo")) {
                proyecto = new Proyecto(0, nombre, "P", fecha_inicio, fecha_fin, null, null, checkList, clienteObj.getNombreEmpresa(), clienteObj.getRuc(), Information.getIDADMIN(), cliente, trabajador);
            } else {
                proyecto = new Proyecto(0, nombre, "P", fecha_inicio, fecha_fin, tarea, descripcion, null, clienteObj.getNombreEmpresa(), clienteObj.getRuc(), Information.getIDADMIN(), cliente, trabajador);
            }

            if (proyectoLogic.insertar(proyecto)) {
                response.sendRedirect("pages/dashboard-nuevoProyecto/nuevoProyecto.jsp");
            } else {
                System.out.println("false");
            }
        } catch (Exception e) {
        }
    }
}

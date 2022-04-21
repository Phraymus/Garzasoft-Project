/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.Requerimiento;
import modelo.logic.RequerimientoLogic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author phraymus
 */
@WebServlet(name = "RequerimientoController", urlPatterns = {"/RequerimientoController"})
public class RequerimientoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RequerimientoLogic requerimientoLogic = new RequerimientoLogic();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("btnEnviar").equals("doList")) {
                doList(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doPut")) {
                doPut(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doUpdate")) {
                doUpdate(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doUpdateEstado")) {
                doUpdateEstado(request, response);
            }
            if (request.getParameter("btnEnviar").equals("doDelete")) {
                doDelete(request, response);
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

    /*Funcion que me va a retornar lista de requerimientos a partir de un id modulo*/
    public void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("idModulo"));

        JSONArray jsonArray = new JSONArray();
        JSONObject json;
        try ( PrintWriter out = response.getWriter()) {

            ArrayList<Requerimiento> listRequerimiento = requerimientoLogic.listarPorModulo(id);
//            request.setAttribute("listRequerimiento", listRequerimiento);

            for (int i = 0; i < listRequerimiento.size(); i++) {
                json = new JSONObject();
                json.put("id", listRequerimiento.get(i).getIdtb_requerimiento());
                json.put("nombre", listRequerimiento.get(i).getNombre());
                json.put("estado", listRequerimiento.get(i).getEstado());
                json.put("fecha_inicio", new SimpleDateFormat("dd-MM-yyyy").format(new Date(listRequerimiento.get(i).getFecha_inicio().getTime())));
                json.put("fecha_fin", new SimpleDateFormat("dd-MM-yyyy").format(new Date(listRequerimiento.get(i).getFecha_fin().getTime())));
                json.put("tb_modulo_id", listRequerimiento.get(i).getTb_modulo_id());

                jsonArray.add(json);

            }

            out.print(jsonArray.toString());
        }
    }

    /*Funcion que me va a retornar lista de requerimientos a partir de un id modulo*/
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            String nombre = request.getParameter("txtNombre");
            java.sql.Timestamp fecha_inicio = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaInicio")).getTime());
            java.sql.Timestamp fecha_fin = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaFin")).getTime());
            int idModulo = Integer.parseInt(request.getParameter("idModulo"));

            Requerimiento requerimiento = new Requerimiento(0, nombre, "P", fecha_inicio, fecha_fin, idModulo);

            if (requerimientoLogic.insertar(requerimiento)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } catch (java.text.ParseException ex) {
            Logger.getLogger(RequerimientoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*Funcion que me va a retornar lista de requerimientos a partir de un id modulo*/
    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            
            int idRequerimiento=Integer.parseInt(request.getParameter("idRequerimiento"));
            String nombre = request.getParameter("txtNombre");
            java.sql.Timestamp fecha_inicio = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaInicio")).getTime());
            java.sql.Timestamp fecha_fin = new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFechaFin")).getTime());
            int idModulo = Integer.parseInt(request.getParameter("idModulo"));
            
            Requerimiento requerimientoAux=requerimientoLogic.buscar(idRequerimiento);

            Requerimiento requerimiento = new Requerimiento(idRequerimiento, nombre, requerimientoAux.getEstado(), fecha_inicio, fecha_fin, idModulo);

            if (requerimientoLogic.editar(requerimiento)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } catch (java.text.ParseException ex) {
            Logger.getLogger(RequerimientoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doUpdateEstado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            
            int idRequerimiento=Integer.parseInt(request.getParameter("idRequerimiento"));
            String estado = request.getParameter("txtEstado");
            
            Requerimiento requerimiento=requerimientoLogic.buscar(idRequerimiento);
            requerimiento.setEstado(estado);

            if (requerimientoLogic.editarEstado(requerimiento)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } catch (Exception ex) {
            Logger.getLogger(RequerimientoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {

            int idRequerimiento = Integer.parseInt(request.getParameter("idRequerimiento"));
            if (requerimientoLogic.eliminar(idRequerimiento)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import config.Information;
import config.Utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.Modulo;
import modelo.beans.Requerimiento;
import modelo.logic.ModuloLogic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author phraymus
 */
@WebServlet(name = "ModuloController", urlPatterns = {"/ModuloController"})
public class ModuloController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ModuloLogic moduloLogic = new ModuloLogic();

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

    /*Funcion que me va a retornar lista de modulos a partir de un id proyecto*/
    public void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("idProyecto"));

        JSONArray jsonArray = new JSONArray();
        JSONObject json;
        JSONParser jsonParser = new JSONParser();

        try ( PrintWriter out = response.getWriter()) {

            ArrayList<Modulo> listModulo = moduloLogic.listarPorProyecto(id);
            for (int i = 0; i < listModulo.size(); i++) {
                String respuesta = Utilities.getURL(Information.getURL_WEB() + request.getContextPath() + "/RequerimientoController?btnEnviar=doList&idModulo=" + listModulo.get(i).getIdtb_modulo());
                Object obj = jsonParser.parse(respuesta);
                json = new JSONObject();
                json.put("id", listModulo.get(i).getIdtb_modulo());
                json.put("nombre", listModulo.get(i).getNombre());
                json.put("estado", listModulo.get(i).getEstado());
                json.put("tb_proyecto_id", listModulo.get(i).getTb_proyecto_id());
                json.put("requerimientos", obj);

//                ArrayList<Requerimiento> listRequerimiento = (ArrayList<Requerimiento>) request.getAttribute("listRequerimiento");
//                listModuloRetorno.put(listModulo.get(i), listRequerimiento);
                jsonArray.add(json);
            }
            json = new JSONObject();
            json.put("modulos", jsonArray);
            out.println(json);

//            request.setAttribute("listModulo", listModuloRetorno);
        } catch (ParseException ex) {
            Logger.getLogger(ModuloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("txtNombre");
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));

            Modulo modulo= new Modulo(0, nombre, "P", idProyecto);
            if (moduloLogic.insertar(modulo)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } 
    }
    
    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {
            int idModulo = Integer.parseInt(request.getParameter("idModulo"));
            String nombre = request.getParameter("txtNombre");
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            Modulo moduloAux= moduloLogic.buscar(idModulo);

            Modulo modulo= new Modulo(idModulo, nombre, moduloAux.getEstado(), idProyecto);
            
            if (moduloLogic.editar(modulo)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } 
    }
    
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try ( PrintWriter out = response.getWriter()) {

            int idModulo = Integer.parseInt(request.getParameter("idModulo"));
            if (moduloLogic.eliminar(idModulo)) {
                out.print("true");
            }else{
                out.print("false");
            }
        } 
    }
}

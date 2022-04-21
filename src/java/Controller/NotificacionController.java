/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import config.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.logic.NotificacionLogic;

/**
 *
 * @author phraymus
 */
@WebServlet(name = "NotificacionController", urlPatterns = {"/NotificacionController"})
public class NotificacionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    NotificacionLogic notificacionLogic= new NotificacionLogic();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("btnEnviar").equals("doPut")) {
                doPut(request, response);
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

    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();

            String idUsuario = request.getParameter("idUsuario");
            String usuario = request.getParameter("txtUsuario");
            String proyecto = request.getParameter("txtProyecto");
            String tipo = request.getParameter("txtTipo");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Timestamp fecha = (!request.getParameter("txtFecha").equals(""))?new java.sql.Timestamp(formatoFecha.parse(request.getParameter("txtFecha")).getTime()):null;
            String correo = request.getParameter("txtCorreo");
            String numero = request.getParameter("txtNumero");
            out.print(Utilities.enviarMensaje(usuario, proyecto, tipo, fecha, correo, numero,"verde"));
        } catch (Exception ex) {
            
        }
    }

    public void doList(HttpServletRequest request, HttpServletResponse response) {

    }
}

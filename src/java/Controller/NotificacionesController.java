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
import javax.servlet.http.HttpSession;
import modelo.beans.Persona;
import modelo.beans.Usuario;
import modelo.logic.PersonaLogic;
import modelo.logic.TelefonoLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author phraymus
 */
@WebServlet(name = "NotificacionesController", urlPatterns = {"/NotificacionesController"})
public class NotificacionesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioLogic usuarioLogic = new UsuarioLogic();
    PersonaLogic personaLogic = new PersonaLogic();
    TelefonoLogic telefonoLogic = new TelefonoLogic();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("btnEnviar").equals("doCodigo")) {
                doCodigo(request, response);
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

    public void doCodigo(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try {
            PrintWriter out = response.getWriter();

            Usuario usuario = usuarioLogic.buscar(Integer.parseInt(request.getParameter("idUsuario")));
            
            Persona persona = personaLogic.buscar((usuario.getPerfil_usuario().equals("C")) ? usuario.getTb_cliente_idc() : usuario.getTb_trabajador_id());
                       
            session.setAttribute("codigoGenerado", Utilities.enviarMensaje("", "", "GC", null, persona.getCorreo(), telefonoLogic.buscar(persona.getIdtb_persona()).getNumero(),"success"));
        } catch (Exception ex) {

        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.logic.CiudadLogic;
import modelo.logic.DepartamentoLogic;
import modelo.logic.PaisLogic;
import javax.servlet.http.Part;

/**
 *
 * @author Brayan Carrasco
 */
@WebServlet(name = "CRUDGestionUsuarioController", urlPatterns = {"/CRUDGestionUsuarioController"})
public class CRUDGestionUsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("btnEnviar").equals("getTrabajadores")) {
            getTrabajadores(request, response);
        }
        if (request.getParameter("btnEnviar").equals("getDepartamentos")) {
            getDepartamentos(request, response);

        }
        if (request.getParameter("btnEnviar").equals("getCiudades")) {
            getCiudades(request, response);

        }
        if (request.getParameter("btnEnviar").equals("putUser")) {
            putUser(request, response);
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

    public void getTrabajadores(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        RequestDispatcher rd = request.getRequestDispatcher("pages/dashboard-gestionarUsuario/dashboard.jsp");
        PaisLogic paisLogic = new PaisLogic();

        session.setAttribute("lstPaises", paisLogic.listar());
        rd.forward(request, response);
    }

    public void getDepartamentos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        DepartamentoLogic departamentoLogic = new DepartamentoLogic();

        ArrayList<Object[]> lstDepartamentos = departamentoLogic.listar("SELECT idtb_departamento, nombre FROM tb_departamento WHERE tb_pais_id=" + request.getParameter("idPais") + " ORDER BY nombre", 2);
        try ( PrintWriter out = response.getWriter()) {

            out.println("<option value='0'>Seleccione</option>");
            for (int i = 0; i < lstDepartamentos.size(); i++) {
                out.println("<option value=" + lstDepartamentos.get(i)[0] + ">");
                out.print(lstDepartamentos.get(i)[1]);
                out.println("</option>");
            }

        }
    }

    public void getCiudades(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        CiudadLogic ciudadLogic = new CiudadLogic();

        ArrayList<Object[]> lstCiudades = ciudadLogic.listar("SELECT idtb_Ciudad, nombre FROM tb_ciudad WHERE tb_departamento_id=" + request.getParameter("idDepartamento") + " ORDER BY nombre", 2);
        try ( PrintWriter out = response.getWriter()) {

            out.println("<option value='0'>Seleccione</option>");
            for (int i = 0; i < lstCiudades.size(); i++) {
                out.println("<option value=" + lstCiudades.get(i)[0] + ">");
                out.print(lstCiudades.get(i)[1]);
                out.println("</option>");
            }

        }
    }

    public void putUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {

            out.println("Esta registrando un usuario");
            out.println(request.getParameter("txtNombres"));
            out.println(request.getParameter("txtApellidoPaterno"));
            out.println(request.getParameter("txtApellidoMaterno"));
            System.out.println(request.getParameter("txtApellidoMaterno"));

            out.println(request.getParameter("txtCorreo"));
            out.println(request.getParameter("txtTipoIdentificacion"));
            out.println(request.getParameter("txtDni"));
            out.println(request.getParameter("txtTelefono"));
            out.println(request.getParameter("txtPais"));
            out.println(request.getParameter("txtDepartamento"));
            out.println(request.getParameter("txtCiudad"));
            out.println("<img src=" + request.getPart("txtFoto") + ">");
            out.println(request.getPart("txtFoto"));

        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.logic.CiudadLogic;
import modelo.logic.DepartamentoLogic;
import modelo.logic.PaisLogic;
import javax.servlet.http.Part;
import modelo.beans.Ciudad;
import modelo.beans.Cliente;
import modelo.beans.Departamento;
import modelo.beans.Pais;
import modelo.beans.Persona;
import modelo.beans.Telefono;
import modelo.beans.Trabajador;
import modelo.beans.Usuario;
import modelo.logic.ClienteLogic;
import modelo.logic.PersonaLogic;
import modelo.logic.TelefonoLogic;
import modelo.logic.TrabajadorLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author Brayan Carrasco
 */
@MultipartConfig
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
    TrabajadorLogic trabajadorLogic = new TrabajadorLogic();
    ClienteLogic clienteLogic = new ClienteLogic();
    PersonaLogic personaLogic = new PersonaLogic();
    CiudadLogic ciudadLogic = new CiudadLogic();
    DepartamentoLogic departamentoLogic = new DepartamentoLogic();
    PaisLogic paisLogic = new PaisLogic();
    TelefonoLogic telefonoLogic = new TelefonoLogic();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {

            if (request.getParameter("btnEnviar").equals("getVG")) {
                getTrabajadores(request, response);
            }
            if (request.getParameter("btnEnviar").equals("getTrabajadores")) {
                getTrabajadores(request, response);
            }

            if (request.getParameter("btnEnviar").equals("getClientes")) {
                getClientes(request, response);
            }

            if (request.getParameter("btnEnviar").equals("getDepartamentos")) {
                getDepartamentos(request, response);

            }
            if (request.getParameter("btnEnviar").equals("getCiudades")) {
                getCiudades(request, response);
            }
            if (request.getParameter("btnEnviar").equals("putUserTrabajador")) {
                putUserTrabajador(request, response);
            }
            if (request.getParameter("btnEnviar").equals("putUserCliente")) {
                putUserCliente(request, response);
            }
            if (request.getParameter("btnEnviar").equals("setUserTrabajador")) {
                setUserTrabajador(request, response);
            }
            if (request.getParameter("btnEnviar").equals("setUserCliente")) {
                setUserCliente(request, response);
            }
            if (request.getParameter("btnEnviar").equals("deleteUserTrabajador")) {
                deleteUserTrabajador(request, response);
            }
            if (request.getParameter("btnEnviar").equals("deleteUserCliente")) {
                deleteUserCliente(request, response);
            }
            if (request.getParameter("btnEnviar").equals("autentificarUsuario")) {
                autentificarUsuario(request, response);
            }
            if (request.getParameter("btnEnviar").equals("cerrarSesion")) {
                cerrarSesion(request, response);
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

    public void getTrabajadores(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (request.getParameter("llamado") != null) {
            request.setAttribute("llamado", "nuevo");
        }
        RequestDispatcher rd = request.getRequestDispatcher("components/trabajadores-general.jsp");
        ArrayList<Usuario> listUsuariosTrabajadores = usuarioLogic.listarUsuariosTrabajadores();

        ArrayList<InformacionUsuarios> listTrabajadores = new ArrayList<InformacionUsuarios>();
        for (int i = 0; i < listUsuariosTrabajadores.size(); i++) {
            Usuario usuario = listUsuariosTrabajadores.get(i);
            Trabajador trabajador = trabajadorLogic.buscar(usuario.getTb_trabajador_id());
            Persona persona = personaLogic.buscar(trabajador.getTb_persona_id());
            Telefono telefono = telefonoLogic.buscar(persona.getIdtb_persona());

            Ciudad ciudad = ciudadLogic.buscar(persona.getTb_ciudad_id());
            Departamento departamento = departamentoLogic.buscar(ciudad.getTb_departamento_id());
            Pais pais = paisLogic.buscar(departamento.getTb_pais_id());

            InformacionUsuarios informacionUsuarios = new InformacionUsuarios(usuario, null, trabajador, persona, telefono, ciudad, departamento, pais);
            listTrabajadores.add(informacionUsuarios);
        }

        session.setAttribute("lstTrabajadores", listTrabajadores);
        session.setAttribute("lstPaises", paisLogic.listar());
        rd.forward(request, response);
    }

    public void getClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        RequestDispatcher rd = request.getRequestDispatcher("components/clientes-general.jsp");
        ArrayList<Usuario> listUsuariosClientes = usuarioLogic.listarUsuariosClientes();
        if (request.getParameter("llamado") != null) {
            request.setAttribute("llamado", "nuevo");
        }
        ArrayList<InformacionUsuarios> listClientes = new ArrayList<InformacionUsuarios>();
        for (int i = 0; i < listUsuariosClientes.size(); i++) {
            Usuario usuario = listUsuariosClientes.get(i);
            Cliente cliente = clienteLogic.buscar(usuario.getTb_cliente_idc());
            Persona persona = personaLogic.buscar(cliente.getTb_persona_id());
            Telefono telefono = telefonoLogic.buscar(persona.getIdtb_persona());

            Ciudad ciudad = ciudadLogic.buscar(persona.getTb_ciudad_id());
            Departamento departamento = departamentoLogic.buscar(ciudad.getTb_departamento_id());
            Pais pais = paisLogic.buscar(departamento.getTb_pais_id());

            InformacionUsuarios informacionUsuarios = new InformacionUsuarios(usuario, cliente, null, persona, telefono, ciudad, departamento, pais);
            listClientes.add(informacionUsuarios);
        }
        session.setAttribute("lstClientes", listClientes);
        session.setAttribute("lstPaises", paisLogic.listar());
        rd.forward(request, response);

    }

    public void getDepartamentos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        ArrayList<Departamento> lstDepartamentos = departamentoLogic.listarPorPais(request.getParameter("idPais"));
        try ( PrintWriter out = response.getWriter()) {
            out.println("<option value='0'>Seleccione</option>");
            for (int i = 0; i < lstDepartamentos.size(); i++) {
                out.println("<option value=" + lstDepartamentos.get(i).getIdtb_departamento() + ">");
                out.print(lstDepartamentos.get(i).getNombre());
                out.println("</option>");
            }

        }
    }

    public void getCiudades(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        ArrayList<Ciudad> lstCiudades = ciudadLogic.listarPorDepartamento(request.getParameter("idDepartamento"));
        try ( PrintWriter out = response.getWriter()) {
            out.println("<option value='0'>Seleccione</option>");
            for (int i = 0; i < lstCiudades.size(); i++) {
                out.println("<option value=" + lstCiudades.get(i).getIdtb_ciudad() + ">");
                out.print(lstCiudades.get(i).getNombre());
                out.println("</option>");
            }
        }
    }

    public void putUserTrabajador(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String nombres = request.getParameter("txtNombres");
        String apellidoPaterno = request.getParameter("txtApellidoPaterno");
        String apellidoMaterno = request.getParameter("txtApellidoMaterno");
        String correo = request.getParameter("txtCorreo");
        String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
        String dni = request.getParameter("txtDni");
        String carnet = request.getParameter("txtCarnet");
        String telef = request.getParameter("txtTelefono");
        int idCiudad = Integer.parseInt(request.getParameter("txtCiudad"));
        Part foto = request.getPart("txtImagen");

        Persona persona = new Persona(1, nombres, apellidoPaterno, apellidoMaterno, correo, tipoIdentificacion, ((tipoIdentificacion.equals("N")) ? dni : carnet), foto.getInputStream(), idCiudad);

        Trabajador trabajador = new Trabajador(0, "P");
        Telefono telefono = new Telefono(1, telef, 0);
        Usuario usuario = new Usuario("P", 0, 0);

        String[] usuarioGenerado;

        try ( PrintWriter out = response.getWriter()) {

            if (personaLogic.insertar(persona)) {
                int idPersona = personaLogic.getUltimoRegistro();
                trabajador.setTb_persona_id(idPersona);
                telefono.setTb_persona_id(idPersona);
                usuario.setTb_trabajador_id(idPersona);
                if (trabajadorLogic.insertar(trabajador)) {
                    if (telefonoLogic.insertar(telefono)) {
                        usuarioGenerado = usuarioLogic.generarUsuario(usuario);
                        if (!usuarioGenerado[0].equals("Error")) {
                            out.print("Se ha registrado al usuario");
                            response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
                        } else {
                            out.print("Ha ocurrido un error");
                        }
                        out.print("Se ha registrado a telefono");

                    } else {
                        out.print("Ha ocurrido un error");
                    }
                    out.print("Se ha registrado a trabajador");

                } else {
                    out.print("Ha ocurrido un error");
                }
                out.print("Se ha registrado a persona");
            } else {
                out.print("Ha ocurrido un error");
            }
        }

    }

    public void putUserCliente(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String nombres = request.getParameter("txtNombres");
        String apellidoPaterno = request.getParameter("txtApellidoPaterno");
        String apellidoMaterno = request.getParameter("txtApellidoMaterno");
        String correo = request.getParameter("txtCorreo");
        String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
        String dni = request.getParameter("txtDni");
        String carnet = request.getParameter("txtCarnet");
        String telef = request.getParameter("txtTelefono");
        String ruc = request.getParameter("txtRuc");
        String nombreEmpresa = request.getParameter("txtNombreEmpresa");
        int idCiudad = Integer.parseInt(request.getParameter("txtCiudad"));
        Part foto = request.getPart("txtImagen");

        Persona persona = new Persona(1, nombres, apellidoPaterno, apellidoMaterno, correo, tipoIdentificacion, ((tipoIdentificacion.equals("N")) ? dni : carnet), foto.getInputStream(), idCiudad);
        Cliente cliente = null;
        if (request.getParameter("txtTipoPersona").equals("Natural")) {
            cliente = new Cliente(0, null, null);
        } else {
            cliente = new Cliente(0, ruc, nombreEmpresa);
        }

        Telefono telefono = new Telefono(1, telef, 0);
        Usuario usuario = new Usuario("C", 0, 0);

        String[] usuarioGenerado;

        try ( PrintWriter out = response.getWriter()) {

            if (personaLogic.insertar(persona)) {
                int idPersona = personaLogic.getUltimoRegistro();
                cliente.setTb_persona_id(idPersona);
                telefono.setTb_persona_id(idPersona);
                usuario.setTb_cliente_idc(idPersona);
                if (clienteLogic.insertar(cliente)) {
                    if (telefonoLogic.insertar(telefono)) {
                        usuarioGenerado = usuarioLogic.generarUsuario(usuario);
                        if (!usuarioGenerado[0].equals("Error")) {
                            out.print("Se ha registrado al usuario");
                            response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
                        } else {
                            out.print("Ha ocurrido un error");
                        }
                        out.print("Se ha registrado a telefono");

                    } else {
                        out.print("Ha ocurrido un error");
                    }
                    out.print("Se ha registrado a trabajador");

                } else {
                    out.print("Ha ocurrido un error");
                }
                out.print("Se ha registrado a persona");
            } else {
                out.print("Ha ocurrido un error");
            }
        }

    }

    public void setUserTrabajador(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        int idPersona = Integer.parseInt(request.getParameter("txtIdPersona"));
        String nombres = request.getParameter("txtNombres");
        String apellidoPaterno = request.getParameter("txtApellidoPaterno");
        String apellidoMaterno = request.getParameter("txtApellidoMaterno");
        String correo = request.getParameter("txtCorreo");
        String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
        String dni = request.getParameter("txtDni");
        String carnet = request.getParameter("txtCarnet");
        String telef = request.getParameter("txtTelefono");
        int idCiudad = Integer.parseInt(request.getParameter("txtCiudad"));
        Part foto = request.getPart("txtImagen");

        Persona personaAux = personaLogic.buscar(idPersona);

        Persona persona = new Persona(idPersona, nombres, apellidoPaterno, apellidoMaterno, correo, tipoIdentificacion, ((tipoIdentificacion.equals("N")) ? dni : carnet), (foto.getSize() != 0) ? foto.getInputStream() : personaAux.getFoto(), idCiudad);

        Trabajador trabajador = new Trabajador(idPersona, "P");
        Telefono telefono = telefonoLogic.buscar(idPersona);

        try ( PrintWriter out = response.getWriter()) {
            if (personaLogic.editar(persona)) {
                if (telefonoLogic.editar(telefono)) {
                    response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
                    out.print("Se ha registrado a telefono");
                } else {
                    out.print("Ha ocurrido un error");
                }
                out.print("Se ha registrado a trabajador");
            } else {
                out.print("Ha ocurrido un error");
            }
        }
    }

    public void setUserCliente(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        int idPersona = Integer.parseInt(request.getParameter("txtIdPersona"));
        String nombres = request.getParameter("txtNombres");
        String apellidoPaterno = request.getParameter("txtApellidoPaterno");
        String apellidoMaterno = request.getParameter("txtApellidoMaterno");
        String correo = request.getParameter("txtCorreo");
        String tipoIdentificacion = request.getParameter("txtTipoIdentificacion");
        String dni = request.getParameter("txtDni");
        String carnet = request.getParameter("txtCarnet");
        String telef = request.getParameter("txtTelefono");
        int idCiudad = Integer.parseInt(request.getParameter("txtCiudad"));
        String ruc = request.getParameter("txtRuc");
        String nombreEmpresa = request.getParameter("txtNombreEmpresa");
        Part foto = request.getPart("txtImagen");

        Persona personaAux = personaLogic.buscar(idPersona);

        Persona persona = new Persona(idPersona, nombres, apellidoPaterno, apellidoMaterno, correo, tipoIdentificacion, ((tipoIdentificacion.equals("N")) ? dni : carnet), (foto.getSize() != 0) ? foto.getInputStream() : personaAux.getFoto(), idCiudad);

        Cliente cliente = null;

        if (request.getParameter("txtTipoPersona").equals("Natural")) {
            cliente = new Cliente(0, null, null);
        } else {
            cliente = new Cliente(0, ruc, nombreEmpresa);
        }

        Telefono telefono = telefonoLogic.buscar(idPersona);

        try ( PrintWriter out = response.getWriter()) {
            if (personaLogic.editar(persona)) {
                if (clienteLogic.editar(cliente)) {
                    if (telefonoLogic.editar(telefono)) {
                        response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
                        out.print("Se ha registrado a telefono");
                    } else {
                        out.print("Ha ocurrido un error");
                    }
                } else {
                    out.print("Ha ocurrido un error");
                }
                out.print("Se ha registrado a trabajador");
            } else {
                out.print("Ha ocurrido un error");
            }
        }
    }

    public void deleteUserTrabajador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int idUsuario = Integer.parseInt(request.getParameter("txtIdObjeto"));

        try ( PrintWriter out = response.getWriter()) {

            if (usuarioLogic.eliminar(idUsuario)) {
                out.println("Eliminado");
                response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
            }

        }
    }

    public void deleteUserCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int idUsuario = Integer.parseInt(request.getParameter("txtIdObjeto"));

        try ( PrintWriter out = response.getWriter()) {

            if (usuarioLogic.eliminar(idUsuario)) {
                out.println("Eliminado");
                response.sendRedirect("pages/dashboard-gestionarUsuario/dashboard.jsp");
            }

        }
    }

    public void autentificarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {
            Usuario usuario = usuarioLogic.autentificar(request.getParameter("txtUser"), request.getParameter("txtPassword"));
            if (usuario != null) {
                session.setMaxInactiveInterval(60*20);
                session.setAttribute("userSession", usuario);
                if (usuario.getPerfil_usuario().equals("C")) {
                    session.setAttribute("personaSession", personaLogic.buscar(usuario.getTb_cliente_idc()));
                } else {
                    session.setAttribute("personaSession", personaLogic.buscar(usuario.getTb_trabajador_id()));
                }
                response.sendRedirect("pages/dashboard-inicio/dashboard.jsp");
            } else {
                session.setAttribute("respuesta", "no autentificado");
                out.print("No autentificado");
                response.sendRedirect("pages/login.jsp");
            }
        }
    }
    
    public void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        session.invalidate();
        response.sendRedirect("pages/login.jsp");
    }

    //Estructuras Adicionales
    public class InformacionUsuarios {

        private Usuario usuario;
        private Cliente cliente;
        private Trabajador trabajador;
        private Persona persona;
        private Telefono telefono;
        private Ciudad ciudad;
        private Departamento departamento;
        private Pais pais;

        public InformacionUsuarios() {
        }

        public InformacionUsuarios(Usuario usuario, Cliente cliente, Trabajador trabajador, Persona persona, Telefono telefono, Ciudad ciudad, Departamento departamento, Pais pais) {
            this.usuario = usuario;
            this.cliente = cliente;
            this.trabajador = trabajador;
            this.persona = persona;
            this.telefono = telefono;
            this.ciudad = ciudad;
            this.departamento = departamento;
            this.pais = pais;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public Trabajador getTrabajador() {
            return trabajador;
        }

        public void setTrabajador(Trabajador trabajador) {
            this.trabajador = trabajador;
        }

        public Persona getPersona() {
            return persona;
        }

        public void setPersona(Persona persona) {
            this.persona = persona;
        }

        public Telefono getTelefono() {
            return telefono;
        }

        public void setTelefono(Telefono telefono) {
            this.telefono = telefono;
        }

        public Ciudad getCiudad() {
            return ciudad;
        }

        public void setCiudad(Ciudad ciudad) {
            this.ciudad = ciudad;
        }

        public Departamento getDepartamento() {
            return departamento;
        }

        public void setDepartamento(Departamento departamento) {
            this.departamento = departamento;
        }

        public Pais getPais() {
            return pais;
        }

        public void setPais(Pais pais) {
            this.pais = pais;
        }

    }

}

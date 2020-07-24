/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "Persona", urlPatterns = {"/Persona"})
public class Persona extends HttpServlet {

    int indice = 0;
    String resultado = "";
    public Registro registros[] = new Registro[10];
    List lista = new ArrayList<Registro>();
    public Documento documento[] = new Documento[4];

    public Persona() {
        // Documento doc = new Documento(2,"adasda");
        documento[0] = new Documento(1, "Cedula");
        documento[1] = new Documento(2, "Tarjeta Identidad");
        documento[2] = new Documento(3, "Pasaporte");
        documento[3] = new Documento(3, "otro");

        for (int i = 0; i < registros.length; i++) {
            registros[i] = new Registro();
        }
    }

    public String getselect() {
        String html = "";
        for (int i = 0; i < documento.length; i++) {
            html += "<option  value='" + documento[i].getNombre() + "' >" + documento[i].getNombre() + "</option>";
        }
        return html;
    }

    public String gettable() {
        String datos = "";

        if (this.lista.size() > 0) {
            for (int i = 0; i < this.lista.size(); i++) {
                Registro registro = (Registro) lista.get(i);
                datos += "<tr><td>" + registro.getId() + "</td>"
                        + "<td>" + registro.getNombres() + "</td>"
                        + "<td>" + registro.getApellidos() + "</td>"
                        + "<td>" + registro.getTipoDocumento() + "</td>"
                        + "<td>" + registro.getNumeroDocumento() + "</td></tr>";
            }
        }
        return datos;
    }

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
        String datoe = request.getParameter("delete");
       // System.out.println(datoe) + "Ingreso";
        if (request.getParameter("delete") != null) {
             
            this.registros[Integer.parseInt(request.getParameter("delete"))] = new Registro();
            response.sendRedirect("index.jsp");
        } 
            // this.registros[0] = request.getParameter();

            System.out.println(indice);
            System.out.println(datoe);
            // this.registros[indice] = new Registro(1,"a", "b", "c", 123);

            this.registros[indice] = new Registro(
                    indice,
                    request.getParameter("nombres"),
                    request.getParameter("apellidos"),
                    request.getParameter("tipoDocumento"),
                    Integer.parseInt(request.getParameter("numeroDocumento"))
            );

        //System.out.println(registros[indice].getNombres());
            lista.add(new Registro(
                    indice,
                    request.getParameter("nombres"),
                    request.getParameter("apellidos"),
                    request.getParameter("tipoDocumento"),
                    Integer.parseInt(request.getParameter("numeroDocumento"))
            ));
            // System.out.println(this.gettable());
            indice++;
        
        
        HttpSession session = request.getSession(true);
        session.setAttribute("html", this.gettable());
        request.getSession().setAttribute("registros", this.registros);
        //session.setAttribute("registros", this.registros);
        response.setContentType("text/html;charset=UTF-8");

        response.sendRedirect("index.jsp");

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

}

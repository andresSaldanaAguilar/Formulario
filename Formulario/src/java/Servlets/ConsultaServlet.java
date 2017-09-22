/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.DBConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANDRES
 */
@WebServlet(name = "ConsultaServlet", urlPatterns = {"/consulta"})
public class ConsultaServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        
        //Conseguimos el parametro del jsp        
        String curp=request.getParameter("CURP");
        System.out.println("CURP del usuario:"+curp);
        
        //realizamos la consulta a la base de datos
        DBConexion con=new DBConexion();      
        con.conectar();
        ResultSet resultados=con.consultar("select * from usuario where curp='"+curp+"';");

        //conseguimos los datos y los mandamos al jsp    
        if (resultados != null) {
            try {
                while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Nombre",resultados.getString("Nombre"));
                    request.setAttribute("Apellido_Paterno",resultados.getString("Apellido_Paterno"));
                    request.setAttribute("Apellido_Materno",resultados.getString("Apellido_Materno"));
                    request.setAttribute("CURP",resultados.getString("CURP"));
                    request.setAttribute("Fecha_Nacimiento",resultados.getString("Fecha_Nacimiento"));
                    request.setAttribute("Correo",resultados.getString("Correo"));
                    request.setAttribute("Sexo_idSexo",resultados.getBigDecimal("Sexo_idSexo"));
                    request.getRequestDispatcher("Resultado.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                  e.printStackTrace();
            }
            
        }
        else{
            System.out.println("Sin resultados");          
        }
        request.getRequestDispatcher("Consulta.jsp").forward(request, response);
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

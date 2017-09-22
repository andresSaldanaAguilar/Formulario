/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.DBConexion;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Reus Gaming PC
 */
public class RegistroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException 
    {
//        cConexion conn = new cConexion();
//        ResultSet rs;
//        conn.conectar();
//        rs = conn.consulta("SELECT Nombre FROM sexo");
        /*
        while(rs.next())
            {
                String Name = rs.getString("Nombre");
            System.out.println(Name);
                    }        //Vuelve a cargar el JSP
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registro.jsp");
        requestDispatcher.forward(request, response);
        */
        /*try {
     
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
        */
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String nombre=request.getParameter("nombre");
        String apaterno=request.getParameter("apaterno");
        String amaterno=request.getParameter("amaterno");
        String curp=request.getParameter("curp");
        String f_nac=request.getParameter("f_nac");
        String email=request.getParameter("email");
        String idSexo=request.getParameter("idSexo");

        //realizamos la consulta a la base de datos
        DBConexion con=new DBConexion();      
        con.conectar();
        //realizamos insert
        boolean resultados=con.ejecutar("insert into usuario values"
                + "('"+nombre+"','"+apaterno+"','"+amaterno+"','"+curp+"',"
                + "'"+f_nac+"','"+email+"','"+Integer.parseInt(idSexo)+"');");
        if(resultados==true){
            System.out.println("Registro Exitoso.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            System.out.println("No se pudo registrar.");
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
        }
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

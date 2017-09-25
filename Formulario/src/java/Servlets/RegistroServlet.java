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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private static final String C =
            "[A-Z]{4}[0-9]{6}[H,M][A-Z]{5}[0-9]{2}" ;
//        "ˆ[A-Z]{1}[AEIOU]{1}][A-Z]{2}[0-9]{2}(0[1-9]—1[0-2])" 
//        + "(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}"
//                + "(AS|BC|BS|CC|CS|CH|CL|CM|DFT|DF|DG|G|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
//                + "[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$";
    
    private Pattern pC = Pattern.compile(C);
    private static final String NOM = "^([a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,50})$";
    private Pattern pNOM = Pattern.compile(NOM);
    private static final String EM = "^[_a-z0-9-]+(.[_a-z0-9-]+)@[a-z0-9-]+(.[a-z0-9]+)*(.[a-z]{2,4})$";
    private Pattern pEM = Pattern.compile(EM);
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
        //Matchers para las regexes
        Matcher m_curp = pC.matcher(curp);
        Matcher m_nom = pNOM.matcher(nombre);
        Matcher m_ap = pNOM.matcher(apaterno);
        Matcher m_am = pNOM.matcher(amaterno);
        Matcher m_email = pEM.matcher(email);
        if (!m_curp.find( )) //Si no hay un match con el CURP
        {
            request.setAttribute("mensaje", "La CURP ingresada no es válida");
            System.out.println("Error en CURP");
            
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            ResultSet resultados=con.consultar("select nombre from sexo;");

            //conseguimos los datos del catalogo
            if (resultados != null) {
                try {
                    int i=0;
                    while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Sexo"+i,resultados.getString("Nombre"));         
                    i++;
                    }
                    request.setAttribute("Num_elementos",i);                       
                    } catch (Exception e) {
                      e.printStackTrace();
                  }
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            else{
                System.out.println("Sin resultados");
            }
        }
        else if (!m_nom.find( )) //Si no hay un match con el nombre
        {
            request.setAttribute("mensaje", "El nombre ingresado no es válido");
            System.out.println("Error en nombre");
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            ResultSet resultados=con.consultar("select nombre from sexo;");

            //conseguimos los datos del catalogo
            if (resultados != null) {
                try {
                    int i=0;
                    while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Sexo"+i,resultados.getString("Nombre"));         
                    i++;
                    }
                    request.setAttribute("Num_elementos",i);                       
                    } catch (Exception e) {
                      e.printStackTrace();
                  }
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            else{
                System.out.println("Sin resultados");
            }
        }
        else if (!m_ap.find( ))//Si no hay un match con el apellido paterno
        {
            request.setAttribute("mensaje", "El apellido paterno ingresado no es válido");
            System.out.println("Error en apellido paterno");
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            ResultSet resultados=con.consultar("select nombre from sexo;");

            //conseguimos los datos del catalogo
            if (resultados != null) {
                try {
                    int i=0;
                    while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Sexo"+i,resultados.getString("Nombre"));         
                    i++;
                    }
                    request.setAttribute("Num_elementos",i);                       
                    } catch (Exception e) {
                      e.printStackTrace();
                  }
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            else{
                System.out.println("Sin resultados");
            }
        }
        else if (!m_am.find( )) //Si no hay un match con el apellido materno
        {
            request.setAttribute("mensaje", "El apellido materno ingresado no es válido");
            System.out.println("Error en apellido materno");
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            ResultSet resultados=con.consultar("select nombre from sexo;");

            //conseguimos los datos del catalogo
            if (resultados != null) {
                try {
                    int i=0;
                    while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Sexo"+i,resultados.getString("Nombre"));         
                    i++;
                    }
                    request.setAttribute("Num_elementos",i);                       
                    } catch (Exception e) {
                      e.printStackTrace();
                  }
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            else{
                System.out.println("Sin resultados");
            }        
        }
        else if (!m_email.find( )) //Si no hay un match con el email
        {
            request.setAttribute("mensaje", "El email ingresado no es válido");
            System.out.println("Error en el mail");
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            ResultSet resultados=con.consultar("select nombre from sexo;");

            //conseguimos los datos del catalogo
            if (resultados != null) {
                try {
                    int i=0;
                    while (resultados.next()) {
                    response.setContentType("text/html");
                    request.setAttribute("Sexo"+i,resultados.getString("Nombre"));         
                    i++;
                    }
                    request.setAttribute("Num_elementos",i);                       
                    } catch (Exception e) {
                      e.printStackTrace();
                  }
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            else{
                System.out.println("Sin resultados");
            }
        }
        //Si todo sale bien
        else 
        {
            //realizamos la consulta a la base de datos
            DBConexion con=new DBConexion();      
            con.conectar();
            //realizamos insert
            boolean resultados=con.ejecutar("insert into usuario values"
                    + "('"+nombre+"','"+apaterno+"','"+amaterno+"','"+curp+"',"
                    + "'"+f_nac+"','"+email+"','"+Integer.parseInt(idSexo)+"');");
            
            //La trayectoria principal :D
            if(resultados==true){
                System.out.println("Registro Exitoso.");
                //Redireccionar con el mensaje de error
                request.setAttribute("mensajeEXITO", "Registro exitoso!");
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
            //El registro ya existe en la base de datos
            else{
                
                System.out.println("No se pudo registrar.");
             
                //realizamos la consulta a la base de datos
                DBConexion con2=new DBConexion();      
                con2.conectar();
                ResultSet resultados2=con2.consultar("select nombre from sexo;");

                //conseguimos los datos del catalogo
                if (resultados2 != null) {
                    try {
                        int i=0;
                        while (resultados2.next()) {
                        response.setContentType("text/html");
                        request.setAttribute("Sexo"+i,resultados2.getString("Nombre"));         
                        i++;
                        }
                        request.setAttribute("Num_elementos",i);                       
                        } catch (Exception e) {
                          e.printStackTrace();
                      }
                    request.setAttribute("mensajeDUP", "El CURP ingresado ya ha sido registrado.");
                    //Redireccionar con el mensaje de error
                    request.getRequestDispatcher("Registro.jsp").forward(request, response);
                }
                else{
                    System.out.println("Sin resultados");
                    request.setAttribute("mensajeERRBD", "Error en la conexion de base de datos.");
                    //Redireccionar con el mensaje de error
                    request.getRequestDispatcher("Registro.jsp").forward(request, response);
                }
            }
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

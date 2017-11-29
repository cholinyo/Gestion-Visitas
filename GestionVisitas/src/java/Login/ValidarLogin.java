/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author vcaruncho
 */
public class ValidarLogin extends HttpServlet {
    private DataSource fuenteDatos = null;
    @Override
    public void init (ServletConfig conf)
        throws ServletException {
        //Vamos a obtener los parametros de contexto
        Context ctx;
        try {
            ctx = new InitialContext();
            fuenteDatos = (DataSource) ctx.lookup("java:comp/env/jdbc/AccesoDB");
        }
        catch(NamingException  e) {
        }    
            
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        String user = request.getParameter("login");
        String pass = request.getParameter("password");
        Connection conexion=null;
        synchronized(fuenteDatos){
        try{
            conexion=fuenteDatos.getConnection();
            
        } catch (SQLException e){
          e.printStackTrace();
            }
        }  
        //Conectar a BBDD y comprobar si admin es correcto
    }
}

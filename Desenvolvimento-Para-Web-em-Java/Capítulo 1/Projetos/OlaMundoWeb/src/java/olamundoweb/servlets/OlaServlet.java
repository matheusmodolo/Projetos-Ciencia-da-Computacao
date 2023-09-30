package olamundoweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nmmat
 */
 @WebServlet(name = "OlaServlet", urlPatterns = {"/ola"})
public class OlaServlet extends HttpServlet {
   
     @Override
     protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
         
         processRequest(request, response);
         
     }
     
     @Override
     protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
         
         processRequest(request, response);
     }
     protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
         
         System.out.println("Ola Mundo!");
         System.out.println("Meu Primeiro Servlet!");
         
     }
}

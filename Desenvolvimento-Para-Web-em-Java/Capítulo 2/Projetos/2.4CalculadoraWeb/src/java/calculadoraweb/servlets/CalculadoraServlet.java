package calculadoraweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nmmat
 */
@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/Calculadora"})
public class CalculadoraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String numero = request.getParameter("numero1");
        int numero1 = Integer.parseInt(numero);
        numero = request.getParameter("numero2");
        int numero2 = Integer.parseInt(numero);

        String conta = request.getParameter("conta");
        
        System.out.printf("Resultado da calculadora: ");

        switch (conta) {
            case "adicao":
                System.out.println(numero1+numero2);
                break;
            case "subtracao":
                System.out.println(numero1-numero2);
                break;
            case "multiplicacao":
                System.out.println(numero1*numero2);
                break;
            case "divisao":
                System.out.println(numero1/numero2);
                break;
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

}

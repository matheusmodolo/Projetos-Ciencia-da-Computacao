package formulariodvd.servlets;

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
@WebServlet(name = "ProcessaDadosDVDServlet", urlPatterns = {"/processaDadosDVD"})
public class ProcessaDadosDVDServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        String numero = request.getParameter("numero");
        String titulo = request.getParameter("titulo");
        String atorPrincipal = request.getParameter("atorPrincipal");
        String atorCoadjuvante = request.getParameter("atorCoadjuvante");
        String diretor = request.getParameter("diretor");
        String ano = request.getParameter("ano");

        System.out.println("Dados do DVD:");
        System.out.println("Número: " + numero);
        System.out.println("Título: " + titulo);
        System.out.println("Ator/Atriz Principal: " + atorPrincipal);
        System.out.println("Ator/Atriz Coadjuvante: " + atorCoadjuvante);
        System.out.println("Diretor/Diretora: " + diretor);
        System.out.println("Ano de Lançamento: " + ano);

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

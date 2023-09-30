package servlets;

import entidades.DVD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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

        int numero = 0;
        int ano = 0;
        String titulo = request.getParameter("titulo");
        String atorPrincipal = request.getParameter("atorPrincipal");
        String atorCoadjuvante = request.getParameter("atorCoadjuvante");
        String diretor = request.getParameter("diretor");

        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException exc) {
            System.out.println("Erro ao converter o número.");
        }
        try {
            ano = Integer.parseInt(request.getParameter("ano"));
        } catch (NumberFormatException exc) {
            System.out.println("Erro ao converter o ano.");
        }

        DVD dvd = new DVD();
        dvd.setNumero(numero);
        dvd.setTitulo(titulo);
        dvd.setAtorPrincipal(atorPrincipal);
        dvd.setAtorCoadjuvante(atorCoadjuvante);
        dvd.setDiretor(diretor);
        dvd.setAno(ano);

        request.setAttribute("DVDObtido", dvd);

        RequestDispatcher disp = request.getRequestDispatcher("exibeDados.jsp");

        disp.forward(request, response);
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
        return "ProcessaDadosDVDServlet";
    }// </editor-fold>

}

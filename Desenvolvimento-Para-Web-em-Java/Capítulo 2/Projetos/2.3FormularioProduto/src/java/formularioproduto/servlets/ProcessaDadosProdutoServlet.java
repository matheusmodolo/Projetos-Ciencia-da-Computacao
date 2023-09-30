package formularioproduto.servlets;

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
@WebServlet(name = "ProcessaDadosProdutoServlet", urlPatterns = {"/processaDadosProduto"})
public class ProcessaDadosProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String codigo = request.getParameter("codigo");
        String descricao = request.getParameter("descricao");
        String unidade = request.getParameter("unidade");
        String quantidade = request.getParameter("quantidade");
        String fabricante = request.getParameter("fabricante");

        System.out.println("Dados do Produto:");
        System.out.println("Código de Barras: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Unidade de Medida(un. ou kg.): " + unidade);
        System.out.println("Quantidade por Embalagem: " + quantidade);
        System.out.println("Fabricante: " + fabricante);

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

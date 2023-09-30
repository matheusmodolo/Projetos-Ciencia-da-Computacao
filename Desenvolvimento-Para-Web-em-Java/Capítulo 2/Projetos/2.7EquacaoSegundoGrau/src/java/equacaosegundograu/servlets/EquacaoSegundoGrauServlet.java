package equacaosegundograu.servlets;

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
@WebServlet(name = "EquacaoSegundoGrauServlet", urlPatterns = {"/EquacaoSegundoGrau"})
public class EquacaoSegundoGrauServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //a não pode ser 0 nem null
        String num = request.getParameter("a");
        int a = Integer.valueOf(num);
        num = request.getParameter("b");
        int b = Integer.valueOf(num);
        num = request.getParameter("c");
        int c = Integer.valueOf(num);

        if (a == 0) {
            throw new Error("Não é uma Equação de Segundo Grau!");
        } else if (b == 0) {
            double x1 = Math.sqrt(-c / a);
            double x2 = -(Math.sqrt(-c / a));

            System.out.println("\nRaízes");
            System.out.println("X1: " + x1);
            System.out.println("X2: " + x2);

        } else if (c == 0) {
            double x = -b / a;

            System.out.println("\nRaízes");
            System.out.println("X1: 0");
            System.out.println("X2: " + x);

        } else {
            int delta = (b * b) - 4 * a * c;

            if (delta < 0) {
                throw new Error("Equação Inválida!");
            } else if (delta == 0) {
                double x = ((-b - (Math.sqrt(delta))) / 2 * a);

                System.out.println("\nRaíz");
                System.out.println("X: " + x);
            } else {
                double x1 = ((-b + (Math.sqrt(delta))) / 2 * a);

                double x2 = ((-b - (Math.sqrt(delta))) / 2 * a);

                System.out.println("\nRaízes");
                System.out.println("X1: " + x1);
                System.out.println("X2: " + x2);
            }
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

package cadastrocarros.servlets;

import cadastrocarros.dao.CarroDAO;
import cadastrocarros.pojo.Carro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarroServlet", urlPatterns = {"/processaCarro"})
public class CarroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        Jsonb jb = JsonbBuilder.create();
        List<Carro> lista = new ArrayList<>();

        String acao = request.getParameter("acao");
        CarroDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new CarroDAO();

            if (acao.equals("inserir")) {

                String nome = request.getParameter("nome");
                String modelo = request.getParameter("modelo");
                int ano = Integer.parseInt(request.getParameter("ano"));

                Carro c = new Carro();
                c.setNome(nome);
                c.setModelo(modelo);
                c.setAno(ano);

                dao.salvar(c);

                disp = request.getRequestDispatcher("/index.jsp");

            } else if (acao.equals("listagem")) {

                try ( PrintWriter out = response.getWriter()) {
                    out.print(jb.toJson(dao.listarTodos()));
                }
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }
        if (disp != null) {
            disp.forward(request, response);
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

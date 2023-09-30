package meuprimeiroformulario.servlets;

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
@WebServlet(name = "ProcessaDadosClienteServlet", urlPatterns = {"/processaDadosCliente"})
public class ProcessaDadosClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String dataNascimento = request.getParameter("dataNasc");
        String sexo = request.getParameter("sexo");
        String observacoes = request.getParameter("observacoes");
        String email = request.getParameter("email");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        String filhos = request.getParameter("filhos");

        System.out.println("Dados do Cliente:");
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        if (sexo.equals("M")) {
            System.out.println("Sexo: Masculino");
        } else {
            System.out.println("Sexo: Feminino");
        }
        System.out.println("Email: " + email);
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Número: " + numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("CEP: " + cep);
        if (filhos.equals("S")) {
            System.out.println("Filhos: Possui");
        } else {
            System.out.println("Filhos: Não Possui");
        }

        System.out.println("Observações: " + observacoes);
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

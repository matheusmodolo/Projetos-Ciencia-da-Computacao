package servlets;

import entidades.Cliente;
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
@WebServlet(name = "ProcessaDadosClienteServlet", urlPatterns = {"/processaDadosCliente"})
public class ProcessaDadosClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int cpf = 0;
        int numero = 0;
        int cep = 0;
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String nascimento = request.getParameter("nascimento");
        String sexo = request.getParameter("sexo");
        String observacoes = request.getParameter("observacoes");
        String email = request.getParameter("email");
        String logradouro = request.getParameter("logradouro");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String filhos = request.getParameter("filhos");

        try {
            cpf = Integer.parseInt(request.getParameter("cpf"));
        } catch (NumberFormatException exc) {
            System.out.println("Erro ao converter o CPF.");
        }
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException exc) {
            System.out.println("Erro ao converter o Número.");
        }
        try {
            cep = Integer.parseInt(request.getParameter("cep"));
        } catch (NumberFormatException exc) {
            System.out.println("Erro ao converter o CEP.");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setCpf(cpf);
        cliente.setNascimento(nascimento);
        cliente.setSexo(sexo);
        cliente.setEmail(email);
        cliente.setLogradouro(logradouro);
        cliente.setNumero(numero);
        cliente.setComplemento(complemento);
        cliente.setSexo(sexo);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setCep(cep);
        cliente.setFilhos(filhos);
        cliente.setObservacoes(observacoes);
        
        request.setAttribute("clienteObtido", cliente);
        
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
        return "ProcessaDadosClienteServlet";
    }// </editor-fold>

}

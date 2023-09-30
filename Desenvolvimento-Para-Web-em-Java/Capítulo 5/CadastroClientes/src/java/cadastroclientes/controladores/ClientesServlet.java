package cadastroclientes.controladores;

import cadastroclientes.dao.ClienteDAO;
import cadastroclientes.entidades.Cidade;
import cadastroclientes.entidades.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Clientes.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet(name = "ClientesServlet",
        urlPatterns = {"/processaClientes"})
public class ClientesServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        ClienteDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {

            dao = new ClienteDAO();

            if (acao.equals("inserir")) {

                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String dataNascimento = request.getParameter("dataNascimento");
                String cpf = request.getParameter("cpf");
                String email = request.getParameter("email");
                String logradouro = request.getParameter("logradouro");
                String numero = request.getParameter("numero");
                String bairro = request.getParameter("bairro");
                String cep = request.getParameter("cep");
                int idCidade = Integer.parseInt(
                        request.getParameter("idCidade"));

                Cidade ci = new Cidade();
                ci.setId(idCidade);

                Cliente c = new Cliente();
                c.setNome(nome);
                c.setSobrenome(sobrenome);
                c.setDataNascimento(Date.valueOf(
                        LocalDate.parse(dataNascimento, dtf)));
                c.setCpf(cpf);
                c.setEmail(email);
                c.setLogradouro(logradouro);
                c.setNumero(numero);
                c.setBairro(bairro);
                c.setCep(cep);
                c.setCidade(ci);

                if (validarClientes(c) == true) {

                    dao.salvar(c);

                    disp = request.getRequestDispatcher("/formularios/clientes/listagem.jsp");
                } else {

                    request.setAttribute("cliente", c);

                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                }

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String dataNascimento = request.getParameter("dataNascimento");
                String cpf = request.getParameter("cpf");
                String email = request.getParameter("email");
                String logradouro = request.getParameter("logradouro");
                String numero = request.getParameter("numero");
                String bairro = request.getParameter("bairro");
                String cep = request.getParameter("cep");
                int idCidade = Integer.parseInt(
                        request.getParameter("idCidade"));

                Cidade ci = new Cidade();
                ci.setId(idCidade);

                Cliente c = new Cliente();
                c.setId(id);
                c.setNome(nome);
                c.setSobrenome(sobrenome);
                c.setDataNascimento(Date.valueOf(
                        LocalDate.parse(dataNascimento, dtf)));
                c.setCpf(cpf);
                c.setEmail(email);
                c.setLogradouro(logradouro);
                c.setNumero(numero);
                c.setBairro(bairro);
                c.setCep(cep);
                c.setCidade(ci);

                if (validarClientes(c) == true) {

                    dao.atualizar(c);

                    disp = request.getRequestDispatcher("/formularios/clientes/listagem.jsp");
                } else {

                    request.setAttribute("cliente", c);
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                }

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Cliente c = new Cliente();
                c.setId(id);

                dao.excluir(c);

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp");

            } else {

                int id = Integer.parseInt(request.getParameter("id"));
                Cliente c = dao.obterPorId(id);
                request.setAttribute("cliente", c);

                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher(
                            "/formularios/clientes/alterar.jsp");
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher(
                            "/formularios/clientes/excluir.jsp");
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

    private boolean validarClientes(Cliente valClient) {

        boolean passa = true;
        String n = valClient.getNome();
        String s = valClient.getSobrenome();
        String cpf = valClient.getCpf();
        String e = valClient.getEmail();
        String l = valClient.getLogradouro();
        String num = valClient.getNumero();
        String b = valClient.getBairro();
        String cep = valClient.getCep();
        Cidade c = valClient.getCidade();
        Date d = valClient.getDataNascimento();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataF = dateFormat.format(d);

        if (n.length() > 45 || n.length() <= 0) {
            passa = false;
        }
        if (s.length() > 45 || s.length() <= 0) {
            passa = false;
        }
        if (cpf.length() > 14 || cpf.length() <= 0) {
            passa = false;
        }
        if (e.length() > 60 || e.length() <= 0) {
            passa = false;
        }
        if (l.length() > 50 || l.length() <= 0) {
            passa = false;
        }
        if (num.length() > 6 || num.length() <= 0) {
            passa = false;
        }
        if (b.length() > 30 || b.length() <= 0) {
            passa = false;
        }
        if (cep.length() > 9 || cep.length() <= 0) {
            passa = false;
        }
        if (cep.length() > 9 || cep.length() <= 0) {
            passa = false;
        }
        if (c == null) {
            passa = false;
        }
        if (dataF == null) {
            passa = false;
        }

        return passa;
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ClientesServlet";
    }
}
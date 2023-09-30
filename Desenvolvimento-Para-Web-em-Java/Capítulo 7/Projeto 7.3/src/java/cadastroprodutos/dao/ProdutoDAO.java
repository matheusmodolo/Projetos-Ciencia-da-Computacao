package cadastroprodutos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cadastroprodutos.pojo.Produto;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Produto obj) throws SQLException {

        String sql = "INSERT INTO produto( descricao, estoque ) "
                + "VALUES( ?, ? );";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getEstoque());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Produto> listarTodos() throws SQLException {

        List<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT * FROM produto;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setEstoque(rs.getInt("estoque"));

            lista.add(prod);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Produto obterPorId(int id) throws SQLException {

        Produto prod = null;
        String sql = "SELECT * FROM produto WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setEstoque(rs.getInt("estoque"));
        }

        rs.close();
        stmt.close();
        return prod;
    }

    @Override
    public void atualizar(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
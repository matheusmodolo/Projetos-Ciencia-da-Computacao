package cadastrocarros.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cadastrocarros.pojo.Carro;

public class CarroDAO extends DAO<Carro> {

    public CarroDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Carro obj) throws SQLException {

        String sql = "INSERT INTO carro( nome, modelo, ano ) "
                + "VALUES( ?, ?, ?);";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getModelo());
        stmt.setInt(3, (obj.getAno()));

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Carro obj) throws SQLException {

        String sql = "UPDATE carro "
                + "SET"
                + " nome = ?, "
                + " modelo = ? "
                + " ano = ? "
                + "WHERE"
                + " id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getModelo());
        stmt.setInt(3, obj.getAno());
        stmt.setInt(4, obj.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Carro obj) throws SQLException {

        String sql = "DELETE FROM carro WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Carro> listarTodos() throws SQLException {

        List<Carro> lista = new ArrayList<Carro>();
        String sql = "SELECT * FROM carro;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Carro carro = new Carro();
            carro.setId(rs.getInt("id"));
            carro.setNome(rs.getString("nome"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAno(rs.getInt("ano"));

            lista.add(carro);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Carro obterPorId(int id) throws SQLException {

        Carro carro = null;
        String sql = "SELECT * FROM carro WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            carro = new Carro();
            carro.setId(rs.getInt("id"));
            carro.setNome(rs.getString("nome"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAno(rs.getInt("ano"));

        }

        rs.close();
        stmt.close();
        return carro;
    }
}

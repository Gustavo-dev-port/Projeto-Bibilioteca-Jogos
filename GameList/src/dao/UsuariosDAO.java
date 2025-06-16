package gamelist.src.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import gamelist.src.model.Usuarios;
import gamelist.src.util.DBconnection;

public class UsuariosDAO {
    public List<Usuarios> findAll() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        try (
                Connection connection = DBconnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            List<Usuarios> usuariosList = new ArrayList<>();
            while (resultSet.next()) {
                usuariosList.add(
                        new Usuarios(
                                resultSet.getInt("id"),
                                resultSet.getString("nome"),
                                resultSet.getString("email"),
                                resultSet.getString("senha"),
                                resultSet.getString("data_nascimento"),
                                resultSet.getBoolean("is_admin")));
            }
            return usuariosList;
        }
    }

    public void save(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, data_nascimento, is_admin) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection connection = DBconnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getDataNascimento());
            statement.setBoolean(5, usuario.isAdmin());
            statement.executeUpdate();
        }
    }

    public void delete(Usuarios usuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (
                Connection connection = DBconnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuario.getId());
            statement.executeUpdate();
        }
    }

    public void update(Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?, data_nascimento = ?, is_admin = ? WHERE id = ?";
        try (
                Connection connection = DBconnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getDataNascimento());
            statement.setBoolean(5, usuario.isAdmin());
            statement.setInt(6, usuario.getId());
            statement.executeUpdate();
        }
    }
}
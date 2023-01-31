package br.com.cadastro.dao;

import br.com.cadastro.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import br.com.cadastro.factory.*;

public class CadastroDAO {

	public void save(Usuario usuario) throws SQLException {

		String sql = "INSERT INTO usuarios(nome, idade, datacadastro) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL(); // criar conexão com banco de dados
			pstm = (PreparedStatement) conn.prepareStatement(sql); // uso do PreparedStatement para executar a query
			pstm.setString(1, usuario.getNome());
			pstm.setInt(2, usuario.getIdade());
			pstm.setDate(3, new Date(usuario.getDataCadastro().getTime()));

			// executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

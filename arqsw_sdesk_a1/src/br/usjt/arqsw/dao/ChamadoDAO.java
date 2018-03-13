package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Tatiane Ayres 816118367
 *
 */

public class ChamadoDAO {
	public ArrayList<Chamado> listarChamado(Fila fila) throws IOException {
		String query = "select * from chamado Where ID_FILA = ?";
		ArrayList<Chamado> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setInt(1, fila.getId());
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setIdChamado(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDtAbertura(rs.getDate("dt_abertura"));
					chamado.setDtFechamento(rs.getDate("dt_fechamento"));
					chamado.setFila(fila);
					lista.add(chamado);

				}
			}
		} catch (SQLException e) {
			throw new IOException(e);

		} catch (IOException e1) {
			throw new IOException(e1);
		}
		return lista;
	}
}

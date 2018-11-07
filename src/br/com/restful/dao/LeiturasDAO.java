package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Leituras;

/**
 * Classe responsovel por conter os metodos do CRUD.
 */
public class LeiturasDAO extends ConnectionFactory {

	private static LeiturasDAO instance;

	/**
	 * Metodo responsovel por criar uma instancia da classe LeiturasDAO.
	 */
	public static LeiturasDAO getInstance() {
		if (instance == null)
			instance = new LeiturasDAO();
		return instance;
	}

	/**
	 * @return ArrayList<Cliente>
	 * Metodo responsavel por buscar e listar todos os clientes gravados no  banco de dados.
	 * @since 11/05/2016 11:40:45
	 * @version 1.0
	 */
	public ArrayList<Leituras> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Leituras> leituras = null;

		conexao = criarConexao();
		leituras = new ArrayList<Leituras>();
		try {
			pstmt = conexao
					.prepareStatement("SELECT * FROM lixeiras ORDER BY nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Leituras leitura = new Leituras();

				
				leitura.setNome(rs.getString("nome"));
                                leitura.setSensor1(rs.getString("sensor1"));
                                leitura.setSensor2(rs.getString("sensor2"));
                                leitura.setSensor3(rs.getString("sensor3"));
				
                                leituras.add(leitura);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todas as leituras: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return leituras;
	}

	/**
	 * Busca um cliente no banco dado um id.
	 * 
	 * @param id
	 * @return cliente
	 * @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	 * @since 11/05/2016 11:48:45
	 * @version 1.0
	 */
        
	public Leituras getById(long id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Leituras leitura = null;
		conexao = criarConexao();

		try {
			pstmt = conexao
					.prepareStatement("SELECT * FROM lixeiras WHERE id = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				leitura = new Leituras();
				
				leitura.setNome(rs.getString("nome"));
                                leitura.setSensor1(rs.getString("sensor1"));
				leitura.setSensor1(rs.getString("sensor2"));
                                leitura.setSensor1(rs.getString("sensor3"));
			}
		} catch (Exception e) {
			System.out
					.println("Erro ao buscar leitura com ID=" + id + "\n" + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return leitura;

	}
        
	/**
	 * Metodo responsavel por gravar cliente no banco de dados.
	 * 
	 * @param cliente
	 * @return verdade se cliente gravado e falso se nao gravado
	 * @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	 * @since 11/05/2016 11:49:38
	 * @version 1.0
	 */
	public boolean insert(Leituras leitura) {
		String nome = leitura.getNome();
                String sensor1 = leitura.getSensor1();
                String sensor2 = leitura.getSensor2();
                String sensor3 = leitura.getSensor3();
		boolean isGravado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao
					.prepareStatement("insert into lixeiras(nome,sensor1,sensor2,sensor3)"
							+ "values(?,?,?,?)");
			pstmt.setString(1, nome);
                        pstmt.setString(2, sensor1);
                        pstmt.setString(3, sensor2);
                        pstmt.setString(4, sensor3);
			boolean execute = pstmt.execute();
			isGravado = true;
			System.out.println("Respota do insert: " + execute);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			isGravado = false;
			e.printStackTrace();

		}
		return isGravado;
	}

	/**
	 * Metodo responsavel por atualizar cliente na base de dados
	 * 
	 * @param cliente
	 * @return verdade se atualizado e falso se nao.
	 * @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	 * @since 15/05/2016 13:29:22
	 * @version 1.0
	 */
        
	public boolean update(Leituras leitura) {
		//long id = leitura.getId();
		String nome = leitura.getNome();
                String leitura1 = leitura.getSensor1();
                String leitura2 = leitura.getSensor2();
                String leitura3 = leitura.getSensor3();
		boolean isAtualizado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("UPDATE lixeiras SET,sensor1 = ?,sensor2 = ?,sensor3 WHERE nome = ?");
			pstmt.setString(1, nome);
                        pstmt.setString(2, leitura1);
			pstmt.setString(3, leitura2);
                        pstmt.setString(4, leitura3);
			int execute = pstmt.executeUpdate();
			isAtualizado = true;
			System.out.println("Retorno update: " + execute);

		} catch (SQLException e) {
			isAtualizado = false;
			e.printStackTrace();

		} finally {
			fecharConexao(conexao, pstmt, null);
		}
		return isAtualizado;

	}
        
	/**
	 * Metodo responsavel por deletar cliente na base de dados.
	 * 
	 * @param id
	 * @return Verdade se cliente deletado e falso se nao.
	 * @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
	 * @since 15/05/2016 13:29:40
	 * @version 1.0
	 */
        
	public boolean delete(Leituras leitura) {
		boolean isDeletado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("DELETE FROM lixeiras WHERE id = ?");
			
			boolean execute = pstmt.execute();
			isDeletado = true;
			System.out.println("Respota do delete: " + execute);

		} catch (SQLException e) {
			isDeletado = false;
			e.printStackTrace();

		} finally {
			fecharConexao(conexao, pstmt, null);
		}
		return isDeletado;
	}
        
}

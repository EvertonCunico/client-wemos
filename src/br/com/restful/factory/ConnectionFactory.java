package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel por conter os metodos para criar e fechar o banco de dados.
 */

public class ConnectionFactory {
	
    /**
	private String SENHA_MYSQL;
	private String HOST_MYSQL;
	private String URL_MYSQL;
	private String PORTA_MYSQL;
	private String USUARIO_MYSQL;
	private String DRIVER;
    */
	/**
	 * Metodo responsavel por criar uma conexao com o banco
	 */
	public Connection criarConexao() {

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/lixeiras", "root", "root");
        } catch (SQLException excecao) {
            excecao.printStackTrace();
            throw new RuntimeException(excecao);
        }
             
            /**
		if (System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null) {
			//se executado no servidor do openshift pega valores de variaveis de ambiente
			SENHA_MYSQL = System.getenv("root");
			HOST_MYSQL = System.getenv("127.0.0.1");
			PORTA_MYSQL = System.getenv("3306");
			USUARIO_MYSQL = System.getenv("root");
		} else {
			// conexão local
			HOST_MYSQL = "127.0.0.1";
			PORTA_MYSQL = "3306";
			USUARIO_MYSQL = "root";
			SENHA_MYSQL = "root";
		}
		URL_MYSQL = "jdbc:mysql://" + HOST_MYSQL + ":" + PORTA_MYSQL + "/lixeiras";
		DRIVER = "com.mysql.jdbc.Driver";
		Connection conexao = null;

		try {

			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL_MYSQL, USUARIO_MYSQL, SENHA_MYSQL);
			System.out.println("Conexao criada");

		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com o banco: " + URL_MYSQL);
			e.printStackTrace();
		}
		return conexao;
                * 
                * */
	}

	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {

		try {

			if (conexao != null) {
				conexao.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			System.out.println("Conexao fechada");
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com o banco: " + "jdbc:mysql://127.0.0.1/");
		}
	}
}

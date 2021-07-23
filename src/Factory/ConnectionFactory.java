package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
private static final String USERNAME = "root";
	
	//Senha do mysql
	private static final String PASSWORD = "";
	
	//Caminho do banco de dados: padrao : banco : porta : nome do banco
	private static final String DATABASE_URL = "";
	
	/*
	 * Conexão com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM ( Comentado pois esta obsoleto)
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conexão com banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		//Recuperar uma conexão com banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão realizada com sucesso!");
		}
	}
}

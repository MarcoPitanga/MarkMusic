package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Musicas.*;
import javax.swing.JOptionPane;

import Factory.ConnectionFactory;

public class MusicaDAO {
	public void save(Musica musica) {
		
		String sql = "INSERT INTO musica VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			//Criar uma conexão com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//PreparedStatement para executar a query
			statement = conn.prepareStatement(sql);
			
			//Adicionar os valores esperados pela query
			statement.setString(1, musica.getNome());
			statement.setString(2, musica.getArtista());
			statement.setString(3, musica.getDiretorio());
			statement.setString(4, musica.getTempoMin());
			statement.setInt(5, musica.getTempoSec());
			
			//Executar a query
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "musica salva com sucesso!", "Sucesso!", 1);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			//Fechar as conexões
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	
	public ArrayList<Musica> listamusicas() throws Exception{
		
		String sql = "SELECT * FROM musica";
		
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		//Classe que vai recuperar os dados do banco.  ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			// salvar as informaçoes que vem do banco
			rset = statement.executeQuery();
			
			//Enquanto tiver dados para percorrer em rset, ele vai rodar o while
			while (rset.next()) {
				Musica musica = new Musica(rset.getString("nome"), rset.getString("artista"), rset.getString("diretorio"), rset.getString("tempo_min"), rset.getInt("tempo_sec"));
				
				musicas.add(musica);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return musicas;
	}

	
	/*public void delete(Musica musica) {
		String sql = "DELETE FROM musicas WHERE matricula = ?";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, musica.getMatricula());
			
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "musica Deletado com sucesso!", "Sucesso!", 1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}*/

	
	/*public void update(Musica musica) {
		String sql = "UPDATE musicas SET senha = ? WHERE matricula = ?";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, musica.getSenha());
			statement.setInt(2, musica.getMatricula());
			
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso!","Sucesso!",1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}*/

	/*public Musica login(Musica musica) {
		
		String sql = "SELECT * FROM musicas WHERE matricula = ? AND senha = ?";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, musica.getMatricula());
			statement.setString(2, musica.getSenha());
			
			rset = statement.executeQuery();
			if(rset != null && rset.next()) {
				musica.setMatricula(rset.getInt("matricula"));
				musica.setSenha(rset.getString("senha"));
				musica.setNome(rset.getString("nome"));
				JOptionPane.showMessageDialog(null, "Bem vindo(a), "+rset.getString("nome")+" !","Sucesso!", 1);
				return musica;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		JOptionPane.showMessageDialog(null, "Matricula ou Senha incorreta!","Falha!",0);
		return null;
	}*/

	public static Musica buscar(Musica musica) throws Exception{
		
		String sql = "SELECT * FROM musicas WHERE nome LIKE ?";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, "%"+musica.getNome()+"%");
			
			rset = statement.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return musica;
	}
}

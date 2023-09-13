//Aluno: Jhonny Guimarães
//BSI - praça osorio
//RGM: 29318602


package hierarquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import lojacoisasecoisas.bancodedados;

public class funcionario extends pessoa {
	
	

	public funcionario(String cpf, String nome, String email, String telefone, String aniversario ) {
		super(cpf, nome, email, telefone, aniversario);
		
	}


	protected String departamento;
	
	
	
	public boolean save() {
		
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into funcionario(cpf, nome, email, telefone, aniversario)values(?,?,?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.cpf);
			ps.setString(2, this.nome);
			ps.setString(3, this.email);
			ps.setString(4, this.telefone);
			ps.setString(5, this.aniversario);
			
			
			int status = ps.executeUpdate();
			
			
			if(status == 1) {
			
				
				return true;
			}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
	        
			
		}
	
		return false;
		
	}
	
	
	
	public boolean delete() {
		
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
		
			
			
			String sql = "delete from funcionario where cpf = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setString(1, this.cpf);
			
			
			ps.executeUpdate();
			
			int status = ps.executeUpdate();
			
			if(status== 1) {
				return true;
				}
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
			 
	         
		}
	
	
		return false;
		}
	
	
	
	public void find_one() {

		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from funcionario where cpf = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, this.cpf);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String aniversario = rs.getString("aniversario");
				
				System.out.println("CPF: " +cpf + 
						" \nNOME: " + nome + 
						" \nEMAIL: " + email+ 
						"\nFONE: " + telefone+ 
						"\nANIVERSARIO: " + aniversario);
		}
		
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
	        System.out.println(e.getErrorCode());
	        System.out.println(e.getMessage());
		}
		
	}

	 
		
		
		
}



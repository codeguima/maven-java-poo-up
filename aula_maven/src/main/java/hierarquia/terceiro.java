//Aluno: Jhonny Guimarães
//BSI - praça osorio
//RGM: 29318602


package hierarquia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lojacoisasecoisas.bancodedados;

public class terceiro extends pessoa {

	public terceiro(String cpf, String nome, String email, String telefone, String aniversario) {
		super(cpf, nome, email, telefone, aniversario);
		
	}
	
	public terceiro() {}
	
	
	public boolean save() {
		
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into funcionario(cpf, nome, email, telefone, aniversario, terceiro)values(?,?,?,?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.cpf);
			ps.setString(2, this.nome);
			ps.setString(3, this.email);
			ps.setString(4, this.telefone);
			ps.setString(5, this.aniversario);
			ps.setString(6, "1");
			
			//quando usado o save() da classe terceiro ao inserir novo 
			//funcionario já é inserido como true na tabela funcionario para terceiro
			
			int status = ps.executeUpdate();
			
			
			if(status == 1) {
				
				
				return true;
			}
			
		} catch (SQLException e) {
			
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
	
	
	public boolean inativar() {
		
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
			
			
			String sql = "UPDATE `hierarquia`.`funcionario` SET `status` = 'Inativo' WHERE (`cpf` = ?);";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.cpf);
			
			
			int retorno = ps.executeUpdate();
			
			if(retorno != 0) {
				return true;
			}
			
		}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MESSAGE: " + e.getMessage());
		}
		
	
		return false;
		
	}
	
	
	public boolean encerrar_contrato() {
		
		
		Connection conexao = conectBDD.getConexaoMySQL();
		
		
		try {
			
			
			String sql = "call encerrarcontrato(?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.cpf);
			
			
			int retorno = ps.executeUpdate();
			
			if(retorno != 1) {
				return true;
			}
			
		}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MESSAGE: " + e.getMessage());
		}
		
	
		return false;
		
	}
		
	
}

package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		
		boolean trovato = false;
		String sql ="SELECT * "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma.toLowerCase());
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				trovato = true;
			
		}catch(SQLException sqle) {
			System.out.println("Errore nella query");
		}
		return trovato;
	}
}

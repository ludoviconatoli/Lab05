package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Anagrammi{
	
	
	AnagrammaDAO anagrammadao = new AnagrammaDAO();
	public List<String> anagrammi(String parola){
		
		List<String> risultato = new ArrayList<>();
		permuta("", parola, 0, risultato);//LANCIA la ricorsione
		return risultato;
	}
	
	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
	
		if(lettere.length() == 0) {
			risultato.add(parziale);
		}else {
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos);
				String nuovaParziale = parziale + tentativo;
				String nuoveLettere = lettere.substring(0, pos) + lettere.substring(pos+1); //togli il carattere pos da lettere
						
				permuta(nuovaParziale, nuoveLettere, livello+1, risultato);		
			}
		}
	}
	
	public void calcola(List<String> corretti, List<String> errati, String parola) {
		
		List<String> risultato = this.anagrammi(parola);
		
		for(String s: risultato) {
			boolean found = false;
			found = this.anagrammadao.isCorrect(s);
			if(found) {
				corretti.add(s);
			}else
				errati.add(s);
				
		}
		
	}
}

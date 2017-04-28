package it.polito.tdp.anagramma.model;

import java.util.*;

import it.polito.tdp.anagrammi.dao.AnagrammiDAO;

public class Model {
	
	AnagrammiDAO anagrammaDAO=new AnagrammiDAO();
	
	//List<String> anagrammi=null;
	
	public Set<String> anagrammi (String parola){
		
		Set<String>anagrammi=new HashSet<String>();
		String parziale="";
		int step=0;
		calcola(parziale, parola, step, anagrammi);
		
		return anagrammi;
		
	}
	
	public void calcola (String parziale, String parola, int step, Set<String>anagrammi){
		
		if(step==parola.length()){
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0; i<parola.length(); i++)
			if(charCounter(parziale, parola.charAt(i))<charCounter(parola, parola.charAt(i))){
				//aggiungi la nuova lettera alla stringa
				parziale+=parola.charAt(i);
				
				//richiami la ricorsione
				calcola(parziale,parola,step+1,anagrammi);
				
				//rimuovi la lettera aggiunta
				parziale= parziale.substring(0, parziale.length()-1);
			}
		
	}

	private int charCounter(String string, char c) {
		
		int cnt=0;
		
		for (int i=0; i<string.length(); i++){
			if(string.charAt(i)==c)
				cnt++;
		}
		
		return cnt;
	}
	
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}
	

}

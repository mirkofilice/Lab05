package it.polito.tdp.anagramma.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		Set<String> anagrammi= model.anagrammi("eat");
    	
    	for(String s: anagrammi){
    		if (model.isCorrect(s))
    			System.out.println("Corretta: "+s+"\n");
    		else
    			System.out.println("Non corretta: "+s+"\n");
    	}

	}

}

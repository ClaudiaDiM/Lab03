package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Dictionary {
	
	private List<String> dizionario;
	private String language;
	
	
	
	public boolean loadDictionary(String language) {
		
		if(dizionario!=null && this.language.equals(language)) {
			return true;
		}
		
		dizionario = new ArrayList<String>();
		this.language = language;
		
		try {
			FileReader fr = new FileReader("src/main/resources/" + language + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while((word = br.readLine())!=null) {
				dizionario.add(word.toLowerCase());
			}
			
			Collections.sort(dizionario);
			
			br.close();
			//System.out.println("Dizionario " + language + " loaded. Found " + dizionario.size() + " words.");
			return true;
			
			
		}catch(IOException e) {
			System.out.println("Errore nella lettura del file");
			return false;
		}
		
		
		
		
		
	}

}

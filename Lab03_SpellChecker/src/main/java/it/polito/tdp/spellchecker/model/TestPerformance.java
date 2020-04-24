package it.polito.tdp.spellchecker.model;

public class TestPerformance {

	public static void main(String[] args) {
		
		Dictionary model = new Dictionary();
		model.loadDictionary("Italian");

		String inputText = "In informatica Java è un linguaggio di programmazione ad alto livello, "
				+ "orientato agli oggetti e a tipizzazione statica, specificatamente progettato per essere "
				+ "il più possibile indipendente dalla piattaforma di esecuzione.";
		inputText = inputText.replaceAll("\n", " ");
		inputText = inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
		System.out.println(inputText);

	}

}

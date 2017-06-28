package be.steformation.tunsajan.jd.conj.utils;

import be.steformations.java_data.conjugaison_fr.interfaces.Personne;

public class ConjExtractor {

	public String extractTermInf(String infinitif, String radical ){
		return infinitif.substring(radical.length());
	}
	public String extractRadical(String term, String vi){
		return vi.substring(0, vi.length()-term.length());
	}
	public String extractTermParticipe(String radical, String participe){
		return participe.substring(radical.length());	
	}
	public be.steformations.java_data.conjugaison_fr.interfaces.Personne getPersonne(int p){
		switch(p){
			case 1: return Personne.JE;
			case 2: return Personne.TU;
			case 3: return Personne.IL;
			case 4: return Personne.NOUS;
			case 5: return Personne.VOUS;
			case 6: return Personne.ILS;
			default: return null;
		}
	}
}

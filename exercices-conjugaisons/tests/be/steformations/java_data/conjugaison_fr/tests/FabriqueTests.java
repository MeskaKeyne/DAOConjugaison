package be.steformations.java_data.conjugaison_fr.tests;

import be.steformation.tunsajan.jd.conj.dao.DAOConjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;

public class FabriqueTests {
	
	public static Conjugueur getConjugueur() {
		// TODO
		return new DAOConjugueur();
	}
}

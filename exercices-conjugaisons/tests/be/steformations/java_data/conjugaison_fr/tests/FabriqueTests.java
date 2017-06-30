package be.steformations.java_data.conjugaison_fr.tests;

import be.steformation.tunsajan.jd.conj.dao.DAOConjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;

public class FabriqueTests {
	static private DAOConjugueur DAO= new DAOConjugueur();
	
	public static Conjugueur getConjugueur() {
		return DAO;
	}
}

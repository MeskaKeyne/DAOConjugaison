package be.steformations.java_data.conjugaison_fr.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;

public class _01_TestGetConjugueur {

	@Test
	public void testGetConjugueur() {
		try {
			Conjugueur c = FabriqueTests.getConjugueur();
			assertNotNull("FabriqueTests.getConjugueur()", c);
		} catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

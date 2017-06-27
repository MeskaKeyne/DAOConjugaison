package be.steformations.java_data.conjugaison_fr.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class _02_TestGetVerbe {

	@Test
	public void testGetVerbe() {
		try {
			Conjugueur c = FabriqueTests.getConjugueur();
			assertNotNull("FabriqueTests.getConjugueur()", c);
			
			Verbe programmer = c.getVerbe("programmer");
			assertNotNull( "FabriqueTests.getConjugueur().createVerbe(\"programmer\") != null", programmer );
			assertNotNull( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getInfinitif() != null", 
						   programmer.getInfinitif() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getInfinitif().equals(\"programmer\")", 
					       "programmer", programmer.getInfinitif() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getRadical().equals(\"programm\")", 
				           "programm", programmer.getRadical() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getParticipe().equals(\"programmé\")", 
			               "programmé", programmer.getParticipe() );	
			
			
			assertNotNull( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getModele() != null", 
					   	   programmer.getModele() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getModele().getInfinitif().equals(\"programmer\")", 
				       	   "aimer", programmer.getModele().getInfinitif() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getModele().getRadical().equals(\"programm\")", 
			               "aim", programmer.getModele().getRadical() );
			assertEquals ( "FabriqueTests.getConjugueur().createVerbe(\"programmer\").getModele().getParticipe().equals(\"programmé\")", 
		                   "aimé", programmer.getModele().getParticipe() );
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

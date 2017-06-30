package be.steformations.java_data.conjugaison_fr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;
import be.steformations.java_data.conjugaison_fr.tests.FabriqueTests;

public class _35_TestConjugueurGetListConjugaisonJouerSubjonctifPlusQueParfait {
	
	private static Mode mode                = Mode.SUBJONCTIF;
	private static Temps temps              = Temps.PLUS_QUE_PARFAIT;
	private static String infinitif			= "jouer";
	private static String[] valeurs         = new String[] { "eusse joué", "eusses joué", "eût joué", "eussions joué", "eussiez joué", "eussent joué" };
	
	@Test
	public void testGetConjugaisons() {
		try {		
			Conjugueur conjugueur = FabriqueTests.getConjugueur();
			assertNotNull("FabriqueTests.getConjugueur()", conjugueur);
			
			Verbe verbe = conjugueur.getVerbe(infinitif);
			assertNotNull(String.format("Conjugueur.getVerbe(\"%s\") != null", infinitif), verbe);
			
			List<Conjugaison> conjugaisons = conjugueur.conjuguer(verbe, mode, temps);
			assertNotNull(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s) != null", infinitif, mode, temps), conjugaisons);
			assertEquals(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s).size() == %s", infinitif, mode, temps, valeurs.length), valeurs.length, conjugaisons.size());
			for (int i = 0; i < valeurs.length; i++) {
				assertNotNull(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s ).get(%s) != null", infinitif, mode, temps, i), conjugaisons.get(i));
				assertEquals(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s).get(%s).getValeur() == %s", infinitif, mode, temps, i, valeurs[i]), 
							 valeurs[i], conjugaisons.get(i).getValeur());
			}
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}










package be.steformations.java_data.conjugaison_fr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;
import be.steformations.java_data.conjugaison_fr.tests.FabriqueTests;

public class _07_TestConjugueurGetConjugaisonChoisirIndicatifPlusQueParfait {
	
	private static Mode mode                = Mode.INDICATIF;
	private static Temps temps              = Temps.PLUS_QUE_PARFAIT;
	private static String infinitif			= "choisir";
	private static Map<Personne,String> map = new HashMap<Personne, String>();
	
	static {
		map.put(Personne.JE,   "avais choisi");
		map.put(Personne.TU,   "avais choisi");
		map.put(Personne.IL,   "avait choisi");
		map.put(Personne.NOUS, "avions choisi");
		map.put(Personne.VOUS, "aviez choisi");
		map.put(Personne.ILS,  "avaient choisi");
	}
	
	@Test
	public void testGetConjugaison() {
		try {
			Conjugueur conjugueur = FabriqueTests.getConjugueur();
			assertNotNull("FabriqueTests.getConjugueur() != null", conjugueur);
			
			Verbe verbe = conjugueur.getVerbe(infinitif);
			assertNotNull(String.format("Conjugueur.getVerbe(\"%s\") != null", infinitif), verbe);
			
			Conjugaison c = null;
			for (Entry<Personne, String> entry : map.entrySet()) {
				c = conjugueur.conjuguer(verbe, mode, temps, entry.getKey());
				assertNotNull(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s, %s ) != null", infinitif, mode, temps, entry.getKey()), c);
				assertEquals(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s, %s ).equals(\"%s\")", infinitif, mode, temps, entry.getKey(), entry.getValue()), entry.getValue(), c.getValeur());
			}
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}










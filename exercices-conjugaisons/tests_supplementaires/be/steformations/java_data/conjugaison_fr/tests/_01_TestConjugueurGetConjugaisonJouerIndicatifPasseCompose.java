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

public class _01_TestConjugueurGetConjugaisonJouerIndicatifPasseCompose {
	
	private static Mode mode                = Mode.INDICATIF;
	private static Temps temps              = Temps.PASSE_COMPOSE;
	private static String infinitif			= "jouer";
	private static Map<Personne,String> map = new HashMap<Personne, String>();
	
	static {
		map.put(Personne.JE,   "ai joué");
		map.put(Personne.TU,   "as joué");
		map.put(Personne.IL,   "a joué");
		map.put(Personne.NOUS, "avons joué");
		map.put(Personne.VOUS, "avez joué");
		map.put(Personne.ILS,  "ont joué");
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










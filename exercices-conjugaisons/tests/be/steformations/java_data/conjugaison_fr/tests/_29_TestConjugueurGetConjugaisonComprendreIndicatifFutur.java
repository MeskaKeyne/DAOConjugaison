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

public class _29_TestConjugueurGetConjugaisonComprendreIndicatifFutur {
	
	private static Mode mode                = Mode.INDICATIF;
	private static Temps temps              = Temps.FUTUR;
	private static String infinitif			= "comprendre";
	private static Map<Personne,String> map = new HashMap<Personne, String>();
	
	static {
		map.put(Personne.JE,   "comprendrai");
		map.put(Personne.TU,   "comprendras");
		map.put(Personne.IL,   "comprendra");
		map.put(Personne.NOUS, "comprendrons");
		map.put(Personne.VOUS, "comprendrez");
		map.put(Personne.ILS,  "comprendront");
	}
	
	@Test
	public void testConjuguer() {
		try {
			Conjugueur conjugueur = FabriqueTests.getConjugueur();
			assertNotNull("FabriqueTests.getConjugueur()", conjugueur);
			
			Verbe verbe = conjugueur.getVerbe(infinitif);
			assertNotNull(String.format("Conjugueur.getVerbe(\"%s\") ", infinitif), verbe);
			
			Conjugaison c = null;
			for (Entry<Personne, String> entry : map.entrySet()) {
				c = conjugueur.conjuguer(verbe, mode, temps, entry.getKey());
				assertNotNull(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s, %s )", infinitif, mode, temps, entry.getKey()), c);
				assertEquals(String.format("Conjugueur.conjuguer( Conjugueur.getVerbe(\"%s\"), %s, %s, %s )", infinitif, mode, temps, entry.getKey(), entry.getValue()), entry.getValue(), c.getValeur());
			}
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}










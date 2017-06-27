package be.steformations.java_data.conjugaison_fr.interfaces;

public interface Conjugueur {
	
	/**
	 * Construit un {@link Verbe} à partir d'un infinitif
	 * 
	 * @param infinitif
	 * @return le {@link Verbe} correspondant ou null si il n'existe pas
	 */
	Verbe getVerbe(String infinitif);
	
	/**
	 * Conjugue un {@link Verbe} à un mode, un temps et une personne donnés
	 * 
	 * @param verbe
	 * @param mode
	 * @param temps
	 * @param personne
	 * @return la {@link Conjugaison} ou null si la conjugaison demandée est impossible
	 */
	Conjugaison conjuguer(Verbe verbe, Mode mode, Temps temps, Personne personne);
	
	/**
	 * Conjugue un {@link Verbe} à un mode et un temps donnés pour toutes les personnes
	 * 
	 * @param verbe
	 * @param mode
	 * @param temps
	 * @return la liste des {@link Conjugaison} ordonnée par {@link Personne} 
	 */
	java.util.List<Conjugaison> conjuguer(Verbe verbe, Mode mode, Temps temps);
}

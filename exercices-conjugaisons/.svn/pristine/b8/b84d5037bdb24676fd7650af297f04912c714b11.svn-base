package be.steformations.java_data.conjugaison_fr.interfaces;

import java.io.Serializable;

public interface Verbe extends Serializable  {

	/**
	 * Renvoie le {@link Verbe} qui permet de déduire le radical, l'infinitif et les {@link Conjugaison}
	 * 
	 * @return le modèle du verbe
	 */
	Verbe  getModele();
	
	/**
	 * Renvoie l'infinitif
	 * 
	 * @return
	 */
	String getInfinitif();
	
	/**
	 * Renvoie le radical du {@link Verbe}
	 * <br/>
	 * Exemple: l'infinitif "programmer" a pour radical "programm"
	 * 
	 * @return
	 */
	String getRadical();
	
	/**
	 * Renvoie l'{@link Auxiliaire} à utiliser dans les {@link Conjugaison} composées
	 * <br/>
	 * Exemple: "programmer" se conjugue avec l'auxiliaire "avoir"
	 * 
	 * @return
	 */
	Auxiliaire getAuxiliaire();
	
	/**
	 * Renvoie le participe passé à utiliser dans les {@link Conjugaison} composées
	 * <br/>
	 * Exemple: le participe passé de "programmer" est "programmé"
	 * 
	 * @return
	 */
	String getParticipe();
}

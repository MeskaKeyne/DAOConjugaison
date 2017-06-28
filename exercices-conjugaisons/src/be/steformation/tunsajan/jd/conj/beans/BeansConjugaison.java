package be.steformation.tunsajan.jd.conj.beans;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class BeansConjugaison implements Conjugaison {
	private Mode _mode;
	private Temps _temps;
	private Verbe _verbe;
	private Personne _personne;
	private String _valeur;

	public BeansConjugaison(Mode m, Temps t, Personne p, String val, Verbe v ) {
		this._mode = m;
		this._personne = p;
		this._temps = t;
		this._valeur = val;
		this._verbe = v;
	}
	@Override
	public Mode getMode() {
		// TODO Auto-generated method stub
		return this._mode;
	}

	@Override
	public Temps getTemps() {
		// TODO Auto-generated method stub
		return this._temps;
	}

	@Override
	public Verbe getVerbe() {
		// TODO Auto-generated method stub
		return this._verbe;
	}

	@Override
	public Personne getPersonne() {
		// TODO Auto-generated method stub
		return this._personne;
	}

	@Override
	public String getValeur() {
		// TODO Auto-generated method stub
		return this._valeur;
	}
	public void setVerbe(Verbe v){
		this._verbe = v;
	}
	@Override
	public String toString() {
		return "BeansConjugaison [_mode=" + _mode + ", _temps=" + _temps + ", _verbe=" + _verbe + ", _personne="
				+ _personne + ", _valeur=" + _valeur + "]";
	}

}

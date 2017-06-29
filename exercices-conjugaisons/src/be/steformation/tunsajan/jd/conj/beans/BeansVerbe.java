package be.steformation.tunsajan.jd.conj.beans;

import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class BeansVerbe implements Verbe {
	
	private int _id;
	private String _infinitif;
	private String _radical;
	private String _participe;
	private Auxiliaire _auxilaire;
	private Verbe _modele;
	
	public BeansVerbe(String infinitf, String radical, String participe, Auxiliaire aux, Verbe modele){
		this._infinitif = infinitf;
		this._radical = radical;
		this._participe = participe;
		this._auxilaire = aux;
		this._modele = modele;
	}

	@Override
	public Verbe getModele() {
		// TODO Auto-generated method stub
		return this._modele;
	}

	@Override
	public String getInfinitif() {
		// TODO Auto-generated method stub
		return this._infinitif;
	}

	@Override
	public String getRadical() {
		// TODO Auto-generated method stub
		return this._radical;
	}

	@Override
	public Auxiliaire getAuxiliaire() {
		// TODO Auto-generated method stub
		return this._auxilaire;
	}

	@Override
	public String getParticipe() {
		// TODO Auto-generated method stub
		return this._participe;
	}
	public int gztID(){
		return this._id;
	}

	@Override
	public String toString() {
		return _infinitif +" " ;
	}


	
	
	

}

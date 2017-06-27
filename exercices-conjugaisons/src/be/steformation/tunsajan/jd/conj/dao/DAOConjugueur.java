package be.steformation.tunsajan.jd.conj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class DAOConjugueur implements Conjugueur {
	
	private JdbcTemplate jdbc;

	
	public DAOConjugueur() {
	
		//this.jdbc = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost/conjugaison", "postgres", "postgres"));
		this.jdbc = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://PRIM2014-14/conjugaison", "postgres", "postgres"));
		
	}
	@Override
	public Verbe getVerbe(String infinitif) {
		
		
		String sql = "SELECT * FROM Verbes, modeles where verbes.modele = modeles.id AND infinitif = (?)";
		
	/*	SELECT verbes.infinitif as vi, verbes.auxiliaire as aux, modeles.infinitif as mi, modeles.radical as radical, modeles.participe as participe  FROM Verbes, modeles
		where verbes.modele = modeles.id and verbes.infinitif = 'programmer'*/
	
		return null;
	}

	@Override
	public Conjugaison conjuguer(Verbe verbe, Mode mode, Temps temps, Personne personne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conjugaison> conjuguer(Verbe verbe, Mode mode, Temps temps) {
		// TODO Auto-generated method stub
		return null;
	}

}

package be.steformation.tunsajan.jd.conj.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import be.steformation.tunsajan.jd.conj.mapper.MapperConjugaison;
import be.steformation.tunsajan.jd.conj.mapper.MapperVerbe;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class DAOConjugueur implements Conjugueur {
	
	private JdbcTemplate _jdbc;

	
	public DAOConjugueur() {
	
		//this.jdbc = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost/conjugaison", "postgres", "postgres"));
		this._jdbc = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://PRIM2014-14/conjugaison", "postgres", "postgres"));
		
	}
	@Override
	public Verbe getVerbe(String infinitif) {
		Verbe verbe = null;
		
		
		String sql = "SELECT verbes.id AS idVerbe, modeles.id AS idModele, verbes.infinitif as vi, verbes.auxiliaire as aux, modeles.infinitif as mi, modeles.radical as radical, modeles.participe as participe  "
				+ "FROM Verbes, modeles "
				+ "where verbes.modele = modeles.id and verbes.infinitif = (?)";
	
		try {
				MapperVerbe mapper = new MapperVerbe();
				verbe = this._jdbc.queryForObject(sql, mapper, infinitif);
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {e.getMessage();}
			return verbe;
		}

	@Override
	public Conjugaison conjuguer(Verbe verbe, Mode mode, Temps temps, Personne personne) {
		Conjugaison conjugaison = null;
		String sql = "SELECT m.nom AS mode, t.nom AS temps, c.personne AS personne, c.terminaison AS term "
				+ "FROM conjugaisons AS c, temps as t, modes AS m, verbes AS v, modeles AS ms "
				+ "WHERE c.fk_temps = t.id and ms.id = v.modele and c.fk_modele = ms.id and t.id = c.fk_temps and m.id = c.fk_mode "
                +" AND c.personne = (?) and t.nom = (?) and m.nom = (?) AND v.infinitif = (?) and ms.infinitif = (?)";
		
		try {
			MapperConjugaison mapper = new MapperConjugaison(verbe);
			conjugaison = this._jdbc.queryForObject(sql, mapper, personne.ordinal()+1, temps.name(), mode.name(), verbe.getInfinitif(), verbe.getModele().getInfinitif()
					);
		} catch(org.springframework.dao.EmptyResultDataAccessException e) {e.getMessage();}
		return conjugaison;

	}

	@Override
	public List<Conjugaison> conjuguer(Verbe verbe, Mode mode, Temps temps) {
		List<Conjugaison> conjugaison = null;
		String sql = "SELECT m.nom AS mode, t.nom AS temps, c.personne AS personne, c.terminaison AS term "
				+ "FROM conjugaisons AS c, temps as t, modes AS m, verbes AS v, modeles AS ms "
				+ "WHERE c.fk_temps = t.id and ms.id = v.modele and c.fk_modele = ms.id and t.id = c.fk_temps and m.id = c.fk_mode "
                +" and t.nom = (?) and m.nom = (?) AND v.infinitif = (?) and ms.infinitif = (?)";
		
		try {
			MapperConjugaison mapper = new MapperConjugaison(verbe);
			conjugaison = this._jdbc.query(sql, mapper, temps.name(), mode.name(), verbe.getInfinitif(), verbe.getModele().getInfinitif()
					);
		} catch(org.springframework.dao.EmptyResultDataAccessException e) {e.getMessage();}
		return conjugaison;
	}

}

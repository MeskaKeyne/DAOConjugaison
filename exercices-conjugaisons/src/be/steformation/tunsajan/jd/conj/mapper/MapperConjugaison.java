package be.steformation.tunsajan.jd.conj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import be.steformation.tunsajan.jd.conj.utils.ConjExtractor;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;

public class MapperConjugaison implements RowMapper<Conjugaison> {

	@Override
	public Conjugaison mapRow(ResultSet rs, int row) throws SQLException {
	
		ConjExtractor extract = new ConjExtractor();
		Personne pers = extract.getPersonne(rs.getInt("personne"));
		
		

		
		
		return null;
	}

}

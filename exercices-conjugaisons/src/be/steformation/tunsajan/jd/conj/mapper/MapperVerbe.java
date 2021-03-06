package be.steformation.tunsajan.jd.conj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import be.steformation.tunsajan.jd.conj.beans.BeansVerbe;
import be.steformation.tunsajan.jd.conj.utils.ConjExtractor;
import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class MapperVerbe implements RowMapper<Verbe> {

	@Override
	public Verbe mapRow(ResultSet rs, int row) throws SQLException {
		String vi = rs.getString("vi"); // VERBE INF
		String aux = rs.getString("aux");
		String modeleInf = rs.getString("mi"); 
		String participe = rs.getString("participe");
		String radical = rs.getString("radical");
		Auxiliaire auxi = null;
		if(aux == "E") auxi=Auxiliaire.ETRE;
		else auxi = Auxiliaire.AVOIR;
		if(!rs.wasNull()){
			ConjExtractor extract = new ConjExtractor(); 
			String term = extract.extractTermInf(modeleInf, radical);
			String vbRadical = extract.extractRadical(term, vi);
			String vParticipe = extract.extractTermParticipe(radical, participe);
			Verbe modele =  new BeansVerbe(modeleInf, radical, participe, auxi, null);
			Verbe bv = new BeansVerbe(vi, vbRadical, vbRadical.concat(vParticipe), auxi, modele);
			return bv ;
		}
		else {
			Verbe modele=new BeansVerbe(modeleInf, null, participe, auxi, null);
			Verbe bv = new BeansVerbe(vi, null, participe, auxi, modele);
			return bv ;
		}
	
		
		
	}

}

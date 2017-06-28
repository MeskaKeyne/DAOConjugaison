package be.steformation.tunsajan.jd.conj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import be.steformation.tunsajan.jd.conj.beans.BeansVerbe;
import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class MapperVerbe implements RowMapper<Verbe> {

	@Override
	public Verbe mapRow(ResultSet rs, int row) throws SQLException {
		String vi = rs.getString("vi"); // VERBE INF
		String aux = rs.getString("aux");
		String modeleInf = rs.getString("mi"); 
		String radical = rs.getString("radical");
		String participe = rs.getString("participe");
		
		
		String term = this.terminaison(modeleInf, radical);
		String vbRadical = this.radical(term, vi);
		String vParticipe = this.participe(radical, participe);
		Auxiliaire auxi = Auxiliaire.AVOIR;
		
		
		Verbe modele =  new BeansVerbe(modeleInf, radical, participe, auxi, null);
		Verbe bv = new BeansVerbe(vi, vbRadical, vbRadical.concat(vParticipe), auxi, modele);
		System.out.println(bv);
		
		
		/////////////////////////////////////////////////////
		
		
		
		return bv ;
	}
	public String terminaison(String infinitif, String radical ){
		return infinitif.substring(radical.length());
	}
	public String radical(String term, String vi){
		return vi.substring(0, vi.length()-term.length());
	}
	public String participe(String radical, String participe){
		return participe.substring(radical.length());	
	}

}

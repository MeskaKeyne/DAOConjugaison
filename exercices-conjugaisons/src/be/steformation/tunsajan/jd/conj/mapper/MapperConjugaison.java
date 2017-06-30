package be.steformation.tunsajan.jd.conj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import be.steformation.tunsajan.jd.conj.beans.BeansConjugaison;
import be.steformation.tunsajan.jd.conj.utils.ConjExtractor;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class MapperConjugaison implements RowMapper<Conjugaison> {
	private Verbe _verbe;
	private String _participe;
	private Temps _temps;
	
	
	public MapperConjugaison(Verbe v) {
		this._verbe = v;
		this._participe = null;
		this._temps = null;
	
	}
	
	public MapperConjugaison(Verbe v, String p, Temps t) {
		this._verbe = v;
		this._participe = p;
		this._temps = t;
	}

	@Override
	public Conjugaison mapRow(ResultSet rs, int row) throws SQLException {
	
		ConjExtractor extract = new ConjExtractor();
		Personne p = extract.getPersonne(rs.getInt("personne"));
		Temps t=Temps.valueOf(rs.getString("temps"));
		Mode m =Mode.valueOf(rs.getString("mode"));
		String term = rs.getString("term");
		
		String vc = null;
		if (this._verbe.getRadical()!=null){
			vc =this._verbe.getRadical().concat(term);
			
		}
		else vc = term;
		if (this._participe !=null) vc = vc.concat(" "+this._participe);
		if(this._temps != null) t = this._temps;
		
		Conjugaison conj = new BeansConjugaison(m, t, p, vc, this._verbe);
		//System.out.println(conj);
		return conj;
	}
	public void setVerbe(Verbe verbe){
		this._verbe = verbe;
	};

}

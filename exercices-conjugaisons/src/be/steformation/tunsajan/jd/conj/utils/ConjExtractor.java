package be.steformation.tunsajan.jd.conj.utils;

public class ConjExtractor {

	public String extractTermInf(String infinitif, String radical ){
		return infinitif.substring(radical.length());
	}
	public String extractRadical(String term, String vi){
		return vi.substring(0, vi.length()-term.length());
	}
	public String extractTermParticipe(String radical, String participe){
		return participe.substring(radical.length());	
	}
}

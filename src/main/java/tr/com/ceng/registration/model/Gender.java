package tr.com.ceng.registration.model;

/**
 *
 * @author Cengizhan Ozcan
 */
public enum Gender {

	M("Erkek"), F("Kadin");
	
	private String lbl;
	
	private Gender(String lbl){
		this.lbl = lbl;
	}

	public String getLbl() {
		return lbl;
	}
	
}

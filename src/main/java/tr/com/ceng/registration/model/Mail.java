package tr.com.ceng.registration.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cengizhan Ozcan
 */
public class Mail implements Serializable{

	private List<String> tos;
	
	private String subject;
	
	private String body;

	public List<String> getTos() {
		return tos;
	}

	public void setTos(List<String> tos) {
		this.tos = tos;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}

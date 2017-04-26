package tr.com.ceng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import tr.com.ceng.utils.DatabaseUtils;

/**
*
* @author Cengizhan Ozcan
*/
@Entity
@Table(name = "user_user", schema = DatabaseUtils.SCHEMA_NAME)
public class User extends BaseEntity{

	private static final long serialVersionUID = 8868622958062242006L;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "surname", nullable = false, length = 100)
	private String surname;
	
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	
	@Column(name = "phone_number", nullable = true, length=20)
	private String phoneNumber;
	
	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}

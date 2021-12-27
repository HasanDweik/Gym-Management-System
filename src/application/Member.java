package application;

public class Member {
	private int member_id;
	private String full_name;
	private String address;
	private String gender;
	private String mobile_number;
	private String date_of_birth;
	private String email;
	
	
	
	public Member(int member_id, String full_name, String address, String gender, String mobile_number,
			String date_of_birth, String email) {
		super();
		this.member_id = member_id;
		this.full_name = full_name;
		this.address = address;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
	}

	public Member(String full_name, String address, String gender, String mobile_number, String date_of_birth,
			String email) {
		super();
		this.full_name = full_name;
		this.address = address;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
	}
	
	public Member() {

	}



	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return  full_name;
	}
	
	
	
	

}

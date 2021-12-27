package application;

public class Trainer {
	
	private int trainer_id;
	private String full_name;
	private String address;
	private String gender;
	private String mobile_number;
	private String date_of_birth;
	private String email;
	private String joining_date;
	private String trainer_description;
	
	public Trainer(String full_name, String address, String gender, String mobile_number, String date_of_birth,
			String email, String joining_date, String trainer_description) {
		super();
		this.full_name = full_name;
		this.address = address;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.joining_date = joining_date;
		this.trainer_description = trainer_description;
	}
	
	
	public Trainer() {

	}


	public Trainer(int trainer_id, String full_name, String address, String gender, String mobile_number,
			String date_of_birth, String email, String joining_date, String trainer_description) {
		super();
		this.trainer_id = trainer_id;
		this.full_name = full_name;
		this.address = address;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.joining_date = joining_date;
		this.trainer_description = trainer_description;
	}


	public int getTrainer_id() {
		return trainer_id;
	}


	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
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

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getTrainer_description() {
		return trainer_description;
	}

	public void setTrainer_description(String trainer_description) {
		this.trainer_description = trainer_description;
	}

	@Override
	public String toString() {
		return "Coach " + full_name;
	}
	
	
}

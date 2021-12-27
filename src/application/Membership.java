package application;

public class Membership {

	private int membership_id;
	private String first_payment_date;
	private int registration_id;
	private int package_id;
	private int trainer_id;
	private String valid_from;
	private String valid_till;
	
	
	public Membership(int membership_id, String first_payment_date, int registration_id, int package_id,
			int trainer_id,String valid_from,String valid_till) {
		super();
		this.membership_id = membership_id;
		this.first_payment_date = first_payment_date;
		this.registration_id = registration_id;
		this.package_id = package_id;
		this.trainer_id = trainer_id;
		this.valid_from = valid_from;
		this.valid_till = valid_till;
	}

	public Membership(String first_payment_date, int registration_id, int package_id,
			int trainer_id,String valid_from,String valid_till) {
		super();
		this.first_payment_date = first_payment_date;
		this.registration_id = registration_id;
		this.package_id = package_id;
		this.trainer_id = trainer_id;
		this.valid_from = valid_from;
		this.valid_till = valid_till;
	}
	
	public Membership() {

	}


	public String getValid_from() {
		return valid_from;
	}

	public void setValid_from(String valid_from) {
		this.valid_from = valid_from;
	}

	public String getValid_till() {
		return valid_till;
	}

	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}

	public String getFirst_payment_date() {
		return first_payment_date;
	}

	public void setFirst_payment_date(String first_payment_date) {
		this.first_payment_date = first_payment_date;
	}

	public int getRegistration_id() {
		return registration_id;
	}

	public void setRegistration_id(int registration_id) {
		this.registration_id = registration_id;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public int getMembership_id() {
		return membership_id;
	}

	public void setMembership_id(int membership_id) {
		this.membership_id = membership_id;
	}
	
	
	
	
}

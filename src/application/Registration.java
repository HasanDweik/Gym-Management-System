package application;

public class Registration {
	private String joining_date;
	private int member_id;
	
	public Registration(String joining_date, int member_id) {
		super();
		this.joining_date = joining_date;
		this.member_id = member_id;
	}
	
	public Registration() {

	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	
}


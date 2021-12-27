package application;

public class Attendance {

	private String attendance_date;
	private String in_time;
	private int membership_id;
	
	public Attendance(String attendance_date, String in_time, int membership_id) {
		super();
		this.attendance_date = attendance_date;
		this.in_time = in_time;
		this.membership_id = membership_id;
	}
	
	public Attendance() {

	}

	public String getAttendance_date() {
		return attendance_date;
	}

	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public int getMembership_id() {
		return membership_id;
	}

	public void setMembership_id(int membership_id) {
		this.membership_id = membership_id;
	}
	
	
	
	
}

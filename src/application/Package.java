package application;

public class Package {

	private int package_id;
	private String package_name;
	private String package_description;
	private Double package_fee;
	private int duration;
	
	public Package(String package_name, String package_description, Double package_fee, int duration) {
		super();
		this.package_name = package_name;
		this.package_description = package_description;
		this.package_fee = package_fee;
		this.duration = duration;
	}
	
	public Package() {

	}

	
	
	
	public Package(int package_id, String package_name, String package_description, Double package_fee,int duration) {
		super();
		this.package_id = package_id;
		this.package_name = package_name;
		this.package_description = package_description;
		this.package_fee = package_fee;
		this.duration=duration;
	}

	
	
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getPackage_description() {
		return package_description;
	}

	public void setPackage_description(String package_description) {
		this.package_description = package_description;
	}

	public Double getPackage_fee() {
		return package_fee;
	}

	public void setPackage_fee(Double package_fee) {
		this.package_fee = package_fee;
	}

	@Override
	public String toString() {
		return package_name;
	}
	
	
	
	
}

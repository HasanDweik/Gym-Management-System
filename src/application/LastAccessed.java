package application;

public class LastAccessed {

	private static int membership_id;

	public static int getMembership_id() {
		return membership_id;
	}

	public static void setMembership_id(int membership_id) {
		LastAccessed.membership_id = membership_id;
	}
}

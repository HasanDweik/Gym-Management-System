package application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;

public class Database_Connection {
	
	public static Connection cn;

	public static Connection getCn() throws SQLException {
	
		Connection connection;
		
		
			connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Gym_Management_System_db","root","toor");
			

		return connection;
	}


	public void connect() {
		
		
		try{
			
			cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Gym_Management_System_db","root","toor");
			
		}catch(Exception ex) {
				ex.printStackTrace();
				}
		
	}
	
	public void disconnect() {
		
		
		try{
			cn=null;
			System.out.println("Disconnected");
		}catch(Exception ex) {
				ex.printStackTrace();
				}
	}
	
	
	public String check_User(String user_name,String password) {
		
		String name="";
		
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select user_name,password,login_name from user where user_name ='" + user_name +"' and password = '"+password+"'");
			while(rs.next()) {
				name=rs.getString(3);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public void insert_Member(Member member, FileInputStream fis, int l) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Member(full_name,address,gender,mobile_number,date_of_birth,email,image) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, member.getFull_name());
			ps.setString(2, member.getAddress());
			ps.setString(3, member.getGender());
			ps.setString(4, member.getMobile_number());
			ps.setString(5, member.getDate_of_birth());
			ps.setString(6, member.getEmail());
			ps.setBinaryStream(7, (InputStream)fis);
			
			ps.executeUpdate();
		
			System.out.println("Member Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public void insert_Member_No_Img(Member member) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Member(full_name,address,gender,mobile_number,date_of_birth,email) values(?,?,?,?,?,?)");
			
			ps.setString(1, member.getFull_name());
			ps.setString(2, member.getAddress());
			ps.setString(3, member.getGender());
			ps.setString(4, member.getMobile_number());
			ps.setString(5, member.getDate_of_birth());
			ps.setString(6, member.getEmail());;
			
			ps.executeUpdate();
		
			System.out.println("Member Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	public int get_Member_Id(int registration_id) {
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select member_id from registration where registration_id ="+registration_id);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public int get_Member_Id2(String mobile_number) {
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select member_id from member where mobile_number ="+mobile_number);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void insert_Trainer(Trainer trainer) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Trainer(full_name,address,gender,mobile_number,date_of_birth,email,joining_date,trainer_description) values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, trainer.getFull_name());
			ps.setString(2, trainer.getAddress());
			ps.setString(3, trainer.getGender());
			ps.setString(4, trainer.getMobile_number());
			ps.setString(5, trainer.getDate_of_birth());
			ps.setString(6, trainer.getEmail());
			ps.setString(7, trainer.getJoining_date());
			ps.setString(8, trainer.getTrainer_description());

			ps.executeUpdate();
		
			System.out.println("Trainer Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public int get_Trainer_Id(String phone_number) {
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select trainer_id from member where mobile_number ="+phone_number);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void insert_Package(Package package_) {
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Package(package_name,package_description,package_fee,duration) values(?,?,?,?)");
			
			ps.setString(1, package_.getPackage_name());
			ps.setString(2, package_.getPackage_description());
			ps.setDouble(3, package_.getPackage_fee());
			ps.setInt(4, package_.getDuration());

			ps.executeUpdate();
		
			System.out.println("Package Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	public int get_Package_Duration(int package_id) {
		int duration=0;
		
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select duration from package where package_id ="+package_id);
			while(rs.next()) {
				duration=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return duration;
	}
	
	public int get_Package_Id(String package_name) {
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select package_id from package where package_name ="+package_name);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void insert_Registration(Registration registration) {
		
		
		
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Registration(joining_date,member_id) values(?,?)");
			
			ps.setString(1, registration.getJoining_date());
			ps.setInt(2, registration.getMember_id());



			ps.executeUpdate();
		
			System.out.println("Registration Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public int get_Registration_Id(int member_id) {
		

		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select registration_id from registration where member_id ="+member_id);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void insert_Membership(Membership membership) {
		
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Membership(first_payment_date,registration_id,package_id,trainer_id,valid_from,valid_till) values(?,?,?,?,?,?)");
			
			ps.setString(1,membership.getFirst_payment_date() );
			ps.setInt(2,membership.getRegistration_id());
			ps.setInt(3, membership.getPackage_id());
			ps.setInt(4, membership.getTrainer_id());
			ps.setString(5,membership.getValid_from());
			ps.setString(6,membership.getValid_till());


			ps.executeUpdate();
		
			System.out.println("Membership Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public int get_Membership_Id(int registration_id) {
		
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select membership_id from membership where registration_id ="+registration_id);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	
	public int get_Registration_Id2(int membership_id) {
		
		
		int id = 0;
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select registration_id from membership where membership_id ="+membership_id);
			while(rs.next()) {
				id=rs.getInt(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public String get_mail(int registration_id) {
		
		String email="";
		
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select email from member,registration where registration.registration_id =" + registration_id + " and registration.member_id=member.member_id");
			while(rs.next()) {
				email=rs.getString(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return email;
	}
	
	public void insert_Attendance(Attendance attendance) {
		
		
		
		try {
			PreparedStatement ps=cn.prepareStatement("insert into Attendance(attendance_date,in_time,membership_id) values(?,?,?)");
			
			ps.setString(1,attendance.getAttendance_date() );
			ps.setString(2,attendance.getIn_time());
			ps.setInt(3, attendance.getMembership_id());

			



			ps.executeUpdate();
		
			System.out.println("Attendance Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public void fillComboMember(ComboBox<Member> memberCombo) {
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from member");
			while(rs.next()) {
				Member member=new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
						,rs.getString(6),rs.getString(7));
				memberCombo.getItems().add(member);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
			public void fillComboTrainer(ComboBox<Trainer> trainerCombo) {
				try {
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery("select * from trainer");
					while(rs.next()) {
						Trainer trainer=new Trainer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
								,rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
						trainerCombo.getItems().add(trainer);
						
					}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void fillComboPackage(ComboBox<Package> packageCombo) {
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from package");
			while(rs.next()) {
				Package package_=new Package(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
				packageCombo.getItems().add(package_);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void fillComboMembership(ComboBox<Member> membershipCombo) {
		
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select member.member_id,member.full_name,member.address,member.gender,member.mobile_number,member.date_of_birth,member.email from member,registration,membership \r\n"
					+ "where member.member_id=registration.registration_id \r\n"
					+ "and registration.registration_id = membership.registration_id");
			while(rs.next()) {
				Member member=new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
						,rs.getString(6),rs.getString(7));
				membershipCombo.getItems().add(member);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void fillTable(ObservableList<Member> oblst) {
		
		try {
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from member");
		
	
		while ( rs.next()) {
			oblst.add(new Member(rs.getInt(1),  rs.getString(2), rs.getString(3),
			rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7)));
		}
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkAccess(int membership_id) {
		boolean access = false;
		Membership membership=null;
		System.out.println("Checking accessability");
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from membership where membership_id ="+membership_id);
			while(rs.next()) {
				membership = new Membership(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)
				,rs.getString(6),rs.getString(7));				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String valid_till = membership.getValid_till();
				    
		    Date valid_till_date = null;
			try {
				valid_till_date = new SimpleDateFormat("yyyy-MM-dd").parse(valid_till);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now(); 
			String attendance_date=dtf.format(now);
			
			Date now_date = null;
			try {
				now_date = new SimpleDateFormat("yyyy-MM-dd").parse(attendance_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		    if(valid_till_date.after(now_date)) {
		    	
		    	access=false;
		    }else {
		    	access=true;
		    }
		
		
		
		
		
		return access;		
	}
	
	public Image get_image(int member_id) {
		
		Blob blob=null;
		
		try {
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select image from member where member_id =" +member_id);
			while(rs.next()) {
				blob= rs.getBlob(1);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image image=null;
		try {
			image = new Image(blob.getBinaryStream());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return image;
	}
	
	
}

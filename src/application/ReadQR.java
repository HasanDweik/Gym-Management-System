package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class ReadQR extends JFrame implements Runnable, ThreadFactory {

	private static final long serialVersionUID = 6441489157408381878L;

	private Executor executor = Executors.newSingleThreadExecutor(this);

	private Webcam webcam = null;
	private WebcamPanel panel = null;
	private JTextArea textarea = null;

	public ReadQR() {
		super();

		setLayout(new FlowLayout());
		setTitle("QR Reader");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Dimension size = WebcamResolution.QVGA.getSize();

		this.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				webcam.close();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
      
            
        });
				
		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);

		panel = new WebcamPanel(webcam);
		panel.setPreferredSize(size);
		panel.setFPSDisplayed(true);

		textarea = new JTextArea();
		textarea.setEditable(false);
		textarea.setPreferredSize(size);

		add(panel);
		add(textarea);
		
		ImageIcon image = new ImageIcon("/images/logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change icon of frame	
		
		pack();
		setVisible(true);

		executor.execute(this);
	}

	@Override
	public void run() {

//		Boolean access = false;
		int keyy;
		do {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Result result = null;
			BufferedImage image = null;

			if (webcam.isOpen()) {

				if ((image = webcam.getImage()) == null) {
					continue;
				}

				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

				try {
					result = new MultiFormatReader().decode(bitmap);
				} catch (NotFoundException e) {
					// fall thru, it means there is no QR code in image
				}
			}

			if (result != null) {
				textarea.setText(result.getText());

				String key = textarea.getText();
				
				String tempWord = "Alpha"; 
	            key = key.replaceAll(tempWord, "");
	            
	            keyy = Integer.valueOf(key);
	            
	            LastAccessed.setMembership_id(keyy);
	            
				Database_Connection aConnection = new Database_Connection();
				
//				access = aConnection.checkAccess(keyy);
				
//				if(access==true) {
					
				
				
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				LocalDateTime now = LocalDateTime.now(); 
				String attendance_date=dtf.format(now);
				
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
				LocalDateTime now2 = LocalDateTime.now(); 
				String in_time = dtf2.format(now2);
				
				Attendance attendance = new Attendance(attendance_date, in_time, keyy);
				
				aConnection.insert_Attendance(attendance);
				

				webcam.close();
				
				textarea.setText("You can enter");
				textarea.setForeground(Color.GREEN);
				textarea.setFont(new Font("New Times Roman",Font.BOLD,14));
				
//				}			
			}

		} while (true);
		
		
		
		
		
		
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "example-runner");
		t.setDaemon(true);
		return t;
	}


}

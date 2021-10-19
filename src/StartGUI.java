

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class StartGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGUI frame = new StartGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartGUI() {
		setTitle("Winds of Trade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Create a button named "Start" which will take
		 * us to the next JFrame while disposing the current 
		 * JFrame.
		 */
		
		JButton btnStart = new JButton("START");
		btnStart.setForeground(Color.DARK_GRAY);
		btnStart.setBackground(new Color(255, 204, 153));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartGUI.this.setVisible(false);
				dispose();
				ProfileGUI profile = new ProfileGUI();
				profile .setVisible(true);
			}
		});
		btnStart.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		btnStart.setBounds(321, 499, 150, 25);
		contentPane.add(btnStart);
		
		/*Set the title of the frame to Winds of Trade */
		
		JLabel lblTitle = new JLabel("Winds of Trade\n");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(264, 27, 250, 50);
		contentPane.add(lblTitle);
		
		/* Create a new label to set the background using the icon 
		 * through classpath resource.
		 */
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 22));
		lblbackground.setIcon(new ImageIcon(StartGUI.class.getResource("/img/Ship_adobespark.jpeg")));
		lblbackground.setBounds(0, 0, 843, 560);
		contentPane.add(lblbackground);
	}
	
}

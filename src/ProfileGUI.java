

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ProfileGUI extends JFrame {

	protected static Object frame;
	private JPanel contentPane;
	public JTextField name;
	private JComboBox<Integer> daysSelect;
	public static int daysSelected;
	public static String playerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileGUI frame = new ProfileGUI();
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
	public ProfileGUI() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a JLabel which will ask you to Enter Your
		 * Trader Name.
		 */
		
		JLabel lblName = new JLabel("Enter Your Trader Name:");
		lblName.setForeground(new Color(255, 0, 51));
		lblName.setBounds(40, 41, 228, 49);
		lblName.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 17));
		getContentPane().add(lblName);
		
		/**
		 *Create a JTextField which will take the input of
		 *the Trader name.
		 */
		
		name = new JTextField();
		name.setBackground(new Color(153, 0, 51));
		name.setForeground(Color.LIGHT_GRAY);
		name.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 16));
		name.setBounds(315, 41, 420, 49);
		getContentPane().add(name);
		name.setColumns(10);
		
		/**
		 * Create a JLabel asking for to Select the number
		 * of trading days.
		 */
		
		JLabel lblDays = new JLabel("Select Number of Trading Days:");
		lblDays.setForeground(new Color(255, 0, 51));
		lblDays.setBounds(40, 117, 275, 49);
		lblDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 17));
		getContentPane().add(lblDays);
		
		/**
		 * Create a JButton "Next" which will take you to the next JFrame if 
		 * all the given conditions are met and will set the visibility of this 
		 * JFrame to false.
		 */
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (name.getText().equals("")) {
					JOptionPane.showMessageDialog((Component) contentPane, "Enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(name.getText().length() > 15 || name.getText().length() < 3) {
					JOptionPane.showMessageDialog((Component) contentPane, "Name should have 3-15 characters.", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				else if(name.getText().matches("^[a-zA-Z]*$") == false) {
					JOptionPane.showMessageDialog((Component) contentPane, "Special Characters and numbers are not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(daysSelect.getSelectedItem() == null) {
					JOptionPane.showMessageDialog((Component) contentPane, "Select number of days.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					daysSelected = daysSelect.getItemAt(daysSelect.getSelectedIndex());
					playerName = name.getText();
					ProfileGUI.this.setVisible(false);
					ShipSelectGUI frm = new ShipSelectGUI();
					frm.setVisible(true);
					
				}
			}
		});
		btnNext.setBounds(645, 487, 150, 25);
		btnNext.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNext);
		
		/**
		 * Create a JComboBox "daysSelect" which will display the 
		 * options the player use to select the number of days
		 * they want to play.
		 */
		
		daysSelect = new JComboBox<Integer>();
		daysSelect.setBackground(new Color(153, 0, 51));
		daysSelect.setOpaque(true);
		daysSelect.setForeground(Color.LIGHT_GRAY);
		daysSelect.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		daysSelect.setBounds(314, 129, 123, 24);
		for (int i=20; i <= 50; i++) {
			daysSelect.addItem(i);
		}
		daysSelect.setSelectedItem(null); 

		contentPane.add(daysSelect);
		
		/**
		 * Create a JLabel which will display the restrictions applied
		 * while inputting a name.
		 */
		
		JLabel lblNameRule = new JLabel("(Only letters and length between");
		lblNameRule.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNameRule.setBounds(40, 70, 200, 25);
		contentPane.add(lblNameRule);
		
		JLabel lblNameRule_2 = new JLabel("3 and 15 characters accepted)");
		lblNameRule_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNameRule_2.setBounds(40, 80, 200, 25);
		contentPane.add(lblNameRule_2);
		
		/**
		 * Create a JLabel which will set the background of the JFrame using the 
		 * given image using icon and selecting classpath resource.
		 */
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblbackground.setIcon(new ImageIcon(ProfileGUI.class.getResource("/img/OHP_Jan_Forest_2-red-1_adobespark.jpeg")));
		lblbackground.setBounds(0, 0, 839, 560);
		contentPane.add(lblbackground);
	}
}

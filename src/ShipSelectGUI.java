

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class ShipSelectGUI extends JFrame {

	private JPanel contentPane;
	private static ButtonGroup group;
	private static JTextPane shipOneProp;
	private static JTextPane shipTwoProp;
	private static JTextPane shipThreeProp;
	private static JTextPane shipFourProp;
	public static String shipName;
	GameEnvironment game = new GameEnvironment();
	Ship voyager = new Ship("SS Voyager", "Kanto", 450, 1.5, 300, 85400, 141, 12);
	Ship crusader = new Ship("SS Crusader", "Hoenn", 400, 1.1, 350, 105000, 88, 10);
	Ship endeavor = new Ship("SS Endeavor", "Sinnoh", 520, 1.5, 300, 72000, 120, 15);
	Ship titan = new Ship("SS Titan", "Kalos", 450, 1.5, 320, 85000, 141, 20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipSelectGUI frame = new ShipSelectGUI();
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
	public ShipSelectGUI() {
		setTitle("Select Ship");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a radio button "Ship 1" 
		 */
		
		JRadioButton rdbtnShip_1 = new JRadioButton("Ship 1");
		rdbtnShip_1.setForeground(new Color(153, 0, 51));
		rdbtnShip_1.setBackground(Color.RED);
		rdbtnShip_1.setBounds(133, 8, 120, 39);
		rdbtnShip_1.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnShip_1.setActionCommand("SS Voyager");
		rdbtnShip_1.setOpaque(false);
		getContentPane().add(rdbtnShip_1);
		
		/**
		 * Create a radio button "Ship 2" 
		 */
		
		JRadioButton rdbtnShip_2 = new JRadioButton("Ship 2");
		rdbtnShip_2.setForeground(new Color(153, 0, 51));
		rdbtnShip_2.setBounds(576, 8, 120, 39);
		rdbtnShip_2.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnShip_2.setActionCommand("SS Crusader");
		rdbtnShip_2.setOpaque(false);
		getContentPane().add(rdbtnShip_2);
		
		/**
		 * Create a radio button "Ship 3" 
		 */
		
		JRadioButton rdbtnShip_3 = new JRadioButton("Ship 3");
		rdbtnShip_3.setForeground(new Color(153, 0, 51));
		rdbtnShip_3.setBounds(133, 248, 120, 39);
		rdbtnShip_3.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnShip_3.setActionCommand("SS Endeavor");
		rdbtnShip_3.setOpaque(false);
		getContentPane().add(rdbtnShip_3);
		
		/**
		 * Create a radio button "Ship 4" 
		 */
		
		JRadioButton rdbtnShip_4 = new JRadioButton("Ship 4");
		rdbtnShip_4.setForeground(new Color(153, 0, 51));
		rdbtnShip_4.setBounds(576, 248, 120, 39);
		rdbtnShip_4.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnShip_4.setActionCommand("SS Titan");
		rdbtnShip_4.setOpaque(false);
		getContentPane().add(rdbtnShip_4);
		
		/**
		 * Create a group to add all the radio buttons to.
		 */
		
		group = new ButtonGroup();
		group.add(rdbtnShip_1);
		group.add(rdbtnShip_2);
		group.add(rdbtnShip_3);
		group.add(rdbtnShip_4);
		
		/**
		 * Create a button "Start Game" which will take you to the
		 * MainGUI and set the visibility of this GUI to false if
		 * you have selected a radio button option or else it will
		 * display an Error JOptionPane.
		 */
		
		JButton btnStartGameButton = new JButton("Start Game");
		btnStartGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (group.isSelected(null)) {
					JOptionPane.showMessageDialog((Component) contentPane, "Select a ship.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					ShipSelectGUI.this.setVisible(false);
					
					MainGUI main = new MainGUI(ProfileGUI.daysSelected);
					
					main.setVisible(true);
				}
			}
		});
		btnStartGameButton.setBounds(673, 485, 150, 25);
		btnStartGameButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		getContentPane().add(btnStartGameButton);
		
		/**
		 * Create a button "Back" which will set the visibility of ProfileGUI
		 * to true while setting the visibility of this GUI to false.
		 */
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ShipSelectGUI.this.setVisible(false);
				
				ProfileGUI prof = new ProfileGUI();
				prof.setVisible(true);
			}
		});
		btnBackButton.setBounds(12, 485, 150, 25);
		contentPane.add(btnBackButton);
		
		/**
		 * Create four TextPanes which will display the properties of the
		 * Ship to be selected.
		 */
		
		shipThreeProp = new JTextPane();
		shipThreeProp.setForeground(new Color(51, 0, 0));
		shipThreeProp.setBackground(UIManager.getColor("Label.background"));
		shipThreeProp.setFont(new Font("EB Garamond SC 08", Font.PLAIN, 18));
		shipThreeProp.setText(endeavor.getPropertiesGUI());
		shipThreeProp.setOpaque(false);
		shipThreeProp.setBounds(34, 295, 380, 185);
		shipThreeProp.setEditable(false);
		contentPane.add(shipThreeProp);
		
		shipOneProp = new JTextPane();
		shipOneProp.setEditable(false);
		shipOneProp.setFont(new Font("EB Garamond SC 08", Font.PLAIN, 18));
		shipOneProp.setForeground(new Color(51, 0, 0));
		shipOneProp.setBackground(SystemColor.info);
		shipOneProp.setBounds(34, 55, 380, 185);
		shipOneProp.setText(voyager.getPropertiesGUI());
		shipOneProp.setOpaque(false);
		contentPane.add(shipOneProp);
		
		shipTwoProp = new JTextPane();
		shipTwoProp.setEditable(false);
		shipTwoProp.setFont(new Font("EB Garamond SC 08", Font.PLAIN, 18));
		shipTwoProp.setForeground(new Color(51, 0, 0));
		shipTwoProp.setText(crusader.getPropertiesGUI());
		shipTwoProp.setBackground(UIManager.getColor("Button.background"));
		shipTwoProp.setOpaque(false);
		shipTwoProp.setBounds(470, 55, 360, 185);
		contentPane.add(shipTwoProp);
		
		shipFourProp = new JTextPane();
		shipFourProp.setEditable(false);
		shipFourProp.setFont(new Font("EB Garamond SC 08", Font.PLAIN, 18));
		shipFourProp.setForeground(new Color(51, 0, 0));
		shipFourProp.setText(titan.getPropertiesGUI());
		shipFourProp.setBackground(UIManager.getColor("Button.background"));
		shipFourProp.setOpaque(false);
		shipFourProp.setBounds(470, 295, 360, 185);
		contentPane.add(shipFourProp);
		
	}
	
	/**
	 * Create a method which will return the value of
	 * the selected button and store it to be able to
	 * use in further JFrames.
	 */
	
	public static String getSelectedButtonText() {
		ButtonModel model = group.getSelection();
		if (model == null) {
			return "";
		} else {
			shipName = model.getActionCommand();
			return model.getActionCommand();
		}

	}

}

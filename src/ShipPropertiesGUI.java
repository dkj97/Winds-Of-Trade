

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ShipPropertiesGUI extends JFrame {

	private JPanel contentPane;
	private Constructor next = new Constructor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipPropertiesGUI frame = new ShipPropertiesGUI();
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
	public ShipPropertiesGUI() {
		setTitle("Ship Properties");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 415);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a JLabel "Current Ship" which displays the
		 * given words.
		 */
		
		JLabel lblCurrentShip = new JLabel("Current Ship:");
		lblCurrentShip.setForeground(Color.CYAN);
		lblCurrentShip.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblCurrentShip.setBounds(12, 30, 170, 27);
		contentPane.add(lblCurrentShip);
		
		/**
		 * Create a JLabel "Ship" which gets the selected ship 
		 * from the ShipSelectedGUI and displays it.
		 */
		
		JLabel lblShip = new JLabel("New label");
		lblShip.setForeground(Color.ORANGE);
		lblShip.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		lblShip.setBounds(206, 30, 170, 27);
		lblShip.setText(ShipSelectGUI.getSelectedButtonText());
		contentPane.add(lblShip);
		
		/**
		 * Create a JLabel "Properties" which displays the given word.
		 */
		
		JLabel lblProperties = new JLabel("Properties:");
		lblProperties.setForeground(Color.CYAN);
		lblProperties.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblProperties.setBounds(12, 69, 170, 27);
		contentPane.add(lblProperties);
		
		/**
		 * Create a JButton "Back" which takes you back to
		 * the MainGUi JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShipPropertiesGUI.this.setVisible(false);
				
				MainGUI main = new MainGUI(ProfileGUI.daysSelected);
				main.setVisible(true);
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnBack.setBounds(590, 354, 117, 25);
		contentPane.add(btnBack);
		
		/**
		 * Create a JtextPane "props" which will display the
		 * properties of the selected ship.
		 */
		
		JTextPane props = new JTextPane();
		props.setEditable(false);
		for (int i = 0; i < next.shipsConstructor().size(); i++) {
			if (next.shipsConstructor().get(i).getShipName() == ShipSelectGUI.getSelectedButtonText()) {
				props.setText(next.shipsConstructor().get(i).getPropertiesGUI());
			}
		}
		props.setForeground(Color.ORANGE);
		props.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 20));
		props.setBackground(Color.BLACK);
		props.setBounds(22, 108, 486, 240);
		contentPane.add(props);
	}
}

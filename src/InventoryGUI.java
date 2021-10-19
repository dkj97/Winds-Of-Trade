
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class InventoryGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryGUI frame = new InventoryGUI();
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
	public InventoryGUI() {
		setTitle("Inventory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 607);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Create a JButton back which will take the player back to
		 * the MainGUI JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(813, 522, 117, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InventoryGUI.this.setVisible(false);
				
				MainGUI main = new MainGUI(ProfileGUI.daysSelected);
				main.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		contentPane.add(btnBack);
		
		/**
		 * Create a JScrollPane "scrollPane".
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 27, 904, 454);
		contentPane.add(scrollPane);
		
		/**
		 * Create a JTextPane shipStock which will display the stock of the
		 * items in the ship.
		 */
		
		JTextPane shipStock = new JTextPane();
		shipStock.setBackground(Color.BLACK);
		shipStock.setForeground(Color.CYAN);
		shipStock.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 20));
		shipStock.setText(MainGUI.shipname.getShipStockProperties());
		shipStock.setEditable(false);
		scrollPane.setViewportView(shipStock);
	}
}

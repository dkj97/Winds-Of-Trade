
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IslandStoresGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> islandSelect;
	private Constructor next = new Constructor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IslandStoresGUI frame = new IslandStoresGUI();
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
	public IslandStoresGUI() {
		setTitle("Island Stores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 654);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a JLabel selectIsland which displays the given words.
		 */
		
		JLabel lblSelectIsland = new JLabel("Select Island:");
		lblSelectIsland.setForeground(Color.CYAN);
		lblSelectIsland.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 19));
		lblSelectIsland.setBounds(27, 27, 150, 35);
		contentPane.add(lblSelectIsland);
		
		/**
		 * Create a JComboBox islandSelect which will give the options
		 * of the available islands in the drop down menu and make it
		 * a class attribute.
		 */
		
		islandSelect = new JComboBox<String>();
		islandSelect.setBackground(Color.WHITE);
		islandSelect.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		islandSelect.setBounds(195, 31, 150, 24);
		islandSelect.addItem("Kanto");
		islandSelect.addItem("Johto");
		islandSelect.addItem("Hoenn");
		islandSelect.addItem("Sinnoh");
		islandSelect.addItem("Kalos");
		contentPane.add(islandSelect);
		
		/**
		 * Create a JTextPane islandStore which will display the store 
		 * of the island selected in the JComboBox.
		 */
		
		JTextPane islandStore = new JTextPane();
		islandStore.setForeground(Color.CYAN);
		islandStore.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 16));
		islandStore.setBackground(Color.BLACK);
		Store current_store = GameEnvironment.getCurrentstore(next.storeConstructor(), MainGUI.currentPosition.getText());
		for (int  i = 0; i < current_store.getForSaleStock().size(); i++) {
			if ((String) islandSelect.getSelectedItem() == next.storeConstructor().get(i).getLocation()) {
				islandStore.setText(next.storeConstructor().get(i).getProperties());
			}
		}
		
		/**
		 * Create a JButton show which will change the display of
		 * the JTextPane.
		 */
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnShow.setBackground(Color.LIGHT_GRAY);
		btnShow.setBounds(375, 31, 117, 25);
		contentPane.add(btnShow);
		islandStore.setEditable(false);
		islandStore.setBounds(27, 97, 814, 470);
		contentPane.add(islandStore);
		
		/**
		 * Create a JButton back which will take the player back to the
		 * MainGUI JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IslandStoresGUI.this.setVisible(false);
				
				MainGUI main = new MainGUI(ProfileGUI.daysSelected);
				main.setVisible(true);
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnBack.setBounds(745, 593, 117, 25);
		contentPane.add(btnBack);
		
		/**
		 * Create a JLabel store which will display the store properties of the
		 * island displayed in the comboBox.
		 */
		
		JLabel lblStore = new JLabel("Store:");
		lblStore.setForeground(Color.CYAN);
		lblStore.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 19));
		lblStore.setBounds(27, 63, 150, 35);
		contentPane.add(lblStore);
		Store new_store = GameEnvironment.getCurrentstore(next.storeConstructor(), (String) islandSelect.getSelectedItem());
		for (int  i = 0; i < new_store.getForSaleStock().size(); i++) {
			if ((String) islandSelect.getSelectedItem() == next.storeConstructor().get(i).getLocation()) {
				islandStore.setText(next.storeConstructor().get(i).getProperties());
			}
		}
	}
}

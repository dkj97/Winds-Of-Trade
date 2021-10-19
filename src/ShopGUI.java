import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ShopGUI extends JFrame {

	private JPanel contentPane;
	private Constructor next = new Constructor();
	Store current_store = GameEnvironment.getCurrentstore(next.storeConstructor(), MainGUI.currentPosition.getText());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopGUI frame = new ShopGUI();
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
	public ShopGUI() {
		setTitle("Buy Items");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 701);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Create a JButton "back" which will take the player to the
		 * MainGUI JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(815, 624, 117, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShopGUI.this.setVisible(false);
				
				MainGUI main = new MainGUI(ProfileGUI.daysSelected);
				main.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		contentPane.add(btnBack);
		
		/**
		 * Create a JTextPane store which will display the store of the
		 * current island.
		 */
		
		JTextPane store = new JTextPane();
		store.setForeground(Color.CYAN);
		store.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 18));
		store.setBackground(Color.BLACK);
		for (int  i = 0; i < current_store.getForSaleStock().size(); i++) {
			if (MainGUI.currentPosition.getText() == next.storeConstructor().get(i).getLocation()) {
				store.setText(next.storeConstructor().get(i).getProperties());
			}
		}

		store.setEditable(false);
		store.setBounds(44, 25, 888, 451);
		contentPane.add(store);
		
		/**
		 * Create a JButton buy which will display a JOptionPane asking for the
		 * input of the number of the item you want to buy and then ads that to the shipStock
		 * or inventory.
		 */
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.parseInt(JOptionPane.showInputDialog("Which item do you want to buy?")) - 1;
				JOptionPane.showMessageDialog(store, current_store.sellStockGUI(index, MainGUI.shipname), "Bought", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnBuy.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnBuy.setBackground(Color.LIGHT_GRAY);
		btnBuy.setBounds(24, 623, 117, 25);
		contentPane.add(btnBuy);
		
		/**
		 * Create a JButton sell which will display a JOptionPane asking for the 
		 * input of the number of the item you want to sell and then sells the
		 * item for the displayed price.
		 */
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.parseInt(JOptionPane.showInputDialog("Which item do you want to sell?")) - 1;
				JOptionPane.showMessageDialog((Component) contentPane, current_store.buyStock(index, MainGUI.shipname), "Sold", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSell.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnSell.setBackground(Color.LIGHT_GRAY);
		btnSell.setBounds(153, 623, 117, 25);
		contentPane.add(btnSell);
		
		
		
	}
}

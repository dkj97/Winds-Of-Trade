

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class PlayerInfoGUI extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private Constructor next = new Constructor(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerInfoGUI frame = new PlayerInfoGUI(null, 0);
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
	public PlayerInfoGUI(String playerName, int daysSelected) {
		setTitle("Player Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 427);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a JButton "Back" which will take you back
		 * to the MenuGUI JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerInfoGUI.this.setVisible(false);
				
				MenuGUI menu = new MenuGUI();
				menu.setVisible(true);
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnBack.setBounds(449, 353, 117, 25);
		contentPane.add(btnBack);
		
		/**
		 * Create a JLabel "Name" which will display the given word.
		 */
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.CYAN);
		lblName.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(12, 29, 164, 36);
		contentPane.add(lblName);
		
		/**
		 * Create a JLabel traderName which will get the name
		 * of the player given ProfileGUI and display it.
		 */
		
		JLabel traderName = new JLabel("");
		traderName.setForeground(Color.RED);
		traderName.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		traderName.setText(playerName);
		traderName.setBounds(188, 29, 127, 36);
		contentPane.add(traderName);
		
		/**
		 * Create a JLabel tradingDays which will display the given word. 
		 */
		
		JLabel lblTradingDays = new JLabel("Trading Days:");
		lblTradingDays.setForeground(Color.CYAN);
		lblTradingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblTradingDays.setBounds(12, 81, 164, 36);
		contentPane.add(lblTradingDays);
		
		/**
		 * Create a JLabel ElapsedDays which will display the given word. 
		 */
		
		JLabel lblElapsedDays = new JLabel("Elapsed Days:");
		lblElapsedDays.setForeground(Color.CYAN);
		lblElapsedDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblElapsedDays.setBounds(12, 129, 164, 36);
		contentPane.add(lblElapsedDays);
		
		/**
		 * Create a JLabel RemainingDays which will display the given word. 
		 */
		
		JLabel lblRemainingDays = new JLabel("Remaining Days:");
		lblRemainingDays.setForeground(Color.CYAN);
		lblRemainingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblRemainingDays.setBounds(12, 177, 164, 36);
		contentPane.add(lblRemainingDays);
		
		/**
		 * Create a JLabel tradingDays which will get the number of
		 * days selected by the player in ProfileGUI and display it.
		 */
		
		JLabel tradingDays = new JLabel("");
		tradingDays.setText(String.valueOf(daysSelected));
		tradingDays.setForeground(Color.RED);
		tradingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		tradingDays.setBounds(188, 81, 127, 36);
		contentPane.add(tradingDays);
		/**
		 * Create a JLabel elapsedDays which will display the days elapsed.
		 */
		
		JLabel elapsedDays = new JLabel("");
		elapsedDays.setText(String.valueOf(next.playerConstructorGUI().getElapsedDays()));
		elapsedDays.setForeground(Color.RED);
		elapsedDays.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		elapsedDays.setBounds(188, 129, 127, 36);
		contentPane.add(elapsedDays);
		
		/**
		 * Create a JLabel remainingDays which will display the number of days remaining.
		 */
		
		JLabel remainingDays = new JLabel("");
		remainingDays.setText(String.valueOf(next.playerConstructorGUI().getRemainingDays()));
		remainingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		remainingDays.setForeground(Color.RED);
		remainingDays.setBounds(188, 177, 127, 36);
		contentPane.add(remainingDays);
	}
}

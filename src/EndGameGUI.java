import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class EndGameGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGameGUI frame = new EndGameGUI(null, 0);
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
	public EndGameGUI(String playerName, int daysSelected) {
		setTitle("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a JLabel GameOver which will display the given words.
		 */
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 40));
		lblGameOver.setBounds(192, 79, 278, 78);
		contentPane.add(lblGameOver);
		
		/**
		 * Create a JLabel reason which will display the reason why
		 * the game finished.
		 */
		
		JLabel lblReason = new JLabel("");
		lblReason.setForeground(Color.ORANGE);
		lblReason.setBounds(36, 37, 559, 30);
		contentPane.add(lblReason);
		
		/**
		 * Create a JLabel name which will display the given word.
		 */
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.CYAN);
		lblName.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(36, 157, 164, 30);
		contentPane.add(lblName);
		
		/**
		 * Create a JLabel tradingDays which will display the given word. 
		 */
		
		JLabel lblTradingDays = new JLabel("Trading Days:");
		lblTradingDays.setForeground(Color.CYAN);
		lblTradingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblTradingDays.setBounds(36, 199, 164, 30);
		contentPane.add(lblTradingDays);
		
		/**
		 * Create a JLabel RemainingDays which will display the given word. 
		 */
		
		JLabel lblRemainingDays = new JLabel("Remaining Days:");
		lblRemainingDays.setForeground(Color.CYAN);
		lblRemainingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblRemainingDays.setBounds(36, 241, 164, 30);
		contentPane.add(lblRemainingDays);
		
		/**
		 * Create a JLabel profit which will display the given word. 
		 */
		
		JLabel lblProfit = new JLabel("Profit:");
		lblProfit.setForeground(Color.CYAN);
		lblProfit.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblProfit.setBounds(36, 283, 164, 30);
		contentPane.add(lblProfit);
		
		/**
		 * Create a JLabel score which will display the given word.
		 */
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setForeground(Color.CYAN);
		lblScore.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 20));
		lblScore.setBounds(36, 327, 164, 30);
		contentPane.add(lblScore);
		
		/**
		 * Create a JLabel traderName which will get the name
		 * of the player given ProfileGUI and display it.
		 */
		
		JLabel traderName = new JLabel("");
		traderName.setText(playerName);
		traderName.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		traderName.setForeground(Color.RED);
		traderName.setBounds(202, 157, 164, 30);
		contentPane.add(traderName);
		
		/**
		 * Create a JLabel tradingDays which will get the number of
		 * days selected by the player in ProfileGUI and display it.
		 */
		
		JLabel tradingDays = new JLabel("");
		tradingDays.setText(String.valueOf(daysSelected));
		tradingDays.setForeground(Color.RED);
		tradingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		tradingDays.setBounds(202, 199, 164, 30);
		contentPane.add(tradingDays);
		
		/**
		 * Create a JLabel daysRemaining which will display the number of days remaining.
		 */
		
		JLabel daysRemaining = new JLabel("");
		daysRemaining.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		daysRemaining.setForeground(Color.RED);
		daysRemaining.setBounds(202, 241, 164, 30);
		contentPane.add(daysRemaining);
		
		/**
		 * Create a JLabel profitMade which will display the profit made.
		 */
		
		JLabel profitMade = new JLabel("");
		profitMade.setForeground(Color.RED);
		profitMade.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		profitMade.setBounds(202, 283, 164, 30);
		contentPane.add(profitMade);
		
		/**
		 * Create a JLabel finalScore which will display the final score achieved.
		 */
		
		JLabel finalScore = new JLabel("");
		finalScore.setForeground(Color.RED);
		finalScore.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		finalScore.setBounds(202, 327, 164, 30);
		contentPane.add(finalScore);
	}
}

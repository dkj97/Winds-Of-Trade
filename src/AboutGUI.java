import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AboutGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea txtAbout;
	private GameEnvironment game = new GameEnvironment(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutGUI frame = new AboutGUI();
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
	public AboutGUI() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Create a jTextArea "about" which displays the
		 * string from the method getAboutGUI in the 
		 * GameEnvironment class.
		 */
	
		txtAbout = new JTextArea();
		txtAbout.setForeground(Color.CYAN);
		txtAbout.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 20));
		txtAbout.setEditable(false);
		txtAbout.setBounds(12, 71, 554, 186);
		txtAbout.setText(game.getAboutGUI());
		txtAbout.setOpaque(false);
		contentPane.add(txtAbout);
		txtAbout.setColumns(10);
		
		/**
		 * Create a JButton back which will take the player back
		 * to the MenuGUI JFrame.
		 */
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutGUI.this.setVisible(false);
				
				MenuGUI menu = new MenuGUI();
				menu.setVisible(true);
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnBack.setBounds(449, 288, 117, 25);
		contentPane.add(btnBack);
		
		/**
		 * Create a JLabel WindsOfTrade which will display
		 * the given word.
		 */
		
		JLabel lblWindsOfTrade = new JLabel("WINDS OF TRADE");
		lblWindsOfTrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindsOfTrade.setForeground(Color.RED);
		lblWindsOfTrade.setFont(new Font("EB Garamond SC 12", Font.BOLD | Font.ITALIC, 30));
		lblWindsOfTrade.setBounds(73, 12, 440, 47);
		contentPane.add(lblWindsOfTrade);
	}
}
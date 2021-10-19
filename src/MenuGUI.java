

import java.awt.BorderLayout;
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

public class MenuGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProfile = new JButton("Player Info");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuGUI.this.setVisible(false);
				
				PlayerInfoGUI player = new PlayerInfoGUI(ProfileGUI.playerName, ProfileGUI.daysSelected);
				player.setVisible(true);
			}
		});
		btnProfile.setBackground(Color.BLACK);
		btnProfile.setForeground(Color.CYAN);
		btnProfile.setOpaque(false);
		btnProfile.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		btnProfile.setBounds(61, 30, 155, 25);
		contentPane.add(btnProfile);
		
		JLabel label = new JLabel("1.");
		label.setFont(new Font("EB Garamond SC 12", Font.BOLD, 23));
		label.setForeground(Color.CYAN);
		label.setBounds(12, 30, 70, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setForeground(Color.CYAN);
		label_1.setFont(new Font("EB Garamond SC 12", Font.BOLD, 23));
		label_1.setBounds(12, 67, 70, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setForeground(Color.CYAN);
		label_2.setFont(new Font("EB Garamond SC 12", Font.BOLD, 23));
		label_2.setBounds(12, 104, 70, 25);
		contentPane.add(label_2);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuGUI.this.setVisible(false);
				
				AboutGUI about = new AboutGUI();
				about.setVisible(true);
			}
		});
		btnAbout.setOpaque(false);
		btnAbout.setForeground(Color.CYAN);
		btnAbout.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		btnAbout.setBackground(Color.BLACK);
		btnAbout.setBounds(61, 67, 155, 25);
		contentPane.add(btnAbout);
		
		JButton btnExit = new JButton("End Game");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuGUI.this.setVisible(false);
				
				EndGameGUI end = new EndGameGUI(ProfileGUI.playerName, ProfileGUI.daysSelected);
				end.setVisible(true);
			}
		});
		btnExit.setOpaque(false);
		btnExit.setForeground(Color.CYAN);
		btnExit.setFont(new Font("EB Garamond SC 12", Font.BOLD, 20));
		btnExit.setBackground(Color.BLACK);
		btnExit.setBounds(61, 104, 155, 25);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuGUI.this.setVisible(false);
				
				MainGUI main = new MainGUI(ProfileGUI.daysSelected);
				main.setVisible(true);
			}
		});
		btnNewButton.setBounds(323, 226, 125, 25);
		contentPane.add(btnNewButton);
	}
}

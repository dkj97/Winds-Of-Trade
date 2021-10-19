

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private JPanel contentPane;
	static JLabel currentPosition;
	private JTextPane route;
	JComboBox<String> islandSelect;
	JLabel coins;
	JTextPane currentIsland;
	private static Constructor next = new Constructor();
	static Ship shipname = next.shipsConstructor().get(0);
	// Construct list of events
	ArrayList<Events> event_list = next.eventsConstructor();  
	// Construct list of routes
	ArrayList<Route> route_list = next.routesConstructor(event_list); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI(0);
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
	public MainGUI(int daysSelected) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Create a JButton Shop which will take the player to the
		 * JFrame ShopGUI.
		 */
		
		JButton btnShop = new JButton("Shop");
		btnShop.setBackground(Color.LIGHT_GRAY);
		btnShop.setBounds(814, 485, 117, 25);
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
					MainGUI.this.setVisible(false);
					
					ShopGUI buy = new ShopGUI();
					buy.setVisible(true);
				
			}
		});	
		contentPane.setLayout(null);
		btnShop.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnShop);
		
		/**
		 * Create a JButton Inventory which will take the player to the 
		 * JFrame InventoryGUI.
		 */
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBackground(Color.LIGHT_GRAY);
		btnInventory.setBounds(821, 11, 117, 25);
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.this.setVisible(false);
				
				InventoryGUI bag = new InventoryGUI();
				bag.setVisible(true);
			}
		});
		btnInventory.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnInventory);
		
		/**
		 * Create a JButton Inventory which will take the player to the 
		 * JFrame MenuGUI.
		 */
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBackground(Color.LIGHT_GRAY);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.this.setVisible(false);
				
				MenuGUI menu = new MenuGUI();
				menu.setVisible(true);
			}
		});
		btnMenu.setBounds(22, 11, 117, 25);
		btnMenu.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnMenu);
		
		/**
		 * Create a JButton Inventory which will take the player to the 
		 * JFrame IslandStoresGUI.
		 */
		
		JButton btnIslandStores = new JButton("Island Stores\n");
		btnIslandStores.setBackground(Color.LIGHT_GRAY);
		btnIslandStores.setBounds(32, 485, 194, 25);
		btnIslandStores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.this.setVisible(false);
				
				IslandStoresGUI island = new IslandStoresGUI();
				island.setVisible(true);
			}
		});
		btnIslandStores.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnIslandStores);
		
		/**
		 * Create a JButton Inventory which will take the player to the 
		 * JFrame ShipPropertiesGUI.
		 */
		
		JButton btnShipProperties = new JButton("Ship Properties");
		btnShipProperties.setBackground(Color.LIGHT_GRAY);
		btnShipProperties.setBounds(238, 485, 194, 25);
		btnShipProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.this.setVisible(false);
				
				ShipPropertiesGUI ship = new ShipPropertiesGUI();
				ship.setVisible(true);
			}
		});
		btnShipProperties.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnShipProperties);
		
		/**
		 * Create a JTextPane route and make it a class attribute.
		 */
		
		route = new JTextPane();
		route.setEditable(false);
		route.setBackground(Color.BLACK);
		route.setForeground(Color.ORANGE);
		route.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 20));
		route.setBounds(540, 133, 396, 290);
		contentPane.add(route);
		
		/**
		 * Create a JLabel remainingDays which will display given word.
		 */
		
		JLabel lblRemainingDays = new JLabel("Remaining days:");
		lblRemainingDays.setForeground(Color.CYAN);
		lblRemainingDays.setBounds(198, 11, 131, 25);
		lblRemainingDays.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(lblRemainingDays);
		
		/**
		 * Create a JLabel coins which will display the given word.
		 */
		
		JLabel lblCoins = new JLabel("Coins:");
		lblCoins.setForeground(Color.CYAN);
		lblCoins.setBounds(460, 11, 60, 25);
		lblCoins.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(lblCoins);
		
		/**
		 * Create a JLabel CurrentIsland which will display the given word.
		 */
		
		JLabel lblCurrentIsland = new JLabel("Current Island:");
		lblCurrentIsland.setForeground(Color.CYAN);
		lblCurrentIsland.setBounds(22, 84, 204, 37);
		lblCurrentIsland.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		contentPane.add(lblCurrentIsland);
		
		/**
		 * Create a JLabel currentPostion which will display the current
		 * position of the ship and make it a class attribute.
		 */
		
		currentPosition = new JLabel("");
		currentPosition.setForeground(Color.RED);
		currentPosition.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 22));
		if (ShipSelectGUI.getSelectedButtonText() == "SS Voyager") {
			currentPosition.setText("Kanto");
		}
		else if (ShipSelectGUI.getSelectedButtonText() == "SS Crusader") {
			currentPosition.setText("Hoenn");
		}
		else if (ShipSelectGUI.getSelectedButtonText() == "SS Endeavor") {
			currentPosition.setText("Sinnoh");
		}
		else {
			currentPosition.setText("Kalos");
		}
		currentPosition.setBounds(178, 84, 176, 37);
		contentPane.add(currentPosition);
		
		/**
		 * Create a JLabel TravelTo which will display the given word.
		 */
		
		JLabel lblTravelTo = new JLabel("Travel To:");
		lblTravelTo.setForeground(Color.CYAN);
		lblTravelTo.setBounds(530, 84, 117, 37);
		lblTravelTo.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		contentPane.add(lblTravelTo);
		
		/**
		 * Create a JComboBox islandSelect which will give the options of the
		 * islands the player can travel to and displays the routes from current 
		 * island to selected island using the JTextPane route and JButton display.
		 */
		
		islandSelect = new JComboBox<String>();
		islandSelect.setBounds(639, 84, 176, 25);
		islandSelect.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		islandSelect.addItem("Kanto");
		islandSelect.addItem("Johto");
		islandSelect.addItem("Hoenn");
		islandSelect.addItem("Sinnoh");
		islandSelect.addItem("Kalos");
		if ((String) islandSelect.getSelectedItem() == currentPosition.getText()) {
			JOptionPane.showMessageDialog((Component) contentPane, "Choose an Island to travel to.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (islandSelect.getSelectedItem() == "Kanto") {
		    String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
			route.setText(text);
			
		}
		else if (islandSelect.getSelectedItem() == "Johto") {
			String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
			route.setText(text);
		}
		else if (islandSelect.getSelectedItem() == "Hoenn") {
			String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
			route.setText(text);
		}
		else if (islandSelect.getSelectedItem() == "Sinnoh") {
			String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
			route.setText(text);
		}
		else {
			String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
			route.setText(text);
		} 
		contentPane.add(islandSelect);
		
		/**
		 * Create a JButton setSail which will change your currentPostion to the
		 * selected position in the islandSelect combo box.
		 */
		
		JButton btnSetSail = new JButton("Set Sail");
		btnSetSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < next.islandsConstructorGUI().size(); i++) {
					if (islandSelect.getSelectedItem() == next.islandsConstructorGUI().get(i).getIslandName() && 
							currentPosition.getText() != next.islandsConstructorGUI().get(i).getIslandName()) {
						
						try {
							if (route_list.get(i).pirateEvent(i)) {
								JOptionPane.showMessageDialog((Component) contentPane, "You have encountered Pirates.\nTo escape them you will play a game of dice.\n"
										+ "The one who gets a greater number will win.\nGodspeed Sailor!", "Pirate Attack", JOptionPane.INFORMATION_MESSAGE);
								JOptionPane.showMessageDialog((Component) contentPane, Route.playDiceGUI(shipname,
										next.playerConstructorGUI()), "Pirate Attack", JOptionPane.INFORMATION_MESSAGE);
								if (next.playerConstructorGUI().getEndGameID() == true){
									MainGUI.this.dispose();
									
									EndGameGUI end = new EndGameGUI(ProfileGUI.playerName, ProfileGUI.daysSelected);
									end.setVisible(true);
									} 
								else {
									JOptionPane.showMessageDialog((Component) contentPane, route_list.get(i).applyRouteGUI(shipname,
											next.playerConstructorGUI()), "Journey Report", JOptionPane.INFORMATION_MESSAGE);
									
									currentIsland.setText(next.islandsConstructorGUI().get(i).getPropertiesGUI());
									currentPosition.setText((String) islandSelect.getSelectedItem());
									route.setText("");
								}
							} 
							else {
								JOptionPane.showMessageDialog((Component) contentPane, route_list.get(i).applyRouteGUI(shipname,
										next.playerConstructorGUI()), "Journey Report", JOptionPane.INFORMATION_MESSAGE);
								
								currentIsland.setText(next.islandsConstructorGUI().get(i).getPropertiesGUI());
								currentPosition.setText((String) islandSelect.getSelectedItem());
								route.setText("");
								}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				}
			}
		});
		btnSetSail.setBackground(Color.LIGHT_GRAY);
		btnSetSail.setBounds(685, 485, 117, 25);
		btnSetSail.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		contentPane.add(btnSetSail);
		
		/**
		 * Create a JLabel daysRemaining which will display the number of days remaining.
		 */
		
		JLabel lbldaysRemaining = new JLabel("");
		lbldaysRemaining.setForeground(Color.RED);
		lbldaysRemaining.setBounds(328, 11, 85, 25);
		lbldaysRemaining.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		lbldaysRemaining.setText(String.valueOf(daysSelected)); 
		contentPane.add(lbldaysRemaining);
		
		/**
		 * Create a JTextPane currentIsland which will display the properties
		 * of the currentIsland where the ship currently is located. 
		 */
		
		currentIsland = new JTextPane();
		currentIsland.setForeground(Color.ORANGE);
		currentIsland.setBackground(Color.BLACK);
		currentIsland.setEditable(false);
		currentIsland.setFont(new Font("EB Garamond SC 12", Font.PLAIN, 20));
		currentIsland.setBounds(32, 133, 396, 290);
		if (ShipSelectGUI.getSelectedButtonText() == "SS Voyager"){
			currentIsland.setText(next.islandsConstructor().get(0).getPropertiesGUI());
		}
		else if (ShipSelectGUI.getSelectedButtonText() == "SS Crusader"){
			currentIsland.setText(next.islandsConstructor().get(2).getPropertiesGUI());
		}
		else if (ShipSelectGUI.getSelectedButtonText() == "SS Endeavor"){
			currentIsland.setText(next.islandsConstructor().get(3).getPropertiesGUI());
		}
		else {
			currentIsland.setText(next.islandsConstructor().get(4).getPropertiesGUI());
		}
		contentPane.add(currentIsland);
		
		/**
		 * Create a JButton display which will display the routes from currentIsland
		 * to the island selected in the combo box.
		 */
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (islandSelect.getSelectedItem() == "Kanto") {
				    String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
					route.setText(text);
					
				}
				else if (islandSelect.getSelectedItem() == "Johto") {
					String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
					route.setText(text);
				}
				else if (islandSelect.getSelectedItem() == "Hoenn") {
					String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
					route.setText(text);
				}
				else if (islandSelect.getSelectedItem() == "Sinnoh") {
					String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
					route.setText(text);
				}
				else {
					String text = GameEnvironment.getAvailableRouteListGUI(route_list, currentPosition.getText(), (String) islandSelect.getSelectedItem()).get(0).getPropertiesGUI(shipname);
					route.setText(text);
				} 
			}
		});
		btnDisplay.setBackground(Color.LIGHT_GRAY);
		btnDisplay.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		btnDisplay.setBounds(831, 83, 117, 25);
		contentPane.add(btnDisplay);
		
		/**
		 * Create a JButton repair which will repair the ship.
		 */
		
		JButton btnRepair = new JButton("Repair");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog((Component) contentPane, shipname.repairShip(), "Report", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRepair.setFont(new Font("EB Garamond SC 12", Font.BOLD, 16));
		btnRepair.setBackground(Color.LIGHT_GRAY);
		btnRepair.setBounds(556, 484, 117, 25);
		contentPane.add(btnRepair);
		
		/**
		 * Create a JLabel coins which will display the number of coins remaining
		 * and make it a class attribute.
		 */
		
		coins = new JLabel("");
		for (int i = 0; i < next.shipsConstructor().size(); i++){
			if (next.shipsConstructor().get(i).getShipName() == ShipSelectGUI.shipName) {
				coins.setText(String.valueOf(next.shipsConstructor().get(i).getShipCoins()));
			}
		}
		coins.setForeground(Color.RED);
		coins.setFont(new Font("EB Garamond SC 12", Font.BOLD, 18));
		coins.setBounds(526, 11, 121, 25);
		contentPane.add(coins);
		

		
	}
}

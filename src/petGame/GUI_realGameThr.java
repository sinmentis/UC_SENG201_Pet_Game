package petGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.InputStream;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.SystemColor;

public class GUI_realGameThr extends GUI_NewGameAsk_Sec {

	private JPanel contentPane;
	private String top_score;
	private Toys toy_store;
	private Foods food_store;
	public  Players currentPlayer = players[0];
	private Pets currentPet = currentPlayer.pets.get(0);
	private Toys currentToy=null;
	private Foods currentFood = null;
	private int currentDay = 1;
	private String day_disp = "(%d/%d)";
	private ArrayList<JButton> toy_button_list = new ArrayList<JButton>();
	private ArrayList<JButton> food_button_list = new ArrayList<JButton>();
	private ArrayList<Toys> toy_Dis_list = new ArrayList<Toys>();
	private ArrayList<Foods> food_Dis_list = new ArrayList<Foods>();
	private ArrayList<JButton> pet_home_button_list = new ArrayList<JButton>();
	private Random rand = new Random();
	private String titleTT="%s is moving";

	
	
	
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_realGameThr frame = new GUI_realGameThr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.

	public GUI_realGameThr() {
		setBackground(Color.LIGHT_GRAY);
		setTitle(String.format(titleTT, currentPlayer.getName())+" | "+currentPet.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 599);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem help_menu = new JMenuItem("Help");
		help_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Just play it! You will figure that out!"); // error message when no food.
			}
		});
		mnNewMenu.add(help_menu);
		
		JMenuItem rank_menu = new JMenuItem("Rank");
		rank_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="";
				top_score="";
				String template ="";
				try{
					ClassLoader classLoader = this.getClass().getClassLoader();
					// Getting resource(File) from class loader
					java.io.InputStream is= this.getClass().getResourceAsStream("/petGame/Rank.txt"); 
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
					name = bufferedReader.readLine();
					top_score = bufferedReader.readLine();
					template = "Highest score is ["+top_score+"] by user: "+name;
				}
		        catch(FileNotFoundException ex) {
		        	template="Unable to open file 'Rank.txt'";                
		        }
		        catch(IOException ex) {
		        	template="Error reading file 'Rank.txt'";
		        }
				JOptionPane.showMessageDialog(null, template); // error message when no food.
			}
		});
		mnNewMenu.add(rank_menu);
		
		JMenuItem about_menu = new JMenuItem("About");
		about_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Design by Lyu && Xu"); // error message when no food.
			}
		});
		mnNewMenu.add(about_menu);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 0, 731, 540);
		contentPane.add(tabbedPane);
		
		
		JPanel home_panel = new JPanel();
		home_panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Home", null, home_panel, null);
		home_panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 10, -210, 326);
		home_panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("Pet Name:");
		lblNewLabel_5.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(268, 10, 129, 30);
		home_panel.add(lblNewLabel_5);
		
		JLabel petName_home_TXT = new JLabel("New label");
		petName_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		petName_home_TXT.setText(currentPet.getName());
		petName_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		petName_home_TXT.setBounds(396, 14, 214, 21);
		home_panel.add(petName_home_TXT);
		
		JLabel lblNewLabel_6 = new JLabel("Hungry:");
		lblNewLabel_6.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(268, 46, 100, 30);
		home_panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tried:");
		lblNewLabel_7.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(268, 82, 71, 30);
		home_panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Fun:");
		lblNewLabel_8.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(268, 118, 54, 30);
		home_panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Health:");
		lblNewLabel_9.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(518, 46, 90, 30);
		home_panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Toilet:");
		lblNewLabel_10.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(518, 82, 77, 30);
		home_panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Weight: ");
		lblNewLabel_11.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(518, 118, 105, 30);
		home_panel.add(lblNewLabel_11);
		
		JLabel lblDeath = new JLabel("Death:");
		lblDeath.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblDeath.setBounds(369, 167, 83, 30);
		home_panel.add(lblDeath);
		
		JLabel lblNewLabel_12 = new JLabel("Misbehave:");
		lblNewLabel_12.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_12.setBounds(369, 203, 142, 30);
		home_panel.add(lblNewLabel_12);
		
		JLabel score_home_TXT = new JLabel("New label");
		score_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		score_home_TXT.setText("0");
		score_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 40));
		score_home_TXT.setBounds(43, 436, 174, 41);
		home_panel.add(score_home_TXT);
		
		JLabel point_home_TXT = new JLabel("2");
		point_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		point_home_TXT.setBounds(643, 486, 54, 15);
		home_panel.add(point_home_TXT);
		
		JLabel hungry_home_TXT = new JLabel("New label");
		hungry_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		hungry_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		hungry_home_TXT.setText(""+currentPet.getHung());
		hungry_home_TXT.setBounds(369, 53, 87, 21);
		home_panel.add(hungry_home_TXT);
		
		JLabel tried_home_TXT = new JLabel("New label");
		tried_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		tried_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		tried_home_TXT.setText(""+currentPet.getTried());
		tried_home_TXT.setBounds(369, 86, 87, 21);
		home_panel.add(tried_home_TXT);
		
		JLabel fun_home_TXT = new JLabel("New label");
		fun_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		fun_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		fun_home_TXT.setText(""+currentPet.getFun());
		fun_home_TXT.setBounds(369, 122, 87, 21);
		home_panel.add(fun_home_TXT);
		
		JLabel health_home_TXT = new JLabel("New label");
		health_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		health_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		health_home_TXT.setText(""+currentPet.getHeath());
		health_home_TXT.setBounds(610, 50, 87, 21);
		home_panel.add(health_home_TXT);
		
		JLabel toilet_home_TXT = new JLabel("New label");
		toilet_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		toilet_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		toilet_home_TXT.setText(""+currentPet.getToilet());
		toilet_home_TXT.setBounds(610, 86, 87, 21);
		home_panel.add(toilet_home_TXT);
		
		JLabel weight_home_TXT = new JLabel("New label");
		weight_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		weight_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		weight_home_TXT.setText(""+currentPet.getWeight());
		weight_home_TXT.setBounds(610, 122, 87, 21);
		home_panel.add(weight_home_TXT);
		
		JLabel death_home_TXT = new JLabel("New label");
		death_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		death_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		death_home_TXT.setText("false");
		death_home_TXT.setBounds(506, 171, 87, 21);
		home_panel.add(death_home_TXT);
		
		JLabel misB_home_TXT = new JLabel("New label");
		misB_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		misB_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		misB_home_TXT.setText("false");
		misB_home_TXT.setBounds(506, 207, 87, 21);
		home_panel.add(misB_home_TXT);
		
		JLabel lblNewLabel_15 = new JLabel("Sick:");
		lblNewLabel_15.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_15.setBounds(369, 239, 59, 30);
		home_panel.add(lblNewLabel_15);
		
		JLabel sick_home_TXT = new JLabel("New label");
		sick_home_TXT.setHorizontalAlignment(SwingConstants.CENTER);
		sick_home_TXT.setFont(new Font("3ds Light", Font.PLAIN, 20));
		sick_home_TXT.setText("false");
		sick_home_TXT.setBounds(506, 243, 87, 21);
		home_panel.add(sick_home_TXT);
		
		JLabel lblGoToilet = new JLabel("Go toilet:");
		lblGoToilet.setFont(new Font("3ds Light", Font.PLAIN, 20));
		lblGoToilet.setBounds(346, 387, 93, 24);
		home_panel.add(lblGoToilet);
		
		JButton toilet_home_button = new JButton("Go toilet");
		toilet_home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPet.getDeath()==false){
					if(currentPlayer.isStand){
						JOptionPane.showMessageDialog(null, "You have wait until next day!"); // error message when no food.
					}else{
						if(currentPet.getActionPoint()==0){
							JOptionPane.showMessageDialog(null, "You don't have any action point!"); // error message when no food.
						}else{
							currentPet.Toilet();
							currentPet.usePoint();
							currentPlayer.getScore(10);
							
							// misbehave
							int misB_flaggg = rand.nextInt(7);
							if(misB_flaggg == 3){
								currentPet.misBehave();
								int result_mig = JOptionPane.showConfirmDialog(null, "Your pet is misbehaving!Are you gonna kick it?!",null, JOptionPane.YES_NO_OPTION);
								if(result_mig == JOptionPane.YES_OPTION) {
									currentPet.misBkick();
									JOptionPane.showMessageDialog(null, "That's hurt, but works!");
									}else{
										JOptionPane.showMessageDialog(null, "Weak!");
									}
							}
							petName_home_TXT.setText(currentPet.getName());
							hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
							tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
							fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
							health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
							toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
							weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
							death_home_TXT.setText(boolToString(currentPet.getDeath()));
							misB_home_TXT.setText(boolToString(currentPet.getMisB()));
							sick_home_TXT.setText(boolToString(currentPet.getSick()));
							point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
							score_home_TXT.setText(Integer.toString(currentPlayer.score()));		
							JOptionPane.showMessageDialog(null, "Your pet is using toilet!||Action Point -1||Score +10"); // error message when no food.
							}
						}
					}
				}
		});
		toilet_home_button.setBackground(Color.LIGHT_GRAY);
		toilet_home_button.setFont(new Font("3ds Light", Font.PLAIN, 20));
		toilet_home_button.setBounds(451, 382, 120, 34);
		home_panel.add(toilet_home_button);
		
		JLabel lblGoSleep = new JLabel("Go sleep:");
		lblGoSleep.setFont(new Font("3ds Light", Font.PLAIN, 20));
		lblGoSleep.setBounds(346, 422, 94, 24);
		home_panel.add(lblGoSleep);
		
		JButton sleep_home_button = new JButton("Go sleep");
		sleep_home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPet.getDeath()==false){
					if(currentPlayer.isStand){
						JOptionPane.showMessageDialog(null, "You have to wait until next day!"); // error message when no food.
					}else{
						if(currentPet.getActionPoint()==0){
							JOptionPane.showMessageDialog(null, "You don't have any action point!"); // error message when no food.
						}else{
							currentPet.sleep();
							currentPet.usePoint();
							currentPlayer.getScore(10);
							
							// misbehave
							int misB_flagd = rand.nextInt(7);
							if(misB_flagd == 3){
								currentPet.misBehave();
								int result_miss = JOptionPane.showConfirmDialog(null, "Your pet is misbehaving!Are you gonna kick it?!",null, JOptionPane.YES_NO_OPTION);
								if(result_miss == JOptionPane.YES_OPTION) {
									currentPet.misBkick();
									JOptionPane.showMessageDialog(null, "That's hurt, but works!");
									}else{
										JOptionPane.showMessageDialog(null, "Weak!");
									}
							}
							petName_home_TXT.setText(currentPet.getName());
							hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
							tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
							fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
							health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
							toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
							weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
							death_home_TXT.setText(boolToString(currentPet.getDeath()));
							misB_home_TXT.setText(boolToString(currentPet.getMisB()));
							sick_home_TXT.setText(boolToString(currentPet.getSick()));
							point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
							score_home_TXT.setText(Integer.toString(currentPlayer.score()));
							JOptionPane.showMessageDialog(null, "Your pet is sleeping!||Action Point -1||Score +10"); // error message when no food.
						}
					}
				}
			}
		});
		sleep_home_button.setFont(new Font("3ds Light", Font.PLAIN, 20));
		sleep_home_button.setBackground(Color.LIGHT_GRAY);
		sleep_home_button.setBounds(451, 417, 121, 34);
		home_panel.add(sleep_home_button);
		
		JLabel lblNewLabel_18 = new JLabel("Those action will cost you one action point!");
		lblNewLabel_18.setFont(new Font("Aharoni", Font.PLAIN, 20));
		lblNewLabel_18.setBounds(268, 338, 434, 24);
		home_panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("User score:");
		lblNewLabel_19.setFont(new Font("3ds Light", Font.PLAIN, 30));
		lblNewLabel_19.setBounds(10, 379, 169, 36);
		home_panel.add(lblNewLabel_19);		
		
		JButton pet3_home_button = new JButton("No pet");
		pet3_home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer.pets.size()>=3){
					// update current pet and it's data
					currentPet = currentPlayer.pets.get(2);
					petName_home_TXT.setText(currentPet.getName());
					hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
					tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
					fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
					health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
					toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
					weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
					death_home_TXT.setText(boolToString(currentPet.getDeath()));
					misB_home_TXT.setText(boolToString(currentPet.getMisB()));
					sick_home_TXT.setText(boolToString(currentPet.getSick()));
					point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
					score_home_TXT.setText(Integer.toString(currentPlayer.score()));	
					String pet_name_title = " | " + currentPet.getName();
					setTitle(titleTT+pet_name_title);
				}else{
					JOptionPane.showMessageDialog(null, "You don't have that many pets!");
				}
			}
		});
		pet3_home_button.setFont(new Font("3ds Light", Font.PLAIN, 30));
		if(currentPlayer.pets.size()>=3){
			pet3_home_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(2).getImg())));
		}
		pet3_home_button.setBackground(Color.LIGHT_GRAY);
		pet3_home_button.setBounds(10, 234, 195, 102);
		home_panel.add(pet3_home_button);
		
		JButton pet2_home_button = new JButton("No pet");
		pet2_home_button.setFont(new Font("3ds Light", Font.PLAIN, 30));
		if(currentPlayer.pets.size()>=2){
			pet2_home_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(1).getImg())));
		}
		pet2_home_button.setBackground(Color.LIGHT_GRAY);
		pet2_home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPlayer.pets.size()>=2){
					currentPet = currentPlayer.pets.get(1);
					// update current pet and it's data
					petName_home_TXT.setText(currentPet.getName());
					hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
					tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
					fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
					health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
					toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
					weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
					death_home_TXT.setText(boolToString(currentPet.getDeath()));
					misB_home_TXT.setText(boolToString(currentPet.getMisB()));
					sick_home_TXT.setText(boolToString(currentPet.getSick()));
					point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
					score_home_TXT.setText(Integer.toString(currentPlayer.score()));	
					String pet_name_title = " | " + currentPet.getName();
					setTitle(titleTT+pet_name_title);
				}else{
					JOptionPane.showMessageDialog(null, "You have't only one pet!");
				}
			}

		});
		pet2_home_button.setBounds(10, 122, 195, 102);
		home_panel.add(pet2_home_button);
		
		JButton pet1_home_button = new JButton("player");
		pet1_home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPet = currentPlayer.pets.get(0);
				// update current pet and it's data
				petName_home_TXT.setText(currentPet.getName());
				hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
				tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
				fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
				health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
				toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
				weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
				death_home_TXT.setText(boolToString(currentPet.getDeath()));
				misB_home_TXT.setText(boolToString(currentPet.getMisB()));
				sick_home_TXT.setText(boolToString(currentPet.getSick()));
				point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
				score_home_TXT.setText(Integer.toString(currentPlayer.score()));	
				String pet_name_title = " | " + currentPet.getName();
				setTitle(titleTT+pet_name_title);
			}
		});
		pet1_home_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(0).getImg())));
		pet1_home_button.setFont(new Font("3ds Light", Font.PLAIN, 30));
		pet1_home_button.setBackground(Color.LIGHT_GRAY);
		pet1_home_button.setBounds(10, 10, 195, 102);
		home_panel.add(pet1_home_button);
		
		JLabel lblNewLabel_13 = new JLabel("Action point left:");
		lblNewLabel_13.setBounds(506, 486, 118, 15);
		home_panel.add(lblNewLabel_13);
		

		
		
		/*
		 * above is all home page
		 */
		JPanel backpack_panel = new JPanel();
		backpack_panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Backpack", null, backpack_panel, null);
		backpack_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Click the item to check");
		lblNewLabel_1.setFont(new Font("3ds Light", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 706, 41);
		backpack_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Toys:");
		lblNewLabel_2.setFont(new Font("3ds Light", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(10, 115, 80, 36);
		backpack_panel.add(lblNewLabel_2);
		
		JTextPane describe_backpack_Text = new JTextPane();
		describe_backpack_Text.setEditable(false);
		describe_backpack_Text.setBackground(Color.LIGHT_GRAY);
		describe_backpack_Text.setBounds(560, 155, 156, 203);
		backpack_panel.add(describe_backpack_Text);
		
		//toy backpack bottom
		JButton toy1_backpack_button = new JButton("Nothing");
		toy1_backpack_button.setBackground(Color.LIGHT_GRAY);
		toy1_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toy_Dis_list.get(0)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentToy = toy_Dis_list.get(0);
					describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));
				}
			}
		});
		toy1_backpack_button.setBounds(10, 155, 100, 100);
		backpack_panel.add(toy1_backpack_button);
		
		JButton toy2_backpack_button = new JButton("Nothing");
		toy2_backpack_button.setBackground(Color.LIGHT_GRAY);
		toy2_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toy_Dis_list.get(1)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentToy = toy_Dis_list.get(1);
					describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));
				}
			}
		});
		toy2_backpack_button.setBounds(120, 155, 100, 100);
		backpack_panel.add(toy2_backpack_button);
		
		JButton toy3_backpack_button = new JButton("Nothing");
		toy3_backpack_button.setBackground(Color.LIGHT_GRAY);
		toy3_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toy_Dis_list.get(2)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentToy = toy_Dis_list.get(2);
					describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));
				}
			}
		});
		toy3_backpack_button.setBounds(230, 155, 100, 100);
		backpack_panel.add(toy3_backpack_button);
		
		JButton toy4_backpack_button = new JButton("Nothing");
		toy4_backpack_button.setBackground(Color.LIGHT_GRAY);
		toy4_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toy_Dis_list.get(3)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentToy = toy_Dis_list.get(3);
					describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));
				}
			}
		});
		toy4_backpack_button.setBounds(340, 155, 100, 100);
		backpack_panel.add(toy4_backpack_button);
		
		JButton toy5_backpack_button = new JButton("Nothing");
		toy5_backpack_button.setBackground(Color.LIGHT_GRAY);
		toy5_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toy_Dis_list.get(4)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentToy = toy_Dis_list.get(4);
					describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));

				}
			}
		});
		toy5_backpack_button.setBounds(450, 155, 100, 100);
		backpack_panel.add(toy5_backpack_button);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Foods:");
		lblNewLabel_3.setFont(new Font("3ds Light", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 328, 98, 36);
		backpack_panel.add(lblNewLabel_3);
		
		
		//food backpack bottom
		JButton food1_backpack_button = new JButton("Nothing");
		food1_backpack_button.setBackground(Color.LIGHT_GRAY);
		food1_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(food_Dis_list.get(0)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentFood = food_Dis_list.get(0);
					describe_backpack_Text.setText(food_Dis_list.get(0).getDis());
				}
			}
		});
		food1_backpack_button.setBounds(10, 368, 100, 100);
		backpack_panel.add(food1_backpack_button);
		
		JButton food2_backpack_button = new JButton("Nothing");
		food2_backpack_button.setBackground(Color.LIGHT_GRAY);
		food2_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(food_Dis_list.get(1)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentFood = food_Dis_list.get(1);
					describe_backpack_Text.setText(food_Dis_list.get(1).getDis());
				}
			}
		});
		food2_backpack_button.setBounds(120, 368, 100, 100);
		backpack_panel.add(food2_backpack_button);
		
		JButton food3_backpack_button = new JButton("Nothing");
		food3_backpack_button.setBackground(Color.LIGHT_GRAY);
		food3_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(food_Dis_list.get(2)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentFood = food_Dis_list.get(2);
					describe_backpack_Text.setText(food_Dis_list.get(2).getDis());
				}
			}
		});
		food3_backpack_button.setBounds(230, 368, 100, 100);
		backpack_panel.add(food3_backpack_button);
		
		JButton food4_backpack_button = new JButton("Nothing");
		food4_backpack_button.setBackground(Color.LIGHT_GRAY);
		food4_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(food_Dis_list.get(3)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentFood = food_Dis_list.get(3);
					describe_backpack_Text.setText(food_Dis_list.get(3).getDis());
				}
			}
		});
		food4_backpack_button.setBounds(340, 368, 100, 100);
		backpack_panel.add(food4_backpack_button);
		
		JButton food5_backpack_button = new JButton("Nothing");
		food5_backpack_button.setBackground(Color.LIGHT_GRAY);
		food5_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(food_Dis_list.get(4)==null){
					JOptionPane.showMessageDialog(null, "You have nothing here!"); // error message when name repea.
				}else{
					currentFood = food_Dis_list.get(4);
					describe_backpack_Text.setText(food_Dis_list.get(4).getDis());
				}
			}
		});
		food5_backpack_button.setBounds(450, 368, 100, 100);
		backpack_panel.add(food5_backpack_button);
		
		JLabel lblNewLabel_4 = new JLabel("Describe:");
		lblNewLabel_4.setFont(new Font("3ds Light", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(560, 128, 117, 30);
		backpack_panel.add(lblNewLabel_4);
		// set up back pack
		toy_Dis_list = new ArrayList<Toys>();
		food_Dis_list = new ArrayList<Foods>();
		toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
		if(currentPlayer.toys.isEmpty()){}else{

			// set up image and describe.

			for(int i = 0; i < currentPlayer.toys.size();i++){
				toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
				toy_Dis_list.set(i, currentPlayer.toys.get(i));
			}
		}
		
		food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
		food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
		if(currentPlayer.foods.isEmpty()){}else{

			// set up image and describe.
			for(int i = 0; i < currentPlayer.foods.size();i++){
				food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
				food_Dis_list.set(i, currentPlayer.foods.get(i));
			}
		}

		
		JButton play_backpack_button = new JButton("Play");
		play_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPet.getDeath()==false){
					if(currentPlayer.isStand){
						JOptionPane.showMessageDialog(null, "You have to wait until next day!"); // error message when no food.
					}else{
						if(currentToy==null){
							JOptionPane.showMessageDialog(null, "Select toy first!"); // error message when no food.
						}else{
							if(currentPet.getActionPoint()==0){
								JOptionPane.showMessageDialog(null, "You don't have any action point!"); // error message when no food.
							}else{
								currentPet.play(currentToy);
								currentToy.useToy();
								if(currentToy.isBreak){
									currentPlayer.useToy(currentToy);
									currentToy=null;
									JOptionPane.showMessageDialog(null, "Your pet just break your Toy!"); // error message when no food.
								}else{
									JOptionPane.showMessageDialog(null, "Your toy durabaility is "+currentToy.getDur()); // error message when no food.
								}
								currentPet.usePoint();
								currentPlayer.getScore(20);
								
								// misbehave
								int misB_flag = rand.nextInt(7);
								if(misB_flag == 3){
									currentPet.misBehave();
									int result_mi = JOptionPane.showConfirmDialog(null, "Your pet is misbehaving!Are you gonna kick it?!",null, JOptionPane.YES_NO_OPTION);
									if(result_mi == JOptionPane.YES_OPTION) {
										currentPet.misBkick();
										JOptionPane.showMessageDialog(null, "That's hurt, but works!");
										}else{
											JOptionPane.showMessageDialog(null, "Weak!");
										}
								}
								// update home page
								hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
								tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
								fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
								health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
								toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
								weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
								death_home_TXT.setText(boolToString(currentPet.getDeath()));
								misB_home_TXT.setText(boolToString(currentPet.getMisB()));
								sick_home_TXT.setText(boolToString(currentPet.getSick()));
								point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
								score_home_TXT.setText(Integer.toString(currentPlayer.score()));	
								
								// update backpack.
								toy_Dis_list = new ArrayList<Toys>();
								toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
								if(currentPlayer.toys.isEmpty()){}else{

									// set up image and describe.
					
									for(int i = 0; i < currentPlayer.toys.size();i++){
										toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
										toy_Dis_list.set(i, currentPlayer.toys.get(i));
									}
								}
								describe_backpack_Text.setText(String.format(currentToy.getDis(), currentToy.getDur()));
								JOptionPane.showMessageDialog(null, "You pet is playing|| action point-1|| Score+20"); // message when succeed.
								}
							}
					}
				}
			}
		});
		play_backpack_button.setBackground(Color.LIGHT_GRAY);
		play_backpack_button.setBounds(127, 127, 93, 23);
		backpack_panel.add(play_backpack_button);
		
		JButton eat_backpack_button = new JButton("Eat");
		eat_backpack_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPet.getDeath()==false){
					if(currentPlayer.isStand){
						JOptionPane.showMessageDialog(null, "You have to wait until next day!"); // error message when no food.
					}else{
						if(currentFood==null){
							JOptionPane.showMessageDialog(null, "Sclect the food first!"); // error message when no food.
						}else{
							if(currentPet.getActionPoint()==0){
								JOptionPane.showMessageDialog(null, "You don't have any action point!"); // error message when no food.
							}else{
								currentPet.eat(currentFood);
								currentPet.usePoint();
								currentPlayer.useFood(currentFood);
								currentPlayer.getScore(20);
								
								// misbehave
								int misB_flagg = rand.nextInt(7);
								if(misB_flagg == 3){
									currentPet.misBehave();
									int result_mib = JOptionPane.showConfirmDialog(null, "Your pet is misbehaving!Are you gonna kick it?!",null, JOptionPane.YES_NO_OPTION);
									if(result_mib == JOptionPane.YES_OPTION) {
										currentPet.misBkick();
										JOptionPane.showMessageDialog(null, "That's hurt, but works!");
										}else{
											JOptionPane.showMessageDialog(null, "Weak!");
										}
								}
								
								// update home page
								hungry_home_TXT.setText(Integer.toString(currentPet.getHung()));
								tried_home_TXT.setText(Integer.toString(currentPet.getTried()));
								fun_home_TXT.setText(Integer.toString(currentPet.getFun()));
								health_home_TXT.setText(Integer.toString(currentPet.getHeath()));
								toilet_home_TXT.setText(Integer.toString(currentPet.getToilet()));
								weight_home_TXT.setText(Integer.toString(currentPet.getWeight()));
								death_home_TXT.setText(boolToString(currentPet.getDeath()));
								misB_home_TXT.setText(boolToString(currentPet.getMisB()));
								sick_home_TXT.setText(boolToString(currentPet.getSick()));
								point_home_TXT.setText(Integer.toString(currentPet.getActionPoint()));
								score_home_TXT.setText(Integer.toString(currentPlayer.score()));	
								
								//update back pack
								food_Dis_list = new ArrayList<Foods>();
								food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
								food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
								if(currentPlayer.foods.isEmpty()){}else{

									// set up image and describe.
									for(int i = 0; i < currentPlayer.foods.size();i++){
										food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
										food_Dis_list.set(i, currentPlayer.foods.get(i));
									}
								}
								JOptionPane.showMessageDialog(null, "You pet is eating||action point -1||Score +20"); // message when succeed.	
							}
						}
					}
				}
				currentFood=null;
			}
		});
		eat_backpack_button.setBackground(Color.LIGHT_GRAY);
		eat_backpack_button.setBounds(127, 335, 93, 23);
		backpack_panel.add(eat_backpack_button);
		

		
		JPanel store_panel = new JPanel();
		store_panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Store", null, store_panel, null);
		store_panel.setLayout(null);
		
		JLabel money_store = new JLabel("300");
		money_store.setHorizontalAlignment(SwingConstants.CENTER);
		money_store.setBounds(80, 10, 54, 15);
		store_panel.add(money_store);
		
		JLabel lblToy = new JLabel("Toy");
		lblToy.setHorizontalAlignment(SwingConstants.CENTER);
		lblToy.setFont(new Font("3ds Light", Font.PLAIN, 40));
		lblToy.setBounds(120, 10, 320, 41);
		store_panel.add(lblToy);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setToolTipText("nutrition=hungry, tastiness=fun");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("3ds Light", Font.PLAIN, 40));
		lblFood.setBounds(286, 10, 320, 41);
		store_panel.add(lblFood);
		
		JButton toy1_store_button = new JButton("New button");
		toy1_store_button.setBackground(Color.LIGHT_GRAY);
		toy1_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toy_store = new CarrotRob();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy1_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/CarrotRob.png")));
		toy1_store_button.setBounds(10, 61, 100, 100);
		store_panel.add(toy1_store_button);
		
		JButton toy2_store_button = new JButton("New button");
		toy2_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toy_store = new FakeMouse();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy2_store_button.setBackground(Color.LIGHT_GRAY);
		toy2_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/FakeMouse.png")));
		toy2_store_button.setBounds(120, 61, 100, 100);
		store_panel.add(toy2_store_button);
		
		JButton toy3_store_button = new JButton("New button");
		toy3_store_button.setBackground(Color.LIGHT_GRAY);
		toy3_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/FlyingDisk.png")));
		toy3_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toy_store = new FlyingDisk();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy3_store_button.setBounds(230, 61, 100, 100);
		store_panel.add(toy3_store_button);
		
		JButton toy4_store_button = new JButton("New button");
		toy4_store_button.setBackground(Color.LIGHT_GRAY);
		toy4_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toy_store = new ToiletPump();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy4_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/ToiletPump.png")));
		toy4_store_button.setBounds(10, 282, 100, 100);
		store_panel.add(toy4_store_button);
		
		JButton toy5_store_button = new JButton("New button");
		toy5_store_button.setBackground(Color.LIGHT_GRAY);
		toy5_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toy_store = new Underwear();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy5_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Underwear.png")));
		toy5_store_button.setBounds(120, 282, 100, 100);
		store_panel.add(toy5_store_button);
		
		JButton toy6_store_button = new JButton("New button");
		toy6_store_button.setBackground(Color.LIGHT_GRAY);
		toy6_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toy_store = new Boxx();
				buy_toy(toy_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		toy6_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Box.png")));
		toy6_store_button.setBounds(230, 282, 100, 100);
		store_panel.add(toy6_store_button);
		
		JButton food1_store_button = new JButton("New button");
		food1_store_button.setBackground(Color.LIGHT_GRAY);
		food1_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new Bone();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food1_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Bone.png")));
		food1_store_button.setBounds(396, 61, 100, 100);
		store_panel.add(food1_store_button);
		
		JButton food2_store_button = new JButton("New button");
		food2_store_button.setBackground(Color.LIGHT_GRAY);
		food2_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new CatMint();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food2_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Catmint.png")));
		food2_store_button.setBounds(506, 61, 100, 100);
		store_panel.add(food2_store_button);
		
		JButton food3_store_button = new JButton("New button");
		food3_store_button.setBackground(Color.LIGHT_GRAY);
		food3_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new Bamboo();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food3_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Bamboo.png")));

		food3_store_button.setBounds(616, 61, 100, 100);
		store_panel.add(food3_store_button);
		
		JButton food4_store_button = new JButton("New button");
		food4_store_button.setBackground(Color.LIGHT_GRAY);
		food4_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new Mosquito();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food4_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Mosquito.png")));
		food4_store_button.setBounds(396, 282, 100, 100);
		store_panel.add(food4_store_button);
		
		JButton food5_store_button = new JButton("New button");
		food5_store_button.setBackground(Color.LIGHT_GRAY);
		food5_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new Grass();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food5_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Grass.png")));
		food5_store_button.setBounds(506, 282, 100, 100);
		store_panel.add(food5_store_button);
		
		JButton food6_store_button = new JButton("New button");
		food6_store_button.setBackground(Color.LIGHT_GRAY);
		food6_store_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_store = new Peanut();
				buy_food(food_store, currentPlayer);
				money_store.setText(Integer.toString(currentPlayer.money())); // renew the money
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		food6_store_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/Peanut.png")));
		food6_store_button.setBounds(616, 282, 100, 100);
		store_panel.add(food6_store_button);
		
		JTextPane txtpnNameDurabilityAbailty = new JTextPane();
		txtpnNameDurabilityAbailty.setEditable(false);
		txtpnNameDurabilityAbailty.setBackground(Color.LIGHT_GRAY);
		txtpnNameDurabilityAbailty.setText("Name: Rob\r\nDurability: 15\r\nAbailty: 35\r\nPrice: 90");
		txtpnNameDurabilityAbailty.setBounds(10, 172, 100, 100);
		store_panel.add(txtpnNameDurabilityAbailty);
		
		JTextPane txtpnNameDurabilityAbailty_1 = new JTextPane();
		txtpnNameDurabilityAbailty_1.setEditable(false);
		txtpnNameDurabilityAbailty_1.setBackground(Color.LIGHT_GRAY);
		txtpnNameDurabilityAbailty_1.setText("Name: FakeMouse\r\nDurability: 6\r\nAbailty: 15\r\nPrice: 30");
		txtpnNameDurabilityAbailty_1.setBounds(120, 171, 100, 100);
		store_panel.add(txtpnNameDurabilityAbailty_1);
		
		JTextPane txtpnNameDurabilityAbailty_2 = new JTextPane();
		txtpnNameDurabilityAbailty_2.setEditable(false);
		txtpnNameDurabilityAbailty_2.setBackground(Color.LIGHT_GRAY);
		txtpnNameDurabilityAbailty_2.setText("Name:FlyingDisk\r\nDurability: 8\r\nAbailty: 20\r\nPrice: 50");
		txtpnNameDurabilityAbailty_2.setBounds(230, 171, 100, 100);
		store_panel.add(txtpnNameDurabilityAbailty_2);
		
		JTextPane txtpnNameDurabilityAbailty_3 = new JTextPane();
		txtpnNameDurabilityAbailty_3.setEditable(false);
		txtpnNameDurabilityAbailty_3.setBackground(Color.LIGHT_GRAY);
		txtpnNameDurabilityAbailty_3.setText("Name:ToiletPump\r\nDurability: 7\r\nAbailty: 60\r\nPrice: 120");
		txtpnNameDurabilityAbailty_3.setBounds(10, 392, 100, 100);
		store_panel.add(txtpnNameDurabilityAbailty_3);
		
		JTextPane txtpnNamemaleUnderwearDurability = new JTextPane();
		txtpnNamemaleUnderwearDurability.setEditable(false);
		txtpnNamemaleUnderwearDurability.setBackground(Color.LIGHT_GRAY);
		txtpnNamemaleUnderwearDurability.setText("Name:MaleUnderwear\r\nDurability: 3\r\nAbailty: 2\r\nPrice: 5");
		txtpnNamemaleUnderwearDurability.setBounds(120, 392, 100, 100);
		store_panel.add(txtpnNamemaleUnderwearDurability);
		
		JTextPane txtpnNameplasiDurabilityAbailty = new JTextPane();
		txtpnNameplasiDurabilityAbailty.setEditable(false);
		txtpnNameplasiDurabilityAbailty.setBackground(Color.LIGHT_GRAY);
		txtpnNameplasiDurabilityAbailty.setText("Name: Box\r\nDurability: 35\r\nAbailty: 30\r\nPrice: 70");
		txtpnNameplasiDurabilityAbailty.setBounds(230, 392, 100, 100);
		store_panel.add(txtpnNameplasiDurabilityAbailty);
		
		JTextPane txtpnNameBoneNutrition = new JTextPane();
		txtpnNameBoneNutrition.setEditable(false);
		txtpnNameBoneNutrition.setBackground(Color.LIGHT_GRAY);
		txtpnNameBoneNutrition.setText("Name: Bone\r\nNutrition: 15\r\nTastiness: 5\r\nPrice: 15");
		txtpnNameBoneNutrition.setBounds(396, 171, 100, 100);
		store_panel.add(txtpnNameBoneNutrition);
		
		JTextPane txtpnNameCatMint = new JTextPane();
		txtpnNameCatMint.setEditable(false);
		txtpnNameCatMint.setBackground(Color.LIGHT_GRAY);
		txtpnNameCatMint.setText("Name: Cat Mint\r\nNutrition: 5\r\nTastiness: 15\r\nPrice: 15");
		txtpnNameCatMint.setBounds(506, 171, 100, 100);
		store_panel.add(txtpnNameCatMint);
		
		JTextPane txtpnNameBambooNutrition = new JTextPane();
		txtpnNameBambooNutrition.setEditable(false);
		txtpnNameBambooNutrition.setBackground(Color.LIGHT_GRAY);
		txtpnNameBambooNutrition.setText("Name: Bamboo\r\nNutrition: 35\r\nTastiness: 35\r\nPrice: 75");
		txtpnNameBambooNutrition.setBounds(616, 171, 100, 100);
		store_panel.add(txtpnNameBambooNutrition);
		
		JTextPane txtpnNameMosquitoNutrition = new JTextPane();
		txtpnNameMosquitoNutrition.setEditable(false);
		txtpnNameMosquitoNutrition.setBackground(Color.LIGHT_GRAY);
		txtpnNameMosquitoNutrition.setText("Name: Mosquito\r\nNutrition: 3\r\nTastiness: 3\r\nPrice: 5");
		txtpnNameMosquitoNutrition.setBounds(396, 392, 100, 100);
		store_panel.add(txtpnNameMosquitoNutrition);
		
		JTextPane txtpnNameGrassNutrition = new JTextPane();
		txtpnNameGrassNutrition.setEditable(false);
		txtpnNameGrassNutrition.setBackground(Color.LIGHT_GRAY);
		txtpnNameGrassNutrition.setText("Name: Grass\r\nNutrition: 30\r\nTastiness: 15\r\nPrice: 40");
		txtpnNameGrassNutrition.setBounds(506, 392, 100, 100);
		store_panel.add(txtpnNameGrassNutrition);
		
		JTextPane txtpnNamePeanutNutrition = new JTextPane();
		txtpnNamePeanutNutrition.setEditable(false);
		txtpnNamePeanutNutrition.setBackground(Color.LIGHT_GRAY);
		txtpnNamePeanutNutrition.setText("Name: Peanut\r\nNutrition: 1\r\nTastiness: 20\r\nPrice: 1");
		txtpnNamePeanutNutrition.setBounds(616, 392, 100, 100);
		store_panel.add(txtpnNamePeanutNutrition);
		

		
		JLabel lblBalance = new JLabel("Balance: $");
		lblBalance.setBounds(10, 10, 73, 15);
		store_panel.add(lblBalance);
		
		JLabel dayNumber_Label = new JLabel(""+currentDay);
		dayNumber_Label.setFont(new Font("����", Font.PLAIN, 80));
		dayNumber_Label.setBounds(823, 10, 85, 92);
		contentPane.add(dayNumber_Label);
		
		JLabel c_dayLabel = new JLabel("Day:");
		c_dayLabel.setFont(new Font("����", Font.PLAIN, 30));
		c_dayLabel.setBounds(741, 16, 69, 36);
		contentPane.add(c_dayLabel);
		
		JProgressBar days_progressBar =  new JProgressBar();
		days_progressBar.setMinimum(1);
		days_progressBar.setMaximum(totalDays);
		days_progressBar.setBackground(SystemColor.menu);
		days_progressBar.setBounds(741, 112, 143, 14);
		contentPane.add(days_progressBar);
		
		JLabel lblNewLabel = new JLabel("Game progress:");
		lblNewLabel.setBounds(741, 90, 134, 15);
		contentPane.add(lblNewLabel);
		
		JLabel dayProgress_label = new JLabel(String.format(day_disp, currentDay, totalDays));
		dayProgress_label.setBounds(894, 111, 47, 15);
		contentPane.add(dayProgress_label);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Ready for next day");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tglbtnNewToggleButton.isSelected()==true){
					currentPlayer.stand();
					JOptionPane.showMessageDialog(null, "Player is ready!"); // send message.
				}else{
					currentPlayer.cancellStand();
					JOptionPane.showMessageDialog(null, "Player is not ready!"); // send message.

				}				
			}
		});
		tglbtnNewToggleButton.setBackground(SystemColor.menu);
		tglbtnNewToggleButton.setFont(new Font("Andalus", Font.PLAIN, 16));
		tglbtnNewToggleButton.setBounds(751, 474, 183, 29);
		contentPane.add(tglbtnNewToggleButton);
		
		// add button in list for image set later.
		pet_home_button_list.add(pet1_home_button);
		pet_home_button_list.add(pet2_home_button);
		pet_home_button_list.add(pet3_home_button);
		
		JButton playerOne_button = new JButton("player 1");
		playerOne_button.setFont(new Font("Dialog", Font.BOLD, 25));
		playerOne_button.setBackground(SystemColor.menu);
		playerOne_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlayer = players[0];
				currentPet = currentPlayer.pets.get(0);
				// set up image.
				for(int i=0;i<currentPlayer.pets.size();i++){
					pet_home_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(i).getImg())));
				}
				for(int i=3;i>currentPlayer.pets.size();i--){
					pet_home_button_list.get(i-1).setIcon(null);
				}
				// update
				if(currentPlayer.isStand==true){tglbtnNewToggleButton.setSelected(true);}else{tglbtnNewToggleButton.setSelected(false);}
				petName_home_TXT.setText(currentPet.getName());
				hungry_home_TXT.setText(""+currentPet.getHung());
				tried_home_TXT.setText(""+currentPet.getTried());
				fun_home_TXT.setText(""+currentPet.getFun());
				health_home_TXT.setText(""+currentPet.getHeath());
				toilet_home_TXT.setText(""+currentPet.getToilet());
				weight_home_TXT.setText(""+currentPet.getWeight());
				death_home_TXT.setText(""+currentPet.getDeath());
				misB_home_TXT.setText(""+currentPet.getMisB());
				sick_home_TXT.setText(""+currentPet.getSick());
				score_home_TXT.setText(""+currentPlayer.score());
				money_store.setText(""+currentPlayer.money());
				point_home_TXT.setText(""+currentPlayer.getPoint());
				titleTT = String.format("%s is moving!", currentPlayer.getName());
				setTitle(titleTT+" | "+currentPet.getName());
				
				// set up back pack
				toy_Dis_list = new ArrayList<Toys>();
				food_Dis_list = new ArrayList<Foods>();
				toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
				if(currentPlayer.toys.isEmpty()){}else{

					// set up image and describe.
	
					for(int i = 0; i < currentPlayer.toys.size();i++){
						toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
						toy_Dis_list.set(i, currentPlayer.toys.get(i));
					}
				}
				
				food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
				food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
				if(currentPlayer.foods.isEmpty()){}else{

					// set up image and describe.
					for(int i = 0; i < currentPlayer.foods.size();i++){
						food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
						food_Dis_list.set(i, currentPlayer.foods.get(i));
					}
				}
			}
		});
		playerOne_button.setBounds(737, 136, 204, 102);
		contentPane.add(playerOne_button);
		
		JButton playerTwo_button = new JButton("player 2");
		playerTwo_button.setFont(new Font("Dialog", Font.BOLD, 25));
		playerTwo_button.setBackground(SystemColor.menu);
		playerTwo_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(players.length >= 2){
					currentPlayer = players[1];
					currentPet = currentPlayer.pets.get(0);
					// set up image.
					for(int i=0;i<currentPlayer.pets.size();i++){
						pet_home_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(i).getImg())));
					}	
					for(int i=3;i>currentPlayer.pets.size();i--){
						pet_home_button_list.get(i-1).setIcon(null);}
					
					//update
					if(currentPlayer.isStand==true){tglbtnNewToggleButton.setSelected(true);}else{tglbtnNewToggleButton.setSelected(false);}
					petName_home_TXT.setText(currentPet.getName());
					hungry_home_TXT.setText(""+currentPet.getHung());
					tried_home_TXT.setText(""+currentPet.getTried());
					fun_home_TXT.setText(""+currentPet.getFun());
					health_home_TXT.setText(""+currentPet.getHeath());
					toilet_home_TXT.setText(""+currentPet.getToilet());
					weight_home_TXT.setText(""+currentPet.getWeight());
					death_home_TXT.setText(""+currentPet.getDeath());
					misB_home_TXT.setText(""+currentPet.getMisB());
					sick_home_TXT.setText(""+currentPet.getSick());
					score_home_TXT.setText(""+currentPlayer.score());
					money_store.setText(""+currentPlayer.money());
					point_home_TXT.setText(""+currentPlayer.getPoint());
					titleTT = String.format("%s is moving!", currentPlayer.getName());
					setTitle(titleTT+" | "+currentPet.getName());
					
					// set up back pack
					toy_Dis_list = new ArrayList<Toys>();
					food_Dis_list = new ArrayList<Foods>();
					toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
					if(currentPlayer.toys.isEmpty()){}else{

						// set up image and describe.
		
						for(int i = 0; i < currentPlayer.toys.size();i++){
							toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
							toy_Dis_list.set(i, currentPlayer.toys.get(i));
						}
					}
					
					food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
					if(currentPlayer.foods.isEmpty()){}else{

						// set up image and describe.
						for(int i = 0; i < currentPlayer.foods.size();i++){
							food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
							food_Dis_list.set(i, currentPlayer.foods.get(i));
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "You are the only player"); // error message when name repea.
				}
			}
		});
		playerTwo_button.setBounds(737, 248, 204, 102);
		contentPane.add(playerTwo_button);
		
		JButton playerThree_button = new JButton("player 3");
		playerThree_button.setFont(new Font("Dialog", Font.BOLD, 25));
		playerThree_button.setBackground(SystemColor.menu);
		playerThree_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(players.length >= 3){
					currentPlayer = players[2];
					currentPet = currentPlayer.pets.get(0);
					// set up image.
					for(int i=0;i<currentPlayer.pets.size();i++){
						pet_home_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.pets.get(i).getImg())));
					}
					for(int i=3;i>currentPlayer.pets.size();i--){
						pet_home_button_list.get(i-1).setIcon(null);}
					//update
					if(currentPlayer.isStand==true){tglbtnNewToggleButton.setSelected(true);}else{tglbtnNewToggleButton.setSelected(false);}
					petName_home_TXT.setText(currentPet.getName());
					hungry_home_TXT.setText(""+currentPet.getHung());
					tried_home_TXT.setText(""+currentPet.getTried());
					fun_home_TXT.setText(""+currentPet.getFun());
					health_home_TXT.setText(""+currentPet.getHeath());
					toilet_home_TXT.setText(""+currentPet.getToilet());
					weight_home_TXT.setText(""+currentPet.getWeight());
					death_home_TXT.setText(""+currentPet.getDeath());
					misB_home_TXT.setText(""+currentPet.getMisB());
					sick_home_TXT.setText(""+currentPet.getSick());
					score_home_TXT.setText(""+currentPlayer.score());
					money_store.setText(""+currentPlayer.money());
					point_home_TXT.setText(""+currentPlayer.getPoint());
					titleTT = String.format("%s is moving!", currentPlayer.getName());
					setTitle(titleTT+" | "+currentPet.getName());
					
					// set up back pack
					toy_Dis_list = new ArrayList<Toys>();
					food_Dis_list = new ArrayList<Foods>();
					toy_button_list.add(toy1_backpack_button);toy1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy2_backpack_button);toy2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy3_backpack_button);toy3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy4_backpack_button);toy4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_button_list.add(toy5_backpack_button);toy5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);toy_Dis_list.add(null);
					if(currentPlayer.toys.isEmpty()){}else{

						// set up image and describe.
		
						for(int i = 0; i < currentPlayer.toys.size();i++){
							toy_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.toys.get(i).getImg()))); // set up image.
							toy_Dis_list.set(i, currentPlayer.toys.get(i));
						}
					}
					
					food_button_list.add(food1_backpack_button);food1_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food2_backpack_button);food2_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food3_backpack_button);food3_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food4_backpack_button);food4_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_button_list.add(food5_backpack_button);food5_backpack_button.setIcon(new ImageIcon(GUI_realGameThr.class.getResource("/petGame/icons/nothing.png")));
					food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);food_Dis_list.add(null);
					if(currentPlayer.foods.isEmpty()){}else{

						// set up image and describe.
						for(int i = 0; i < currentPlayer.foods.size();i++){
							food_button_list.get(i).setIcon(new ImageIcon(GUI_realGameThr.class.getResource(currentPlayer.foods.get(i).getImg()))); // set up image.
							food_Dis_list.set(i, currentPlayer.foods.get(i));
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "You don't have 3 player!"); // error message when name repea.
				}
			}
		});
		playerThree_button.setBounds(737, 360, 204, 102);
		contentPane.add(playerThree_button);
		
		JButton newDay_button = new JButton("NEXT DAY");
		newDay_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag = 0;
				for(Players player:players){
					if(player.getStand()==true){flag++;}
				}
				if(flag==howMany){
					
					
					if(currentDay < totalDays){
						currentDay++;
						dayProgress_label.setText(String.format(day_disp, currentDay, totalDays));
						days_progressBar.setValue(currentDay);
						dayNumber_Label.setText(""+currentDay);
						
						// update action point| check state
						for(Players player: players){
							player.cancellStand();
							for(Pets pet: player.pets){
								pet.refillPoint(); // refill action point
								pet.nextDay(); // update pet's sate.
								setTitle(String.format("Checking pet %s...", pet.getName()));
								if(pet.getHung()<=0){pet.die();JOptionPane.showMessageDialog(null, "Your pet starved to death!R.I.P");}
								if(pet.getToilet()<=0){pet.die();JOptionPane.showMessageDialog(null, "Your pet died cause he can't find toilet!R.I.P");}
								if(pet.getFun()<=0){pet.die();JOptionPane.showMessageDialog(null, "Your pet died cause he is bored!R.I.P");}
								if(pet.getTried()<=0){pet.die();JOptionPane.showMessageDialog(null, "Your pet died cause he can't get enough rest!R.I.P");}
								
								// save pet
								if(pet.getDeath()){
									if(player.getSave()==1){
										int result_D = JOptionPane.showConfirmDialog(null, "Are you want to save it?(one chance only)",null, JOptionPane.YES_NO_OPTION);
										if(result_D==JOptionPane.YES_OPTION){
											pet.rebirth();
											player.useSave();
											JOptionPane.showMessageDialog(null, "Your pet is live again!");
										}else{
											JOptionPane.showMessageDialog(null, "Waaaaaaaaaat?");
										}
									}
								}else{
									// not died, check health
									if(pet.getHeath()<=0){
										pet.die();JOptionPane.showMessageDialog(null, "Your pet died cause cancer!R.I.P");
										}else if(pet.getHeath()<=25){
											// operation of check.
											pet.sick();
											int result = JOptionPane.showConfirmDialog(null, "Your pet is sick, using $150 can save it",null, JOptionPane.YES_NO_OPTION);
											if(result == JOptionPane.YES_OPTION) {
												if(player.money()>=150){
													pet.cure();
													player.useMoney(150);
													JOptionPane.showMessageDialog(null, "Your pet is cured and cost you $150!");
												}else{
													// not have enough money
													JOptionPane.showMessageDialog(null, "Your don't have $150");
												}
											}else{
												JOptionPane.showMessageDialog(null, "Waaat?");
											}
										}
									
									// misB check
									if(pet.getMisB()){
										int result_m = JOptionPane.showConfirmDialog(null, "Your pet is misbehaving!Are you gonna kick it?!",null, JOptionPane.YES_NO_OPTION);
										if(result_m == JOptionPane.YES_OPTION) {
											pet.misBkick();
											JOptionPane.showMessageDialog(null, "That's hurt, but works!");
											}else{
												JOptionPane.showMessageDialog(null, "Weak!");
											}
										}
									}
							}
						}
						
						
						
						// update data in home page.
						tglbtnNewToggleButton.setSelected(false);
						currentPlayer = players[0];
						currentPet = currentPlayer.pets.get(0);
						setTitle(String.format("player %s is moving | %s", currentPlayer.getName(), currentPet.getName()));
						petName_home_TXT.setText(currentPet.getName());
						hungry_home_TXT.setText(""+currentPet.getHung());
						tried_home_TXT.setText(""+currentPet.getTried());
						fun_home_TXT.setText(""+currentPet.getFun());
						health_home_TXT.setText(""+currentPet.getHeath());
						toilet_home_TXT.setText(""+currentPet.getToilet());
						weight_home_TXT.setText(""+currentPet.getWeight());
						death_home_TXT.setText(""+currentPet.getDeath());
						misB_home_TXT.setText(""+currentPet.getMisB());
						sick_home_TXT.setText(""+currentPet.getSick());
						score_home_TXT.setText(""+currentPlayer.score());
						setTitle(String.format("Player %s is moving | ", currentPlayer.getName())+currentPet.getName());
					}else{
						JOptionPane.showMessageDialog(null, "Now you can check what you got"); // send message.
						
						
						

						JPanel scoreRank = new JPanel();
						scoreRank.setVisible(false);
						tabbedPane.addTab("Score", null, scoreRank, null);
						scoreRank.setLayout(null);
						
						JTextPane textPane = new JTextPane();
						textPane.setFont(new Font("Dialog", Font.PLAIN, 20));
						textPane.setEditable(false);
						textPane.setBounds(171, 91, 354, 281);
						String scoreT = "";
						for(Players player : players){
							scoreT += String.format("\nplayer: %s Score: %s\n", player.getName(), player.score());
						}
						textPane.setText(scoreT);
						scoreRank.add(textPane);
						
						JLabel lblNewLabel_14 = new JLabel("Final Result");
						lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_14.setFont(new Font("Dialog", Font.BOLD, 25));
						lblNewLabel_14.setBounds(171, 46, 354, 33);
						scoreRank.add(lblNewLabel_14);
						
						JButton btnNewButton = new JButton("Save");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								int max_current = currentPlayer.score();
								for(Players player: players){
									if(player.score()>=max_current){
										max_current = player.score();
									}
								}
								if(max_current>Integer.parseInt(top_score)){
									ClassLoader classLoader = this.getClass().getClassLoader();
									// Getting resource(File) from class loader
									File configFile = new File(classLoader.getResource("petGame/Rank.txt").getFile());
									FileWriter fileReader = null;
									try {
										fileReader = new FileWriter(configFile);
									} catch (IOException e) {
										JOptionPane.showMessageDialog(null, "You will be remerbered");
										e.printStackTrace();
									}
									BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
									try {
										bufferedWriter.write(max_current);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}else{
									JOptionPane.showMessageDialog(null, "you need work harder than that.");
								}
								}
						});
						btnNewButton.setFont(new Font("3ds Light", Font.PLAIN, 50));
						btnNewButton.setBounds(231, 382, 236, 119);
						scoreRank.add(btnNewButton);
						//end of the game!
					}
				}else{
					JOptionPane.showMessageDialog(null, "Every one need to be ready!");
				}

			}
		});
		newDay_button.setBackground(SystemColor.menu);
		newDay_button.setFont(new Font("3ds Light", Font.PLAIN, 20));
		newDay_button.setBounds(741, 505, 200, 35);
		contentPane.add(newDay_button);


	}
	
	
	public void buy_toy(Toys toy, Players player){
		if(player.toys.size()>=5){
			JOptionPane.showMessageDialog(null, "You can't have more toy!"); // send message.
		}else{
			if(player.money()>=toy.getPrice()){
				player.useMoney(toy.getPrice());//money change
				player.buyToy(toy);// add one in backpack
				JOptionPane.showMessageDialog(null, "Success!"); // send message.
				}else{
					JOptionPane.showMessageDialog(null, "You don't have enough money!"); // send message.
					}
			}
		}
	
	public void buy_food(Foods food, Players player){
		if(player.foods.size()>=5){
			JOptionPane.showMessageDialog(null, "You can't have more food!"); // send message.
		}else{
			if(player.money()>=food.getPrice()){
				player.useMoney(food.getPrice());//money change
				player.buyFood(food);// add one in backpack
				JOptionPane.showMessageDialog(null, "Success!"); // send message.
				}else{
					JOptionPane.showMessageDialog(null, "You don't have enough money!"); // send message.
					}
			}
		}
	
	public String boolToString(boolean bool){
		String result="";
		if(bool){result = "Yes";}else{result = "No";}
		return result;
	}
}

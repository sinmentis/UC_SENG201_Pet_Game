package petGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class GUI_NewGameAsk_Sec extends GUI_greetingFir {

	private JPanel contentPane;
	private GUI_NewGameAsk_Sec frame = null;
	private JTextField playerNameField;
	public static Players[] players = new Players[howMany];
	public static ArrayList<Pets> petList = new ArrayList<Pets>();
	public static ArrayList<String> NameList = new ArrayList<String>();
	private JTextField PetName;
	private int playerOrder = 0;
	private String template;
	private int petNumber=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NewGameAsk_Sec frame = new GUI_NewGameAsk_Sec();
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
	public GUI_NewGameAsk_Sec() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_NewGameAsk_Sec.class.getResource("/petGame/icons/titleIcon.png")));
		setTitle("You can only choose 3 pets top");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel petNameLabel = new JLabel("Pet name:");
		petNameLabel.setBounds(10, 69, 72, 15);
		contentPane.add(petNameLabel);
		
		JTextArea txtrWelcom = new JTextArea();
		txtrWelcom.setBackground(Color.GRAY);
		txtrWelcom.setText("Choose the pet you like [Check] for more information");
		txtrWelcom.setBounds(10, 124, 403, 35);
		contentPane.add(txtrWelcom);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 198, 127, 64);
		contentPane.add(textArea);
		
		JLabel petsListLabel = new JLabel("Pets you selected");
		petsListLabel.setBounds(10, 171, 127, 15);
		contentPane.add(petsListLabel);
		
		PetName = new JTextField();
		PetName.setBackground(Color.GRAY);
		PetName.setText("Pet name");
		PetName.setBounds(110, 67, 114, 19);
		contentPane.add(PetName);
		PetName.setColumns(10);
		JLabel Label_playerName = new JLabel("Player name:");
		Label_playerName.setBounds(10, 12, 93, 15);
		contentPane.add(Label_playerName);
		
		playerNameField = new JTextField();
		playerNameField.setBackground(Color.GRAY);
		playerNameField.setToolTipText("YOUR  NAME!");
		playerNameField.setText("Player name");
		playerNameField.setBounds(110, 10, 114, 19);
		contentPane.add(playerNameField);
		playerNameField.setColumns(10);
		
		JLabel lblPetsSelect = new JLabel("Pets Select:");
		lblPetsSelect.setBounds(10, 42, 85, 15);
		contentPane.add(lblPetsSelect);
		
		JLabel icons204102 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/petGame/icons/welcome.png"));
		icons204102.setIcon(new ImageIcon(GUI_NewGameAsk_Sec.class.getResource("/petGame/icons/welcome.png")));
		icons204102.setBounds(232, 12, 204, 102);
		contentPane.add(icons204102);
		
		JComboBox PetListComBox = new JComboBox();
		PetListComBox.setBackground(Color.LIGHT_GRAY);
		String[] petNameList = new String[]{"Ant", "Cat", "Dog", "Frog", "Panda", "Poney"};
		PetListComBox.setModel(new DefaultComboBoxModel(petNameList));
		PetListComBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Pets petName = new Pets();
				ImageIcon petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/welcome.png"));

				switch((String) PetListComBox.getSelectedItem()){
				case "Ant": petName = new Ant();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Ant.png"));break;
				case "Cat": petName = new Cat();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Cat.png"));break;
				case "Dog": petName = new Dog();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Dog.png"));break;
				case "Frog": petName = new Frog();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Frog.png"));break;
				case "Panda": petName = new PanDa();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Panda.png"));break;
				case "Poney": petName = new Poney();petImg = new ImageIcon(this.getClass().getResource("/petGame/icons/Poney.png"));break;
				}
				// set up Describe area.
				template = petName.getDesc();
				txtrWelcom.setText(template);
				// set up image icons.
				icons204102.setIcon(petImg);
			}
		});
		PetListComBox.setBounds(110, 37, 114, 24);
		contentPane.add(PetListComBox);
		
		JButton SelectButton = new JButton("Select PET!");
		SelectButton.setBackground(Color.LIGHT_GRAY);
		SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(petNumber == 3){
					JOptionPane.showMessageDialog(null, "You can't have more pet"); // error message when name repea.
				}else{
					if(NameList.contains(PetName.getText())==false){
						//determine the selected pet
						Pets pet = new Pets();
						String nameCheck = (String) PetListComBox.getSelectedItem();
						switch(nameCheck){
						case "Ant": pet = new Ant();break;
						case "Cat": pet = new Cat();break;
						case "Dog": pet = new Dog();break;
						case "Frog": pet = new Frog();break;
						case "Panda": pet = new PanDa();break;
						case "Poney": pet = new Poney();break;
						}
						pet.setName(PetName.getText()); // set up pet's name
						petList.add(pet); // add in the list
						petNumber++; // number + 1 
						NameList.add(PetName.getText()); // add name in petName Array List for later check
						
						// set up show area 
						template = "";
						for(Pets petTemplate:petList){template += petTemplate.getName() + "\n";}
						textArea.setText(template);
						
					}else{
						JOptionPane.showMessageDialog(null, "Already have this name!"); // error message when overnumber.
					}
					}
				}
			});
		SelectButton.setBounds(300, 188, 114, 24);
		contentPane.add(SelectButton);
		

		JButton StartButton = new JButton("Next");
		StartButton.setBackground(Color.LIGHT_GRAY);
		StartButton.setFont(new Font("Dialog", Font.BOLD, 20));
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// identify the name first.
				if(petList.isEmpty()){
					JOptionPane.showMessageDialog(null, "You have't choose pet yet!");
				}else{
					if(NameList.contains(playerNameField.getText())){
						JOptionPane.showMessageDialog(null, "player name already exist!"); // error message when name repea.
					}
					else{
						NameList.add(playerNameField.getText()); // add name into list for later check
						Players player = new Players(300); // Create a new player class
						player.setname(playerNameField.getText()); // set up the name
						player.addPetArray(petList);
						players[playerOrder] = player; // add into player list
						if(playerOrder >= howMany-1){
							// if every one got legal pet, real game on. 
							GUI_realGameThr realGame = new GUI_realGameThr();
							realGame.setVisible(true);
							CloseJframe();
						}else{
							playerOrder ++; // next player
							
							// initialization
							textArea.setText("");
							petList = new ArrayList<Pets>();
							petNumber = 0;
							playerNameField.setText("player name");
							PetName.setText("pet name");
						}
					}
				}
			}
		});
		StartButton.setBounds(275, 222, 161, 40);
		contentPane.add(StartButton);
		
		JLabel lblNewLabel = new JLabel("Describe:");
		lblNewLabel.setBounds(10, 99, 67, 15);
		contentPane.add(lblNewLabel);

	}
}

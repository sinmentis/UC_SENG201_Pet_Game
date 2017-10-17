package petGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class GUI_greetingFir extends JFrame {

	private JPanel contentPane;
	public static int howMany;
	public static int totalDays;
	private JTextField textField;
	
	public void CloseJframe(){
		// close the frame.
        super.dispose();
        }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_greetingFir frame = new GUI_greetingFir();
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
	public GUI_greetingFir() {
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_greetingFir.class.getResource("/petGame/icons/titleIcon.png")));
		setTitle("Hello world!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox playerNum = new JComboBox();
		playerNum.setFont(new Font("3ds Light", Font.PLAIN, 12));
		playerNum.setBackground(Color.LIGHT_GRAY);
		String[] items = new String[] {"1", "2", "3"}; 
		playerNum.setModel(new DefaultComboBoxModel(items));
		playerNum.setSelectedIndex(0);
		playerNum.setBounds(199, 122, 36, 24);
		contentPane.add(playerNum);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setFont(new Font("3ds Light", Font.PLAIN, 12));
		textField.setText("1");
		textField.setBounds(199, 156, 36, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setFont(new Font("3ds Light", Font.PLAIN, 12));
		ExitButton.setBackground(Color.LIGHT_GRAY);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Exit when click.
				System.exit(0);
			}
		});
		ExitButton.setBounds(307, 227, 117, 25);
		contentPane.add(ExitButton);
		
		JLabel UCTitle = new JLabel("University of Canterbury");
		UCTitle.setFont(new Font("3ds Light", Font.BOLD, 20));
		UCTitle.setBounds(10, 10, 281, 24);
		contentPane.add(UCTitle);
		
		JLabel lblSengPetGame = new JLabel("SENG201 Pet Game");
		lblSengPetGame.setFont(new Font("3ds Light", Font.BOLD, 15));
		lblSengPetGame.setBounds(10, 41, 161, 18);
		contentPane.add(lblSengPetGame);
		
		JLabel lblNewLabel = new JLabel("Player number:");
		lblNewLabel.setFont(new Font("3ds Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 120, 153, 24);
		contentPane.add(lblNewLabel);
		
		JLabel ucImage11795 = new JLabel("");
		ucImage11795.setIcon(new ImageIcon(GUI_greetingFir.class.getResource("/petGame/icons/ucLOGO.png")));
		ucImage11795.setBounds(307, 10, 117, 95);
		contentPane.add(ucImage11795);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("3ds Light", Font.PLAIN, 20));
		lblDays.setBounds(116, 152, 55, 24);
		contentPane.add(lblDays);
		
		JButton NewGameButton = new JButton("New Game");
		NewGameButton.setFont(new Font("3ds Light", Font.PLAIN, 12));
		NewGameButton.setBackground(Color.LIGHT_GRAY);
		NewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open GUI_NewGameAsk_Sec
				howMany = Integer.parseInt((String)playerNum.getSelectedItem());
				GUI_NewGameAsk_Sec newGame = new GUI_NewGameAsk_Sec();
				totalDays = Integer.parseInt(textField.getText());
				newGame.setVisible(true);
				CloseJframe();
			}
		});
		NewGameButton.setBounds(307, 192, 117, 25);
		contentPane.add(NewGameButton);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainWindow2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField filename = new JTextField(), dir = new JTextField();

	/**
	 * Launch the application.
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// --------- TITLE -----------//
		JPanel title = new JPanel();
		frame.getContentPane().add(title, BorderLayout.NORTH);
		title.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_4 = new JPanel();
		title.add(panel_4);

		JLabel label = new JLabel("XTS-AES");
		panel_4.add(label);

		JPanel panel_5 = new JPanel();
		title.add(panel_5);

		JLabel label_1 = new JLabel("Cryptography and Information Security");
		panel_5.add(label_1);

		JPanel panel_6 = new JPanel();
		title.add(panel_6);

		JLabel lblMartinNovela = new JLabel("Martin Novela - Wahid Nur Rohman");
		panel_6.add(lblMartinNovela);
		// ------- END TITLE ---------//

		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(4, 3, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JLabel lblSourceFile = new JLabel("Source File");
		lblSourceFile.setHorizontalAlignment(SwingConstants.LEFT);
		panel_8.add(lblSourceFile);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);

		textField_1 = new JTextField();
		panel_10.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);

		JButton btnExplore = new JButton("Explore");
		btnExplore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(panel_9);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					textField_1.setText(selectedFile.getAbsolutePath());

				}
			}
		});
		panel_9.add(btnExplore);

		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);

		JLabel lblKeyFile = new JLabel("Key File");
		panel_11.add(lblKeyFile);

		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);

		textField = new JTextField();
		panel_12.add(textField);
		textField.setColumns(10);

		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);

		JButton btnExplore_1 = new JButton("Explore");
		btnExplore_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(panel_9);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					textField.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		panel_13.add(btnExplore_1);

		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14);

		JLabel lblTweak = new JLabel("Tweak");
		panel_14.add(lblTweak);

		JPanel panel_15 = new JPanel();
		panel_7.add(panel_15);

		textField_2 = new JTextField();
		panel_15.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_16 = new JPanel();
		panel_7.add(panel_16);

		JButton btnExplore_2 = new JButton("Explore");
		btnExplore_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(panel_9);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					textField_2.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		panel_16.add(btnExplore_2);

		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17);

		JLabel label_2 = new JLabel("Operation");
		panel_17.add(label_2);

		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);

		JSpinner spinner_1 = new JSpinner();
		panel_18.add(spinner_1);

		JPanel panel_19 = new JPanel();
		panel_7.add(panel_19);

		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				// Demonstrate "Save" dialog:
				int rVal = c.showSaveDialog(panel_19);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename.setText(c.getSelectedFile().getName());
					dir.setText(c.getCurrentDirectory().toString());
					System.out.println(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
					System.out.println("You pressed cancel");
					dir.setText("");
				}
			}
		});

		panel_19.add(buttonOK);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
	}

}

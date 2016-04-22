import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private HeaderPanel header = new HeaderPanel();
	private XTSPanel xtsPanel = new XTSPanel();

	public MainWindow() {
		super("XTS-AES EncDec");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(700, 420);
		setBackground(Color.blue);
		setVisible(true);
		setBounds(0, 0, 720, 450);
		setResizable(false);
		getContentPane().add(header);
		getContentPane().add(xtsPanel);
		setVisible(true);
	}
}

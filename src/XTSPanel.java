import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.NoSuchPaddingException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class XTSPanel extends JPanel {
	private JTextField sourceTxtFld;
	private JTextField keyTxtFld;
	private JTextField tweakTxtFld;
	private JSpinner modeSpnr;
	private JLabel sourceLbl;
	private JLabel keyLbl;
	private JLabel tweakLbl;
	private JLabel modeLbl;
	private JButton sourceBtn;
	private JButton keyBtn;
	private JButton tweakBtn;
	private JButton execute;
	SpinnerListModel spinnerModel;
	MyJFileChooser keyReader;
	MyJFileChooser srcReader;
	MyJFileChooser tweakReader;
	MyJFileSaver fileSaver;

	public XTSPanel() {
		setLayout(null);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setLocation(10, 100);
		setSize(700, 300);
		init();
	}

	private void init() {
		initTxtField();
		initLabel();
		initButton();
		initSpinner();
		addAll();
	}

	private void initTxtField() {
		int start = 10;
		int level = 50;

		sourceTxtFld = new JTextField();
		setTxtPrpts(sourceTxtFld, start);
		start += level;

		keyTxtFld = new JTextField();
		setTxtPrpts(keyTxtFld, start);
		start += level;

		tweakTxtFld = new JTextField();
		setTxtPrpts(tweakTxtFld, start);
	}

	private void initLabel() {
		int start = 10;
		int level = 50;

		sourceLbl = new JLabel("Source File");
		setLblPrpts(sourceLbl, start);
		start += level;

		keyLbl = new JLabel("Key");
		setLblPrpts(keyLbl, start);
		start += level;

		tweakLbl = new JLabel("Tweak");
		setLblPrpts(tweakLbl, start);
		start += level;

		modeLbl = new JLabel("Operation Mode");
		setLblPrpts(modeLbl, start);
		start += level;
	}

	private void initButton() {
		int start = 10;
		int level = 50;

		sourceBtn = new JButton("Explore");
		setBtnPrpts(sourceBtn, start);
		sourceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srcReader = new MyJFileChooser();
			}
		});
		start += level;

		keyBtn = new JButton("Explore");
		setBtnPrpts(keyBtn, start);
		keyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyReader = new MyJFileChooser();
			}
		});
		start += level;

		tweakBtn = new JButton("Explore");
		tweakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tweakReader = new MyJFileChooser();
			}
		});
		setBtnPrpts(tweakBtn, start);
		
		start += level;

		execute = new JButton("OK");
		setBtnPrpts(execute, start);
		execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mode = modeSpnr.getValue().toString();
				System.out.println(mode);
				fileSaver = new MyJFileSaver();
				
					doXTSAES();
				
			}
		});
		start += level;
	}

	private void initSpinner() {
		modeSpnr = new JSpinner();
		ArrayList<String> mode = new ArrayList<>();
		mode.add("Encript");
		mode.add("Decript");
		spinnerModel = new SpinnerListModel();
		spinnerModel.setList(mode);
		modeSpnr.setModel(spinnerModel);
		modeSpnr.setSize(200, 40);
		modeSpnr.setLocation(400, 160);
		if (modeSpnr.getEditor() instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) modeSpnr.getEditor();
			editor.getTextField().setEnabled(true);
			editor.getTextField().setEditable(false);
		}
	}

	private void addAll() {
		add(sourceLbl);
		add(keyLbl);
		add(tweakLbl);
		add(modeLbl);
		add(sourceTxtFld);
		add(keyTxtFld);
		add(tweakTxtFld);
		add(modeSpnr);
		add(sourceBtn);
		add(keyBtn);
		add(tweakBtn);
		add(execute);
	}

	private void setLblPrpts(JLabel comp, int posY) {
		comp.setHorizontalAlignment(SwingConstants.LEFT);
		comp.setSize(680, 40);
		comp.setHorizontalTextPosition(SwingConstants.LEFT);
		comp.setVerticalTextPosition(SwingConstants.CENTER);
		comp.setLocation(10, posY);
	}

	private void setTxtPrpts(JTextField comp, int posY) {
		comp.setHorizontalAlignment(SwingConstants.LEFT);
		comp.setSize(450, 40);
		comp.setLocation(150, posY);
	}

	private void setBtnPrpts(JButton comp, int posY) {
		// Rectangle r = new Rectangle(80, 40);
		Rectangle r = new Rectangle(630, posY, 60, 30);
		comp.setOpaque(true);
		comp.setBorder(BorderFactory.createLineBorder(Color.black));
		comp.setBounds(r);
		
	}
	
	private void doXTSAES(){
		try {
			Encryptor enc = new Encryptor(srcReader.path, keyReader.path, tweakReader.path, fileSaver.path);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

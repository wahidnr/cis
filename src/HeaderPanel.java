import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class HeaderPanel extends JPanel {
	JLabel title;
	JLabel subject;
	JLabel author;

	public HeaderPanel() {
		init();
		setLayout(new GridLayout(3, 1));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	    setLocation(10,10);
	    setSize(700,80);
		add(title);
		add(subject);
		add(author);
	}

	public void init() {
		title = new JLabel("XTS-AES");
		title.setHorizontalAlignment(SwingConstants.CENTER);
	    title.setSize(680,40);
	    title.setHorizontalTextPosition(SwingConstants.CENTER);
	    title.setVerticalTextPosition(SwingConstants.CENTER);
	    
		subject = new JLabel("Cryptography and Information Security");
		subject.setHorizontalAlignment(SwingConstants.CENTER);
		subject.setSize(680,40);
		subject.setHorizontalTextPosition(SwingConstants.CENTER);
		subject.setVerticalTextPosition(SwingConstants.CENTER);
		
		author = new JLabel("Martin Novela (NPM)- Wahid Nur Rohman (1306381856)");
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setSize(680,40);
		author.setHorizontalTextPosition(SwingConstants.CENTER);
		author.setVerticalTextPosition(SwingConstants.CENTER);
		
	}
}

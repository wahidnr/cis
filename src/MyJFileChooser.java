import java.io.File;

import javax.swing.JFileChooser;

public class MyJFileChooser {
	private JFileChooser fileChooser;
	private File file;
	public String path;

	public MyJFileChooser() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			loadFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
	}

	public void loadFile() {
        file = fileChooser.getSelectedFile();
        path = file.getPath();
	}
}

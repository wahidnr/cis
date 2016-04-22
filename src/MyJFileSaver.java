import java.io.File;

import javax.swing.JFileChooser;

public class MyJFileSaver {
	private JFileChooser fileChooser;
	private File file;
	public String path;

	public MyJFileSaver() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			saveFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
	}

	public void saveFile() {
		file = fileChooser.getSelectedFile();
		path = file.getPath();
	}
}

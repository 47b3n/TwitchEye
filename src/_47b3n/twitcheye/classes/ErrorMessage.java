package _47b3n.twitcheye.classes;

import javax.swing.JOptionPane;

import _47b3n.twitcheye.main.Gui;

public class ErrorMessage {
	
	public ErrorMessage(String errMsg, int errNum, String errOption) {
		String[] options = {errOption};
		String errNumber = "Error " + String.valueOf(errNum);
		JOptionPane.showOptionDialog(Gui.frame, errMsg, errNumber, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
		System.exit(0);
	}
	
}

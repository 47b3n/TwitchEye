package _47b3n.twitcheye.classes;

public class OpenInBrowser {
	
	public OpenInBrowser(String url) {
		try {
			
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

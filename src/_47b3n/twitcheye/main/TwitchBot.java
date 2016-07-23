package _47b3n.twitcheye.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import _47b3n.twitcheye.classes.ReadPropertiesFile;

public class TwitchBot {

	public static Gui bot;
	public static ReadPropertiesFile readPropertiesFile;
	public static String username, oauth, channelname;

	public static void main(String[] args) throws NickAlreadyInUseException, IOException, IrcException {		
		readPropertiesFile = new ReadPropertiesFile();

		username = readPropertiesFile.readProperties("username", "settings/details.properties");
		oauth = readPropertiesFile.readProperties("oauth", "settings/details.properties");
		channelname = readPropertiesFile.readProperties("channel", "settings/details.properties");

		String channel = "#" + channelname.toLowerCase();
		bot = new Gui(username);
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv", 6667, oauth);
		bot.joinChannel(channel);	
		
		if(bot.isConnected() == false) {
			String[] options = {"Ok"};
			JOptionPane.showOptionDialog(Gui.frame, "Can't connect to the chat!\nThis means that you are not connected to the internet or "
					+ "\nyour information in files\\details.properties isn't right!", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
			System.exit(0);
		}
		
		bot.gui();
	}

}
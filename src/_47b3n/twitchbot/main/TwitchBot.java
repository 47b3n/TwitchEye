package _47b3n.twitchbot.main;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import _47b3n.twitcheye.classes.ReadPropertiesFile;

public class TwitchBot {

	public static Gui bot;
	public static ReadPropertiesFile cmd;
	public static String username, oauth, channelname;

	public static void main(String[] args) throws NickAlreadyInUseException, IOException, IrcException {
		cmd = new ReadPropertiesFile();

		username = cmd.readProperties("username", "files/details.properties");
		oauth = cmd.readProperties("oauth", "files/details.properties");
		channelname = cmd.readProperties("channel", "files/details.properties");

		String channel = "#" + channelname.toLowerCase();
		bot = new Gui(username);
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv", 6667, oauth);
		bot.joinChannel(channel);		
		bot.gui();
	}

}

/*
 * username = JOptionPane.showInputDialog(null, "Twitch username:", "Username",
 * JOptionPane.PLAIN_MESSAGE); while(username == null || username.length() <= 0)
 * { JOptionPane.showMessageDialog(null,
 * "You have to put in your Twitch username!", "Error!",
 * JOptionPane.ERROR_MESSAGE); username = JOptionPane.showInputDialog(null,
 * "Twitch username:", "Username", JOptionPane.PLAIN_MESSAGE); }
 */

/*
 * oauth = JOptionPane.showInputDialog(null, "Twitch oAuth:", "oAuth",
 * JOptionPane.PLAIN_MESSAGE); while(oauth == null || oauth.length() <= 0) {
 * JOptionPane.showMessageDialog(null,
 * "You have to put in your Twitch oAuth key!", "Error!",
 * JOptionPane.ERROR_MESSAGE); oauth = JOptionPane.showInputDialog(null,
 * "Twitch oAuth:", "oAuth", JOptionPane.PLAIN_MESSAGE); }
 */

/*
 * channelname = JOptionPane.showInputDialog(null, "Twitch channel name:",
 * "Channel", JOptionPane.PLAIN_MESSAGE); while(channelname == null ||
 * channelname.length() <= 0) { JOptionPane.showMessageDialog(null,
 * "You have to put in your Twitch channelname!", "Error!",
 * JOptionPane.ERROR_MESSAGE); channelname = JOptionPane.showInputDialog(null,
 * "Twitch channel name:", "Channel", JOptionPane.PLAIN_MESSAGE); }
 */
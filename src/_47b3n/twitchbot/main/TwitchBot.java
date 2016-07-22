package _47b3n.twitchbot.main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class TwitchBot{
 
	public static Gui bot;
	public static String username = "47b3n", oauth = "oauth:jrf3vu8raqqxq4wjdapp809595f4ly", channelname = "SCHEITLIJF";
	
	public static void main(String[] args) throws NickAlreadyInUseException, IOException, IrcException {
		username = JOptionPane.showInputDialog(null, "Twitch username:", "Username", JOptionPane.PLAIN_MESSAGE);
		while(username == null || username.length() <= 0) {
			JOptionPane.showMessageDialog(null, "You have to put in your Twitch username!", "Error!", JOptionPane.ERROR_MESSAGE);
			username = JOptionPane.showInputDialog(null, "Twitch username:", "Username", JOptionPane.PLAIN_MESSAGE);
		}

		oauth = JOptionPane.showInputDialog(null, "Twitch oAuth:", "oAuth", JOptionPane.PLAIN_MESSAGE);
		while(oauth == null || oauth.length() <= 0) {
			JOptionPane.showMessageDialog(null, "You have to put in your Twitch oAuth key!", "Error!", JOptionPane.ERROR_MESSAGE);
			oauth = JOptionPane.showInputDialog(null, "Twitch oAuth:", "oAuth", JOptionPane.PLAIN_MESSAGE);
		}
		
		channelname = JOptionPane.showInputDialog(null, "Twitch channel name:", "Channel", JOptionPane.PLAIN_MESSAGE);
		while(channelname == null || channelname.length() <= 0) {
			JOptionPane.showMessageDialog(null, "You have to put in your Twitch channelname!", "Error!", JOptionPane.ERROR_MESSAGE);
			channelname = JOptionPane.showInputDialog(null, "Twitch channel name:", "Channel", JOptionPane.PLAIN_MESSAGE);
		}
		
		String channel = "#" + channelname.toLowerCase();
		bot = new Gui(username);
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv", 6667, oauth);
		bot.joinChannel(channel);
		
		bot.gui();
	}
	
}

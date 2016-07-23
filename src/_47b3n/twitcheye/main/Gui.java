package _47b3n.twitcheye.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jibble.pircbot.PircBot;

import _47b3n.twitcheye.classes.OpenInBrowser;
import _47b3n.twitcheye.classes.ReadPropertiesFile;

public class Gui extends PircBot {
	
	public static ReadPropertiesFile readPropertiesFile;

	public static JFrame frame;
	public static JTextArea chatArea;
	public static JLabel copyrightLabel;
	public static JTextField messageField;
	
	
	public Gui(String username) {
		init();
		this.setName(username);
		this.isConnected();
	}
	
	private void init() {
		readPropertiesFile = new ReadPropertiesFile();	
		
		frame = new JFrame("TwitchEye");
		chatArea = new JTextArea();
		copyrightLabel = new JLabel("Copyright (c) 2016 - Ruben de Groot   ", SwingConstants.RIGHT);
		messageField = new JTextField("Type here your message to the chat or type /help to learn more about this application.");
	}
	
	private void setIconImage(String imgPath) {
		BufferedImage image = null;

	    try {
	        image = ImageIO.read(getClass().getResource(imgPath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		frame.setIconImage(image);	
	}
	
	public void gui() {		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
				
		setIconImage("/images/icon.png");
		
		chatArea.setEditable(false);
		JScrollPane chatAreaPane = new JScrollPane(chatArea);	
		chatAreaPane.setBorder(BorderFactory.createTitledBorder("Chat"));
		chatAreaPane.setViewportView(chatArea);
		
		copyrightLabel.setFont(new Font("Arial", Font.ITALIC, 11));
		
		messageField.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	String msg = messageField.getText();
	    	
	  		if (msg.equalsIgnoreCase("/help")) {
				new OpenInBrowser("https://github.com/47b3n/TwitchEye/wiki");
	  		} 
	  		if (!msg.equalsIgnoreCase("/help")) {
	  			messageSend(msg);
	  		}
	      }
	    });
		
		frame.getContentPane().add(chatAreaPane);		
		frame.getContentPane().add(copyrightLabel, BorderLayout.NORTH);
		frame.getContentPane().add(messageField, BorderLayout.SOUTH);
		
		frame.setVisible(true);
				
		new Gui(TwitchBot.username);
	}
	
	@Override
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		chatArea.append("["+sender+"] " + message + "\n");
		
		if(message.toLowerCase().indexOf('!') >= 0) {
			String[] parts = message.split("!");
			String msg = parts[1];
			if (getFileExist("settings/command.properties") == false) {
				whenMessage("The command.properties file doesn't exist");
			}
			if(readPropertiesFile.readProperties(msg.toLowerCase(), "settings/commands.properties") == null) {
				sendMessage(channel, message + " is not an available command!");
			}
			if(readPropertiesFile.readProperties(msg.toLowerCase(), "settings/commands.properties") != null) {
				sendMessage(channel, readPropertiesFile.readProperties(msg, "files/commands.properties"));
				whenMessage(readPropertiesFile.readProperties(msg, "settings/commands.properties"), TwitchBot.username);
			}
			return;
		}
		
	}
	
	@Override
	public void onConnect() {
		whenMessage("Succesfully connected to chat server!");
	}
	
	public void messageSend(String message) {
		sendMessage("#"+TwitchBot.channelname.toLowerCase(), message);
		whenMessage(message, getName());
	}

	public static void whenMessage(String message, String sender) {
		chatArea.append("["+sender+"] " + message + "\n");
	}
	
	public static void whenMessage(String message) {
		chatArea.append("[Log] " + message + "\n");
	}
	
	public static boolean getFileExist(String filePathString) {
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory()) { 
			return true;
		}
		return false;
	}
}

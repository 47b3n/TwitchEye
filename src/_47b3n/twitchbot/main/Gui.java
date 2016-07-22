package _47b3n.twitchbot.main;

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

public class Gui extends PircBot {

	public static JTextArea chatArea;
	public static JLabel messageLabel;
	public static JTextField messageField;
	
	public static Commands cmd;
	
	public Gui(String username) {	
		this.setName(username);
		this.isConnected();
		cmd = new Commands();
	}
	
	public void messageSend(String message) {
		sendMessage("#"+TwitchBot.channelname.toLowerCase(), message);
		whenMessage(message, getName());
	}
	
	public void gui() {		
		JFrame frame = new JFrame("TwitchBot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		System.out.println(getClass().getClassLoader());
		
		BufferedImage image = null;

	    try {
	        image = ImageIO.read(new File ("files/icon.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		frame.setIconImage(image);	
		
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		JScrollPane chatAreaPane = new JScrollPane(chatArea);	
		chatAreaPane.setBorder(BorderFactory.createTitledBorder("Chat"));
		chatAreaPane.setViewportView(chatArea);
		
		messageLabel = new JLabel("Copyright (c) 2016 - Ruben de Groot   ", SwingConstants.RIGHT);
		messageLabel.setFont(new Font("Arial", Font.ITALIC, 11));
		
		messageField = new JTextField("Type here your message to the chat or type /help to learn more about this application.");
		messageField.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	String msg;
	    	
	  		msg = messageField.getText();
	  		if (msg.equalsIgnoreCase("/help")) {
				openInBrowser(this.getClass().getClassLoader().getResource("files/site/index.html").toString());
	  		} 
	  		if (!msg.equalsIgnoreCase("/help")) {
	  			messageSend(msg);
	  		}
	      }
	    });
		
		frame.getContentPane().add(chatAreaPane);		
		frame.getContentPane().add(messageLabel, BorderLayout.NORTH);
		frame.getContentPane().add(messageField, BorderLayout.SOUTH);
		
		frame.setVisible(true);
				
		new Gui(TwitchBot.username);
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		chatArea.append("["+sender+"] " + message + "\n");
		
		if(message.toLowerCase().indexOf('!') >= 0) {
			String[] parts = message.split("!");
			String msg = parts[1]; // 034556
			if(cmd.readProperties(msg.toLowerCase(), "files/commands.properties") == null) {
				sendMessage(channel, message + " is not an available command!");
			}
			if(cmd.readProperties(msg.toLowerCase(), "files/commands.properties") != null) {
				sendMessage(channel, cmd.readProperties(msg, "files/commands.properties"));
				whenMessage(cmd.readProperties(msg, "files/commands.properties"), TwitchBot.username);
			}
		}
		
	}

	public static void whenMessage(String message, String sender) {
		chatArea.append("["+sender+"] " + message + "\n");
	}
	
	public static void openInBrowser(String url)
	{
		try {
			
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

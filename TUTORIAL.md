# How it works
So the application works like this:
1. You login with a Twitch account. 
2. You can send messages to a certain Twitch-channel-chat with this Twitch account. 
3. If a user in this Twitch-channel-chat enters a command which is listed as a command in your
command.properties file, your Twitch-account will respond to the Twitch-channel-chat
with the response of this command.

Explanation per step
1. To login to your Twitch account search for the details.properties file in 
	the folder settings. After username= you type the username of the Twitch account
	you want to use. After oauth= you type the oAuth key of the Twitch account you want to use.
	To get this oAuth key make sure you are logged in on the Twitch account you want to use
	on Twitch. Then you got to [this link](http://http://twitchapps.com/tmi/) and click
	on 'Connect with Twitch' button. Then follow the steps and copy everything what
	this photo says including the 'oauth:' part
	![Photo1](https://github.com/47b3n/TwitchEye/blob/master/tutorial/twitchbot-oauthkey.png)

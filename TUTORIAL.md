# How it works
So the application works like this:

1. You login with a Twitch account. 
2. You can send messages to a certain Twitch-channel-chat with this Twitch account. 
3. If a user in this Twitch-channel-chat enters a command which is listed as a command in your
command.properties file, your Twitch-account will respond to the Twitch-channel-chat
with the response of this command.

Explanation per step:

1. To login to your Twitch account search for the details.properties file in 
the folder settings. And open this file in your favorite text-editor. 
After username= you type the username of the Twitch account you want to use. 
After oauth= you type the oAuth key of the Twitch account you want to use. 
To get this oAuth key make sure you are logged in on the Twitch account you want to useon Twitch. 
Then you got to [this link](http://http://twitchapps.com/tmi/) and click
on 'Connect with Twitch' button. Then follow the steps and copy everything what
this photo says including the 'oauth:' part.
![Photo1](https://github.com/47b3n/TwitchEye/blob/master/tutorial/twitchbot-oauthkey.png)

So after oauth= you paste that in.
After channel= you type the channel you are streaming to. Now your done logging in!
2. To type a message to the chat start the program and go to the bar where it says
'Type here your message to the chat or type /help to learn more about this application.'
Delete the text which is in this bar and type the message you want to type to your chat.
When you typed your message press enter, then the message gets sent to the chat.
3. 

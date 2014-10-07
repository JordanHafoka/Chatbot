package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView appView;
	private Chatbot notSoCleverBot;
	/**
	 * Allows other objects to access notSoCleverBot.
	 * @return the Chatbot for this app.
	 */
	public Chatbot getNotSoCleverBot()
	{
		return notSoCleverBot;
	}	
	private String startMessage;
	/**
	 * Creates a ChatbotAppController and initialize the associated View and Model objects.
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		notSoCleverBot = new Chatbot("Mr.Not So Clever ");
		startMessage = "Welcome to the " + notSoCleverBot.getName() +" Chatbot, type in your name";
	}
	/**
	 * Starts the Chatbot Application
	 */
	public void start()
	{
		String message = JOptionPane.appView.displayChatbotConversations(startMessage);
		
		
		while(!notSoCleverBot.quitchecker(message))
		{
			message = notSoCleverBot.processText(message);
			message = appView.displayChatbotConversation(message);
		}
	}
	/**
	 * Commands the Chatbot Application to Close
	 */
	private void quit()
	{
		appView.displayInformation("goodbye cruel user! :( ");
		System.exit(0);
	}
}

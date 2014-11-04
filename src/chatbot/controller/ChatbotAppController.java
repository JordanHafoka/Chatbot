package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

/**
 * Application Controller for the Chatbot String
 * 
 * @author jhaf4009
 *
 */
public class ChatbotAppController
{
	/**
	 * the GUI view for the application
	 */
	private ChatbotView appView;
	/**
	 * The Chatbot Model Instance
	 */
	private Chatbot notSoCleverBot;
	/**
	 * the starting message for the Chatbot
	 */
	private String startMessage;

	/**
	 * the ending message for the Chatbot.
	 */
	private String endMessage;
	/**
	 * GUI frame for the application
	 */
	private ChatbotFrame baseFrame;
	
	/**
	 * Creates a ChatbotAppController and initializes the associated View and Model objects.
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);
		notSoCleverBot = new Chatbot("Mr.Not So Clever ");
		startMessage = "Welcome to the " + notSoCleverBot.getName() + " Chatbot, type in your name.";
	}

	/**
	 * Allows other objects to access notSoCleverBot.
	 * 
	 * @return the Chatbot for this app.
	 */
	public Chatbot getNotSoCleverBot()
	{
		return notSoCleverBot;
	}

	/**
	 * Starts the Chatbot Application
	 */
	public void start()
	{
		String message = appView.displayChatbotConversation(startMessage);
		
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
	}
	public String sendTextToChatBot(String userInput)
	{
		String respondText = "";
		respondText = notSoCleverBot.processText(userInput);
		return respondText;
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

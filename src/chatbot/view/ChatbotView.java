package chatbot.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;

public class ChatbotView
{
	private ChatbotAppController baseController;
	private ArrayList<String> memeList;
	
	public ChatbotView(ChatbotAppController baseController)
	
	
	{
		this.baseController = baseController;
		
	}
	/**
	 * Displays the supplied String parameter to the user via pop-up and returns the users response to the controller
	 * @param input the supplied text to be displayed
	 *
	 * @return the user's input
	 */
	public String displayChatbotConversation(String input)
	{
		String output = "";
		output = JOptionPane.showInputDialog(null, baseController.getNotSoCleverBot().getName() + " " + input);
		
		return output;
		

	}
	/**
	 * Displays the supplied input via a pop-up window
	 * @param input the text to be displayed
	 */
	public void displayInformation(String input)
	{
		JOptionPane.showMessageDialog(null,  input);
	}
}

package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotAppController;

public class ChatbotFrame extends JFrame
{
	
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatbotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
}

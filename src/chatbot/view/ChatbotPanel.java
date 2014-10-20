package chatbot.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{	
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;
	
	private SpringLayout baseLayout;
	
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("click on me please :D");
		sampleField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setLayout(baseLayout);
		
		this.add(sampleButton);
		this.add(sampleField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 13, SpringLayout.SOUTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 126, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 85, SpringLayout.WEST, this);
		
		
	}
	private void setupListeners()
	{
		
	}
}

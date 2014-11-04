package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{	
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton clearButton;
	
	private SpringLayout baseLayout;
	
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("Send The Message :D");
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25); 
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -34, SpringLayout.EAST, this);
		chatPane = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);

		clearButton = new JButton("Clear The Message :D");
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -25, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, -217, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 0, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 33, SpringLayout.EAST, clearButton);
		

		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		setupClearButton();
	}
	
	private void setupClearButton()
	{
		clearButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText(null);
				
			}
			
		});
		
	}

	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setLayout(baseLayout);
		
		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatArea);
		this.add(chatPane);
		this.add(clearButton);

		
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 290, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -170, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -51, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 81, SpringLayout.NORTH, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 221, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 102, SpringLayout.NORTH, this);
		
	}
	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextFromUser(userTypedText);
				displayTextToUser(chatbotResponse);
				
				//chatArea.setText(chatArea.getText() +  "\n User: " + sampleField.getText());
				sampleField.setText(null);
				
				
				
			}
		});
		
	}

	public void displayTextFromUser(String input)
	{
		chatArea.append("\n" + "User: "+ input);
	}
	
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + "Chatbot: " + input);
		
	}
}
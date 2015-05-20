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
	private JButton saveButton;
	private JButton loadButton;
	
	
	/**
	 * The constructor for the ChatbotPanel Class.
	 * @param baseController The App Controller for the Chatbot
	 */
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("Send The Message :D");
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25); 
		baseLayout = new SpringLayout();
		chatPane = new JScrollPane(chatArea);
		saveButton = new JButton("Save the chat contents.");
		loadButton = new JButton("Load the saved chat contents");
		
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 77, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 246, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 0, SpringLayout.EAST, sampleField);
		
		clearButton = new JButton("Clear The Message :D");
		

		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Setup for the ChatArea in the GUI.
	 */
	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
	}
	/**
	 * Setup for the Panel in the GUI.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setLayout(baseLayout);
		
		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatPane);
		this.add(clearButton);

		
		
	}
	/**
	 * All code for restraints in the GUI.
	 */
	private void setupLayout()

	{
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 290, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -170, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -51, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 81, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -34, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -25, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, -217, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 0, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 33, SpringLayout.EAST, clearButton);

	}
	/**
	 * All the Listeners used in the GUI.
	 */
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
				sampleField.setText(null);
				
				
				
			}
		});
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText(null);
				
			}
			
		});
		saveButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				String chat = chatArea.getText();
				baseController.saveText(chat, false);
				
			}
			
		});
		
	}
	/**
	 * Takes user input and displays it in ChatArea.	
	 * @param input the User's input.
	 */
	public void displayTextFromUser(String input)
	{
		chatArea.append("\n" + "User: "+ input);
	}
	/**
	 * Takes the User's input and displays a response from the chatbot.
	 * @param input The User's Input
	 */
	public void displayTextToUser(String chatbotResponse)
	{
		chatArea.append("\n" + "Chatbot: " + chatbotResponse);
		
	}
}
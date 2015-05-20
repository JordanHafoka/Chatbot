package chatbot.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
		notSoCleverBot = new Chatbot("Mr.Not So Clever");
		startMessage = "Welcome to the " + notSoCleverBot.getName() + ", type in your name.";
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
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
	}
	
	public void saveText(String conversation, boolean appendToEnd)
	{
		String fileName = "/Users/jhaf4009/Documents/saved text.txt";
		
		PrintWriter outputWriter;
		
		if(appendToEnd)
		{
			try
			{
				outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, appendToEnd)));
				outputWriter.append(conversation);
				outputWriter.close();
			}
			catch(FileNotFoundException noExistingFile)
			{
				JOptionPane.showMessageDialog(baseFrame, "There is no file there :(");
				JOptionPane.showMessageDialog(baseFrame, noExistingFile.getMessage());
			}
			catch(IOException inputOutputError)
			{
				JOptionPane.showMessageDialog(baseFrame, "There is no file there :(");
				JOptionPane.showMessageDialog(baseFrame, inputOutputError.getMessage());
			}
		}
		else
		{
			try
			{
				outputWriter = new PrintWriter(fileName);
				outputWriter.println(conversation);
				outputWriter.close();
			}
			catch(FileNotFoundException noFileThere)
			{
				JOptionPane.showMessageDialog(baseFrame, "There is no file there :(");
			}
		}
		
	}
	
	/**
	 * Takes a User's Input and sends it to Chatbot to get a response.
	 * @param userInput	The User's Input.
	 * @return Returns the User's Text.
	 */
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
	public String readTextFromFile()
	{
		String fileText = "";
		String filePath = "/Users/jhaf4009/Documents/";
		String fileName = filePath + "saved text.txt";
		File inputFile = new File(fileName);
		
		try
		{
			Scanner fileScanner = new Scanner(inputFile);
			while(fileScanner.hasNext())
			{
				fileText += fileScanner.next() + "\n";
			}
			fileScanner.close();
		}
		catch(FileNotFoundException fileException)
		{
			JOptionPane.showMessageDialog(baseFrame,  "The file is not here :(");
		}
		return fileText;
	}
}

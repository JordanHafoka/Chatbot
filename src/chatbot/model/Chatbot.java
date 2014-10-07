package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private String contentArea;
	private int numberOfChats;
	private ArrayList<String> memeList;
	/**
	 *  Creates a Chatbot Object with a specified name. Initializes the total chats to 0
	 * @param name
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		
		memeList = new ArrayList<String>();
		fillTheMemeList();
		//this. means talk to the current class.
	}
	
	public String getName()
	{
		return name;
	}
	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	public void setName(String name)
	{
		this.name = name;
		
	}
	
	public void incrementChats()
	{
		numberOfChats++;
	}
	
	private void fillTheMemeList()
	{
		String processedText = "";
		incrementChats();
	
		
	}
	public String processText(String userText)
	{
		String processedText = "";
		
		if(memeChecker(userText))
		{
			processedText = "hey, you found a meme: " + userText;
			processedText = " isn't that cool.";
		}
		else
		{
			processedText = "Boring, that wasn't a meme.";
			
		}
		return processedText;
	}
	
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;
		
		for(String currentMeme : memeList)
		{
			if(currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
			
		}
		
		for(int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if(memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}
		
		
		return isAMeme;
	}
	/**
	 * Checks for the input "goodbye" to close the app
	 * @param input The supplied String value
	 * @return Whether or not its OK to quit
	 */
	public boolean quitchecker(String input)
	{
		boolean okToQuit = false;
		if (input != null && input.equals("goodbye"))
		{
			okToQuit = true;
		}
		return okToQuit;
	}
	
}


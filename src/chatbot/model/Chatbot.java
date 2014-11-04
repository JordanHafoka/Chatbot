package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private String contentArea;
	private int numberOfChats;
	private ArrayList<String> memeList;

	/**
	 * Creates a Chatbot Object with a specified name. Initializes the total
	 * chats to 0
	 * 
	 * @param name
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;

		memeList = new ArrayList<String>();
		fillTheMemeList();
		// this. means talk to the current class.
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

	/**
	 * Increments the chat count for the Chatbot. Used for tracking the activity
	 * of the Chatbot.
	 */
	public void incrementChats()
	{
		numberOfChats++;
	}

	/**
	 * Fills the contents of the memeList with Internet Memes.
	 */
	private void fillTheMemeList()
	{
		String processedText = "";
		incrementChats();

	}

	/**
	 * Processed the supplied text from the user to provide a message from the
	 * Chatbot.
	 * 
	 * @param userText
	 *            uses the users text as a parameter
	 * @return return the processedText
	 */
	public String processText(String userText)
	{
		String processedText = "";
		incrementChats();

		int randomChoice = (int) (Math.random() * 4);

		if (userText != null)
		{
			if (numberOfChats < 10)
			{
				if (stringLengthChecker(userText))
				{
					processedText = "that is wayyyyyyyyyyyyyy too long to read :D";
				} else
				{
					processedText = "short messages are short on meaning :P";
				}
			} 
			else if (randomChoice == 1)

			{
				if (contentChecker(userText))
				{
					processedText = "you know that secret involves: " + userText;
				} else
				{
					processedText = "";
				}
			}
			else if(null != null)
			{
				if (memeChecker(userText))
				{
					processedText = "hey, you found a meme: " + userText;
					processedText = " isn't that cool.";
				} else
				{
					processedText = "Boring, that wasn't a meme.";

				}
				

			}
		}
		return processedText;

	}

	private boolean contentChecker(String input)
	{
		boolean isSpicy = false;
		boolean isMedium = false;
		boolean isMild = false;
		if (input.equalsIgnoreCase("spicy"));
		{
			isSpicy = true;
		}
		if(input.equalsIgnoreCase("medium"))
		{
			isMedium = true;
		}
		if(input.equalsIgnoreCase("mild"))
		{
			isMild = true;
		}
		return isSpicy;
	}

	private boolean stringLengthChecker(String input)
	{
		boolean isShort = false;
		if (input.length() < 10)
		{
			isShort = true;
		}
		return isShort;

	}

	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}

		}

		for (int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if (memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * Checks for the input "goodbye" to close the app
	 * 
	 * @param input
	 *            The supplied String value
	 * @return Whether or not its OK to quit
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		if (input != null && input.equals("goodbye"))
		{
			okToQuit = true;
		}
		return okToQuit;
	}

}

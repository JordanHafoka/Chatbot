package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private String contentArea;
	private int numberOfChats;
	private ArrayList<String> memeList;
	private ArrayList<String> userInputList;
	private ChatUser myUser;

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
		myUser = new ChatUser();
		userInputList = new ArrayList<String>();
		memeList = new ArrayList<String>();
		fillTheMemeList();
		// this. means talk to the current class.
	}
	
	
	/**
	 * Gets the name of the Chatbot.
	 * @return returns the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the number of chats.
	 * @return returns the number of chats
	 */
	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	/**
	 * 	Sets the user input as the Name of the Chatbot.
	 */
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
		memeList.add("bruh");
		memeList.add("Nyan Cat");
		memeList.add("Trololololo");
		memeList.add("Duck Face");
		memeList.add("Success Kid");

	}

	/**
	 * Processed the supplied text from the user to provide a message from the Chatbot.
	 * @param userText uses the users text as a parameter       
	 * @return return the processedText
	 */
	public String processText(String userText)
	{
		String processedText = "";
	

		//int randomChoice = (int) (Math.random() * 6);
		if (userText != null)
		{
			if (numberOfChats < 11)
			{
				processedText = introduceUser(userText);
			}
			else
			{
				processedText = randomChatTopic(userText);
			}
		}
		incrementChats();
		return processedText;
	}
	
	private String introduceUser(String input)
	{
		String userInfoText = "";
		
		if(numberOfChats == 0)
		{
			myUser.setName(input);
			userInfoText = "Hello " + myUser.getName() + " what is your age?";
		}
		else if(numberOfChats == 2)
		{
			int age = Integer.parseInt(input);
			myUser.setAge(age);
			userInfoText = myUser.getName() + ", you are really" + myUser.getAge() +" years old?";
			userInfoText += "\nWhat is your favorite movie?";
		}
		else if (numberOfChats == 4)
		{
			myUser.setFavoriteMovie(input);
			userInfoText = myUser.getName() + ", you really liked " + myUser.getFavoriteMovie();
			userInfoText += "?? Weird!\nAre you Pierced?";
		}
		else if (numberOfChats == 6)
		{
			boolean isPierced = Boolean.parseBoolean(input);
			myUser.setPierced(isPierced);
			userInfoText = "Wow I would never believed that was true :D";
			userInfoText += "\nDo you have any Tattoos?";
		}
		else if (numberOfChats == 8)
		{
			boolean isTattooed = Boolean.parseBoolean(input);
			myUser.setTattooed(isTattooed);
			userInfoText = "Wow is that really true!?!";
			userInfoText += "\n" + randomChatTopic(userInfoText);
		}
		else
		{
			randomChatTopic(userInfoText);
		}
		incrementChats();
		return userInfoText;
		
	}


	private String randomChatTopic(String userInput)
	{
		String randomTopic = "";
		int randomChoice = (int) (Math.random() * 7);
		if (randomChoice == 0)
		{
			if (stringLengthChecker(userInput))
			{
				randomTopic = "that is wayyyyyyyyyy too long to read";
			}
			else
			{
				randomTopic = "short messages are short on meaning :P";
			}
		}
		else if(randomChoice == 1)
		{
			if (contentChecker(userInput))
			{
				randomTopic = "you know that secret involves " + userInput;
			}
			else
			{
				randomTopic = "Uhhhhhhhh";
			}
		}
		else if(randomChoice == 2)
		{
			if(memeChecker(userInput))
			{
				randomTopic = "Hey you found a meme:" + userInput;
			}
			else
			{
				randomTopic = "Boring, that wasn't a meme:(";
			}
		}
		else if(randomChoice == 3)
		{
			randomTopic = chooseRandomUserInfo(userInput);
		}
		else if(randomChoice == 4)
		{
			userInputList.add(0, userInput);
			randomTopic = "Thanks for the Input, " + myUser.getName();
		}
		else if(randomChoice == 5)
		{
			if(userInputChecker(userInput))
			{
				randomTopic = "Yikes you knew what you said before!!!";
			}
			else
			{
				randomTopic = "I don't think I have heard that before";
			}
		}
		else
		{
			if (chatbotNameChecker(userInput))
			{
				randomTopic = chatbotNameConversation(userInput);
			}
			else
			{
				randomTopic = noNameConversation(userInput);
			}
		}
		
		return randomTopic;
		
	}

	
	
	
	
	
	private String chooseRandomUserInfo(String name)
	{
		this.name = name;
		return name;
	}


	private boolean userInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0)
		{
			for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			{
				if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}
		}
		
		return matchesInput;
	}
	
	/**
	 * Checks if the User likes spicy food or not.
	 * @param input The User's Input.
	 * @return returns whether or not the isSpicy, isMedium, or isMild are true.
	 */
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
	/**
	 * Checks the length of a user's input.
	 * @param input The User's Input.
	 * @return returns isShort.
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean isShort = false;
		if (input.length() < 10)
		{
			isShort = true;
		}
		return isShort;

	}

	/**
	 * Checks if a User's input contains a Meme.
	 * @param currentText The User's Input.
	 * @return returns whether or not it is true.
	 */
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

	/**
	 * Checks to see if the name of the chatbot is contained within the String supplied by the user.
	 * @param currentInput
	 * @return Whether the name is inside or not.
	 */
	private boolean chatbotNameChecker(String currentInput)
	{
		boolean hasName = false;
		if(currentInput.indexOf(this.getName()) > -1)
		{
			hasName = true;
		}
		
		return hasName;
	}
	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation ="This is what you typed after my name: ";
		
		nameConversation.concat(currentInput.substring(currentInput.indexOf(
				this.getName()) + this.getName().length(), currentInput.length()-1));
		
		return nameConversation;
	}
	private String noNameConversation(String currentInput)
	{
		String notNamed = "";
		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) (smallRandom + (Math.random() * currentInput.length() /2)) +1;
		notNamed = "You didn't say my name so here is a special phrase: " + currentInput.substring(smallRandom, largerRandom);
		return notNamed;
		 
	}
}

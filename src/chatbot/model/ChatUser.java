package chatbot.model;

public class ChatUser
{

	private String name;
	private int age;
	private String favoriteMovie;
	private boolean isPierced;
	private boolean isTattooed;
	
	public ChatUser()
	{
		this.name = "";
		this.age = 999;
		this.favoriteMovie = "";
		this.isPierced = false;
		this.isTattooed = false;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String getFavoriteMovie()
	{
		return favoriteMovie;
	}

	public boolean isPierced()
	{
		return isPierced;
	}

	public boolean isTattooed()
	{
		return isTattooed;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setFavoriteMovie(String favoriteMovie)
	{
		this.favoriteMovie = favoriteMovie;
	}

	public void setPierced(boolean isPierced)
	{
		this.isPierced = isPierced;
	}

	public void setTattooed(boolean isTattooed)
	{
		this.isTattooed = isTattooed;
	}
}

/*
Lilibeth Blandon
CSC 311-01
Due Date: February 28, 2017
Project 1: FootballArrays
*/

//Football Team Class//

//In order to keep track of what win percentage belongs to each team, I created a FootballTeam Class.
//In the Driver Class, it creates FootballTeam objects and are placed in a Object Array of size 8.
//When sorting the teams, based on win percentage, both the win percentage and team name, stay as ONE.

public class FootballTeam
{
	private double wins;	//Number of wins
	private String footballTeam;	//Football Team Name
	
	//Default Constructor
	public FootballTeam()
	{
		wins = 0.0;
		footballTeam = "";
	}
	//Constructor with arguments. It takes a double value and a String value.
	public FootballTeam(double wins, String footballTeam)
	{
		this.wins = wins;
		this.footballTeam = footballTeam;
	}
	
	//Getters and Setters to access the wins/team name or to change its value
	public double getWins()
	{
		return wins;
	}
	public void setWins(double wins)
	{
		this.wins = wins;
	}
	public String getFootballTeam()
	{
		return footballTeam;
	}
	public void setFootballTeam(String footballTeam)
	{
		this.footballTeam = footballTeam;
	}	
}
/*
Lilibeth Blandon
CSC 311-01
Due Date: February 28, 2017
Project 1: FootballArrays
*/

import java.text.*;

public class Driver
{
	
	//METHOD 1: Fills in object array with Team Name and their random percentages.
	public static void fillTeamNamesWithPercentages(FootballTeam[] f)
	{
		DecimalFormat decimalPlace = new DecimalFormat("00.##");
		f[0] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Dallas Cowboys");
		f[1] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Carolina Panthers");
		f[2] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Green Bay Packers");
		f[3] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Chicago Bears");
		f[4] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Oakland Raiders");
		f[5] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Minnesota Vikings");
		f[6] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Seattle Seahawks");
		f[7] = new FootballTeam(Double.parseDouble(decimalPlace.format(Math.random() * 99)), "The Pittsburgh Steelers");
		
		//Displays Team with their Win Percentage
		for(int i=0; i < 8; i++)
		{
			System.out.println(f[i].getFootballTeam() + " won " + f[i].getWins() + "% of their games last season!");
		}		
	}
	
	
	//METHOD 2: Fill in String array with team members
	public static void fillTeamMembers(String[] t)
	{
		t[0] = new String("Cam Newton");
		t[1] = new String("Tom Brady");
		t[2] = new String("J.J. Watt");
		t[3] = new String("Antonio Brown");
		t[4] = new String("Adrian Peterson");
		t[5] = new String("Aaron Rodgers");
		t[6] = new String("Luke Kuechly");
		t[7] = new String("Julio Jones");
		t[8] = new String("Rob Gronkowski");
		t[9] = new String("Odell Beckham Jr.");
		t[10] = new String("Josh Norman");
		t[11] = new String("Carson Palmer");
		t[12] = new String("Khalil Mack");
		t[13] = new String("Aaron Donald");
		t[14] = new String("Von Miller");
		t[15] = new String("A.J. Green");
		t[16] = new String("Russell Wilson");
		t[17] = new String("Patrick Peterson");
		t[18] = new String("DeAndre Hopkins");
		t[19] = new String("Richard Sherman");
		t[20] = new String("Todd Gurley");
		t[21] = new String("Joe Thomas");
		t[22] = new String("Darrelle Revis");
		t[23] = new String("Brandon Marshall");
		t[24] = new String("Justin Houston");
		t[25] = new String("Larry Fitzgerald");
		t[26] = new String("Tyrann Mathieu");
		t[27] = new String("Geno Atkins");
		t[28] = new String("Drew Brees");
		t[29] = new String("Allen Robinson");
		t[30] = new String("Kam Chancellor");
		t[31] = new String("Doug Martin");
		System.out.println();
	}
	
    //METHOD 3: Sorting random percentages with their football team in ascending order. I used an insertion sort algorithm.
    public static void sortData(FootballTeam a[])
    {
        for(int i=1; i<a.length; i++)
        {
            int currentElement= i;
            for(int j=i-1; j>=0 ; j--)
            {
                if(a[i].getWins() < a[j].getWins())
                {
					//Sort Percentages in ascending order.
                    double temp=a[i].getWins();
                    a[i].setWins(a[j].getWins());
                    a[j].setWins(temp);
					
					//Sort Football Teams with their corresponding win percentage.
					String temp2=a[i].getFootballTeam();
                    a[i].setFootballTeam(a[j].getFootballTeam());
                    a[j].setFootballTeam(temp2);
					i--;
                }
                else
                    i=currentElement;
            }
        }
		
		//Display teams rank
		for(int i=0; i<8; i++)
		{
			System.out.println(a[i].getFootballTeam() + " is ranked " + (i+1) );
		}
		System.out.println();		
    }	
	
	//METHOD 4: Assign a random number to each player that will determine which round they will be a part of.
	public static void roundRandomizer(String[][] x, String [] playersNames)
	{
		int currentIndex0 = 0;	//Current Index for row 0
		int currentIndex1 = 0;	//Current Index for row 1
		int currentIndex2 = 0;	//Current Index for row 2
		int currentIndex3 = 0;	//Current Index for row 3
		int round = 0; 			//ONLY 4 ROUNDS; 0-3 INDEXES
		
		
		for(int i=0; i < playersNames.length; i++)
		{
			int roundCompleted = 0; //Only two values, 0-1. Value changes when someone has been picked in a round
									//It helps not to skip a player's turn and be able to be a part of a non-empty round
			System.out.print(playersNames[i] + " has been selected to be drafted in Round ");
			while(roundCompleted != 1)
			{
				round = (int)(Math.random() * 4); //Random Number representing each of the 4 rounds. 0-3 indexes
				if(round == 0 && currentIndex0 < 8)
				{
					x[round][currentIndex0++] = playersNames[i];
					roundCompleted++;	//Player successfully assigned will result in a ++ and will exit while-loop and continues to the next player in the outer for loop.
				}
				else if(round ==1 && currentIndex1 < 8)
				{
					x[round][currentIndex1++] = playersNames[i];
					roundCompleted++;	//Player successfully assigned will result in a ++ and will exit while-loop and continues to the next player in the outer for loop.
				}
				else if(round ==2 && currentIndex2 < 8)
				{
					x[round][currentIndex2++] = playersNames[i];
					roundCompleted++;	//Player successfully assigned will result in a ++ and will exit while-loop and continues to the next player in the outer for loop.
				}
				else if(round ==3 && currentIndex3 < 8)
				{
					x[round][currentIndex3++] = playersNames[i];
					roundCompleted++;;	//Player successfully assigned will result in a ++ and will exit while-loop and continues to the next player in the outer for loop.
				}
			}
			System.out.print((round+1));
			System.out.println();
		}		
		System.out.println();
	}

	
	//METHOD 5: Each team will randomly choose 4 players to be part of their team. 
	public static void choosingPlayers(String[][] x, FootballTeam [] f)
	{	
		int player;
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<8; j++)
			{
				int playerChosen = 0;
			
				while(playerChosen != 1)
				{
					player = (int)(Math.random() * 8); //Random Number representing each of the 8 players. 0-7 indexes.
					if(x[i][player] != "PLAYER SELECTED, PICK ANOTHER PLAYER")
					{
						display( (i+1), f[j].getFootballTeam(), x[i][player] ); //METHOD 6
						playerChosen++; 	//Means player was selected, increases by 1, and it breaks the while loop
						x[i][player] = "PLAYER SELECTED, PICK ANOTHER PLAYER"; 	//The if statement checks the location of the player if its already taken. This avoids picking the same
																				//player more than once.
					}
				}
			}
			System.out.println("");
		}
	}	

	
	//METHOD 6: display method used for choosingPlayers();
	public static void display(int index, String footballName, String playerName)
	{
		System.out.println("Round " + (index) + ": Team: " + footballName + " selected: " + playerName);
	}
			
    
	/****************************************************************************/ 	
	/****************************************************************************/
	/****************************MAIN METHOD*************************************/ 	
    /****************************************************************************/
	/****************************************************************************/ 		
    public static void main(String[] args)
    {
		FootballTeam [] f = new FootballTeam[8]; //Array of objects: Helps keep the win percentages and the Football Teams as ONE.
												//Later on in the program, it will be easier to track what each Football Team's rank is.
												//It holds 8 objects in which it contains both (win percentage) and (team name) in a seperate Class named FootballTeam.									
		String teamMembers [] = new String[32]; //Array of Strings. It holds 32 names.
		String [][] round = new String[4][8]; //Two-dimensional String Array. The rows represent each round and the columns represent the players.
		
		fillTeamNamesWithPercentages(f); //METHOD 1
		fillTeamMembers(teamMembers); //METHOD 2
		sortData(f); //METHOD 3
		roundRandomizer(round, teamMembers); //METHOD 4
		choosingPlayers(round, f); //METHOD 5
    }

}

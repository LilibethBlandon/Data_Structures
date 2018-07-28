/*
Lilibeth Blandon
Project 2: Driver Class
Due: March 21, 2017
*/

//Driver Class
//There are a total of 11 methods.

//1st Method: IT USES METHODS 2-4. Displays the first 2 options which are either to create a new client login or to login an existing account.
//2nd Method: It helps us analyze our logins.txt file and see if the username a new client is inputting is unique.
//3rd Method: This is for option 1: If the username is unique and the password is at least 8 character's long, then the information will be saved in logins.txt file.
//4th Method: This is for option 2: It checks if the username and password are inside the logins.txt file.


//5th Method: IT USES METHODS 6-11. This displays the rest of the menu. Options 3-9.
//6th Method: This method is for option 3. It asks the user to input their food item with all of its information. It pushes the information onto the stack in FoodItemStack.
//7th Method: This is for option 4. It displays the history of the user's food items. It calls a method inside FoodItemStack.
//8th Method: This is for option 5.
//9th Method: This is for option 6, which calculates the total calories someone ate in a day. It calls a method inside FoodItemStack
//10th Method: This method is for option 7 which helps find the maximum calorie food. It calls a method inside FoodItemStack
//11th Method: This is for option 8 which says which food someone ate the most throughout the day. It calls a method inside FoodItemStack
/*******************************************************************************************************/



import java.util.Scanner;
import java.io.*;

public class Driver
{
	/*******************METHOD 1: ******************/
	public static void menu() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		int option;
		String firstName;
		String lastName;
		String username;
		String password;
		boolean isUnique;
		
		System.out.println("1-Create Client Login");
		System.out.println("2-Login Existing Client");
		
		option = keyboard.nextInt();
		
		while(option < 1 || option > 2)
		{
			System.out.println("Error Pick a valid option");
			option = keyboard.nextInt();
		}
		
		
		//OPTION 1
		if(option==1)
		{
			//FIRST NAME
			System.out.print("First Name: ");
			firstName = keyboard.next();
			//LAST NAME
			System.out.print("Last Name:");
			lastName = keyboard.next();
			
			//USERNAME
			System.out.print("Username: ");
			username = keyboard.next();
			
			
			/***if true it's unique***///
			/***if false it's not unique***///
			
			isUnique = isUsernameUnique(username); //METHOD 2
			
			if(isUnique==false) //2nd attempt for Username
			{
				System.out.println("Username Taken! Please try again!");
				username = keyboard.next();
				isUnique = isUsernameUnique(username);
			}
			if(isUnique==false)		//Generates a random Username after two failed tries
			{
				int randomNumber = (int)(Math.random() * 10000); 	//Random number that will be concatenated with the user's
																	//last name
				String randomString = Integer.toString(randomNumber);
				username = lastName + randomString;
				System.out.println("New Username created using your last name: " + username);
			}
			
			//PASSWORD
			System.out.print("Password (Must be atleast 8 characters long):");
			password = keyboard.next();
			while(password.length() < 8)
			{
				System.out.println("Password must be at least 8 characters long, Please try again!");
				password = keyboard.next();
			}
			option1(firstName, lastName, username, password); //METHOD 3
			System.out.println();
			return;
		}
		
		//OPTION2
		else if(option==2)
		{
			boolean isLoginAvailable;
			
			System.out.print("Username: ");			
			username = keyboard.next();
			System.out.print("Password: ");	
			password = keyboard.next();
			System.out.println();
			isLoginAvailable = option2(username, password);
			
			if(isLoginAvailable==false)
			{
				System.out.println("Username and Password doesn't match! Try again");
				System.out.println();
			}
			
			
			while(isLoginAvailable==false)
			{
				System.out.print("Username: ");			
				username = keyboard.next();
				System.out.print("Password: ");	
				password = keyboard.next();
				System.out.println();
				isLoginAvailable = option2(username, password); //METHOD 4
			}
			
			if(isLoginAvailable == true)
			{
				System.out.println("Welcome! You are signed in!");
				System.out.println();
			}
			return;
		}
	}
		
		
		
	/*******************METHOD 2: ******************/
	public static boolean isUsernameUnique(String username) throws IOException
	{
		String [] data = new String[20];
		int counter=0;
		
		
		File inputFile = new File("logins.txt");
		Scanner scanFile = new Scanner(inputFile);
		while(scanFile.hasNextLine())
		{
			String line = scanFile.nextLine();
			data[counter]=line;
			counter++;
		}

		
		int key=0;
		int beginningOfUsername=0;
		int endOfUsername=0;
		
		
		//This for loop helps get the contents of logins.txt and make each line an individual character array. Having a character array will make it easier to find which parts is the username of each line. This will make it easier to compare to the username the user originally inputs.
		for(int i=0; i<counter; i++)
		{
			char[] charArray = new char[data[i].length()];
			charArray = data[i].toCharArray();
			
			for(int j=0; j<charArray.length; j++)
			{
				if(charArray[j] == '/')
				{
					key++;
					if(key==2)
					{
						beginningOfUsername=j+1;
					}
					else if(key==3)
					{
						endOfUsername=j;
						key=0;
						break;
					}
				}
				
			}
			
			//CHECKING IF THE USERNAME IS ALREADY TAKEN!
			String result = new String(charArray, beginningOfUsername, (endOfUsername-beginningOfUsername));//Makes a new string just with the Username
			
			if(username.equals(result))
			{
				return false;
			}
		}
		
		return true;
		
	}
		
	/*******************METHOD 3: ******************/
	public static void option1(String f, String l, String u, String p) throws IOException
	{
		File outputFile = new File("logins.txt");
		FileWriter fWriter = new FileWriter (outputFile, true);	
		/*http://stackoverflow.com/questions/4269302/how-do-you-append-to-a-text-file-instead-of-overwriting-it-in-java
		*/
		PrintWriter pWriter = new PrintWriter(fWriter);
		
		pWriter.print(f + "/");
		pWriter.print(l + "/");
		pWriter.print(u + "/");
		pWriter.print(p);
		pWriter.println("");
		
		pWriter.close();
	}
	
	/*******************METHOD 4: ******************/ 
	public static boolean option2(String u, String p) throws IOException
	{
		String [] data = new String[30];//This string array will help keep track of each username's information when reading logins.txt
		int counter=0;//This counter will increase everytime the Scanner Object reads a new line from logins.txt
		
		
		File inputFile = new File("logins.txt");
		Scanner scanFile = new Scanner(inputFile);
		while(scanFile.hasNextLine())
		{
			String line = scanFile.nextLine();
			data[counter]=line;	//Each line will go into it's own String element.
			counter++;//Counter only increases when reading a new line.
		}
		
		int key=0;	//keeps track of the '/' character. After key=2, we know the index of the
					//beginning of the username. When key=3, we know the index for the end of the username
		int beginningOfUsername=0;
		int endOfUsername=0;
		
		
		//This for loop helps get the contents of logins.txt and make each line an individual character array. Having a character array will make it easier to find which parts is the username of each line. This will make it easier to compare to the username the user originally inputs.
		for(int i=0; i<counter; i++)
		{
			char[] charArray = new char[data[i].length()];	//Created a character array for my each String from logins.txt and this will
															//help analyze which parts are the username and which parts are the passwords
															
			charArray = data[i].toCharArray();
			
			for(int j=0; j<charArray.length; j++)
			{
				if(charArray[j] == '/')
				{
					key++;
					if(key==2)
					{
						beginningOfUsername=j+1;
					}
					else if(key==3)
					{
						endOfUsername=j;
						key=0;
						break;
					}
				}
				
			}
			
			//I got help from: 
			//https://www.dotnetperls.com/convert-char-array-string-java
			
			String result1 = new String(charArray, beginningOfUsername, (endOfUsername-beginningOfUsername));//Makes a new string just with the Username
			
			String result2 = new String(charArray, (endOfUsername+1), (charArray.length-(endOfUsername+1)));//Makes a new string just with the Password
			
			boolean isUsernameAvailable;
			boolean isPasswordAvailable;
			
			if(u.equals(result1) && p.equals(result2))//COMPARES BOTH STRINGS WITH ORIGINAL USERNAME AND PASSWORD INPUT
			{
				return true;//Username and Password match one of the logins data from logins.txt
			}
		}
		
		return false; //Username and password doesn't match!
	}


	
	
	
	/*******************METHOD 5: ******************/ 
	public static void options3through9(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("PICK AN OPTION!");
		System.out.println();
		
		System.out.println("3-Add a food item");
		System.out.println("4-Diet Complete History");
		System.out.println("5-Check the different types of food you have ate");
		System.out.println("6-Total Calories eaten in a day");
		System.out.println("7-Food with the maximum calorie content in a day");
		System.out.println("8-Food item you ate the most for the day!");
		System.out.println("9-Logout");
		
		int option = keyboard.nextInt();
		
		System.out.println();
		
		while(option < 3 || option > 9)
		{
			System.out.println("Error Pick a valid option");
			option = keyboard.nextInt();
		}
		
		if(option==3)
		{
			option3(fs); //METHOD 6
		}
		else if(option==4)
		{
			option4(fs); //METHOD 7
		}
		else if(option==5)
		{
			option5(fs); //METHOD 8
		}
		else if(option==6)
		{
			option6(fs); //METHOD 9
		}
		else if(option==7)
		{
			option7(fs); //METHOD 10
		}
		else if(option==8)
		{
			option8(fs); //METHOD 11
		}
		else if(option==9)
		{
			System.exit(0);
		}		
	}

	/*******************METHOD 6: ******************/ 
	public static void option3(FoodItemStack fs)
	{		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Name of Meal: ");
		String mealName = keyboard.next();
		System.out.print("Quantity: ");
		int quantity = keyboard.nextInt();
		System.out.print("Calories: ");
		int calorie = keyboard.nextInt();
		System.out.print("Meal-type(Breakfast, Lunch, Snack, Dinner): ");
		String mealType = keyboard.next();
		System.out.println();
		System.out.println();
		
		fs.push(mealName, quantity, calorie, mealType);

		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();

		options3through9(fs); //RECURSION		
	}

	/*******************METHOD 7: ******************/ 
	public static void option4(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		fs.displayHistory();
		
		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();
		
		options3through9(fs); //RECURSION
	}

	/*******************METHOD 8: ******************/
	
	public static void option5(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		fs.noRepeats();
		
		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();
		
		options3through9(fs); //RECURSION
	}	

	/*******************METHOD 9: ******************/
	public static void option6(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int total = fs.calculateTotalCalories();
		
		System.out.println("Total Calories you ate in a day = " + total);
		
		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();
		
		options3through9(fs); //RECURSION
	}

	/*******************METHOD 10: ******************/
	public static void option7(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String maximumCalories;
		maximumCalories = fs.maximumCalorie();
		System.out.println("Maximum Calorie Food= " + maximumCalories);
		
		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();		
		
		options3through9(fs); //RECURSION
	}

	/*******************METHOD 11: ******************/
	public static void option8(FoodItemStack fs)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String maximumFoodItem;
		maximumFoodItem = fs.maximumFoodItem();
		System.out.println("Maximum food item was: " + maximumFoodItem);
		
		System.out.println("To go back to the menu enter any number");
		int showMenu = keyboard.nextInt();		
		
		options3through9(fs); //RECURSION
	}
	
	
	
	/***********************************************************************************/
	/***********************************************************************************/
	/***********************************************************************************/
	/********************************MAIN METHOD****************************************/
	/***********************************************************************************/
	/***********************************************************************************/
	/***********************************************************************************/
	public static void main(String[] args) throws IOException
	{
		FoodItemStack fs = new FoodItemStack(); //Food Item Stack Object created
		
		menu();//Method 1: Inside method 1 it also uses methods 2,3,and 4
		
		options3through9(fs); //Method5: Inside method 5 it also uses methods 6,7,8,9,10,11
	}
}
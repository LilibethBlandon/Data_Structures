/*
Lilibeth Blandon
CSC 311-01
Project 4: Graduation HashTable
DUE DATE: May 12, 2017
*/

//Graduation Class

import java.util.Random;
import java.text.*;

public class Graduation
{
	private Student[] classOf2011;	//Incoming class of students for the year 2011 array. In it will consist of objects type Student, with name and unique student ID.
	private Student[] classOf2012;	//Incoming class of students for the year 2012 array. In it will consist of objects type Student, with name and unique student ID.
	private Student[] classOf2013;	//Incoming class of students for the year 2013 array. In it will consist of objects type Student, with name and unique student ID.
	private boolean[] idChecker;	//This boolean array will store 60 elements of type boolean. These 60 element will help in not repeating ID numbers by changing the boolean type 
									//to true once taken.
	private HashTableImplementation h;
	private int randomCapacity;		//capacity of HashTable. Randomly choose between 15 to 25 students
	
	private int counterFourYears;
	private int counterFiveYears;
	private int counterSixYears;
	
	//CONSTRUCTOR
	public Graduation()
	{
		//Initializing private variables
		classOf2011 = new Student[20];
		classOf2012 = new Student[20];
		classOf2013 = new Student[20];
		randomCapacity = ((int)(Math.random() * ((25 - 15) + 1)) + 15);
		h = new HashTableImplementation(randomCapacity);
		counterFourYears=0;
		counterFiveYears=0;
		counterSixYears=0;
		idChecker = new boolean[60];
	}
	
	
	//METHOD 1: This fills the 3 class arrays, 20 students for each class. 
	public void fillInClassArrays()
	{
		Random rand = new Random();
		//Class of 2011
		for(int i=0; i<20; i++)
		{
			String name = randomNameGenerator();	//HELPER METHOD
			int randomNumber = rand.nextInt(60) + 1;
			while(idChecker[randomNumber-1] == true)
			{
				randomNumber = rand.nextInt(60) + 1;
			}
			idChecker[randomNumber-1] = true;
			classOf2011[i] = new Student(name, randomNumber, 2011);
		}
		//Class of 2012
		for(int i=0; i<20; i++)
		{
			String name = randomNameGenerator();	//HELPER METHOD
			int randomNumber = rand.nextInt(60) + 1;
			while(idChecker[randomNumber-1] == true)
			{
				randomNumber = rand.nextInt(60) + 1;
			}
			idChecker[randomNumber-1] = true;
			classOf2012[i] = new Student(name, randomNumber, 2012);
		}
		//Class of 2013
		for(int i=0; i<20; i++)
		{
			String name = randomNameGenerator();	//HELPER METHOD
			int randomNumber = rand.nextInt(60) + 1;
			while(idChecker[randomNumber-1] == true)
			{
				randomNumber = rand.nextInt(60) + 1;
			}
			idChecker[randomNumber-1] = true;
			classOf2013[i] = new Student(name, randomNumber, 2013);
		}
		/*for(int i=0; i<20; i++)
		{
			classOf2011[i].display();
		}
		System.out.println("***************************************************************");
		for(int i=0; i<20; i++)
		{
			classOf2012[i].display();
		}
		System.out.println("***************************************************************");
		for(int i=0; i<20; i++)
		{
			classOf2013[i].display();
		}
		*/
					
	}
	
	//Helper method: helps generate 4 letter names for each student. It uses Math.random to find a random number between 97-122 inclusive for lowercase alphabet letters ASCII values.
	public String randomNameGenerator()
	{
		StringBuilder str = new StringBuilder("");
		
		//for-loop to generate a 4 letter name value
		for(int i=0; i<4; i++)
		{
			char letter = (char)((int)(Math.random() * ((122 - 97) + 1)) + 97);  //generate a number between 97-122 inclusive in order to get an ascii value for lowercase letters.
			str.append(letter);
		}
		return str.toString();
	}

	//Method 2: Will randomly choose between 15 to 25 (depends on what the randomCapacity is) from either the incoming 2011 class, 2012 class or the 2013 class.
	public void classOf2017()
	{
		Random r = new Random();
		
		//For-loop where it will randomly pick randomCapacity amount of students
		for(int i=0; i<randomCapacity; i++)
		{
			int randomYear = r.nextInt(3) + 1;
			//2011 students
			if(randomYear == 1)
			{
				int randomStudent = r.nextInt(20);
				while(classOf2011[randomStudent].getIsTaken() == true)
				{
					randomStudent = r.nextInt(20);
				}
				classOf2011[randomStudent].setIsTaken(true);
				h.add(classOf2011[randomStudent]);
			}
			//2012 students
			if(randomYear == 2)
			{
				int randomStudent = r.nextInt(20);
				while(classOf2012[randomStudent].getIsTaken() == true)
				{
					randomStudent = r.nextInt(20);
				}
				classOf2012[randomStudent].setIsTaken(true);
				h.add(classOf2012[randomStudent]);
			}
			//2013 students
			if(randomYear == 3)
			{
				int randomStudent = r.nextInt(20);
				while(classOf2013[randomStudent].getIsTaken() == true)
				{
					randomStudent = r.nextInt(20);
				}
				classOf2013[randomStudent].setIsTaken(true);
				h.add(classOf2013[randomStudent]);
			}
		}
		System.out.println();
		System.out.println(randomCapacity + " STUDENTS FOR THE GRADUATING CLASS OF 2017!!!!");
		System.out.println();
		h.showArray();
		System.out.println();
		System.out.println("**********************************************************************");
		System.out.println();
		return;
	}
	
	//METHOD 3: This method will let us know how many students are graduating in 2017 from the class 2011, 2012 and 2013. This method uses counterFourYears, counterFiveYears, and counterSixYears to know how many students from each graduating. The values from these variables are generated whenever we remove a Student object.
	public void numberOfStudentsGraduating()
	{			
		//FOUR YEARS STUDENTS
		System.out.println("~~~~~~~~~~~~~~~~~~~STUDENTS GRADUATING IN 4 YEARS~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		while(h.findIdx(2013) != -999)
		{
			h.remove(2013);			//Removes student.
			counterFourYears++;		//Incremements counter to let us know how many we have "removed" from the class 2013.
		}
		System.out.println(">>Number of Students graduating in 4 years = " + counterFourYears + " students!<<");
		System.out.println();
		
		
		
		//FIVE YEARS STUDENTS
		System.out.println("~~~~~~~~~~~~~~~~~~~STUDENTS GRADUATING IN 5 YEARS~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		while(h.findIdx(2012) != -999)
		{
			h.remove(2012);			//Removes student.
			counterFiveYears++;		//Incremements counter to let us know how many we have "removed" from the class 2012.
		}
		System.out.println(">>Number of Students graduating in 5 years = " + counterFiveYears + " students!<<");
		System.out.println();
		
		//SIX YEARS STUDENTS
		System.out.println("~~~~~~~~~~~~~~~~~~~STUDENTS GRADUATING IN 6 YEARS~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		while(h.findIdx(2011) != -999)
		{
			h.remove(2011);			//Removes student.
			counterSixYears++;		//Incremements counter to let us know how many we have "removed" from the class 2011.
		}
		System.out.println(">>Number of Students graduating in 6 years = " + counterSixYears + " students!<<");
		System.out.println();
		System.out.println("**********************************************************************");
		System.out.println();
	}
	
	//METHOD 4: This method will let us know the 4, 5 and 6 year graduation rates.
	public void graduationRates()
	{
		DecimalFormat decimalPlace = new DecimalFormat("00.##");
		
		//4 YEAR GRAD RATES
		System.out.print("4 YEAR GRADUATION RATE ");
		double fourYearRate = ((double)(counterFourYears)/(double)(20))*100;
		fourYearRate = Double.parseDouble(decimalPlace.format(fourYearRate));
		System.out.println("- " + fourYearRate + " %");
		System.out.println();
		
		
		//5 YEAR GRAD RATES
		System.out.print("5 YEAR GRADUATION RATE ");
		double fiveYearRate = ((double)(counterFourYears+counterFiveYears)/(double)(40))*100;
		fiveYearRate = Double.parseDouble(decimalPlace.format(fiveYearRate));
		System.out.println("- " + fiveYearRate + " %");
		System.out.println();
		
		//6 YEAR GRAD RATES
		System.out.print("6 YEAR GRADUATION RATE ");
		double sixYearRate = ((double)(counterFourYears+counterFiveYears+counterSixYears)/(double)(60))*100;
		sixYearRate = Double.parseDouble(decimalPlace.format(sixYearRate));
		System.out.println("- " + sixYearRate + " %");
	}	
}
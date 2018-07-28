/*
Lilibeth Blandon
CSC 311-01
Project 4: Graduation HashTable
DUE DATE: May 12, 2017
*/

//Student Class

public class Student
{
	private String name;
	private int id;
	private int classNumber;
	private boolean isTaken;
	
	public Student(String name, int id, int classNumber)
	{
		this.name = name;
		this.id = id;
		this.classNumber = classNumber;
		isTaken=false;
	}
	//Getters
	public String getName()
	{
		return name;
	}
	public int getIDNumber()
	{
		return id;
	}
	public int getClassNumber()
	{
		return classNumber;
	}
	public boolean getIsTaken()
	{
		return isTaken;
	}
	//Setters
	public void setName(String n)
	{
		name = n;
	}
	public void setIDNumber(int i)
	{
		id = i;
	}
	public void setClassNumber(int classN)
	{
		classNumber = classN;
	}
	public void setIsTaken(boolean t)
	{
		isTaken = t;
	}
	//Display
	public void display()
	{
		System.out.printf("%s%s%s%2d%s%4d\n", "Student ", name, " has ID Number ", id, " and is from the incoming class of ", classNumber);
	}
}
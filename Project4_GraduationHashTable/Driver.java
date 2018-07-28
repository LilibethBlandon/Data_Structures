/*
Lilibeth Blandon
CSC 311-01
Project 4: Graduation HashTable
DUE DATE: May 12, 2017
*/

//Driver Class

/****************************//****************************/
/********MAIN METHOD*********//********MAIN METHOD*********/
/****************************//****************************/
public class Driver
{
	public static void main(String[] args)
	{
		Graduation g = new Graduation();
		
		g.fillInClassArrays();			//METHOD 1
		g.classOf2017();				//METHOD 2
		g.numberOfStudentsGraduating();	//METHOD 3
		g.graduationRates();			//METHOD 4
		
	}
}
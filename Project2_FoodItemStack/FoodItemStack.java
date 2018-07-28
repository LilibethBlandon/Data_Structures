/*
Lilibeth Blandon
Project 2: Food Item Stack
Due: March 21, 2017
*/

//FoodItemStack Class
//This class will implement a stack using an array. The array will be made of FoodItem class objects.
/*******************************************************************************************************/


public class FoodItemStack
{
	private FoodItem[] theData;		//Storage for the Stack
	private int topOfStack = -1; 	//Indicates nothing is there
	private static final int INITIAL_CAPACITY = 30;

	//Default constructor
	public FoodItemStack()
	{
		this.theData = new FoodItem[INITIAL_CAPACITY];
	}

	public FoodItem push(String name, int quantity, int calories, String type)
	{
		//This method adds elements to the stack if there is space
		//Check if the stack is full
		if(topOfStack == this.theData.length-1)
		{
				System.out.println("Stack Overflow");
				return null;
		}
		//else there is space available, insert the data
		topOfStack++;
		theData[topOfStack] = new FoodItem(name, quantity, calories, type);
		return theData[topOfStack];
	}


	public FoodItem pop()
	{
		//This method removes elements from the stack if there is something
		//Check for emptiness of the stack
		if(empty())
		{
			System.out.println("Stack Underflow");
			return null;
		}
		//There is some element that can be deleted
		return theData[topOfStack--];
	}

	public FoodItem peek()
	{
		if(empty())
		{
			System.out.println("Stack Underflow");
			return null;
		}
		return theData[topOfStack];
	}

	public boolean empty()
	{
		return (topOfStack == -1);
	}
 
	//vvvvvvvvvvvvvvvvvvvvvvvvv NEW METHODS I ADDED TO THE STACK CLASS vvvvvvvvvvvvvvvvvvv
	/************************************************************************************/
	
	//Displays the history from recent-oldest.
	public void displayHistory()
	{
		System.out.println();
		System.out.println("Complete History from most recent");
		for(int i=topOfStack; i>=0; i--)
		{
			System.out.println("*********Information for item " + (i+1) + "*********");
			
			theData[i].display();	//Uses the display method from FoodItem.
			System.out.println();
		}
		System.out.println();
		System.out.println("--------------------------------------------");
	}
	
	//Method that displays the food items you ate with no repeats
	//I couldn't make it work...
	public void noRepeats()
	{
		String[] xArray = new String [30];
		String[] nArray = new String [30];
		boolean isUnique=true;
		
		System.out.println();
		System.out.println("Complete History of food you ate");
		
		for(int i=topOfStack; i>=0; i--)
		{
			xArray[i]=theData[i].getName();
			System.out.println(xArray[i]);
		}		
	}

	//Calculate the total number of calories someone ate in a day.	
	public int calculateTotalCalories()
	{
		int total=0;
		
		for(int i=0; i<=topOfStack; i++)
		{
			total = total + theData[i].getCalories();
		}
		
		return total;
	}

	//This method will let us know which food item the client ate the most calories from.
	public String maximumCalorie()
	{
		int maximum=theData[0].getCalories();		//Puts the first item's "calories" inside my stack as maximum
		
		String maximumCalories;						//The string that we will return
													//with the food with the maximum calories
													
		
		int currentIndex=0;							//This variable helps us save the index with the current maximum
		
		//http://stackoverflow.com/questions/16325168/how-would-i-find-the-maximum-value-in-an-array
		for(int i=1; i<=topOfStack; i++)
		{
			if(theData[i].getCalories() > maximum)
			{
				maximum = theData[i].getCalories();
				currentIndex=i;
			}
		}
		maximumCalories = theData[currentIndex].getName();
		return maximumCalories;
	}

	//This method will let us know which food item the client ate maximum number of times in a day. We will know this by finding the maximum number of "quantity" inside our stack.
	public String maximumFoodItem()
	{
		int maximum=theData[0].getQuantity(); 	//Puts the first item's "quantity" inside my 
												//stack as maximum.
												
		String maximumFoodItem;					//The string that we will return 
												//with the food with the maximum quantity
												
		int currentIndex=0;						//This variable helps us save the index with the current maximum.
		
		//http://stackoverflow.com/questions/16325168/how-would-i-find-the-maximum-value-in-an-array
		for(int i=1; i<=topOfStack; i++)
		{
			if(theData[i].getQuantity() > maximum)
			{
				maximum = theData[i].getQuantity();
				currentIndex=i;
			}
		}
		maximumFoodItem = theData[currentIndex].getName();
		return maximumFoodItem;
	}
}
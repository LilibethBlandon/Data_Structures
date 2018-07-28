/*
Lilibeth Blandon
Project 2: Food Item Stack
Due: March 21, 2017
*/

//FoodItem Class
//This class will represent 1 food item. Each food item has 4 attributes and has it's own display method.
//These objects will go inside the stack Object array.
/*******************************************************************************************************/

public class FoodItem
{
	private String name;
	private int quantity;
	private int calories;
	private String mealType;
	
	//Constructor
	public FoodItem(String n, int q, int c, String m)
	{
		name = n;
		quantity = q;
		calories = c;
		mealType = m;
	}
	
	//getters
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public int getCalories()
	{
		return calories;
	}
	public String getMealType()
	{
		return mealType;
	}
	public void display()
	{
		System.out.print("Meal Name: " + getName() + "\n" + "Quantity: " + getQuantity() + "\n" + "Total Calories: " + getCalories() + "\n" + "Meal Type: " + getMealType());
		System.out.println();
	}
}
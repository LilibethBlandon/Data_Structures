/*
Lilibeth Blandon
CSC 311-01
Project 4: Graduation HashTable
DUE DATE: May 12, 2017
*/

//HashTable Class

public class HashTableImplementation
{
	//Global variables
	private Student[] hashTable; 	//Object HashTable
	private final int CAPACITY;		//size of Hashtable
	private int size;				//number of elements with Student data.
	
	//Markers
	private final int NEVER_USED = -1;
	private final int PREVIOUSLY_USED = -2;
	private final int NO_ID_NUMBER = -3;
	private final int INDEX_NOT_FOUND = -999;
	
	//One argument Constructor
	public HashTableImplementation(int capacity)
	{
		this.CAPACITY = capacity;
		size=0;
		hashTable = new Student[CAPACITY];
		
		for (int i = 0; i < CAPACITY; i++)
		{
			hashTable[i] = new Student("", NO_ID_NUMBER, NEVER_USED);
		}
	}

	//PUBLIC METHODS
	
	//add method will add Student objects to the hashtable
	public void add(Student keyToAdd)
	{
		int classNumber = keyToAdd.getClassNumber();

		int possibleKeyIdx = hash(keyToAdd.getClassNumber());	//We hash the object we want to add using the Class Number as our key.

		//This while-loop will let us know if the cell-block is available or not. if it isnt, we go to the next index using linear probing.
		while(!(isVacantIndex(possibleKeyIdx)))
		{
			possibleKeyIdx = nextIdx(possibleKeyIdx);
		}
		
		//Change the attributes to the Student objects in hashtable.
		hashTable[possibleKeyIdx].setName(keyToAdd.getName());  //Name is placed in this index*
		hashTable[possibleKeyIdx].setClassNumber(classNumber);   //class number IS PLACED in this index
		hashTable[possibleKeyIdx].setIDNumber(keyToAdd.getIDNumber()); //ID Number placed here
		hashTable[possibleKeyIdx].setIsTaken(true);
                
		size++;
		
	}
	
	//Remove method: This method will remove the data from the cell-block and set all the Student object with a marker (PREVIOUSLY_USED) variable.
	public void remove(int keyToRemove)
	{
		int keyIndex = findIdx(keyToRemove);
		
		Student temp = hashTable[keyIndex];	//This temp variable will help us get the attributes of this Student Object before we change them.
		temp.display();
				
		hashTable[keyIndex].setClassNumber(PREVIOUSLY_USED);
		hashTable[keyIndex].setName("");
		hashTable[keyIndex].setIDNumber(NO_ID_NUMBER);
		
		size--;
	}
	
	
	//This method will serve to see if a key is present in the Hashtable.
	public boolean isPresent(Student keyToFind)
	{
		int keyIndex = findIdx(keyToFind.getClassNumber());
		
		if(keyIndex != INDEX_NOT_FOUND)
			return true;
		else
			return false;
	}
	
	
	//This method will find the index of the key and will return the index. Will return -999 (INDEX_NOT_FOUND) if the key isn't inside the Hashtable.
	public int findIdx(int keyToFind)
	{
		int possibleKeyIdx = hash(keyToFind);
		int cellsExamined = 0;	//Will serve as a counter. It shouldn't reacher greater than capacity. We only want to examine capacity amount of cells.
		
		//this while-loop will help us find the possible index of the index. This uses linear probing.
		while ((cellsExamined < CAPACITY) && (!wasNeverUsedIdx(possibleKeyIdx)) && (hashTable[possibleKeyIdx].getClassNumber() != keyToFind))
		{
			cellsExamined++;

			possibleKeyIdx = nextIdx(possibleKeyIdx);
		}
		if (hashTable[possibleKeyIdx].getClassNumber() == keyToFind)
			return possibleKeyIdx;
		else
			return INDEX_NOT_FOUND;
	}

	//display of hashtable.
	public void showArray()
	{
		for (int i = 0; i < CAPACITY; i++)
		{
			if(hashTable[i].getName()!="" && hashTable[i].getIDNumber() != NO_ID_NUMBER && hashTable[i].getClassNumber() != NEVER_USED)
			{
				//System.out.print("Student " + i + ":------> ");
				hashTable[i].display();
				//System.out.println();
			}
		}
	}
	
	
	//Gets number of elements occupied of hashtable.
	public int getSize()
	{
		return size;
	}
	
	
	//PRIVATE METHODS
	
	//Hash private method: will hash the key to an index. the key will be the graduating class number and this method will "hash" it.
	private int hash(int keyToHash)
	{
		return (keyToHash % CAPACITY);
	}
	
	//This method returns the next index to visit after the index in argument such as searching.
	private int nextIdx(int idxToPass)
	{
		return ((idxToPass+1) % CAPACITY);
	}
	
	//This method lets us know that a cell-block hasn't been used before and we can store data inside the cell with no problem.
	private boolean wasNeverUsedIdx(int idxToExamine)
	{
		if (hashTable[idxToExamine].getClassNumber() == NEVER_USED)	//NEVER_USED is a global variable and serves as a marker. The marker will be -1 in the class number attribute.
			return true;
		else
			return false;
	}
	
	//This method will let us know if a cell-block is available. It can either be never used before or previously used before. 
	private boolean isVacantIndex(int idxToExamine)
	{
		if (hashTable[idxToExamine].getClassNumber() == NEVER_USED || hashTable[idxToExamine].getClassNumber() == PREVIOUSLY_USED)	//NEVER_USED marker is -1 and PREVIOUSLY_USED = -2. Either one will result as Vacant Index/Available Index.
			return true;
		else
			return false;
	}
	
	
	
	
	
	
}

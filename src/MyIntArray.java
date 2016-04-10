/**
 * @author Dion de Jong 
 * @version 1.0 11 February 2014
 * This program will do a basic bubble sort using objects that are 
 * Arrays. 
 */ 

//main class
public class MyIntArray {
	//instance variables
	private int length = 0; 
	private int[] myArray; 

	//default constructor with array length 10
	public MyIntArray()
	{
		this.myArray = new int[10]; 
		for (int i = 0; i < myArray.length; i++)
		{
			myArray[i] = 0; 
		}
	}

	//constructor that creates an array from an array parameter
	public MyIntArray (int[] anArray)
	{
		this.myArray = new int[anArray.length]; 
		for (int i = 0; i < anArray.length; i ++)
		{
			this.myArray[i] = anArray[i]; 
		}

	}

	//constructor that creates an array with any length
	public MyIntArray(int array_size)
	{
		this.myArray = new int[array_size]; 
	}

	//constructor that creates an array with any length setting all the intital values to a chosen value
	public MyIntArray(int array_size , int init_val)
	{
		this.myArray = new int[array_size]; 
		for (int i = 0; i < myArray.length; i++)
		{
			myArray[i] = init_val; 
		}
	}

//getter for the length of myArray, needed to find length if called on an object
	public int getLength() 
		{
			return myArray.length;
		}
	
//getter that retrieves the value at a certain index value of your object
	public int Get(int index) 
	{
		if (index < this.myArray.length)
		{
			return myArray[index]; 
		}
		else
			System.exit(0);
		return 0; 
	}

	//Sets a value at a certain index of your object to a certain value
	public void Set(int index, int value)
	{
		if (index < this.myArray.length)
		{
			myArray[index] = value; 
		}
		else 
		{
			System.out.println("Sorry this is out of bounds");
		}
	}

	//takes in array and the current object, adds them together, and saves them to the name of the current object.
	public void Append(MyIntArray anArray)
	{
		//get lengths of both arrays
		int anArrayLength = anArray.getLength();
		int myArrayLength = myArray.length;
		
		//create the newarray as long as both arrays added together
		int[] newArray = new int[anArrayLength + myArrayLength];
		
		int temp = 0; 
		
		//in a for loop, save the values from the object's array and save them to the first values of the new array
		for (int i = 0; i < myArrayLength; i++)
		{
			 temp = myArray[i];
			 newArray[i] = temp;;
		}

		//move to the first open space in the combined array and save the input from the parameter array until the combined array is full
		for (int i = myArrayLength; i < myArrayLength + anArrayLength; i++)
		{
			newArray[i] = anArray.Get(anArray.Get(i-myArrayLength));
		}
	//create another instance of myArray and save all the values of the combined array to it. 
		this.myArray = new int[newArray.length]; 
		for (int i = 0; i < myArray.length; i ++)
		{
			myArray[i] = newArray[i]; 
		}
	}

	//check if the values in two objects' arrays are the same at every index value
	public boolean equal(MyIntArray anArray)
	{
		boolean equals = true;
		for (int i = 0; i < anArray.getLength(); i++)
		{
			//if index is greater than one of the arrays, they're not equal
			if (myArray.length != anArray.getLength())
			{
				equals = false;
				break; 
			}
			//check each individual index space for the same value, if one does not correspond, they're the same.
			else if (anArray.Get(i) != myArray[i])
			{
				equals = false; 
			}
		}
		return equals; 
	}

	//The bubblesort algorithm that loops through as many times as the length of the array
	//and compares two adjacent values and compares them, moving the smaller one to the smaller index,
	//until everything is sorted
	public void BubbleSort(MyIntArray SomeArray)
	{
		int temp = 0; 
		for(int i= SomeArray.getLength(); i >= 0; i--)
		{
			for(int j=0; j < SomeArray.getLength()-1; j++)
			{
				if(SomeArray.Get(j) >= SomeArray.Get(j+1))
				{
					temp = SomeArray.Get(j);
					SomeArray.Set(j, SomeArray.Get(j+1));
					SomeArray.Set(j + 1, temp);
				}
			}
			
		}
		//SomeArray.PrintArray();
	}

	//Print the array from the object
	public void PrintArray()
	{
		for (int i =0; i < myArray.length; i ++)
		{
			System.out.println("The value at index " + i + " is " + myArray[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Create one instance of the object
		MyIntArray anArray = new MyIntArray(10); 
		
		anArray.Set(0,8);
		anArray.Set(1,2);
		anArray.Set(2,7);
		anArray.Set(3,4);
		anArray.Set(4,5);
		anArray.Set(5,1);
		anArray.Set(6,1);
		anArray.Set(7,2);
		anArray.Set(8,3);
		anArray.Set(9,6);
		
		//Test the bubble sort
//		anArray.BubbleSort(anArray); 
//		anArray.PrintArray();
		
		//Test the Append
//		MyIntArray Array2 = new MyIntArray(5); 
//		Array2.Set(0,4);
//		Array2.Set(1,4);
//		Array2.Set(2,4);
//		Array2.Set(3,4);
//		Array2.Set(4,1);
//		
//		anArray.Append(Array2);
//		anArray.PrintArray();
		
		
		//Test the equal method
MyIntArray anotherArray = new MyIntArray(10); 
		
		anotherArray.Set(0,8);
		anotherArray.Set(1,2);
		anotherArray.Set(2,7);
		anotherArray.Set(3,4);
		anotherArray.Set(4,5);
		anotherArray.Set(5,1);
		anotherArray.Set(6,1);
		anotherArray.Set(7,2);
		anotherArray.Set(8,3);
		anotherArray.Set(9,6);
//		anotherArray.Set(10,6);	
//		anotherArray.Set(9,4);
//		
	System.out.println(anArray.equal(anotherArray));
		
//		for(int i = 0; i < 10; i++)
//		{
//			anArray.Set(i,i);
//			anArray.PrintArray();
//		}

//		int[] Lolray = new int[10]; 
//		Lolray[0] = 0;
//		Lolray[1] = 1;
//		Lolray[2] = 2;
//		Lolray[3] = 1;
//		Lolray[4] = 7;
//		Lolray[5] = 5;
//		Lolray[6] = 2;
//		Lolray[7] = 8;
//		Lolray[8] = 6;
//		Lolray[9] = 3;
	}

}

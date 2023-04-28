import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;


public class lab13 {
	
	java.util.ArrayList<Integer> inputList = new java.util.ArrayList<Integer>();
	
//	This program reads the input file and stores the values in an
//	ArrayList<Integer>
//	– We are going to use the ArrayList.stream methods to do some stream
//	stuff
//	– You will need a ArrayList<Integer> field that is accessable to your class's
//	methods
	public void readData(String inputFile)
	{
		try 
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFile)));
			
			String inn;

			while( (inn = input.readLine()) != null )
	        {
				// convert the input to an integer 
				int inputInt = Integer.parseInt(inn.trim());// Trim()?
				
				// add it to the array list
				inputList.add(inputInt);
	        }
			
			input.close();
		} 
		catch (Exception e) 
		{	
		}
	}
	
	
//	Use a stream to return the number of values in the ArrayList
	public long getTotalCount()
	{
		return inputList.stream().count();
	}
	
//	Use a stream to return the number of odd values in the ArrayList
	public long getOddCount()
	{
		return inputList.stream().filter(x -> x % 2 == 1).count();
	}
	
//	Use a stream to return the number of even values in the ArrayList
	public long getEvenCount()
	{
		return inputList.stream().filter(x -> x % 2 == 0).count();
	}
	
//	Use a stream to return the number of distinct values greater than 5 in the
//			ArrayList
	public long getDistanceGreaterThanFiveCount()
	{
		return inputList.stream().distinct().filter(x -> x > 5).count();
	}
	
//	Use a stream to return the even values greater than 5 and less than 50 in
//	sorted order in the ArrayList as an Integer[]
	public Integer[] getResult()
	{
		return inputList.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}

//	– Use a stream to return the first 50 of the values in the ArrayList after
//	squaring each of the values and multiplying by 3 as an Integer[]
	public Integer[] getResult2()
	{
		return inputList.stream().limit(50).map(x -> x * x * 3).toArray(Integer[]::new);
	}

	
////– Use a stream to filter out the even values (or keep the odd values),
////multiply the remaining values by 2, sorting the values, skipping over the
////first 20 elements, and removing duplicate values from the ArrayList, and
////return the values as an Integer[]
	public Integer[] getResult3()
	{
		return inputList.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
 	}
	
}

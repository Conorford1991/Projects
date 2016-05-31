// Binary search is O(log n) as it half the elements to be searched each interation. 
import java.util.*;

class BinarySearch{
	public static void main(String []args){
		// create array
		int[] array = new int[1000000];
		// key to find
		int key = 16384;
		// populate array
		for(int i=0; i<1000000; i++){
			array[i] = i;
			//System.out.println(i);
		}
		// start timer
		long startTime = System.nanoTime();
		// function call
		BinarySearch(key,array);
		// end timer
		long endTime = System.nanoTime();
                // duration result
                long duration = (endTime - startTime);
                System.out.println(duration);
	}
	public static void BinarySearch(int key, int[] array){
		// position
		int position;
		// upperbound
		int upperbound = array[999999];
		// lowerbound
		int lowerbound = array[0];
		// postion is half of array index
		position = (lowerbound+upperbound)/2;
		
		while(array[position] != key && lowerbound <= upperbound){
			if(array[position] > key){
				// move upperbound down
				upperbound = position -1;
			}
			else if(array[position] < key){
				// move lowerbound up
				lowerbound = position +1;
			}
			// reset position
			position = (lowerbound+upperbound)/2;
		}
		// result
		if(lowerbound <= upperbound){
			System.out.println("Key was found at position: "+position);
		}
	}
}

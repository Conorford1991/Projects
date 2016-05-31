// Binary search is O(log n) as it halves the elements to be searched each interation. 
import java.util.*;

class BinarySearch{
	public static void main(String []args){
		int max = 1000000;
		// create array
		int[] array = new int[max];
		// key to find
		int key = 16384;
		// populate array
		for(int i=0; i<max; i++){
			array[i] = i;
			//System.out.println(i);
		}
		// start timer
		long startTime = System.nanoTime();
		// function call
		BinarySearch(key,array,max);
		// end timer
		long endTime = System.nanoTime();
                // duration result
                long duration = (endTime - startTime);
                System.out.println("Time: "+duration+" ns");
	}
	public static void BinarySearch(int key, int[] array,int max){
		// count variable
		int count=0;
		// position
		int position;
		// upperbound
		int upperbound = array[max-1];
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
			// count iterations
			count++;
		}
		// result
		if(lowerbound <= upperbound){
			System.out.println("Key was found at position: "+position);
			System.out.println("Iterations: "+count);
		}
	}
}

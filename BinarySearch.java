import java.util.*;
// O (log n)
// As binary search reduces the searchable elements by half each time so the performance is O(log n)

class BinarySearch{
	public static void main(String[] args){
		// max value
		int max = 9;
		// Value to be searched
		int key = 6;
		// Create array
		int[] array = new int [10];
		// Fill array
		for(int i=0; i<10; i++){
			array[i] = i;
			System.out.println(i);
		}
		BinarySearch(array,key,max);
	}
	public static void BinarySearch(int[] array, int key, int max){
		// lowerbound
		int lowerbound = array[0];
		// upperbound
		int upperbound = array[max];
		// index positon
		int position;
		
		position = (lowerbound+upperbound)/2;
		
		while(array[position] != key && lowerbound <= upperbound){
			if(array[position] > key){
				upperbound = position -1;
			}
			else if(array[position] < key){
				lowerbound = position +1;
			}
			position = (lowerbound+upperbound)/2;
		}
		if(lowerbound <= upperbound){
			System.out.println("Key was found at position: "+position);
		}
	} 
}

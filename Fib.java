// Author: Conor Ford
import java.util.*;

class Fib{
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter value: ");
		int n = in.nextInt();
		
		int x = FibRecursive(n);
		System.out.println("Recursive: "+x);
		
		int y = FibIterative(n);
		System.out.println("Iterative: "+y);
	}
	static int FibRecursive(int n){
		if(n == 0)
			return 0; // end condition
			else if(n == 1)
				return 1;
				else if(n > 1)
					return (FibRecursive(n-1)+FibRecursive(n-2));
					else 
						return -1; // error condition 
	}
	static int FibIterative(int n){
	
		if(n < 0)
			return -1; // error condition
			else if(n == 0)
				return 0; // end condition
				else if(n == 1)
					return 1;
				
				int a = 1;
		        int b = 1 ;
				for(int i=3; i<=n; i++){
					int temp = a+b;
					a = b; 
				    b = temp; 
				}
				return b; 
}
}
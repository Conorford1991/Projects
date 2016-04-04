import java.util.*;

class Factorial{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter value: ");
		int n = in.nextInt();
		
		int x = fac(n);
		System.out.print(x);
	}
	static int fac(int n){
		if(n==0)
			return 1;
			else
				return(n*fac(n-1));
	}
}
// Author: Conor Ford
#include <iostream>
#include <math.h>
#include <vector>
using namespace std;



int Prime(){
    // Fermat's Theorem
    // Choose an integer value for a such that 2 ≤ a ≤ n - 1.
    // If a^n (mod n) = a (mod n), then n is likely prime.
    
    int n=0;
    int a=2;
    int aPOWn=0;
    
    for(int i=0; i<1000; i++){
    
    cout<<"Enter value: "<<endl;
    cin>>n;
    
    /// Equation: 
    /// if(a^n(% n) == a(% n)
    
    aPOWn = pow(a,n); ///a^n 
    int aPOWnMODn = aPOWn % n;  ///(a^n(% n)
    int aMODn  =a % n; ///a(% n)
    
    if(aPOWnMODn == aMODn && n>3){
        cout<<n<<" is a Prime."<<endl;
    }
    else if(aPOWnMODn != aMODn && n>3){
        cout<<n<<" is not a Prime."<<endl;
    }
    }
    
    ///All numbers that fail this test are composite (non-prime), 
    //but unfortunately numbers that pass this test are only likely primes. 
    //If you want to be sure of avoiding false positives, look for n on a list 
    //of "Carmichael numbers" (which pass this test every time)
}

};

int main(){
    
    Prime();
    
    return 0;
}

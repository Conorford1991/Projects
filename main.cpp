// Author: Conor Ford
#include <iostream>
#include <cstdlib>
#include <ctime> // access computer clock
#include <cmath>
#include <cstdio>// timer

using namespace std;

double MonteCarlo(int n){
    
    int DartsInCircle;
    srand(time(0)); // truely random numbers by changing random alogorithm
    
    clock_t start;
    double duration;
    
    start=clock();
    
    for(int i=0; i<n; i++){
        
        double x = rand () / ( double ) RAND_MAX;
        double y = rand () / ( double ) RAND_MAX;
        
        if(sqrt ( x * x + y * y ) < 1){
            DartsInCircle++;
        }
    }
    duration = ( clock() - start ) / (double) CLOCKS_PER_SEC;

    cout<<"Duration: "<< duration <<" seconds"<<endl;
    
    cout<<"Darts in circle: "<<DartsInCircle<<" out of "<<n<<endl;
    // converts int (n) into a double, DartsInCircle/Darts thrown*4 (sections))
    return DartsInCircle/static_cast <double >(n ) * 4;
}

int main(){
    
    cout<<MonteCarlo(5000000)<<endl;
    return 0;
}

#include <iostream>
#include <cstdlib>
#include <ctime> // access computer clock
#include <cmath>
#include <cstdio>// timer

using namespace std;

int sum(int a, int b){
   return a+b; 
}

int sumArray(int array[], int max){
    int sum=0;
    for(int i=0; i<max; i++){
        sum+=array[i];
    }
    return sum;
}

int printArray(const int array[], const int max){
    for(int i=0; i<max; i++){
        cout<<array[i];
        if(i<max-1){
            cout<<",";
        }
    }
}

void Pointer(){
    int num=10;
    int* Ptr = &num; // allocates  memory address to pointer
    
    cout<<"Address of pointer: "<<Ptr<<endl;
    cout<<"Data at memory address: "<<*Ptr<<endl; //deallocates memory address
    
}

int swap(int &x, int &y){
    int temp;
    temp=x;
    x=y;
    y=temp;
}

double MonteCarlo(int n){
    
    int DartsInCircle;
    srand(time(0)); // truly random numbers  by changing random alogorithm
    
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
    //cout<<sum(2,2);
    
    //int testArray[]{1,2,3,4};
    //sumArray(testArray,5);
    //printArray(testArray,5);
    
    //Pointer();
    
    cout<<MonteCarlo(5000000)<<endl;
    
    

    
    
    
    return 0;
}
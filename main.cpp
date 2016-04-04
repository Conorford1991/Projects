//Exponential Inflation

#include <iostream>

using namespace std;

int main(){
    
    int input = 0;
    int max = 0;
    
    cout<<"Input a value to increase exponentially: "<<endl;
    cin>>input;
    cout<<"Input max value to increase too: "<<endl;
    cin>>max;
    
    for(int i=0; i<max; i++){
        if(input <= max){
            input=input*2;
            cout<<input<<endl;
            
            if(input >= max){
                cout<<"Calculation complete."<<endl;
                break;
                
            }
        }
    }
    
    return 0;
}
        
#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

int userIn(){
    int input = 0;
    int choice = 0;
    
    cout<<"Enter value: "<<endl;
    cin>>input;
    
    cout<<"1 for add, 2 for multiply, 3 for subtract, 4 to quit"<<endl;
    cin>>choice;
    
    while(choice != 4){
    
        if(choice == 1){
        input=input+input;
        cout<<input;
        break;
    }
    
        else if(choice == 2){
        input=input*2;
        cout<<input;
        break;
    }
    
        else if(choice == 3){
        input=input-4;
        cout<<input;
        break;
    }
    
        else if(choice == 4){
        cout<<"You choose to exit."<<endl;
        break;
    }
        
    }
}

int N(){
    int N = 0;
    
    cout<<"Enter value: "<<endl;
    cin>>N;
    
    for(int i=5; i<N; i++){
        i=i*3;
        cout<<"Cubed: "<<i<<endl;
    }
 
}

int Nfac(){
    int n=0;
    int p=1;
    
    cout<<"Enter value: "<<endl;
    cin>>n;
    
    for(int i=1; i<=n; i++){
        p=p*i;
    }
    cout<<n<<"! = "<<p;
    
}

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

int triple(){
    int n=0;
    
    for(int i=0; i<1000; i++){
    
    cout<<"Enter value, -999 exits: "<<endl;
    cin>>n;
    
    if(n == -999){
        cout<<"Exited"<<endl;
        break;
    }
    else{
        cout<<"You entered: "<<n<<endl;
        int n3=n*3;
        cout<<"It's triple is: "<<n3<<endl;
    }
    
    }
       
}
int positive(){
    int n=0;
    int count=0;
    int sum=0;
    int ave=0;
    
    for(int i=0; i<1000; i++){
    
    cout<<"Enter positive value: "<<endl;
    cin>>n;
    
    if(n>0){
        cout<<"Entered: "<<n<<endl;
        count++;
        sum=sum+n;
        
    }
    else if(n<=0){
        cout<<"You entered: "<<count<<" numbers"<<endl;
        ave=sum/count;
        cout<<"Average is: "<<ave<<endl;
        break;
    }
    
    }
    
    
}

int growth(){
    double CountryA = 20.0;
    double CountryB = 70.0;
    double GrowthA = 0;
    double GrowthB = 0;
    
    for(int i=0; i<1000000; i++){
        if(CountryA<CountryB){
            
            GrowthA = CountryA/100*3;
            GrowthB = CountryB/100*2;
            CountryA=CountryA+GrowthA;
            CountryB=CountryB+GrowthB;
            cout<<"Country A: "<<CountryA<<" after year "<<i<<endl;
            cout<<"Country B: "<<CountryB<<" after year "<<i<<endl;
        }
        else if(CountryA>CountryB){
            cout<<"Country A will surpass Country B in: "<<i<<" years"<<endl;
            cout<<"Country A: "<<CountryA<<" million people"<<" Country B: "<<CountryB<<" million people"<<endl;
            break;
        }
    }
    
    
}

int sumSquared(){
    int N;
    int square;
    int sum;
    
    cout<<"Input value: "<<endl;
    cin>>N;
    cout<<"You input: "<<N<<endl;
    
    for(int i=0; i<=N; i++){
        square=i*i;
        sum=sum+square;
        
        cout<<"Squared values: "<<square<<endl;
        
    }
    cout<<"Sum: "<<sum<<endl;
}

void Newton(){
    double t;
    double h;
    double g = 9.81;
    
    cout<<"Input height: "<<endl;
    cin>>h;
    
    t=2*h/g;
    t=t*0.5;
    
    cout<<"Time: "<<t<<endl;
}
void weight(){
    double w;
    double charge;
    
    for(int i=0; i<1000; i++){
    
    cout<<"Input weight kg: "<<endl;
    cin>>w;
    
    if(w<=2.0){
        charge=3.25;
        cout<<"Cost: "<<charge<<" euros"<<endl;
    }
    else if(w>2){
        charge=3.25;
        w=w-2;
        w=w*1.05;
        charge=charge+w;
        cout<<"Cost: "<<charge<<" euros"<<endl;
    }
    }
}

void EasterCal(){
    
    int M;
    int D;
    
    for(int i=0; i<100; i++){
    
    int T;
    cout<<"Enter year: "<<endl;
    cin>>T;
    
    
    int k = T/100;
    int a = T % 19;
    int b = T /100;
    int c = T % 7;
    int q =  k/4 ;
    int p = (13 + 8*k) / 25;
    int m= (15- p + k - q) % 30;
    int d = (19*a + m) % 30; 
    int n = (4 + k - q) % 7;
    int e = (2*b + 4*c + 6*d + n) % 7; 
    
    if(d+e <= 19){
         D = 22+d+e;
         M = 3;
    }
    else if(d == 29 && e == 6 ){
         D = 19;
         M = 4;
    }
    else if(d == 28 && e == 6 && a > 10){
        D=18;
        M=4;
    }
    else{
        D=d+e-9;
        M=4;
    }
    
    cout<<"Day: "<<D+2<<endl;
    cout<<"Month: "<<M<<endl;
    
    }
}

class Triangle{
    
private:
    double x0,y0,x1,y1,x2,y2;
    
public:
    Triangle(double newX0=0,double newY0=0,double newX1=0,double newY1=0,double newX2=0,double newY2=0){
        x0=newX0;
        x1=newX1;
        x2=newX2;
        y0=newY0;
        y1=newY1;
        y2=newY2;
    }
    
    double getPoints(){
       
        cout<<"Point 1: "<<x0<<", "<<y0<<endl;
        cout<<"Point 2: "<<x1<<", "<<y1<<endl;
        cout<<"Point 3: "<<x2<<", "<<y2<<endl;
        return x0,y0,x1,y1,x2,y2;
    }
    
    double setPoint1(double newX0,double newY0){
        x0=newX0;
        y0=newY0;
    }
    
    double setPoint2(double newX1,double newY1){
        x1=newX1;
        y1=newY1;
    }
    
    double setPoint3(double newX2,double newY2){
        x2=newX2;
        y2=newY2;
    }
};

int main(){
    //userIn();
    //N(); 
    //Nfac();
    //Prime();
    //triple();
    //positive();
    //growth();
    //sumSquared();
    //Newton();
    //weight();
    //EasterCal();
    
    /*Triangle t(1.0,2.0,3.0,4.0,5.0,6.0);
    t.getPoints();
    t.setPoint1(5.6,5.4);
    t.getPoints();*/
    return 0;
}
// Author: Conor Ford
import java.util.*;

class Scheduler{
	public static void main(String[]args){
		
		int slot=0;
		Scanner in = new Scanner(System.in);
		
		ArrayList<Patient> patientList = new ArrayList<Patient>(); //new ArrayList
		Patient patient = new Patient(); // new Patient class instance
		
		
		while(slot != 16){
			
		System.out.println("Press 1 to enter a new patient, 0 to exit");
		int p = in.nextInt();
		in.nextLine(); // consumes the nextInt() so it doesn't skip nextLine()
		
		if(p == 1){
		
		System.out.println("Enter name: ");
		String name = in.nextLine();
		patient.setName(name);
		
		System.out.println("Enter gender: ");
		String gender = in.nextLine();
		patient.setGender(gender);
		
		System.out.println("Enter age: ");
		int age = in.nextInt();
		in.nextLine(); // consumes the nextInt() so it doesn't skip nextLine()
		patient.setAge(age);
		
		slot=slot+1;
		patient.setSlot(slot);
		
		patientList.add(patient);
		}
		else if(p == 0){
			break;
		}
		
		}
		System.out.println("Press 1 to search listings, 0 to exit");
		int find = in.nextInt();
		
		if(find == 1){
			System.out.println("Press index number to find: ");
		    int i = in.nextInt();
		    
		    String selectedName = patientList.get(i).getName(); // get at array index
		    String selectedGender = patientList.get(i).getGender();
		    int selectedAge = patientList.get(i).getAge();
		    int selectedSlot = patientList.get(i).getSlot();
		}
		else if(find == 0){
			System.out.println("Exited program");
		}
	}
}

class Patient{
	String name;
	int age; 
	String gender;
	int slot;
	
	void setName(String name){
		this.name = name;
	}
	void setGender(String gender){
		this.gender = gender;
	}
	void setAge(int age){
		this.age = age;
	}
	void setSlot(int slot){
	    this.slot = slot;
	}
	String getName(){
		System.out.println("Name: "+name);
		return name;
	}
	String getGender(){
		System.out.println("Gender: "+gender);
		return gender;
	}
	int getAge(){
		System.out.println("Age: "+age);
		return age;
	}
	int getSlot(){
		if(slot == 1){
			System.out.println("Slot "+slot+" 8:00");
		}
		else if(slot == 2){
			System.out.println("Slot "+slot+" 8:30");
		}
		else if(slot == 3){
			System.out.println("Slot "+slot+" 9:00");
		}
		else if(slot == 4){
			System.out.println("Slot "+slot+" 9:30");
		}
		else if(slot == 5){
			System.out.println("Slot "+slot+" 10:00");
		}
		else if(slot == 6){
			System.out.println("Slot "+slot+" 10:30");
		}
		else if(slot == 7){
			System.out.println("Slot "+slot+" 11:00");
		}
		else if(slot == 8){
			System.out.println("Slot "+slot+" 11:30");
		}
		else if(slot == 9){
			System.out.println("Slot "+slot+" 12:00");
		}
		else if(slot == 10){
			System.out.println("Slot "+slot+" 12:30");
		}
		else if(slot == 11){
			System.out.println("Slot "+slot+" 13:00");
		}
		else if(slot == 12){
			System.out.println("Slot "+slot+" 13:30");
		}
		else if(slot == 13){
			System.out.println("Slot "+slot+" 14:00");
		}
		else if(slot == 14){
			System.out.println("Slot "+slot+" 14:30");
		}
		else if(slot == 15){
			System.out.println("Slot "+slot+" 15:00");
		}
		else if(slot == 16){
			System.out.println("Slot "+slot+" 15:30");
		}
		else if(slot == 17){
			System.out.println("Slot "+slot+" 16:00");
		}
		else if(slot == 18){
			System.out.println("Slot "+slot+" 16:30");
		}
		else if(slot == 19){
			System.out.println("Slot "+slot+" 17:00");
		}
		return slot;
	}
}
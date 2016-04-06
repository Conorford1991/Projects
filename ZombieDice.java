// Author: Conor Ford
import java.util.*;

class ZombieDice{
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		System.out.println("/////////////////////////");
		System.out.println("Welcome to Zombie Dice!!!");
		System.out.println("Enter 1 to roll");
		
		int n = in.nextInt();
		
		while(n != 1){
			
			if(n == 1){
			System.out.println("Rolling");
		    }
		    else
			System.out.println("Enter 1 to begin");
		}
		
		
		
		int Shotguns = 0;
        int Footprints = 0;
        int Brains = 0;
        int Turn = 0;
        
        for(int i=0; i<1000; i++){
        
        // Red = 1, Yellow = 2, Green = 3
		int d1 = (int)(Math.random()*3+1);
		int d2 = (int)(Math.random()*3+1);
		int d3 = (int)(Math.random()*3+1);
		
		int D1side = (int)(Math.random()*6+1);
		int D2side = (int)(Math.random()*6+1);
		int D3side = (int)(Math.random()*6+1);
		
	
		// Dice one: Red Dice
		// Side 1,4,5 = Shotgun
		// Side 2,6 = Footprint
		// Side 3 = Brain
		        if(d1 == 1){
		
		      	if(D1side == 1 ||D1side == 4||D1side == 5){
				Shotguns = Shotguns+1;
				System.out.println("Red Dice-Shotguns, He fought back!");
		      	}
				else if(D1side == 2||D1side == 6){
					Footprints = Footprints+1;
					System.out.println("Red Dice-Footprints, Your victim escaped");
				}
					else if(D1side == 3){
					    Brains = Brains+1;
					    System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					}
		      }
			
		// Dice one: Yellow Dice 	
		// Side 1,4 = Shotgun
		// Side 2,5 = Footprint
		// Side 3,6 = Brain
				
				if(d1 == 2){
					
				if(D1side == 1||D1side == 4){
				Shotguns = Shotguns+1;
				System.out.println("Yellow Dice-Shotguns, He fought back!");
				  }
				  else if(D1side == 2||D1side == 5){
				    Footprints = Footprints+1;
					System.out.println("Yellow Dice-Footprints, Your victim escaped");
				  }
					  else if(D1side == 3||D1side == 6){
					    Brains = Brains+1;
					    System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					  }
				}
		
		// Dice one: Green Dice
		// Side 1 = Shotgun
		// Side 2,4 = Footprint
		// Side 3,5,6 = Brain
		
				if(d1 == 3){
				
				if(D1side == 1){
				   Shotguns = Shotguns+1;	
				   System.out.println("Green Dice-Shotguns, He fought back!");
				}
				  else if(D1side == 2||D1side == 4){
				    Footprints = Footprints+1;
					System.out.println("Green Dice-Footprints, Your victim escaped");
				  }
					 else if(D1side == 3||D1side == 5||D1side == 6){
					    Brains = Brains+1;
					    System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					 }
				}
		
		
		// Dice two: Red Dice
		// Side 1,4,5 = Shotgun
		// Side 2,6 = Footprint
		// Side 3 = Brain
		      
		      if(d2 == 1){
		      	
		      	if(D2side == 1 ||D2side == 4||D2side == 5){
		      	Shotguns = Shotguns+1;
				System.out.println("Red Dice-Shotguns, He fought back!");
		      	}
				else if(D2side == 2||D2side == 6){
					Footprints = Footprints+1;
					System.out.println("Red Dice-Footprints, Your victim escaped");
				}
					else if(D2side == 3){
					    Brains = Brains+1;
					    System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					}
		      }
					
		// Dice two: Yellow Dice	
		// Side 1,4 = Shotgun
		// Side 2,5 = Footprint
		// Side 3,6 = Brain
				
				if(d2 == 2 ){
					
				if(D2side == 1||D2side == 4){
				Shotguns = Shotguns+1;
				System.out.println("Yellow Dice-Shotguns, He fought back!");
				}
				  else if(D2side == 2||D2side == 5){
				    Footprints = Footprints+1;
					System.out.println("Yellow Dice-Footprints, Your victim escaped");
				  }
					  else if(D2side == 3||D2side == 6){
					    Brains = Brains+1;
					    System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					  }
				}
					  
		// Dice two: Green Dice	
		// Side 1 = Shotgun
		// Side 2,4 = Footprint
		// Side 3,5,6 = Brain
		
				if(d2 == 3){
				
				if(D2side == 1){
				   Shotguns = Shotguns+1;	
				   System.out.println("Green Dice-Shotguns, He fought back!");
				}
				  else if(D2side == 2||D2side == 4){
				    Footprints = Footprints+1;
					System.out.println("Green Dice-Footprints, Your victim escaped");
				  }
					 else if(D2side == 3||D2side == 5||D2side == 6){
					    Brains = Brains+1;
					    System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					 }
				}
		// Dice three: Dice Red	
		// Side 1,4,5 = Shotgun
		// Side 2,6 = Footprint
		// Side 3 = Brain
		      
		      if(d3 == 1){
		      	
		      	if(D3side == 1 ||D3side == 4||D3side == 5){
		      	Shotguns = Shotguns+1;
				System.out.println("Red Dice-Shotguns, He fought back!");
		      	}
				else if(D3side == 2||D3side == 6){
					Footprints = Footprints+1;
					System.out.println("Red Dice-Footprints, Your victim escaped");
				}
					else if(D3side == 3){
					    Brains = Brains+1;
					    System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					}
		      }
			
		// Dice three: Yellow Dice	
		// Side 1,4 = Shotgun
		// Side 2,5 = Footprint
		// Side 3,6 = Brain
				
				if(d3 == 2 ){
					
				if(D3side == 1||D3side == 4){
				Shotguns = Shotguns+1;
				System.out.println("Yellow Dice-Shotguns, He fought back!");
				}
				  else if(D3side == 2||D3side == 5){
				    Footprints = Footprints+1;
					System.out.println("Yellow Dice-Footprints, Your victim escaped");
				  }
					  else if(D3side == 3||D3side == 6){
					    Brains = Brains+1;
					    System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					  }
				}
		// Dice three: Green Dice	
		// Side 1 = Shotgun
		// Side 2,4 = Footprint
		// Side 3,5,6 = Brain
		
				if(d3 == 3){
				
				if(D3side == 1){
				   Shotguns = Shotguns+1;	
				   System.out.println("Green Dice-Shotguns, He fought back!");
				}
				  else if(D3side == 2||D3side == 4){
				    Footprints = Footprints+1;
					System.out.println("Green Dice-Footprints, Your victim escaped");
				  }
					 else if(D3side == 3||D3side == 5||D3side == 6){
					    Brains = Brains+1;
					    System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
					 }
				}
					Turn++;
					
					System.out.println("/////////////////////////////");
					System.out.println("Turn: "+Turn);
					System.out.println("Shotguns total: "+Shotguns);
					System.out.println("Footprints total: "+Footprints);
					System.out.println("Brains total: "+Brains);
					
					// Game Rules
					if(Shotguns >= 3){
						System.out.println("/////////////////////////////");
						System.out.println("Booooomm.....your dead. ");
						System.out.println("Shotguns: "+Shotguns+" ,turn over, no score.");
						System.out.println("Other player wins. Press 1 to play again, 0 to exit");
						int y = in.nextInt();
						
						if(y == 1){
							System.out.println("/////////////////////////////");
							System.out.println("Playing again");
							Turn=0;
							Shotguns=0;
							Footprints=0;
							Brains=0;
							
						}
						else if(y == 0){
							System.out.println("/////////////////////////////");
							System.out.println("Exiting");
							break;
						}
					}
					if(Brains >= 13){
						System.out.println("/////////////////////////////");
					    System.out.println("Brains: "+Brains+", you win!!!!");
					    System.out.println(" Press 1 to play again, 0 to exit");
						int z = in.nextInt();
					    
					    if(z == 1){
					    	System.out.println("/////////////////////////////");
							System.out.println("Playing again");
							Turn=0;
							Shotguns=0;
							Footprints=0;
							Brains=0;
							
						}
						else if(z == 0){
							System.out.println("/////////////////////////////");
							System.out.println("Exiting");
							break;
						}
					}
					// Continue or end
					System.out.println("/////////////////////////////");
					System.out.println("Press 1 to continue, 0 to stop & score or 2 to exit game.");
					int x = in.nextInt();
					
					// The footprint dice/dices remains as part of the 3 dice on the re-roll, so its value is reset. 
					if(x == 1 && Shotguns < 3){
						Footprints = 0;
						System.out.println("/////////////////////////////");
						System.out.println("Rolling again");
						}
						else if(x == 0 && Shotguns < 3){
							System.out.println("/////////////////////////////");
							System.out.println("Ended turn, you have: "+Brains+" brains = "+Brains+" points.");
							System.out.println("Next players turn");
							    Turn=0;
								Shotguns=0;
								Footprints=0;
								Brains=0;
						}
						else if(x == 2&& Shotguns < 3){
							System.out.println("/////////////////////////////");
							System.out.print("Exited game");
								break;
						}
                      }
						
	                }
	
	           }
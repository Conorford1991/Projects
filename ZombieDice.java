
package zombiedice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Conor
 */
public class ZombieDice extends Application {
    public GridPane gp;
    public StackPane sp;
    public HBox hb;
    public VBox vb;
    public VBox vbButtons;
    // Buttons
    public Button RollBtn;
    public Button EndTurnBtn;
    public Button RollAgainBtn;
    public Button EndGameBtn;
    public Button PlayAgainBtn;
    // Variables
    public int Shotguns;
    public int Footprints;
    public int Brains;
    public int Turn;
    
    // Labels
    public Label ShotgunLabel;
    public Label FootprintLabel;
    public Label BrainLabel;
    public Label TurnLabel;
    public Label EndTurn;
   
    DiceRoll DiceRollobject = new DiceRoll();  // object of DiceRoll class
    
    @Override
    public void start(Stage primaryStage) {
        sp = new StackPane();
        hb = new HBox();
        vb = new VBox();
        vbButtons = new VBox();
        Turn = 1;
        
        // ****Add every style change after image implementation
        // Add image to stackpane
        Image img = new Image("zombiedice/ZombieBackground.jpg");
        ImageView imgView = new ImageView();
        imgView.setImage(img);
        sp.getChildren().add(imgView);
        
        // add hbox to stack pane
        sp.getChildren().add(hb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        
        // add vbox to stack pane
        sp.getChildren().add(vb);
        
        // add vbox buttons to stack pane
        sp.getChildren().add(vbButtons);
        vbButtons.setAlignment(Pos.TOP_RIGHT);
  
        Scene scene = new Scene(sp, 800, 700); // Horizontal, vertical
      
        primaryStage.setTitle("Zombie Dice");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // member function calls
        RollButton();
      
    }

    public static void main(String[] args) {
        launch(args);
 
    }
    public void RollButton(){
        RollBtn = new Button("Roll dice");
       
        //  roll button
        sp.getChildren().add(RollBtn);
        RollBtn.setAlignment(Pos.CENTER);
        
        RollBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            // DiceOneRules method call
            DiceOneRules();
            DiceTwoRules();
            DiceThreeRules();
            Display();
            RollAgainButton();
            EndTurnButton();
            GameRules();
            sp.getChildren().remove(RollBtn);
     
        }
            
        });
        
    }
    public void RollAgainButton(){
            RollAgainBtn = new Button("Roll again");
            // Roll again button
            vbButtons.getChildren().add(RollAgainBtn);
            RollAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            hb.getChildren().clear();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Rolling again");
            alert.setHeaderText(null);
            alert.setContentText("Rolling again");
            alert.showAndWait();
            
            clear();
            // Footprints are re-rolled so footprints = 0
            Footprints = 0;
            Turn = Turn+1;
            RollButton();
            }
        });
    }
    public void EndTurnButton(){
            EndTurnBtn = new Button("End Turn");
            // End turn button
            vbButtons.getChildren().add(EndTurnBtn);
            EndTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            hb.getChildren().clear();
            
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turn ended");
            alert.setHeaderText(null);
            alert.setContentText("Player ended turn");
            alert.showAndWait();
          
            Reset();
            clear();
            EndGame();
            }
        });
    }
    public void DiceOneRules(){
        // method call
        DiceRollobject.DiceOneRoll();
        DiceRollobject.DiceOneSide();
        
        int dice1 = DiceRollobject.dice1;
        int dice1side = DiceRollobject.dice1side;
     
        // Dice one: Red Dice
	// Side 1,4,5 = Shotgun
	// Side 2,6 = Footprint
	// Side 3 = Brain
        
         if(dice1 == 1){
         if(dice1side == 1 ||dice1side == 4||dice1side == 5){
	 // Shotguns	
	        Shotguns = Shotguns+1;
		System.out.println("Red Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image RedShotgun = new Image("zombiedice/RedShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(RedShotgun);
                hb.getChildren().add(imgView);
         }     	
                        // Footprints
			else if(dice1side == 2||dice1side == 6){
				Footprints = Footprints+1;
				System.out.println("Red Dice-Footprints, Your victim escaped");
                                
                                // Add image to stackpane
                                Image RedFootprint = new Image("zombiedice/RedFootprint.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(RedFootprint);
                                hb.getChildren().add(imgView);
				}
                                // Brains
				else if(dice1side == 3){
					Brains = Brains+1;
					 System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                         
                                         // Add image to stackpane
                                         Image RedBrain = new Image("zombiedice/RedBrain.jpg");
                                         ImageView imgView = new ImageView();
                                         imgView.setImage(RedBrain);
                                         hb.getChildren().add(imgView);
					}
        }
        // Dice one: Yellow Dice 	
	// Side 1,4 = Shotgun
	// Side 2,5 = Footprint
	// Side 3,6 = Brain
	
        if(dice1 == 2){
	if(dice1side == 1||dice1side == 4){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Yellow Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image YellowShotgun = new Image("zombiedice/YellowShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(YellowShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice1side == 2||dice1side == 5){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Yellow Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image YellowFootprint = new Image("zombiedice/YellowFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(YellowFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice1side == 3||dice1side == 6){
                                // Brains
				Brains = Brains+1;
				System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image YellowBrain = new Image("zombiedice/YellowBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(YellowBrain);
                                hb.getChildren().add(imgView);
			}
        }
        // Dice one: Green Dice
	// Side 1 = Shotgun
	// Side 2,4 = Footprint
	// Side 3,5,6 = Brain
        
        if(dice1 == 3 ){
        if(dice1side == 1){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Green Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image GreenShotgun = new Image("zombiedice/GreenShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(GreenShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice1side == 2||dice1side == 4){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Green Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image GreenFootprint = new Image("zombiedice/GreenFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(GreenFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice1side == 3||dice1side == 6||dice1side == 5){
                                // Brains
				Brains = Brains+1;
				System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image GreenBrain = new Image("zombiedice/GreenBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(GreenBrain);
                                hb.getChildren().add(imgView);
			}
        }
	}
    public void DiceTwoRules(){
        // method call
        DiceRollobject.DiceTwoRoll();
        DiceRollobject.DiceTwoSide();
        
        int dice2 = DiceRollobject.dice2;
        int dice2side = DiceRollobject.dice2side;
     
        // Dice two: Red Dice
	// Side 1,4,5 = Shotgun
	// Side 2,6 = Footprint
	// Side 3 = Brain
        
         if(dice2 == 1){
         if(dice2side == 1 ||dice2side == 4||dice2side == 5){
	 // Shotguns	
	        Shotguns = Shotguns+1;
		System.out.println("Red Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image RedShotgun = new Image("zombiedice/RedShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(RedShotgun);
                hb.getChildren().add(imgView);
         }     	
                        // Footprints
			else if(dice2side == 2||dice2side == 6){
				Footprints = Footprints+1;
				System.out.println("Red Dice-Footprints, Your victim escaped");
                                
                                // Add image to stackpane
                                Image RedFootprint = new Image("zombiedice/RedFootprint.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(RedFootprint);
                                hb.getChildren().add(imgView);
				}
                                // Brains
				else if(dice2side == 3){
					Brains = Brains+1;
					 System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                         
                                         // Add image to stackpane
                                         Image RedBrain = new Image("zombiedice/RedBrain.jpg");
                                         ImageView imgView = new ImageView();
                                         imgView.setImage(RedBrain);
                                         hb.getChildren().add(imgView);
					}
        }
        // Dice two: Yellow Dice 	
	// Side 1,4 = Shotgun
	// Side 2,5 = Footprint
	// Side 3,6 = Brain
	
        if(dice2 == 2){
	if(dice2side == 1||dice2side == 4){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Yellow Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image YellowShotgun = new Image("zombiedice/YellowShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(YellowShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice2side == 2||dice2side == 5){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Yellow Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image YellowFootprint = new Image("zombiedice/YellowFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(YellowFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice2side == 3||dice2side == 6){
                                // Brains
				Brains = Brains+1;
				System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image YellowBrain = new Image("zombiedice/YellowBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(YellowBrain);
                                hb.getChildren().add(imgView);
			}
        }
        // Dice two: Green Dice
	// Side 1 = Shotgun
	// Side 2,4 = Footprint
	// Side 3,5,6 = Brain
        
        if(dice2 == 3 ){
        if(dice2side == 1){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Green Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image GreenShotgun = new Image("zombiedice/GreenShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(GreenShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice2side == 2||dice2side == 4){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Green Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image GreenFootprint = new Image("zombiedice/GreenFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(GreenFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice2side == 3||dice2side == 6||dice2side == 5){
                                // Brains
				Brains = Brains+1;
				System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image GreenBrain = new Image("zombiedice/GreenBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(GreenBrain);
                                hb.getChildren().add(imgView);
			}
        }
    }
    public void DiceThreeRules(){
        // method call
        DiceRollobject.DiceThreeRoll();
        DiceRollobject.DiceThreeSide();
        
        int dice3 = DiceRollobject.dice3;
        int dice3side = DiceRollobject.dice3side;
     
        // Dice three: Red Dice
	// Side 1,4,5 = Shotgun
	// Side 2,6 = Footprint
	// Side 3 = Brain
        
         if(dice3 == 1){
         if(dice3side == 1 ||dice3side == 4||dice3side == 5){
	 // Shotguns	
	        Shotguns = Shotguns+1;
		System.out.println("Red Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image RedShotgun = new Image("zombiedice/RedShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(RedShotgun);
                hb.getChildren().add(imgView);
         }     	
                        // Footprints
			else if(dice3side == 2||dice3side == 6){
				Footprints = Footprints+1;
				System.out.println("Red Dice-Footprints, Your victim escaped");
                                
                                // Add image to stackpane
                                Image RedFootprint = new Image("zombiedice/RedFootprint.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(RedFootprint);
                                hb.getChildren().add(imgView);
				}
                                // Brains
				else if(dice3side == 3){
					Brains = Brains+1;
					 System.out.println("Red Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                         
                                         // Add image to stackpane
                                         Image RedBrain = new Image("zombiedice/RedBrain.jpg");
                                         ImageView imgView = new ImageView();
                                         imgView.setImage(RedBrain);
                                         hb.getChildren().add(imgView);
					}
        }
        // Dice three: Yellow Dice 	
	// Side 1,4 = Shotgun
	// Side 2,5 = Footprint
	// Side 3,6 = Brain
	
        if(dice3 == 2){
	if(dice3side == 1||dice3side == 4){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Yellow Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image YellowShotgun = new Image("zombiedice/YellowShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(YellowShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice3side == 2||dice3side == 5){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Yellow Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image YellowFootprint = new Image("zombiedice/YellowFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(YellowFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice3side == 3||dice3side == 6){
                                // Brains
				Brains = Brains+1;
				System.out.println("Yellow Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image YellowBrain = new Image("zombiedice/YellowBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(YellowBrain);
                                hb.getChildren().add(imgView);
			}
        }
        // Dice three: Green Dice
	// Side 1 = Shotgun
	// Side 2,4 = Footprint
	// Side 3,5,6 = Brain
        
        if(dice3 == 3 ){
        if(dice3side == 1){
                // Shotguns
	        Shotguns = Shotguns+1;
		System.out.println("Green Dice-Shotguns, He fought back!");
                
                // Add image to stackpane
                Image GreenShotgun = new Image("zombiedice/GreenShotgun.jpg");
                ImageView imgView = new ImageView();
                imgView.setImage(GreenShotgun);
                hb.getChildren().add(imgView);
	}
		else if(dice3side == 2||dice3side == 4){
                        // Footprints
			Footprints = Footprints+1;
			System.out.println("Green Dice-Footprints, Your victim escaped");
                        
                        // Add image to stackpane
                        Image GreenFootprint = new Image("zombiedice/GreenFootprint.jpg");
                        ImageView imgView = new ImageView();
                        imgView.setImage(GreenFootprint);
                        hb.getChildren().add(imgView);
		}
			else if(dice3side == 3||dice3side == 6||dice3side == 5){
                                // Brains
				Brains = Brains+1;
				System.out.println("Green Dice-Brains, You ate your victim's brain, mmmmmmmm brains....");
                                
                                // Add image to stackpane
                                Image GreenBrain = new Image("zombiedice/GreenBrain.jpg");
                                ImageView imgView = new ImageView();
                                imgView.setImage(GreenBrain);
                                hb.getChildren().add(imgView);
			}
        }
    }
    public void Display(){
        ShotgunLabel = new Label();
        FootprintLabel = new Label();
        BrainLabel = new Label();
        TurnLabel = new Label();
        
        TurnLabel.setText("Turn: "+Turn);
        vb.getChildren().add(TurnLabel);
        TurnLabel.setFont(Font.font("Cambria", 32));
        
        ShotgunLabel.setText(Shotguns +(" shotguns"));
        vb.getChildren().add(ShotgunLabel);
        ShotgunLabel.setFont(Font.font("Cambria", 32));
        
        FootprintLabel.setText(Footprints+(" footprints"));
        vb.getChildren().add(FootprintLabel);
        FootprintLabel.setFont(Font.font("Cambria", 32));
        
        BrainLabel.setText(Brains+(" brains"));
        vb.getChildren().add(BrainLabel);
        BrainLabel.setFont(Font.font("Cambria", 32));
        
       
    }
    public void GameRules(){
        
        if(Shotguns >= 3){
            sp.getChildren().remove(RollBtn);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("Player, you are dead. " + Shotguns+" shotguns");
            alert.showAndWait();
            
            Reset();
            clear();
            EndGame();
            
        }
        else if(Brains >= 13){
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player one wins");
            alert.setHeaderText(null);
            alert.setContentText("Player one wins " + Brains+" brains");
            alert.showAndWait();
        }
    
        
    }
    public void clear(){
        vbButtons.getChildren().clear();
        vb.getChildren().clear();
        hb.getChildren().clear();
        sp.getChildren().remove(RollBtn);
    }
    public void EndGame(){
        EndGameBtn = new Button("End Game");
        PlayAgainBtn = new Button("Play again");
      
        vbButtons.getChildren().add(EndGameBtn);
        vbButtons.getChildren().add(PlayAgainBtn);
        
        // Play again button
        PlayAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            clear();
            Reset();
            Turn = 1;
            RollButton();
          }
        });
        
        // End game button
        EndGameBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            clear();
            Reset();
            
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Thanks for playing");
           alert.setHeaderText(null);
           alert.setContentText("Thank you for playing Zombie Dice");
           alert.showAndWait();
           
           // Exits game
           System.exit(0);
          }
        });
    }
    public void Reset(){
        Shotguns = 0;
        Brains = 0;
        Footprints = 0;
        Turn = 0;
    }
    }


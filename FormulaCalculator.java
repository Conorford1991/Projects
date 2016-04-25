
package formulacalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Conor
 */
public class FormulaCalculator extends Application {
    // Global variables
    // Layout
    private StackPane sp;
    private VBox vbox;
    private GridPane gp;
    private ComboBox combobox;
    // Text Fields
    private TextField speedTf;
    private TextField timeTf;
    private TextField distanceTf;
    private TextField distanceResultTf;
    private TextField timeResultTf;
    private TextField speedResultTf;
    // Buttons
    private Button distanceBtn;
    private Button timeBtn;
    private Button speedBtn;
    private Button clearBtn;
    // Label
    private Label Speedlabel;
    private Label Timelabel;
    private Label Distancelabel;
    private Label SpeedResultLabel;
    private Label TimeResultLabel;
    private Label DistanceResultLabel;
    
    
    @Override
    public void start(Stage primaryStage) {
       
        sp = new StackPane();
        gp = new GridPane();
        vbox = new VBox();
        
        
        Scene scene = new Scene(sp, 700,600);
        sp.getChildren().addAll(gp);
        
        vbox.setSpacing(10);
        gp.getChildren().addAll(vbox);

        
        primaryStage.setTitle("Formula Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        DistanceTimeSpeed();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    public void DistanceTimeSpeed(){
        combobox = new ComboBox<String>();
        combobox.getItems().addAll("Distance", "Time", "Speed");
        combobox.setValue("Choose Distance, Time or Speed");
        
        Speedlabel = new Label("Speed");
        SpeedResultLabel = new Label("Speed Result");
        Timelabel = new Label("Time");
        TimeResultLabel = new Label("Time Result");
        Distancelabel = new Label("Distance");
        DistanceResultLabel = new Label("Distance Result");
        
        distanceBtn = new Button("Calculate Distance");
        speedBtn = new Button("Calculate Speed");
        timeBtn = new Button("Calculate Time");
        
        speedTf = new TextField();
        speedTf.setEditable(true);
        
        timeTf = new TextField();
        timeTf.setEditable(true);
        
        distanceTf = new TextField();
        distanceTf.setEditable(true);
        
        distanceResultTf = new TextField();
        distanceResultTf.setEditable(false);
        timeResultTf = new TextField();
        timeResultTf.setEditable(false);
        speedResultTf = new TextField();
        speedResultTf.setEditable(false);
        
        vbox.getChildren().addAll(combobox);
        
           combobox.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
           combobox.getValue();
               if(combobox.getValue()=="Distance"){
                    DistanceTimeSpeedReset();
                    
                    vbox.getChildren().addAll(distanceBtn);
                    vbox.getChildren().addAll(Speedlabel);
                    vbox.getChildren().addAll(speedTf);
                    vbox.getChildren().addAll(Timelabel);
                    vbox.getChildren().addAll(timeTf);
                    vbox.getChildren().addAll(DistanceResultLabel);
                    vbox.getChildren().addAll(distanceResultTf);
        
                    distanceBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent e) {
                      
                      if(speedTf.getText() == null || speedTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable speed value");
                          alert.showAndWait();
                      }
                      if(timeTf.getText() == null || timeTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable time value");
                          alert.showAndWait();
                      }
                      else if(speedTf.getText() != null || timeTf.getText() != null){
                          double speedResult = Double.parseDouble( speedTf.getText());
                          double timeResult = Double.parseDouble( timeTf.getText());
                          double DistanceCal = speedResult*timeResult;
                          distanceResultTf.setText(Double.toString(DistanceCal)+(" km"));
                      }
            }
             });
                }
                if(combobox.getValue()=="Time"){
                    DistanceTimeSpeedReset();
                    
                    vbox.getChildren().addAll(timeBtn);
                    vbox.getChildren().addAll(Speedlabel);
                    vbox.getChildren().addAll(speedTf);
                    vbox.getChildren().addAll(Distancelabel);
                    vbox.getChildren().addAll(distanceTf);
                    vbox.getChildren().addAll(TimeResultLabel);
                    vbox.getChildren().addAll(timeResultTf);
        
                    timeBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent e) {
                        if(speedTf.getText() == null || speedTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable speed value");
                          alert.showAndWait();
                      }
                      if(distanceTf.getText() == null || distanceTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable distance value");
                          alert.showAndWait();
                      }
                      else if(speedTf.getText() != null || distanceTf.getText() != null){
                          double speedResult = Double.parseDouble( speedTf.getText() );
                          double distanceResult = Double.parseDouble( distanceTf.getText() );
                          double TimeCal = distanceResult/speedResult;
                          TimeCal = TimeCal * 0.6 * 100;
                          timeResultTf.setText(Double.toString(TimeCal)+(" mins"));
                      }         
                      }
                      
                      
             });
               }
                if(combobox.getValue()=="Speed"){
                    DistanceTimeSpeedReset();
                    
                    vbox.getChildren().addAll(speedBtn);
                    vbox.getChildren().addAll(Timelabel);
                    vbox.getChildren().addAll(timeTf);
                    vbox.getChildren().addAll(Distancelabel);
                    vbox.getChildren().addAll(distanceTf);
                    vbox.getChildren().addAll(SpeedResultLabel);
                    vbox.getChildren().addAll(speedResultTf);
        
                    speedBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent e) {
                        
                      if(timeTf.getText() == null || timeTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable time value");
                          alert.showAndWait();
                      }
                      if(distanceTf.getText() == null || distanceTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable distance value");
                          alert.showAndWait();
                      }
                      else if(timeTf.getText() != null || distanceTf.getText() != null){ 
                         double timeResult = Double.parseDouble( timeTf.getText() );
                         double distanceResult = Double.parseDouble( distanceTf.getText() );
                         double SpeedCal = distanceResult/timeResult;
                         speedResultTf.setText(Double.toString(SpeedCal)+(" kmph"));
                      }         
                    
            }         
             });
               }
            }
            });
  
    }
    public void DistanceTimeSpeedReset(){
        // Distance reset
        vbox.getChildren().removeAll(timeBtn);
        vbox.getChildren().removeAll(speedBtn);
        vbox.getChildren().removeAll(speedTf);
        vbox.getChildren().removeAll(timeTf);
        vbox.getChildren().removeAll(timeResultTf);
        vbox.getChildren().removeAll(speedResultTf);
        vbox.getChildren().removeAll(Speedlabel);
        vbox.getChildren().removeAll(Timelabel);
        vbox.getChildren().removeAll(TimeResultLabel);
        vbox.getChildren().removeAll(SpeedResultLabel);
        vbox.getChildren().removeAll(clearBtn);
        
        // Time reset
        vbox.getChildren().removeAll(distanceBtn);
        vbox.getChildren().removeAll(speedBtn);
        vbox.getChildren().removeAll(speedTf);
        vbox.getChildren().removeAll(distanceTf);
        vbox.getChildren().removeAll(distanceResultTf);
        vbox.getChildren().removeAll(speedResultTf);
        vbox.getChildren().removeAll(Speedlabel);
        vbox.getChildren().removeAll(Distancelabel);
        vbox.getChildren().removeAll(DistanceResultLabel);
        vbox.getChildren().removeAll(SpeedResultLabel);
        vbox.getChildren().removeAll(clearBtn);
        
        // Speed reset
        vbox.getChildren().removeAll(timeBtn);
        vbox.getChildren().removeAll(distanceBtn);
        vbox.getChildren().removeAll(distanceTf);
        vbox.getChildren().removeAll(timeTf);
        vbox.getChildren().removeAll(timeResultTf);
        vbox.getChildren().removeAll(distanceResultTf);
        vbox.getChildren().removeAll(Distancelabel);
        vbox.getChildren().removeAll(Timelabel);
        vbox.getChildren().removeAll(TimeResultLabel);
        vbox.getChildren().removeAll(DistanceResultLabel);
        vbox.getChildren().removeAll(clearBtn);
        
        clear();
    }
    public void clear(){
        clearBtn = new Button("Clear");
        vbox.getChildren().addAll(clearBtn);
        
        clearBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent e) {
                   speedTf.clear();
                   timeTf.clear();
                   distanceTf.clear();
                   
                   speedResultTf.clear();
                   timeResultTf.clear();
                   distanceResultTf.clear();
      
            }         
           });
    }
}
                

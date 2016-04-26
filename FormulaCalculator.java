
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
    // Class variables
    // Layout
    private VBox vbox;
    private GridPane gp;
    private ComboBox combobox;
    private ComboBox capacitycombobox;
    // Text Fields
    private TextField speedTf;
    private TextField timeTf;
    private TextField distanceTf;
    private TextField distanceResultTf;
    private TextField timeResultTf;
    private TextField speedResultTf;
    private TextField BandwidthTf;
    private TextField SignalNoiseRatioTf;
    private TextField SignalingLevelsTf;
    private TextField CapacityResultTf;
    // Buttons
    private Button distanceBtn;
    private Button timeBtn;
    private Button speedBtn;
    private Button clearBtn;
    private Button resetBtn;
    private Button capacityBtn;
    // Label
    private Label Speedlabel;
    private Label Timelabel;
    private Label Distancelabel;
    private Label SpeedResultLabel;
    private Label TimeResultLabel;
    private Label DistanceResultLabel;
    private Label CapacityResultlabel; 
    private Label BandwidthLabel;
    private Label SignalNoiseRatioLabel;
    private Label SignalingLevelsLabel;
    
    
    @Override
    public void start(Stage primaryStage) {
       
        gp = new GridPane();
        vbox = new VBox();
        
        
        Scene scene = new Scene(gp, 700,600);
        //gp.getChildren().addAll(vbox);
        gp.add(vbox, 0,0);
        vbox.setSpacing(10);
        
        primaryStage.setTitle("Formula Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // method calls
        Reset();
        DistanceTimeSpeed();
        ShannonNyquist();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    // Distance, time, speed calculation
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
           // removes capacity combobox
           vbox.getChildren().remove(capacitycombobox);
           
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
                                 DistanceCal = (double) Math.round(DistanceCal * 100) / 100; // round to two decimal places
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
                                 TimeCal = (double) Math.round(TimeCal * 100) / 100; // round to two decimal places
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
                                SpeedCal = (double) Math.round(SpeedCal * 100) / 100; // round to two decimal places
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
    // Shannon & Nyquist capacity calculations
    public void ShannonNyquist(){
        capacitycombobox = new ComboBox<String>();
        capacitycombobox.getItems().addAll("Shannon (uses S/N ratio)", "Nyquist (uses signaling levels)");
        capacitycombobox.setValue("Capacity calculation");
        
        CapacityResultlabel = new Label("Capacity Result");
        BandwidthLabel = new Label("Bandwidth (Mhz)");
        SignalNoiseRatioLabel = new Label("S/N ratio (dB)");
        SignalingLevelsLabel = new Label("Signaling Levels");
        
        capacityBtn = new Button("Calculate Capacity");
        
        BandwidthTf = new TextField();
        BandwidthTf.setEditable(true);
        
        SignalNoiseRatioTf = new TextField();
        SignalNoiseRatioTf.setEditable(true);
        
        SignalingLevelsTf = new TextField();
        SignalingLevelsTf.setEditable(true);
        
        CapacityResultTf = new TextField();
        CapacityResultTf.setEditable(false);
        
        
        vbox.getChildren().addAll(capacitycombobox);
        
        capacitycombobox.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
           // removes combobox
           vbox.getChildren().remove(combobox);
           
           capacitycombobox.getValue();
               if(capacitycombobox.getValue()=="Shannon (uses S/N ratio)"){
                    ShannonNyquistReset();
                    
                    vbox.getChildren().addAll(capacityBtn);
                    vbox.getChildren().addAll(BandwidthLabel);
                    vbox.getChildren().addAll(BandwidthTf);
                    vbox.getChildren().addAll(SignalNoiseRatioLabel);
                    vbox.getChildren().addAll(SignalNoiseRatioTf);
                    vbox.getChildren().addAll(CapacityResultlabel);
                    vbox.getChildren().addAll(CapacityResultTf);
        
                    capacityBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent e) {
                      
                      if(BandwidthTf.getText() == null || BandwidthTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable bandwidth value in Mhz");
                          alert.showAndWait();
                      }
                      if(SignalNoiseRatioTf.getText() == null || SignalNoiseRatioTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable S/N value in dB");
                          alert.showAndWait();
                      }
                      // Shannon Algorithm
                      else if(BandwidthTf.getText() != null || SignalNoiseRatioTf.getText() != null){
                          // C = B * log2 * (1+S/N)
                          double BandwidthResult = Double.parseDouble( BandwidthTf.getText()); // Bandwidth = n * 10 ^6 (Mhz)
                                 BandwidthResult = BandwidthResult * Math.pow(10, 6);
                                 System.out.println("Bandwidth: " +BandwidthResult); // test
                          
                          double SignalNoiseRatioResult = Double.parseDouble( SignalNoiseRatioTf.getText()) / 10; // S/N = n / 10 => 10 ^ n
                                 SignalNoiseRatioResult = Math.pow(10, SignalNoiseRatioResult) + 1;
                                 System.out.println("S/N: " +SignalNoiseRatioResult); // test
                          
                          double LogResult = Math.log(SignalNoiseRatioResult) / Math.log(2); // log(S/N) / log2
                                 System.out.println("log: " +LogResult); // test
                          
                          double CapacityCal = BandwidthResult * LogResult / 1000000; // B *(log2)*(1+S/N) // Dividing by 1000000 to convert to Mb
                                 CapacityCal = (double) Math.round(CapacityCal * 100) / 100; // rounds to 2 decimal places
                          CapacityResultTf.setText(Double.toString(CapacityCal)+(" Mb/s")); 
                      }
                    }
                  });
                }
                    if(capacitycombobox.getValue()=="Nyquist (uses signaling levels)"){
                    ShannonNyquistReset();
                    
                    vbox.getChildren().addAll(capacityBtn);
                    vbox.getChildren().addAll(BandwidthLabel);
                    vbox.getChildren().addAll(BandwidthTf);
                    vbox.getChildren().addAll(SignalingLevelsLabel);
                    vbox.getChildren().addAll(SignalingLevelsTf);
                    vbox.getChildren().addAll(CapacityResultlabel);
                    vbox.getChildren().addAll(CapacityResultTf);
        
                    capacityBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override 
                    public void handle(ActionEvent e) {
                      
                      if(BandwidthTf.getText() == null || BandwidthTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable bandwidth value in Mhz");
                          alert.showAndWait();
                      }
                      if(SignalingLevelsTf.getText() == null || SignalingLevelsTf.getText().trim().isEmpty()){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("No value");
                          alert.setHeaderText(null);
                          alert.setContentText("Please enter a suitable signaling level value");
                          alert.showAndWait();
                      }
                      // Nyquist Algorithm
                      else if(BandwidthTf.getText() != null || SignalingLevelsTf.getText() != null){
                          // C = 2B * log2 * M
                          double BandwidthResult = Double.parseDouble( BandwidthTf.getText()); // Bandwidth = n * 10 ^6 (Mhz)
                                 BandwidthResult = 2*BandwidthResult * Math.pow(10, 6); // 2*B
                                 System.out.println("Bandwidth: " +BandwidthResult); // test
                          
                          double SignalingLevelsResult = Double.parseDouble( SignalingLevelsTf.getText()); // M
                                 System.out.println("S/N: " +SignalingLevelsResult); // test
                          
                          double LogResult = Math.log(SignalingLevelsResult) / Math.log(2); // log(S/N) / log2
                                 System.out.println("log: " +LogResult); // test
                          
                          double CapacityCal = BandwidthResult * LogResult / 1000000; // B *(log2)*(1+S/N) // Dividing by 1000000 to convert to Mb
                                 CapacityCal = (double) Math.round(CapacityCal * 100) / 100;// rounds to 2 decimal places
                          CapacityResultTf.setText(Double.toString(CapacityCal)+(" Mb/s")); 
                      }
                    }
                  });
                }
             }
           });
    }
    public void ShannonNyquistReset(){
        // Shannon reset
        vbox.getChildren().removeAll(capacityBtn);
        vbox.getChildren().removeAll(BandwidthLabel);
        vbox.getChildren().removeAll(BandwidthTf);
        vbox.getChildren().removeAll(SignalingLevelsTf);
        vbox.getChildren().removeAll(SignalingLevelsLabel);
        vbox.getChildren().removeAll(CapacityResultlabel);
        vbox.getChildren().removeAll(CapacityResultTf);
        vbox.getChildren().removeAll(clearBtn);
        
        // Nyquist reset
        vbox.getChildren().removeAll(capacityBtn);
        vbox.getChildren().removeAll(BandwidthLabel);
        vbox.getChildren().removeAll(BandwidthTf);
        vbox.getChildren().removeAll(SignalNoiseRatioTf);
        vbox.getChildren().removeAll(SignalNoiseRatioLabel);
        vbox.getChildren().removeAll(CapacityResultlabel);
        vbox.getChildren().removeAll(CapacityResultTf);
        vbox.getChildren().removeAll(clearBtn);
        
        clear();
    }
    // Clear method
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
                   
                   SignalNoiseRatioTf.clear();
                   BandwidthTf.clear();
                   SignalingLevelsTf.clear();
                   CapacityResultTf.clear();
            }         
           });
    }
    // Reset method
    public void Reset(){
        resetBtn = new Button("Reset");
        vbox.getChildren().addAll(resetBtn);
        
        resetBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent e) {
                   vbox.getChildren().remove(combobox);
                   vbox.getChildren().remove(capacitycombobox);
                   DistanceTimeSpeedReset();
                   ShannonNyquistReset();
                   
                   DistanceTimeSpeed();
                   ShannonNyquist();
            }         
           });
    }
}

                
                

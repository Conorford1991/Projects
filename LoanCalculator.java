package Ford_Conor_2856181;
/**
 * This Program allows the user to calculate mortgage and car payments. The user is asked to enter 
 * and amount and a duration for the loan. A total (including interest) is generated and payments 
 * are calculated on a weekly, monthly or yearly basis. 
 * There is error checking to ensure that suitable values are entered. 
 */
// imports
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;

// class definition
public class LoanCalculator extends Application {

	@Override
	public void init() {

		//Populate the ComboBoxes
		vb_mainlayout = new VBox();
				
				
		cb_loan_type = new ComboBox<String>();
	        cb_loan_type.getItems().addAll("Car", "Mortgage");
		cb_loan_type.setValue("Select Type");
			
		cb_interest_rate_type = new ComboBox<String>();
		cb_interest_rate_type.getItems().addAll("Fixed", "Variable");
	        cb_interest_rate_type.setValue("Select Rate");
				
		cb_payments = new ComboBox<String>();
		cb_payments.getItems().addAll("Weekly","Monthly", "Yearly");
		cb_payments.setValue("Select Payment");
		
                //Layout controls
		slider_loan_duration = new Slider(0, 30, 15);
		slider_loan_duration.setShowTickMarks(true);
		slider_loan_duration.setShowTickLabels(true);
		slider_loan_duration.setMajorTickUnit(10);
		slider_loan_duration.setBlockIncrement(0.5);
				
				
				
		lb_loan_type = new Label("Loan Type");
                lb_loan_amount = new Label("Loan Amount");
		lb_interest_rate = new Label("Interest Rate");
		lb_loan_duration = new Label("Loan Duration");
		lb_total = new Label("Total (Including Interest)");
		lb_credit_cost = new Label("Credit Cost");
		lb_payments = new Label("Payments");
		
                //Set certain fields as non editable to avoid the user interfering with results	
		tf_loan_amount = new TextField();
		
                tf_interest_rate = new TextField();
		tf_interest_rate.setEditable(false);
		
                tf_duration = new TextField();
		tf_duration.setEditable(false);
		
                tf_total = new TextField();
		tf_total.setEditable(false);
                
                tf_credit_cost = new TextField();
		tf_credit_cost.setEditable(false);
                
                tf_payments = new TextField();
		tf_payments.setEditable(false);
				
		bt_calculate = new Button("Calculate");
		bt_clear = new Button("Clear");
				
		gp = new GridPane();
				
		gp.add(lb_loan_type, 0,0);
		gp.add(cb_loan_type, 1,0);
		gp.add(lb_loan_amount, 0, 1);
		gp.add(tf_loan_amount,  1,  1);
		gp.add(lb_interest_rate, 0, 2);
		gp.add(tf_interest_rate, 1, 2);
		gp.add(cb_interest_rate_type, 2, 2);
		gp.add(lb_loan_duration, 0, 3);
		gp.add(tf_duration,  1,  3);
		gp.add(slider_loan_duration, 3, 3);
		gp.add(lb_total,  0,  4);
		gp.add(tf_total,  1,  4);
		gp.add(lb_credit_cost, 0, 5);
		gp.add(tf_credit_cost,  1,  5);
		gp.add(lb_payments,0,6);
		gp.add(tf_payments, 1, 6);
		gp.add(cb_payments, 2,6);
		gp.add(bt_calculate, 1, 7);
		gp.add(bt_clear, 2, 7);		
	        
                 //Method call to initialize the Slider and the Loan Duration TextField
		//Action Listener for slider to set a variable and TextField
		slider_loan_duration.valueProperty().addListener(new ChangeListener<Number>() {
		    public void changed(final ObservableValue<? extends Number> observable,
			final Number oldValue, final Number newValue) {
			tf_duration.setText(String.format("%.2f",  newValue ));
							}
		});
		

		//5 Event Handlers, one for each button. Each will call a method. Some will call the same methods. 
		cb_loan_type.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        cb_loan_type.getValue();
                        //Method call to initialize Interest Rates TextField based on the Loan Type and Loan Interest Type
                        setRate();
                    }
                });
		
                cb_interest_rate_type.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        cb_interest_rate_type.getValue();
                       //Method call to initialize Interest Rates TextField based on the Loan Type and Loan Interest Type
                        setRate();
                    }
                });
                
                cb_payments.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        cb_payments.getValue();
                        
                    }
                });
                bt_calculate.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        cal_click++;
                        if (cal_click > 0 && tf_loan_amount.getText()!=" "){
                            calculateTotal();
                        }
                        else if(cal_click > 0 && tf_loan_amount.getText()==" "){
                           tf_loan_amount.setText("Must input values");
                        }
                    }
                });
                
                bt_clear.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        clear_click++;
                        if(clear_click > 0){
                           clear();
                        }
                    }
                });
		
	}

	//Overridden start method
		//@Override
		public void start(Stage primaryStage){
			// set a title and size on our window and add the main layout
			// to the root of the scene graph
			VBox vb = new VBox();
			primaryStage.setTitle("Loan Calculator");
			primaryStage.setScene(new Scene(vb_mainlayout, 600, 500));
			primaryStage.show();
		
			vb_mainlayout.getChildren().addAll(gp);
		}

	//Overridden stop method
	public void stop() {}

	//Entry point to our program
	public static void main(String[] args) {
		launch(args);
	}

	//Method to calculate - the total (including interest) & the credit cost and set these TextFields.
	//It should set some variables with values read from TextFields and catch errors in this process.
	//Formula to calculate compound interest can be found here  http://bit.ly/1MtJqSw. The interest should be
        //compounded once per year. This should also calculate the payments by calling another method.
	private void calculateTotal(){
		d_loan_amount = Double.parseDouble(tf_loan_amount.getText());
		d_interest_rate = Double.parseDouble(tf_interest_rate.getText());
		d_loan_duration = Double.parseDouble(tf_duration.getText());
		
		total = (d_loan_amount*Math.pow(1+d_interest_rate/1, d_loan_duration));
		tf_total.setText(Double.toString(total));
                
                //credit cost
                credit_cost = (total- d_loan_amount );
                tf_credit_cost.setText(Double.toString(credit_cost));
                
                calculatePayments();
	}

	//Method to calculate the payments and display them in the relevant TextField
	//If the total has not been calculated then an error message will be displayed 
	//in the TextField.
	private void calculatePayments(){
		d_loan_amount = Double.parseDouble(tf_duration.getText());
                
                    
                payments = (total /d_loan_duration);
                tf_payments.setText(Double.toString(payments));
                
	
        }
	//Method to set the Slider based on the Loan Type
	private void setSlider(){
		
		
	}

	//Method to set the rate based on the Loan Type and the Interest Rate Type
	private void setRate(){
                
                if(cb_loan_type.getValue()=="Mortgage" && cb_interest_rate_type.getValue()=="Variable"){
                    tf_interest_rate.setText(Double.toString(vm));
                } 
                
                else if(cb_loan_type.getValue()=="Mortgage" && cb_interest_rate_type.getValue()=="Fixed"){
                    tf_interest_rate.setText(Double.toString(fm));
                }
                else if(cb_loan_type.getValue()=="Car" && cb_interest_rate_type.getValue()=="Variable"){
                    tf_interest_rate.setText(Double.toString(vc));
                }
                else if(cb_loan_type.getValue()=="Car" && cb_interest_rate_type.getValue()=="Fixed"){
                    tf_interest_rate.setText(Double.toString(fc));
                }
            
            
	}

	//Method to clear all the TextFields and update the Interest Rate and Loan Duration TextFields.
	private void clear(){
                tf_loan_amount.clear();
                tf_interest_rate.clear();
                tf_duration.clear();
                tf_total.clear();
                tf_credit_cost.clear();
                tf_payments.clear();
                cb_interest_rate_type.setValue("Select Rate");
                cb_loan_type.setValue("Select Type");
                cb_payments.setValue("Select Payment");
		
	}

	//The following variables should be initialized in appropriate location. 
	//For the purposes of this practical you may to choose to initialize most of them here.
	
	//Layout
	private GridPane gp;
	private VBox vb_mainlayout;

	//Loan Type
	private Label lb_loan_type;
	private ComboBox<String> cb_loan_type;

	//Loan Amount
	private Label lb_loan_amount;
	private TextField tf_loan_amount;
	private double d_loan_amount;

	//Interest Rate
	private Label lb_interest_rate;
	private TextField tf_interest_rate;
	private ComboBox<String> cb_interest_rate_type;
	private double d_interest_rate;
	//Values 0 and 1 refer to Variable Rate and Fixed Rate Mortgages respectively 
	//Values 2 and 3 refer to Variable Rate and Fixed Rate Car Loans respectively 
	private final double[] INTEREST_RATES = {0.034,.05,.09,.11};
        //added variables for loan type & interest rate
        private double vm = 0.034;
        private double vc = 0.09;
        private double fm = 0.05;
        private double fc = 0.11;
	
        //Loan Duration
	private Label lb_loan_duration;
	private TextField tf_duration;
	private double d_loan_duration;
	private Slider slider_loan_duration, slider_loan_duration_car;  
	//Formating the values in the duration box
	DecimalFormat df;

	//Total (including interest)
	private Label lb_total;
	private TextField tf_total;
	private double total;

	//Credit Cost
	private Label lb_credit_cost;
	private TextField tf_credit_cost;
	private double credit_cost;

	//Payments
	private Label lb_payments;
	private TextField tf_payments;
	private ComboBox<String> cb_payments;
	private double payments;

	//Calculate Button
	private Button bt_calculate;
	private int cal_click;
	
        //Clear Button
	private Button bt_clear;
	private int clear_click;
	
}
//javafx imports
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;  
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text; 
import javafx.geometry.Insets;

import java.util.*;
import java.io.*;

//main method
public class CalculatorProject extends Application {

	//launch program
	public static void main(String[] args){
		launch(args);
	}

	//display app
	@Override
	public void start(Stage primaryStage) throws Exception{

		//String on calc
		ArrayList<String> varList = new ArrayList<String>();
		
		//Vbox layout
		VBox vbox = new VBox();
		vbox.setPrefWidth(300);
		vbox.setPadding(new Insets(5,5,5,5));

		//y = object
		Text yEquals = new Text(" y = ");
		yEquals.setStyle("-fx-font-size:30px;");

		

		//text field obj
		TextField textField = new TextField();

		HBox hbox = new HBox(yEquals, textField);
		hbox.setPadding(new Insets(5,5,5,5));


		//get CSS
		//text field style
		textField.setStyle("-fx-font-size:25px");

		//set text to textfield
		textField.setText(calcText(varList));

		//graph calc visual

		Group visuals = new Group();
		clearGraph(visuals);
							

		//BTN OBJS1//
		Button btn7 = new Button("7");
		btn7.setId("button");
		btn7.getStylesheets().add("CalcStyle.css");
		btn7.setOnAction(actionEvent -> {
	        addVal(varList,"7");
	        textField.setText(calcText(varList));
		});

		Button btn8 = new Button("8");
		btn8.setId("button");
		btn8.getStylesheets().add("CalcStyle.css");
		btn8.setOnAction(actionEvent -> {
	        addVal(varList,"8");
	       	textField.setText(calcText(varList));
		});

		Button btn9 = new Button("9");
		btn9.setId("button");
		btn9.getStylesheets().add("CalcStyle.css");
		btn9.setOnAction(actionEvent -> {
	        addVal(varList,"9");
	       	textField.setText(calcText(varList));
		});

		Button btnMult = new Button("*");
		btnMult.setId("button");
		btnMult.getStylesheets().add("CalcStyle.css");
		btnMult.setOnAction(actionEvent -> {
	        addVal(varList,"*");
	       	textField.setText(calcText(varList));
		});

		Button btnX = new Button("X");
		btnX.setId("button");
		btnX.getStylesheets().add("CalcStyle.css");
		btnX.setOnAction(actionEvent -> {
	        addVal(varList,"X");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS//

		//add buttons to hbox1
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(btn7,btn8,btn9,btnMult,btnX);

		
		//BTN OBJS2//
		Button btn4 = new Button("4");
		btn4.setId("button");
		btn4.getStylesheets().add("CalcStyle.css");
		btn4.setOnAction(actionEvent -> {
	        addVal(varList,"4");
	       	textField.setText(calcText(varList));
		});

		Button btn5 = new Button("5");
		btn5.setId("button");
		btn5.getStylesheets().add("CalcStyle.css");
		btn5.setOnAction(actionEvent -> {
	        addVal(varList,"5");
	       	textField.setText(calcText(varList));
		});

		Button btn6 = new Button("6");
		btn6.setId("button");
		btn6.getStylesheets().add("CalcStyle.css");
		btn6.setOnAction(actionEvent -> {
	        addVal(varList,"6");
	       	textField.setText(calcText(varList));
		});

		Button btnDiv = new Button("/");
		btnDiv.setId("button");
		btnDiv.getStylesheets().add("CalcStyle.css");
		btnDiv.setOnAction(actionEvent -> {
	        addVal(varList,"/");
	       	textField.setText(calcText(varList));
		});


		Button btnSin = new Button("sin");
		btnSin.setId("button_trig");
		btnSin.getStylesheets().add("CalcStyle.css");
		btnSin.setOnAction(actionEvent -> {
	        addVal(varList,"sin");
	       	textField.setText(calcText(varList));
		});

		//END BTN OBJS2//

		//add buttons to hbox2
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(btn4,btn5,btn6,btnDiv,btnSin);


		//BTN OBJS3//
		Button btn1 = new Button("1");
		btn1.setId("button");
		btn1.getStylesheets().add("CalcStyle.css");
		btn1.setOnAction(actionEvent -> {
	        addVal(varList,"1");
	       	textField.setText(calcText(varList));
		});

		Button btn2 = new Button("2");
		btn2.setId("button");
		btn2.getStylesheets().add("CalcStyle.css");
		btn2.setOnAction(actionEvent -> {
	        addVal(varList,"2");
	       	textField.setText(calcText(varList));
		});

		Button btn3 = new Button("3");
		btn3.setId("button");
		btn3.getStylesheets().add("CalcStyle.css");
		btn3.setOnAction(actionEvent -> {
	        addVal(varList,"3");
	       	textField.setText(calcText(varList));
		});

		Button btnPlus = new Button("+");
		btnPlus.setId("button");
		btnPlus.getStylesheets().add("CalcStyle.css");
		btnPlus.setOnAction(actionEvent -> {
	        addVal(varList,"+");
	       	textField.setText(calcText(varList));
		});

		Button btnCos = new Button("cos");
		btnCos.setId("button_trig");
		btnCos.getStylesheets().add("CalcStyle.css");
		btnCos.setOnAction(actionEvent -> {
	        addVal(varList,"cos");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS3//

		//add buttons to hbox3
		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(btn1,btn2,btn3,btnPlus,btnCos);

		//button objs4
		Button btnDecimal = new Button(".");
		btnDecimal.setId("button");
		btnDecimal.getStylesheets().add("CalcStyle.css");
		btnDecimal.setOnAction(actionEvent -> {
	        addVal(varList,".");
	        textField.setText(calcText(varList));
		});

		Button btn0 = new Button("0");
		btn0.setId("button");
		btn0.getStylesheets().add("CalcStyle.css");
		btn0.setOnAction(actionEvent -> {
	        addVal(varList,"0");
	        textField.setText(calcText(varList));
		});

		Button btnClear = new Button("C");
		btnClear.setId("button");
		btnClear.getStylesheets().add("CalcStyle.css");
		btnClear.setOnAction(actionEvent -> {
	        varList.removeAll(varList);
	        clearGraph(visuals);
	        textField.setText(calcText(varList));
		});

		Button btnMinus = new Button("-");
		btnMinus.setId("button");
		btnMinus.getStylesheets().add("CalcStyle.css");
		btnMinus.setOnAction(actionEvent -> {
	        addVal(varList,"-");
	        textField.setText(calcText(varList));
		});

		Button btnTan = new Button("tan");
		btnTan.setId("button_trig");
		btnTan.getStylesheets().add("CalcStyle.css");
		btnTan.setOnAction(actionEvent -> {
	        addVal(varList,"tan");
	       	textField.setText(calcText(varList));
		});


		//add buttons to hbox4
		HBox hbox4 = new HBox();
		hbox4.getChildren().addAll(btnDecimal,btn0,btnClear,btnMinus,btnTan);

		//hbox 5
		HBox hbox5 = new HBox();
		Button btnEqual = new Button("GRAPH");
		btnEqual.setId("equal_button");
		btnEqual.getStylesheets().add("CalcStyle.css");
		btnEqual.setOnAction(actionEvent -> {
			System.out.println(varList);
			System.out.println(checkSyntax(varList));
			//call graph function
			graph(varList, visuals);
	       	System.out.print(varList);
		});

		hbox5.getChildren().addAll(btnEqual);

		//add objects to vbox
		vbox.getChildren().addAll(visuals,hbox,hbox1,hbox2,hbox3,hbox4,hbox5);

		//set title page
		primaryStage.setTitle("sample");

		//scene obj
		Scene scene = new Scene(vbox,310,655);
		

		//set scene to stage
		primaryStage.setScene(scene);

		//display the stage
		primaryStage.show();

	}

	//addNumbers properly to calcVar
	public static void addVal(ArrayList<String> arr, String input){
		if(arr.size() > 0){
			if(arr.get(0).equals("Error"))
			arr.removeAll(arr);
		}
		
		//if input is operator
		if(input.equals("*") || input.equals("/") ||
		   input.equals("+") || input.equals("-")){
			//add at the end
			arr.add(input);

		}

		//else
		else{

			//add numb to last val
			if(arr.size() == 0){
				//add numb
				arr.add(input);
			}

			else{

				//is prev variable is operator, add numb
				String prevVar = arr.get(arr.size() - 1);
				if(prevVar.equals("*") || prevVar.equals("/") ||
		  		   prevVar.equals("+") || prevVar.equals("-")){
					arr.add(input);		
				}

				else{ //make numb bigger
					String newVal = arr.get(arr.size() - 1) + input + "";
					arr.set(arr.size() - 1, newVal);
				}
			}
		}
	}


	//display text on calculator
	public static String calcText(ArrayList<String> arr){
		String text = "";
		for(int i = 0; i < arr.size(); i++){
			text+= arr.get(i);
		}

		return text;
	}

	//clear graph data and paint graph canvas
	public static void clearGraph(Group visuals){

		//clear visuals
		visuals.getChildren().clear();

		//backgroudnd
		Rectangle rect = new Rectangle(0,0,300,300);
		rect.setFill(Color.WHITE);
		visuals.getChildren().add(rect);

		//Hline
		Line Hline = new Line(1,150,299,150);
		Hline.setStroke(Color.BLACK);
		Hline.setStrokeWidth(2.0);


		//Vline	
		Line Vline = new Line(150,1,150,299);
		Vline.setStroke(Color.BLACK);
		Vline.setStrokeWidth(2.0);

		//Hline markers
		for(int i = 0; i <= 300; i += 25){
			Line HlineMarker = new Line (i,0,i,300);
			HlineMarker.setStroke(Color.GRAY);
			visuals.getChildren().add(HlineMarker);
		}

		//Vline markers
		for(int i = 0; i <= 300; i += 25){
			Line VlineMarker = new Line (0,i,300,i);
			VlineMarker.setStroke(Color.GRAY);
			visuals.getChildren().add(VlineMarker);
		}

		visuals.getChildren().add(Hline);
		visuals.getChildren().add(Vline);

	}

	//checkSyntax
	public static boolean checkSyntax(ArrayList<String> arr){

		if(arr.size() > 2){

			String firstVar = arr.get(0); //first val
			String lastVar = arr.get(arr.size()-1); //last val

			//if starts or end with opp return false
			if(firstVar.equals("*") || firstVar.equals("/") ||
			   firstVar.equals("+") || firstVar.equals("-") ||
			   lastVar.equals("*") || lastVar.equals("/") ||
			   lastVar.equals("+") || lastVar.equals("-")){
				return false;
			
			}
			   

			//if there are two opps in a row return false
			for(int i = 0; i < arr.size() - 1; i++){

				firstVar = arr.get(i);
				String secVar = arr.get(i + 1);

				if( (firstVar.equals("*") || firstVar.equals("/") ||
			   	   firstVar.equals("+") || firstVar.equals("-")) &&
				   (secVar.equals("*") || secVar.equals("/") ||
			   	   secVar.equals("+") || secVar.equals("-")) ){
					return false;
				}
			}

		} else{
			return false;
		}
	
		return true;
	}

	//solve arithmatic
	public static String solution(ArrayList<String> arr){

		if(arr.size() == 1){
			return arr.get(0);
		}

		else if(checkSyntax(arr) == true){ //compute

			if(arr.contains("*")){
				int i = arr.indexOf("*");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("/")){
				int i = arr.indexOf("/");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("+")){
				int i = arr.indexOf("+");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("-")){
				int i = arr.indexOf("-");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}
		
			else{
				throw new NoSuchElementException();
			}
			

		}

		//show Error message
		else{	
			arr.removeAll(arr);
			arr.add("Error");			
			return arr.get(0);
		}
		

	}

	//operation method
	public static String operations(String A, String B, String opp){
		

		double a = Double.parseDouble(A);
		double b = Double.parseDouble(B);

		if(opp.equals("*")){
			return a * b + "";
		}

		else if(opp.equals("/")){
			return a / b + "";
		}

		else if(opp.equals("+")){
			return a + b + "";
		}

		else if(opp.equals("-")){
			return a - b + "";
		}

		else{
			throw new NoSuchElementException();
		}
	}

	//graph
	public static void graph(ArrayList<String> arr, Group visuals){
		//y = x


		//plot values from left to right
		//start at -6
		//ends at 6
		//each unit is 25 pixels

		int midPoint = 150;  //half of the number of pixels
		int pixelPerUnit = 25;

		//if y is positive
		//answer = midPoint - answer
		//if y is negative
		//answer = midPoint + answer

		double i = -5.96;
		try{
			while(i <= 5.96){

				double x = i;
				ArrayList<String> temp = new ArrayList<String>();
				temp.addAll(arr);
				adapt(temp,x);
				solution(temp);
				String yString = temp.get(0);
				double y = Double.parseDouble(yString);

				//visual conversion of units to pixels
				if(x <= 0){
					//behind midpoint
					x = midPoint + (x * pixelPerUnit);
				}
				else{
					//infront of midpoint
					x = midPoint + (x * pixelPerUnit);
				}
				

				if(y <= 0){
					//below the midPoint
					y = midPoint - (y * pixelPerUnit);
				}
				else{
					//above the midPoint
					y = midPoint - (y * pixelPerUnit);
				}
				//end unit conversion

				if(y < 300 && y > 0){
					Circle circle = new Circle((int)x, (int)y, 0.25);
					circle.setStroke(Color.RED);
					visuals.getChildren().add(circle);
				}

				i += 0.005;
			}
		} catch(ArithmeticException e) {
			i+= 0.005;
		}

	}

	//adapt function, finds X in array and transforms it to for loop val
	public static void adapt(ArrayList<String> arr, double x){
		if(arr.contains("X")){
			for(int i = 0; i < arr.size(); i++){
				if(arr.get(i).equals("X")){
					arr.set(i, ""+x);
				}
			}
		}
	}




}


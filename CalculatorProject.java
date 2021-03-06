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
//

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
		textField.setEditable(false);             //disable keyboard input

		HBox hbox = new HBox(yEquals, textField);
		hbox.setPadding(new Insets(5,0,5,0));


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

		Button btnSq = new Button("root()");
		btnSq.setId("button_root");
		btnSq.getStylesheets().add("CalcStyle.css");
		btnSq.setOnAction(actionEvent -> {
	        addVal(varList,"root");
	        addVal(varList,"(");
	       	textField.setText(calcText(varList));
		});
		//END BTN OBJS//

		//add buttons to hbox1
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(btn7,btn8,btn9,btnMult,btnX,btnSq);

		
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

		Button btnOp = new Button("(");
		btnOp.setId("button");
		btnOp.getStylesheets().add("CalcStyle.css");
		btnOp.setOnAction(actionEvent -> {
	        addVal(varList,"(");
	       	textField.setText(calcText(varList));
		});



		//END BTN OBJS2//

		//add buttons to hbox2
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(btn4,btn5,btn6,btnDiv,btnSin,btnOp);


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

		Button btnClo = new Button(")");
		btnClo.setId("button");
		btnClo.getStylesheets().add("CalcStyle.css");
		btnClo.setOnAction(actionEvent -> {
	        addVal(varList,")");
	       	textField.setText(calcText(varList));
		});

		//END BTN OBJS3//

		//add buttons to hbox3
		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(btn1,btn2,btn3,btnPlus,btnCos,btnClo);

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

		Button btnNeg = new Button("(-1)");
		btnNeg.setId("button");
		btnNeg.getStylesheets().add("CalcStyle.css");
		btnNeg.setOnAction(actionEvent -> {
	        addVal(varList,"(");
	        addVal(varList,"-1");
	        addVal(varList,")");
	       	textField.setText(calcText(varList));
		});


		//add buttons to hbox4
		HBox hbox4 = new HBox();
		hbox4.getChildren().addAll(btnDecimal,btn0,btnClear,btnMinus,btnTan,btnNeg);

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
		Scene scene = new Scene(vbox,370,655);
		

		//set scene to stage
		primaryStage.setScene(scene);

		//display the stage
		primaryStage.show();

	}

	//addNumbers properly to calcVar
	public static void addVal(ArrayList<String> arr, String input){
		
		//if array is empty, add input
		if(arr.size() == 0){
			arr.add(input);
		}

		//if input is an x, imply * if numb was prev term
		else if(input.equals("X")){
			String prevVar = arr.get(arr.size() - 1);

			if(prevVar.equals("*") || prevVar.equals("/") ||
			   prevVar.equals("+") || prevVar.equals("-") ||
			   prevVar.equals("sin") || prevVar.equals("cos") ||
			   prevVar.equals("tan") || input.equals("")){
			  
				arr.add(input);		
			}

			else{
				arr.add("");
				arr.add(input);
			}
		}


		//else input must be a number or operator
		else{

			//if input is operator
			if(input.equals("*") || input.equals("/") ||
			   input.equals("+") || input.equals("-") ||
			   input.equals("sin") || input.equals("cos") ||
			   input.equals("tan") || input.equals("") ||
			   input.equals("(") || input.equals(")")){
				//add at the end
				arr.add(input);

			}

			else{ //input is a number

				
				String prevVar = arr.get(arr.size() - 1);
				
				//if prev var is a operator, then add number
				if(prevVar.equals("*") || prevVar.equals("/") ||
				   prevVar.equals("+") || prevVar.equals("-") ||
				   prevVar.equals("sin") || prevVar.equals("cos") ||
				   prevVar.equals("tan") || prevVar.equals("X") ||
				   prevVar.equals("(") || prevVar.equals(")") ||
				   prevVar.equals("")){
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
		Rectangle rect = new Rectangle(0,0,360,360);
		rect.setFill(Color.WHITE);
		visuals.getChildren().add(rect);

		//Hline
		Line Hline = new Line(1,180,359,180);
		Hline.setStroke(Color.BLACK);
		Hline.setStrokeWidth(2.0);


		//Vline	
		Line Vline = new Line(180,1,180,359);
		Vline.setStroke(Color.BLACK);
		Vline.setStrokeWidth(2.0);

		//Hline markers
		for(double i = 0; i <= 360; i += 25.71){
			Line HlineMarker = new Line (i,0,i,360);
			HlineMarker.setStroke(Color.GRAY);
			visuals.getChildren().add(HlineMarker);
		}

		//Vline markers
		for(double i = 0; i <= 360; i += 25.71){
			Line VlineMarker = new Line (0,i,360,i);
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
			   lastVar.equals("+") || lastVar.equals("-")||
			   lastVar.equals("")){
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

		//solve parenthesis
		if(hasPerenthesis(arr) == true){
			solveParentheses(arr);
			solution(arr);
		}

		//solve trig
		if(arr.contains("root")){
			root(arr);
			solution(arr);
		}


		//solve trig first
		if(arr.size() > 1 && (arr.contains("sin") || arr.contains("cos") || arr.contains("tan"))){
			solveTrig(arr);
			solution(arr);
		}

		if(arr.size() > 1 && arr.contains("root")){
			root(arr);
			solution(arr);
		}

		if(arr.size() == 1){
			return arr.get(0);
		}

		else if(checkSyntax(arr) == true){ //compute

			if(arr.contains("")){
				int i = arr.indexOf("");
				arr.set(i, operations(arr.get(i-1), arr.get(i + 1), arr.get(i)));
				arr.remove(i+1);
				arr.remove(i-1);
				return solution(arr);
			}

			else if(arr.contains("*")){
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

	//has perenthesis
	public static boolean hasPerenthesis(ArrayList<String> arr){
		if(arr.contains("(")){
			return true;
		}
		return false;
	}

	//solve parenthesis
	public static void solveParentheses(ArrayList<String> arr){
		//find parentheses index
		int pOpenIndex = 0;
		int pCloseIndex = 0;

		//find open
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i).equals("(")){
				pOpenIndex = i;
				int j = i;
				while(arr.get(j) != (")")){
					j++;
				}
				pCloseIndex = j;
			}
		}

		//find closed
		

		ArrayList<String> temp = new ArrayList<String>();
		for(int i = pOpenIndex + 1; i < pCloseIndex; i++){
			temp.add(arr.get(i));
		}


		int tempSize = temp.size() + 1; //this int will be used to remove ( to ) in arr
		solution(temp);

		while(tempSize > 0){
			arr.remove(pOpenIndex);
			tempSize--;
		}

		arr.set(pOpenIndex, temp.get(0));


	}

	//operation method
	public static String operations(String A, String B, String opp){
		

		double a = Double.parseDouble(A);
		double b = Double.parseDouble(B);

		if(opp.equals("*") || opp.equals("")){
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

		int midPoint = 180;  //half of the number of pixels
		double pixelPerUnit = 25.71;

		//if y is positive
		//answer = midPoint - answer
		//if y is negative
		//answer = midPoint + answer

		double i = -6.98;
		try{
			while(i <= 6.98){

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

				if(y < 360 && y > 0){
					Circle circle = new Circle((int)x, (int)y, 0.30);
					circle.setStroke(Color.RED);
					visuals.getChildren().add(circle);
				}

				i += 0.001;
			}
		} catch(ArithmeticException e) {
			i+= 0.001;
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

	//solve trig functions
	public static void solveTrig(ArrayList<String> arr){
		if(arr.size() > 1) {
			if(arr.contains("sin")){
				int index = arr.indexOf("sin");
				double var = Double.parseDouble(arr.get(index + 1));
				double result = Math.sin(var);
				arr.set(index, result + "");
				arr.remove(index + 1);
			}

			if(arr.contains("cos")){
				int index = arr.indexOf("cos");
				double var = Double.parseDouble(arr.get(index + 1));
				double result = Math.cos(var);
				arr.set(index, result + "");
				arr.remove(index + 1);
			}

			if(arr.contains("tan")){
				int index = arr.indexOf("tan");
				double var = Double.parseDouble(arr.get(index + 1));
				double result = Math.tan(var);
				arr.set(index, result + "");
				arr.remove(index + 1);
			}

		}
	}

	public static void root(ArrayList<String> arr){
		if(arr.size() > 1) {
			if(arr.contains("root")){
				int index = arr.indexOf("root");
				double var = Double.parseDouble(arr.get(index + 1));
				double result = Math.sqrt(var);
				arr.set(index, result + "");
				arr.remove(index + 1);
			}
		}
	}

}


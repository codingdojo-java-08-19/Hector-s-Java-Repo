package calculators;

import java.io.Serializable;
import java.util.ArrayList;

public class Calculator implements Serializable {
	private double result;
	private ArrayList<String> operation = new ArrayList<String>();
	public Calculator() {
	}
	public void setFirstOperand(Double number) {
		operation.add(Double.toString(number));
	}
	public void setOperator(String oporator) {
		operation.add(oporator);
	}
	public void setSecondOperator(Double number) {
		operation.add(Double.toString(number));
	}
	public void preformOperation(){
		Double first = Double.parseDouble(operation.get(0));
		Double second = Double.parseDouble(operation.get(2));
		switch(operation.get(1)) {
		case "+":
			result = first + second;
			break;
		case "-":
			result = first - second;
			break;
		}
	}
	public void getResult() {
		System.out.println(result);
	}
}

package tests;
import calculators.Calculator;
public class Test1 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.setFirstOperand(10.5);
		calc.setOperator("+");
		calc.setSecondOperator(0.5);
		calc.preformOperation();
		calc.getResult();

	}

}

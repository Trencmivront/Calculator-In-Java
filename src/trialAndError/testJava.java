package trialAndError;
import javax.swing.*;
import java.awt.*;

public class testJava {
	
	static JFrame frame = new JFrame("Calculator");
	static JPanel numPad = new JPanel(new GridLayout(4, 3));
	static JPanel leftPanel = new JPanel(new GridLayout(6, 1));
	static JPanel textPanel = new JPanel(new GridLayout());
	static JTextArea screen = new JTextArea("");
	
	static JButton delete = new JButton("C");
	static JButton result = new JButton("=");
	static JButton add = new JButton("+");
	static JButton substract = new JButton("-");
	static JButton multiply = new JButton("*");
	static JButton divide = new JButton("/");
	
	static JButton number0 = new JButton("0");
	static JButton number1 = new JButton("1");
	static JButton number2 = new JButton("2");
	static JButton number3 = new JButton("3");
	static JButton number4 = new JButton("4");
	static JButton number5 = new JButton("5");
	static JButton number6 = new JButton("6");
	static JButton number7 = new JButton("7");
	static JButton number8 = new JButton("8");
	static JButton number9 = new JButton("9");
	
	static void buttonPressed(JButton button) {
		if(isResult) {
			screen.setText("");
			isResult = false;
		}
		screen.append(button.getText());
	}
	
	static boolean isSubstract = false;
	static boolean isMultiply = false;
	static boolean isResult = false;
	static boolean isDivide = false;
	
	static double firstNumber;
	
	static void calculate() {		
		
		char[] digits = screen.getText().toCharArray();
		int n = digits.length;
		double number = 0;
		
		for(int i = 0; i < n; i++) {
			number += Character.getNumericValue(digits[i]);
			if(i + 1 != n) {
				number *= 10;
			}
		}
		
		if(isSubstract) {
			isSubstract = false;
			firstNumber -= number;
		}
		else if(isMultiply) {
			isMultiply = false;
			firstNumber *= number;
		}
		else if(isDivide) {
			isDivide = false;
			firstNumber /= number;
		}
		else {
			firstNumber += number;
		}
		screen.setText("");
	}
	
	static void substract() {
		calculate();
		isSubstract = true;
	}
	
	static void multiply() {
		calculate();
		isMultiply = true;
	}
	
	static void divide() {
		calculate();
		isDivide = true;
	}
	
	static void result() {
			isResult = true;
			calculate();
			screen.setText(Double.toString(firstNumber));
			System.out.println(firstNumber);
			firstNumber = 0;
	}
	
	static void clear() {
		screen.setText("");
		isResult = false;
		isMultiply = false;
		isSubstract = false;
		firstNumber = 0;
	}
	
	public static void main(String[] args) {
		
		screen.setEditable(false);
		frame.setLayout(null);
		
		frame.setLocation(600, 200);
		
		frame.add(numPad);
		numPad.setBounds(0, 40, 180, 300);
		screen.setFont(new Font("Arial", Font.BOLD, 30));
		textPanel.setBounds(0, 0, 260, 30);
		frame.add(textPanel);
		leftPanel.setBounds(181, 40, 95, 325);
		frame.add(leftPanel);
		
		textPanel.add(screen);
		
		frame.setSize(275, 400);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		leftPanel.add(delete);
		leftPanel.add(result);
		leftPanel.add(add);
		leftPanel.add(substract);
		leftPanel.add(multiply);
		leftPanel.add(divide);
		
		numPad.add(number7);
		numPad.add(number8);
		numPad.add(number9);
		numPad.add(number4);
		numPad.add(number5);
		numPad.add(number6);
		numPad.add(number1);
		numPad.add(number2);
		numPad.add(number3);
		numPad.add(new JButton()).setVisible(false);
		numPad.add(number0);
		
		number0.addActionListener(e -> buttonPressed(number0));
		number1.addActionListener(e -> buttonPressed(number1));
		number2.addActionListener(e -> buttonPressed(number2));
		number3.addActionListener(e -> buttonPressed(number3));
		number4.addActionListener(e -> buttonPressed(number4));
		number5.addActionListener(e -> buttonPressed(number5));
		number6.addActionListener(e -> buttonPressed(number6));
		number7.addActionListener(e -> buttonPressed(number7));
		number8.addActionListener(e -> buttonPressed(number8));
		number9.addActionListener(e -> buttonPressed(number9));
		
		add.addActionListener(e -> calculate());
		result.addActionListener(e -> result());
		substract.addActionListener(e -> substract());
		multiply.addActionListener(e -> multiply());
		divide.addActionListener(e -> divide());
		
		
		delete.addActionListener(e -> clear());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
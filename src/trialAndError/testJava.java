package trialAndError;
import javax.swing.*;
import java.awt.*;

public class testJava {
	
	
	
	private static Dimension dim = new Dimension(275, 400);
	private static JFrame frame = new JFrame("Calculator");
	private static JPanel panel = new JPanel(new GridLayout(4, 3, 5, 5));
	private static JPanel leftPanel = new JPanel(new GridLayout(6, 1, 5, 5));
	private static JTextArea screen = new JTextArea("");
	
	private static JButton delete = new JButton("C");
	private static JButton result = new JButton("=");
	private static JButton add = new JButton("+");
	private static JButton substract = new JButton("-");
	private static JButton multiply = new JButton("*");
	
	private static JButton number0 = new JButton("0");
	private static JButton number1 = new JButton("1");
	private static JButton number2 = new JButton("2");
	private static JButton number3 = new JButton("3");
	private static JButton number4 = new JButton("4");
	private static JButton number5 = new JButton("5");
	private static JButton number6 = new JButton("6");
	private static JButton number7 = new JButton("7");
	private static JButton number8 = new JButton("8");
	private static JButton number9 = new JButton("9");
	
	private static void buttonPressed(JButton button) {
		if(isResult) {
			screen.setText("");
			isResult = false;
		}
		screen.append(button.getText());
	}
	
	private static boolean isSubstract = false;
	private static boolean isMultiply = false;
	private static boolean isResult = false;
	
	private static int firstNumber;
	
	private static void calculate() {		
		
		char[] digits = screen.getText().toCharArray();
		int n = digits.length;
		int number = 0;
		
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
		else {
			firstNumber += number;
		}
		screen.setText("");
	}
	
	private static void substract() {
		calculate();
		isSubstract = true;
	}
	
	private static void multiply() {
		calculate();
		isMultiply = true;
	}
	
	private static void result() {
			isResult = true;
			calculate();
			screen.setText(Integer.toString(firstNumber));
			System.out.println(firstNumber);
			firstNumber = 0;
	}
	
	private static void clear() {
		screen.setText("");
	}
	
	public static void main(String[] args) {
		
		screen.setEditable(false);
		frame.setLayout(new BorderLayout());
		
		frame.setLocation(600, 200);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(screen, BorderLayout.NORTH);
		
		panel.setVisible(true);
		
		panel.setSize(100, 100);
		screen.setVisible(true);
		
		frame.setSize(dim);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		leftPanel.add(delete);
		leftPanel.add(result);
		leftPanel.add(add);
		leftPanel.add(substract);
		leftPanel.add(multiply);
		
		panel.add(number7);
		panel.add(number8);
		panel.add(number9);
		panel.add(number4);
		panel.add(number5);
		panel.add(number6);
		panel.add(number1);
		panel.add(number2);
		panel.add(number3);
		panel.add(new JButton()).setVisible(false);
		panel.add(number0);
		
		number0.setVisible(true);
		number1.setVisible(true);
		number2.setVisible(true);
		number3.setVisible(true);
		number4.setVisible(true);
		number5.setVisible(true);
		number6.setVisible(true);
		number7.setVisible(true);
		number8.setVisible(true);
		number9.setVisible(true);
		
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
		
		
		delete.addActionListener(e -> clear());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
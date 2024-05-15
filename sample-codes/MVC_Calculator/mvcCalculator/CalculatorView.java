package mvcCalculator;

import java.awt.event.ActionListener;

import javax.swing.*;
public class CalculatorView extends JFrame{
	
	private JTextField firstNumber = new JTextField (10);
	private JLabel addLabel = new JLabel ("+");
	
	private JTextField secondNumber = new JTextField (10);
	
	private JButton calculateButton = new JButton ("Calculate");
	
	private JTextField theSolution = new JTextField (10);
	
	public CalculatorView () {
		
		JPanel calculatorPanel = new JPanel();
		setSize (300, 300);
		
		calculatorPanel.add(firstNumber);
		calculatorPanel.add(addLabel);
		calculatorPanel.add(secondNumber);
		calculatorPanel.add(calculateButton);
		calculatorPanel.add(theSolution);
		
		add(calculatorPanel);
	
	}
	public int getFirstNumber () {
		return Integer.parseInt(firstNumber.getText());
	}
	public int getSecondNumber () {
		return Integer.parseInt(secondNumber.getText());
	}
	public void setTheSolution (int solution) {
		theSolution.setText(Integer.toString(solution));
	}
	public void addActionListener (ActionListener listenForCalculateButton) {
		calculateButton.addActionListener(listenForCalculateButton);	
	}
	public void displayErrorMessage (String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	
	

}

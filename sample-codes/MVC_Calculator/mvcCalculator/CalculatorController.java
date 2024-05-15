package mvcCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	
	CalculatorView theView;
	CalculatorModel theModel;
	
	public CalculatorController (CalculatorView theView, CalculatorModel theModel) {
		this.theModel = theModel;
		this.theView = theView;
		
		theView.addActionListener(new CalculateListener ());
	}
	class CalculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int firstNumber = 0;
			int secondNumber = 0;
			try {
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				theModel.addTwoNumbers(firstNumber, secondNumber);
				int solution = theModel.getResult();
				theView.setTheSolution(solution);
				
			}catch (NumberFormatException ex) {
				theView.displayErrorMessage("Error! You must enter a number!");
			}
			
		}
		
	}

}

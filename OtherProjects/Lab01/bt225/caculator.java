package bt225;

import javax.swing.JOptionPane;

public class caculator {
	public static void main(String[] args) {
	String strNum1, strNum2;
	strNum1 = JOptionPane.showInputDialog(null,
	"Please input the first number: ","Input the first number", JOptionPane. INFORMATION_MESSAGE);
    double num1 = Double.parseDouble(strNum1);
	
	strNum2 = JOptionPane.showInputDialog(null,
	"Please input the second number: ","Input the second number", JOptionPane. INFORMATION_MESSAGE);
    double num2 = Double.parseDouble(strNum2);

    double sum = num1 + num2;
    double difference = num1 - num2;
    double product = num1 * num2;
    double quotient = num2 != 0 ? num1 / num2 : Double.POSITIVE_INFINITY;

    String strNotification = "Sum of " + num1 + " and " + num2 + " is " + sum + "\n" +
                             "Difference of " + num1 + " and " + num2 + " is " + difference + "\n" +
                             "Product of " + num1 + " and " + num2 + " is " + product + "\n" +
                             "Quotient of " + num1 + " and " + num2 + " is " + quotient;
    JOptionPane.showMessageDialog(null, strNotification, "caculator", JOptionPane. INFORMATION_MESSAGE);
	System.exit(0);
	}
}

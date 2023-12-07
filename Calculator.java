// Import necessary packages for Swing components and event handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Calculator class implementing ActionListener interface
public class Calculator implements ActionListener {

    // Instance variables for the calculator GUI components
    JFrame frame; // The main frame of the calculator
    JTextField textfield; // The text field where the user inputs numbers and sees the results
    JButton[] numberButtons = new JButton[10]; // Array to store number buttons (0-9)
    JButton[] functionButtons = new JButton[12]; // Array to store function buttons (+, -, x, ÷, ., =, Del, Clr, (-))
    JButton addButton, subButton, mulButton, divButton; // Arithmetic operation buttons
    JButton decButton, equButton, delButton, clrButton, negButton; // Decimal, equals, delete, clear, and negate buttons
    JButton sinButton,cosButton,tanButton;
    JPanel panel; // Panel to organize the number and function buttons in a grid layout
    Font myFont = new Font("Ink Free", Font.BOLD, 30); // Custom font for buttons

    // Variables to store the operands, result, and current operator
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor for Calculator class
    Calculator() {
        // Initialize the JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 700);
        frame.setLayout(null);

        // Initialize the text field
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);


        // Initialize the function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");

// Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

// Initialize and set properties for arithmetic operation buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");

// Store function buttons in the array and set properties for each button
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sinButton;
        functionButtons[10] = cosButton;
        functionButtons[11] = tanButton;

// Initialize and set properties for function buttons
        for (int i = 0; i < 12; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }


        // Set positions and sizes for various buttons
        sinButton.setBounds(50, 430, 100, 50);
        cosButton.setBounds(150, 430, 100, 50);
        tanButton.setBounds(250, 430, 100, 50);
        negButton.setBounds(50, 490, 100, 50);
        delButton.setBounds(150, 490, 100, 50);
        clrButton.setBounds(250, 490, 100, 50);



        // Initialize the panel and set layout to grid layout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel in the grid layout
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(tanButton);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);

        // Add a ComponentListener to handle component resize events
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Recalculate frame position to keep it centered when resized
                frame.setLocationRelativeTo(null);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method to create an instance of Calculator class
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }


    /*
     * The actionPerformed method is part of the ActionListener interface
     * and is used to handle button clicks in the calculator.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if a number button is clicked
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                // Concatenate the clicked number to the textfield
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        // Check if the decimal button is clicked
        if (e.getSource() == decButton) {
            // Concatenate a decimal point to the textfield
            textfield.setText(textfield.getText().concat("."));
        }
        // Check if addition button is clicked
        if (e.getSource() == addButton) {
            // Store the current number in num1 and set the operator to addition
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText(""); // Clear the textfield for the next input
        }
        // Check if subtraction button is clicked
        if (e.getSource() == subButton) {
            // Store the current number in num1 and set the operator to subtraction
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        // Check if multiplication button is clicked
        if (e.getSource() == mulButton) {
            // Store the current number in num1 and set the operator to multiplication
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        // Check if division button is clicked
        if (e.getSource() == divButton) {
            // Store the current number in num1 and set the operator to division
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        // Check if equals button is clicked
        if (e.getSource() == equButton) {
            // Store the second number in num2
            num2 = Double.parseDouble(textfield.getText());

            // Perform the corresponding operation based on the stored operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
            // Display the result in the textfield and update num1 for potential further calculations
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        // Check if clear button is clicked, reset the textfield
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        // Check if delete button is clicked
        if (e.getSource() == delButton) {
            // Remove the last character from the textfield
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        // Check if negate button is clicked
        if (e.getSource() == negButton) {
            // Negate the current number in the textfield
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
        // Check if sin button is clicked
        if (e.getSource() == sinButton) {
            // Calculate sin and display the result in the textfield
            double num = Double.parseDouble(textfield.getText());
            double sinValue = Math.sin(Math.toRadians(num));
            textfield.setText(String.valueOf(sinValue));
        }

// Check if cos button is clicked
        if (e.getSource() == cosButton) {
            // Calculate cos and display the result in the textfield
            double num = Double.parseDouble(textfield.getText());
            double cosValue = Math.cos(Math.toRadians(num));
            textfield.setText(String.valueOf(cosValue));
        }

// Check if tan button is clicked
        if (e.getSource() == tanButton) {
            // Calculate tan and display the result in the textfield
            double num = Double.parseDouble(textfield.getText());
            double tanValue = Math.tan(Math.toRadians(num));
            textfield.setText(String.valueOf(tanValue));
        }
    }
}




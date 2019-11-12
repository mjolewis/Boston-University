// File BuildGUI.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**********************************************************************************************************************
 * A BuildGUI class builds a GUI with a text input field and a submit button. This class implements the ActionListener
 * interface to capture the users input.
 *
 * @author mlewis
 * @version Nov 12, 2019
 *********************************************************************************************************************/

public class BuildGUI implements ActionListener {
    // Invariant of the BuildGUI.java class.
    //  1. The instance variable inputField provides a text box on the GUI for the user to type into.
    //  2. The instance variable outputField provides a text box on the GUI to display all prime numbers from 2 to n
    //     where n is the value entered by the user.
    //  3. The instance variable primes is a reference to a CalculatePrimes object.
    private JTextField inputField = new JTextField("", 75);
    private JTextArea outputArea = new JTextArea(15, 75);
    private CalculatePrimes primes;

    /**
     * public void actionPeformed(ActionEvent actionEvent)
     * Action listener listens for the submit button to be pressed.
     * @param actionEvent
     *  An actionEvent object that is triggered by the user pressing the submit button.
     * @postcondition
     *  The user has pressed the submit button and the input has been stored in the instance variable userInput. The
     *  text field has been cleared and focus has been restored to the text field.
     * @exception NumberFormatException
     *  Indicates invalid user input.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int sentinelValue;

        try {
            sentinelValue = Integer.parseInt(inputField.getText());
            inputField.setText("");
            inputField.requestFocus();
            primes = new CalculatePrimes(sentinelValue);
        } catch (NumberFormatException e) {
            inputField.setText("Error. Please enter an integer.");
            inputField.requestFocus();
        }
    }

    /**
     * public void constructGUI()
     * Constructs a GUI.
     * @postcondition
     *  A GUI has been constructed and displayed.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this GUI.
     */
    public void constructGUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel inputLabel = new JLabel("Enter an integer: ");
        JLabel outputLabel = new JLabel("Prime numbers:  ");
        JButton button = new JButton("Submit");

        // Build the panel...
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(outputLabel);
        panel.add(outputArea);

        // ...attach labels to input and output fields...
        inputLabel.setLabelFor(inputField);
        outputLabel.setLabelFor(outputArea);

        // ...set event listeners and restrictions...
        button.addActionListener(this);
        button.setBackground(Color.blue);
        outputArea.setEditable(false);

        // ...build the frame and...
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ...display the frame
        frame.setSize(1000, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * public CalculatePrimes getPrimes()
     * Accessor method that returns a reference to a CalculatePrimes object
     * @return CalculatePrimes
     *  A reference to a CalculatePrimes object.
     */
    public CalculatePrimes getPrimes() { return primes; }

    /**
     * public void setOutputArea(Object[] arr)
     * Mutator method that updates the content of the JTextArea.
     * @param arr
     *  An array container of prime numbers.
     * @postcondition
     *  The numbers in the array container have been added to the JTextArea. Note that there are ten numbers per line.
     *  If any line has fewer than ten numbers, then it is the final line.
     */
    public void setOutputArea(Object[] arr) {
        Integer tmp;
        String input;
        int newLineCounter = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (Object o : arr) {
            if (newLineCounter++ % 10 == 0) {
                stringBuilder.append("\n");
                tmp = (Integer) o;
                input = Integer.toString(tmp);
                stringBuilder.append(input).append(", ");
            } else {
                tmp = (Integer) o;
                input = Integer.toString(tmp);
                stringBuilder.append(input).append(", ");
            }
        }
        outputArea.setText(String.valueOf(stringBuilder));
    }
}

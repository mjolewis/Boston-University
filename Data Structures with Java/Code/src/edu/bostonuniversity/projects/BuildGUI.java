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
 * @version Nov 8, 2019
 *********************************************************************************************************************/

public class BuildGUI implements ActionListener {
    // Invariant of the BuildGUI.java class.
    //  1. The instance variable field provides a text box on the GUI for the user to type into.
    private JTextField field = new JTextField("Enter an integer value", 20);

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
        int maxNumber;

        try {
            maxNumber = Integer.parseInt(field.getText());
            field.setText("");
            field.requestFocus();
            new CalculatePrimes(maxNumber);
        } catch (NumberFormatException e) {
            field.setText("Error. Please enter an integer.");
            field.requestFocus();
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
        JButton button = new JButton("Submit");

        panel.add(field);
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

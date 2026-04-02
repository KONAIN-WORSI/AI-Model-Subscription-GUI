import java.util.ArrayList;
import javax.swing.*;

/**
 * Write a description of class SubscriptionGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubscriptionGUI {   
    public static void main(String[] args) {
        ArrayList<AIModel> plans = new ArrayList<>();

        JFrame frame = new JFrame("AI Model Subscription Management System");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // panel
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 700, 700);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 3));
        frame.add(panel);

        // model name
        JLabel modelLabel = new JLabel("Model Name: ");
        modelLabel.setBounds(50, 50, 200, 25);
        panel.add(modelLabel);

        JTextField modelField = new JTextField();
        modelField.setBounds(155, 50, 200, 25);
        panel.add(modelField);

        // price
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(50, 100, 200, 25);
        panel.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(155, 100, 200, 25);
        panel.add(priceField);

        // parameter count
        JLabel parameterLabel = new JLabel("Parameter Count: ");
        parameterLabel.setBounds(50, 150, 200, 25);
        panel.add(parameterLabel);

        JTextField parameterField = new JTextField();
        parameterField.setBounds(155, 150, 200, 25);
        panel.add(parameterField);

        // context window
        JLabel contextLabel = new JLabel("Context Window: ");
        contextLabel.setBounds(50, 200, 200, 25);
        panel.add(contextLabel);

        JTextField contextField = new JTextField();
        contextField.setBounds(155, 200, 200, 25);
        panel.add(contextField);

        // available team slots
        JLabel teamLabel = new JLabel("Team Slots: ");
        teamLabel.setBounds(50, 250, 200, 25);
        panel.add(teamLabel);

        JTextField teamField = new JTextField();
        teamField.setBounds(155, 250, 200, 25);
        panel.add(teamField);

        // Personal Plan Button
        JButton personalButton = new JButton();
        personalButton.setText("Personal Plan Button");
        personalButton.setBounds(400, 100, 200, 25);
        panel.add(personalButton);

        // Pro Plan Button
        JButton proButton = new JButton();
        proButton.setText("Pro Plan Button");
        proButton.setBounds(400, 150, 200, 25);
        panel.add(proButton);

        // display button
        JButton displayButton = new JButton();
        displayButton.setText("Display Output Details");
        displayButton.setBounds(400, 200, 200, 25);
        panel.add(displayButton);

        // clear button
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(400, 250, 200, 25);
        panel.add(clearButton);

        // Display outpu area
        JTextArea area = new JTextArea();
        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(100, 350, 500, 300);
        panel.add(pane);


        // event handling

        // Personal Plan Button
        personalButton.addActionListener(e -> {
            try{
                String name = modelField.getText();

                if(!name.matches("[a-zA-Z ]+")){
                    JOptionPane.showMessageDialog(frame, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price = Double.parseDouble(priceField.getText());
                int parameterCount = Integer.parseInt(parameterField.getText());
                int contextWindow = Integer.parseInt(contextField.getText());

                PersonalPlan personalPlan = new  PersonalPlan(name, price, parameterCount, contextWindow, 500);
                plans.add(personalPlan);
                JOptionPane.showMessageDialog(frame, "Personal Plan created successfully!" + "\n" + personalPlan.displayOutput());

            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid input for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Pro Plan Button
        proButton.addActionListener(e -> {
            try{
                String name = modelField.getText();

                if(!name.matches("[a-zA-Z ]+")){
                    JOptionPane.showMessageDialog(frame, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price = Double.parseDouble(priceField.getText());
                int parameterCount = Integer.parseInt(parameterField.getText());
                int contextWindow = Integer.parseInt(contextField.getText());
                int teamSlots = Integer.parseInt(teamField.getText());

                ProPlan proPlan = new ProPlan(name, price, parameterCount, contextWindow, teamSlots);
                plans.add(proPlan);
                JOptionPane.showMessageDialog(frame, "Pro Plan created successfully!" + "\n" + proPlan.displayOutput());

            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid input for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // clear button
        clearButton.addActionListener(e -> {
            modelField.setText("");
            priceField.setText("");
            parameterField.setText("");
            contextField.setText("");
            teamField.setText("");
            area.setText("");
        });

        // display button
        displayButton.addActionListener(e -> {
            if(plans.isEmpty()){
                 JOptionPane.showMessageDialog(frame, "No plans to display. Please create a plan first.");
            } else {
                 StringBuilder output = new StringBuilder();
                 for(AIModel plan : plans){
                     output.append(plan.displayOutput()).append("\n-------------------\n");
                 }
                 area.setText(output.toString());
            }
        });
        
        


        frame.setVisible(true);

    }
}
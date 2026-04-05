import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class SubscriptionGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubscriptionGUI {   
    public static void main(String[] args) {
        ArrayList<AIModel> plans = new ArrayList<>();

        JFrame frame = new JFrame("AI Subscription Manager");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Text Fields
        JTextField modelNameField = new JTextField(25);
        JTextField priceField = new JTextField(25);
        JTextField parametersField = new JTextField(25);
        JTextField contextWindowField = new JTextField(25);
        JTextField teamSlotsField = new JTextField(25);
        JTextField promptField = new JTextField(25);
        JTextField responseLengthField = new JTextField(25);
        JTextField teamMemberField = new JTextField(25);

        // ============ LEFT PANEL (FORM) ============
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);

        // Model details group
        JPanel modelSection = new JPanel();
        modelSection.setLayout(null);
        modelSection.setBorder(BorderFactory.createTitledBorder("Model Details"));
        modelSection.setBounds(10, 10, 340, 180);

        JLabel modLabel = new JLabel("Model Name:");
        modLabel.setBounds(15, 25, 110, 25);
        modelSection.add(modLabel);
        modelNameField.setBounds(130, 25, 190, 25);
        modelSection.add(modelNameField);

        JLabel priceLabel = new JLabel("Price ($):");
        priceLabel.setBounds(15, 55, 110, 25);
        modelSection.add(priceLabel);
        priceField.setBounds(130, 55, 190, 25);
        modelSection.add(priceField);

        JLabel parametersLabel = new JLabel("Parameter Count:");
        parametersLabel.setBounds(15, 85, 110, 25);
        modelSection.add(parametersLabel);
        parametersField.setBounds(130, 85, 190, 25);
        modelSection.add(parametersField);

        JLabel contextWindowLabel = new JLabel("Context Window:");
        contextWindowLabel.setBounds(15, 115, 110, 25);
        modelSection.add(contextWindowLabel);
        contextWindowField.setBounds(130, 115, 190, 25);
        modelSection.add(contextWindowField);

        leftPanel.add(modelSection);

        // Plan settings group
        JPanel planSection = new JPanel();
        planSection.setLayout(null);
        planSection.setBorder(BorderFactory.createTitledBorder("Plan Settings"));
        planSection.setBounds(10, 200, 340, 140);

        JLabel teamSlotsLabel = new JLabel("Team Slots:");
        teamSlotsLabel.setBounds(15, 25, 110, 25);
        planSection.add(teamSlotsLabel);
        teamSlotsField.setBounds(130, 25, 190, 25);
        planSection.add(teamSlotsField);

        JLabel promptLabel = new JLabel("Prompt:");
        promptLabel.setBounds(15, 55, 110, 25);
        planSection.add(promptLabel);
        promptField.setBounds(130, 55, 190, 25);
        planSection.add(promptField);

        JLabel responseLengthLabel = new JLabel("Response Length:");
        responseLengthLabel.setBounds(15, 85, 110, 25);
        planSection.add(responseLengthLabel);
        responseLengthField.setBounds(130, 85, 190, 25);
        planSection.add(responseLengthField);

        leftPanel.add(planSection);

        // Team management group
        JPanel teamSection = new JPanel();
        teamSection.setLayout(null);
        teamSection.setBorder(BorderFactory.createTitledBorder("Team Management"));
        teamSection.setBounds(10, 350, 340, 100);

        JLabel teamMemberLabel = new JLabel("Team Member Name:");
        teamMemberLabel.setBounds(15, 25, 125, 25);
        teamSection.add(teamMemberLabel);
        teamMemberField.setBounds(160, 25, 170, 25);
        teamSection.add(teamMemberField);

        leftPanel.add(teamSection);

        // Set left panel size
        leftPanel.setPreferredSize(new Dimension(360, 470));
        leftPanel.setSize(360, 470);

        JScrollPane leftScrollPane = new JScrollPane(leftPanel);
        leftScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // ============ CENTER PANEL (DISPLAY AREA) ============
        JTextArea displayArea = new JTextArea();
        displayArea.setFont(new Font("Roboto Bold", Font.PLAIN, 11));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output Display"));

        // ============ BUTTONS ============
        JButton addPersonal = new JButton("Add Personal Plan");
        JButton addPro = new JButton("Add Pro Plan");
        JButton displayPlans = new JButton("Display Plans");
        JButton promptBtn = new JButton("Give a Prompt");
        JButton clearBtn = new JButton("Clear Fields");
        JButton addTeamMember = new JButton("Add Team Member");
        JButton checkPlanType = new JButton("Check Plan Type");
        JButton exportBtn = new JButton("Export to File");
        JButton loadBtn = new JButton("Load From File");

        // Set button sizes
        Dimension buttonSize = new Dimension(140, 35);
        addPersonal.setPreferredSize(buttonSize);
        addPro.setPreferredSize(buttonSize);
        displayPlans.setPreferredSize(buttonSize);
        promptBtn.setPreferredSize(buttonSize);
        clearBtn.setPreferredSize(buttonSize);
        addTeamMember.setPreferredSize(buttonSize);
        checkPlanType.setPreferredSize(buttonSize);
        exportBtn.setPreferredSize(buttonSize);
        loadBtn.setPreferredSize(buttonSize);

        // Main layout - NULL LAYOUT
        frame.setLayout(null);

        // Position components manually
        leftScrollPane.setBounds(10, 10, 360, 600);
        scrollPane.setBounds(380, 10, 600, 600);

        // Position buttons with spacing
        int buttonY = 620;
        int buttonSpacing = 15;
        int startX = 10;

        addPersonal.setBounds(startX, buttonY, 140, 35);
        addPro.setBounds(startX + 155, buttonY, 140, 35);
        displayPlans.setBounds(startX + 310, buttonY, 140, 35);
        promptBtn.setBounds(startX + 465, buttonY, 140, 35);
        clearBtn.setBounds(startX + 620, buttonY, 140, 35);

        // Second row of buttons
        buttonY += 45;
        addTeamMember.setBounds(startX, buttonY, 140, 35);
        checkPlanType.setBounds(startX + 155, buttonY, 140, 35);
        exportBtn.setBounds(startX + 310, buttonY, 140, 35);
        loadBtn.setBounds(startX + 465, buttonY, 140, 35);

        // Add components to frame
        frame.add(leftScrollPane);
        frame.add(scrollPane);
        frame.add(addPersonal);
        frame.add(addPro);
        frame.add(displayPlans);
        frame.add(promptBtn);
        frame.add(clearBtn);
        frame.add(addTeamMember);
        frame.add(checkPlanType);
        frame.add(exportBtn);
        frame.add(loadBtn);

        frame.setVisible(true);

        // ============ EVENT HANDLING ============

        // Personal Plan Button
        addPersonal.addActionListener(e -> {
            try{
                String name = modelNameField.getText();

                if(!name.matches("[a-zA-Z ]+")){
                    JOptionPane.showMessageDialog(frame, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price = Double.parseDouble(priceField.getText());
                int parameterCount = Integer.parseInt(parametersField.getText());
                int contextWindow = Integer.parseInt(contextWindowField.getText());

                PersonalPlan personalPlan = new  PersonalPlan(name, price, parameterCount, contextWindow, 500);
                plans.add(personalPlan);
                JOptionPane.showMessageDialog(frame, "Personal Plan created successfully!" + "\n" + personalPlan.displayOutput());

            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid input for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Pro Plan Button
        addPro.addActionListener(e -> {
            try{
                String name = modelNameField.getText();

                if(!name.matches("[a-zA-Z ]+")){
                    JOptionPane.showMessageDialog(frame, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price = Double.parseDouble(priceField.getText());
                int parameterCount = Integer.parseInt(parametersField.getText());
                int contextWindow = Integer.parseInt(contextWindowField.getText());
                int teamSlots = Integer.parseInt(teamSlotsField.getText());

                ProPlan proPlan = new ProPlan(name, price, parameterCount, contextWindow, teamSlots);
                plans.add(proPlan);
                JOptionPane.showMessageDialog(frame, "Pro Plan created successfully!" + "\n" + proPlan.displayOutput());

            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid input for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // clear button
        clearBtn.addActionListener(e -> {
            modelNameField.setText("");
            priceField.setText("");
            parametersField.setText("");
            contextWindowField.setText("");
            teamSlotsField.setText("");
            displayArea.setText("");
            teamMemberField.setText("");
            promptField.setText("");
            responseLengthField.setText("");
            teamSlotsField.setText("");
        });

        // display button
        displayPlans.addActionListener(e -> {
            if(plans.isEmpty()){
                 JOptionPane.showMessageDialog(frame, "No plans to display. Please create a plan first.");
            } else {
                 StringBuilder output = new StringBuilder();
                 for(AIModel plan : plans){
                     output.append(plan.displayOutput()).append("\n-------------------\n");
                 }
                 displayArea.setText(output.toString());
            }
        });
    }
}
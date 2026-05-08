import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Provides a Graphical User Interface (GUI) for managing AI subscription plans.
 * Allows users to add, view, and interact with Personal and Pro plans.
 *
 * @author Konain
 * @version 1.0
 */
public class SubscriptionGUI {   
    
    /**
     * Main method that launches the AI Subscription Manager GUI.
     * Sets up the frame, panels, input fields, and action listeners for all features.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ArrayList<AIModel> plans = new ArrayList<>();

        JFrame frame = new JFrame("AI Subscription Manager");
        frame.setSize(1100, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Text Fields
        JTextField modelNameField = new JTextField(25);
        JTextField priceField = new JTextField(25);
        JTextField parametersField = new JTextField(25);
        JTextField contextWindowField = new JTextField(25);
        JTextField promptsQuotaField = new JTextField(25);
        JTextField teamSlotsField = new JTextField(25);
        JTextField promptField = new JTextField(25);
        JTextField responseLengthField = new JTextField(25);
        JTextField teamMemberField = new JTextField(25);
        JTextField indexField = new JTextField(25);
        JTextField modelIndexField = new JTextField(25);
        JTextField buyPromptField = new JTextField(25);
        JTextField checkPlanIndexField = new JTextField(25);

        //  CENTER PANEL  
        JTextArea displayArea = new JTextArea();
        displayArea.setFont(new Font("Roboto Bold", Font.PLAIN, 11));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output Display"));

        //  BUTTONS 
        JButton addPersonal = new JButton("Add Personal Plan");
        JButton addPro = new JButton("Add Pro Plan");
        JButton displayPlans = new JButton("Display Plans");
        JButton promptBtn = new JButton("Give a Prompt");
        JButton clearBtn = new JButton("Clear Fields");
        JButton addTeamMember = new JButton("Add Member");
        JButton checkPlanType = new JButton("Check Plan Type");
        JButton exportBtn = new JButton("Export to File");
        JButton loadBtn = new JButton("Load From File");
        JButton removeTeamMemberBtn = new JButton("Remove Member");
        JButton buyPromptBtn = new JButton("Buy Prompt");

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
        removeTeamMemberBtn.setPreferredSize(buttonSize);
        buyPromptBtn.setPreferredSize(buttonSize);

        frame.setLayout(null);

        // Model Panel
        JPanel modelPanel = new JPanel();
        modelPanel.setLayout(null);
        modelPanel.setBorder(BorderFactory.createTitledBorder("Model Details"));
        // Model details
        JLabel modLabel = new JLabel("*Model Name:");
        modLabel.setBounds(15, 25, 110, 25);
        modelPanel.add(modLabel);
        modelNameField.setBounds(130, 25, 190, 25);
        modelPanel.add(modelNameField);
        JLabel priceLabel = new JLabel("*Price ($):");
        priceLabel.setBounds(15, 55, 110, 25);
        modelPanel.add(priceLabel);
        priceField.setBounds(130, 55, 190, 25);
        modelPanel.add(priceField);
        JLabel parametersLabel = new JLabel("*Parameter Count:");
        parametersLabel.setBounds(15, 85, 110, 25);
        modelPanel.add(parametersLabel);
        parametersField.setBounds(130, 85, 190, 25);
        modelPanel.add(parametersField);
        JLabel contextWindowLabel = new JLabel("*Context Window:");
        contextWindowLabel.setBounds(15, 115, 110, 25);
        modelPanel.add(contextWindowLabel);
        contextWindowField.setBounds(130, 115, 190, 25);
        modelPanel.add(contextWindowField);
        JLabel promptsQuotaLabel = new JLabel("Prompts Quota:");
        promptsQuotaLabel.setBounds(15, 145, 110, 25);
        modelPanel.add(promptsQuotaLabel);
        promptsQuotaField.setBounds(130, 145, 190, 25);
        modelPanel.add(promptsQuotaField);
        JLabel teamSlotsLabel = new JLabel("Team Slots:");
        teamSlotsLabel.setBounds(15, 175, 110, 25);
        modelPanel.add(teamSlotsLabel);
        teamSlotsField.setBounds(130, 175, 190, 25);
        modelPanel.add(teamSlotsField);
        // Buttons
        addPersonal.setBounds(10, 210, 140, 35);
        modelPanel.add(addPersonal);
        addPro.setBounds(160, 210, 140, 35);
        modelPanel.add(addPro);
        // Prompt Setting Panel
        JPanel promptPanel = new JPanel();
        promptPanel.setLayout(null);
        promptPanel.setBorder(BorderFactory.createTitledBorder("Prompt Settings"));
        // Prompt settings
        JLabel promptLabel = new JLabel("Prompt:");
        promptLabel.setBounds(15, 25, 110, 25);
        promptPanel.add(promptLabel);
        promptField.setBounds(130, 25, 190, 25);
        promptPanel.add(promptField);
        JLabel responseLengthLabel = new JLabel("Response Length:");
        responseLengthLabel.setBounds(15, 55, 110, 25);
        promptPanel.add(responseLengthLabel);
        responseLengthField.setBounds(130, 55, 190, 25);
        promptPanel.add(responseLengthField);
        JLabel buyPromptLabel = new JLabel("Buy Prompts:");
        buyPromptLabel.setBounds(15, 85, 110, 25);
        promptPanel.add(buyPromptLabel);
        buyPromptField.setBounds(130, 85, 190, 25);
        promptPanel.add(buyPromptField);
        JLabel indexLabel = new JLabel("Index: ");
        indexLabel.setBounds(15, 115, 110, 25);
        promptPanel.add(indexLabel);
        indexField.setBounds(130, 115, 190, 25);
        promptPanel.add(indexField);
        // Buttons
        promptBtn.setBounds(10, 150, 140, 35);
        promptPanel.add(promptBtn);
        buyPromptBtn.setBounds(160, 150, 140, 35);
        promptPanel.add(buyPromptBtn);
        // Team Panel
        JPanel teamPanel = new JPanel();
        teamPanel.setLayout(null);
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Management"));
        JLabel teamMemberLabel = new JLabel("Team Member Name:");
        teamMemberLabel.setBounds(15, 25, 135, 25);
        teamPanel.add(teamMemberLabel);
        teamMemberField.setBounds(160, 25, 160, 25);
        teamPanel.add(teamMemberField);
        JLabel modelIndexLabel = new JLabel("Model Index: ");
        modelIndexLabel.setBounds(15, 55, 110, 25);
        teamPanel.add(modelIndexLabel);
        modelIndexField.setBounds(130, 55, 190, 25);
        teamPanel.add(modelIndexField);
        addTeamMember.setBounds(10, 100, 140, 35);
        teamPanel.add(addTeamMember);
        removeTeamMemberBtn.setBounds(160, 100, 140, 35);
        teamPanel.add(removeTeamMemberBtn);
        // Check Panel
        JPanel checkPanel = new JPanel();
        checkPanel.setLayout(null);
        checkPanel.setBorder(BorderFactory.createTitledBorder("Check Plan"));
        JLabel checkIndexLabel = new JLabel("Plan Index:");
        checkIndexLabel.setBounds(15, 25, 110, 25);
        checkPanel.add(checkIndexLabel);
        checkPlanIndexField.setBounds(130, 25, 190, 25);
        checkPanel.add(checkPlanIndexField);
        checkPlanType.setBounds(10, 65, 140, 30);
        checkPanel.add(checkPlanType);

        // Position components manually
        modelPanel.setBounds(10, 10, 360, 250);
        promptPanel.setBounds(10, 270, 360, 200);
        teamPanel.setBounds(10, 480, 360, 150);
        checkPanel.setBounds(10, 640, 360, 110);
        scrollPane.setBounds(380, 10, 520, 730);

        // Position buttons with spacing on right side
        int buttonY = 20;
        int startX = 900;

        displayPlans.setBounds(startX, buttonY, 120, 35);
        clearBtn.setBounds(startX, buttonY + 40, 120, 35);
        exportBtn.setBounds(startX, buttonY + 80, 120, 35);
        loadBtn.setBounds(startX, buttonY + 120, 120, 35);

        // Add components to frame
        frame.add(modelPanel);
        frame.add(promptPanel);
        frame.add(teamPanel);
        frame.add(checkPanel);
        frame.add(scrollPane);
        frame.add(displayPlans);
        frame.add(clearBtn);
        frame.add(exportBtn);
        frame.add(loadBtn);

        frame.setVisible(true);

        // Event handling

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
                int promptsQuota = Integer.parseInt(promptsQuotaField.getText());

                PersonalPlan personalPlan = new  PersonalPlan(name, price, parameterCount, contextWindow, promptsQuota);
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

        // add team member button
        addTeamMember.addActionListener(e -> {
            try{
                String teamMember = teamMemberField.getText();
                if(teamMember.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please enter a team member name.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int index = Integer.parseInt(modelIndexField.getText());

                if (index != -1) {
                    if (index < 0 || index >= plans.size()) {
                        JOptionPane.showMessageDialog(frame, "Invalid index! Please enter a valid plan index.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    AIModel plan = plans.get(index);
                    if (plan instanceof ProPlan) {
                        ProPlan proPlan = (ProPlan) plan;
                        String result = proPlan.addTeamMember(teamMember);
                        if (result.startsWith("ERROR")) {
                            JOptionPane.showMessageDialog(frame, result, "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, result);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "team collaboration is only available for Pro Plan subscriptions", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid index number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while adding the team member.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // remove team member button
        removeTeamMemberBtn.addActionListener(e -> {
            try{
                String teamMember = teamMemberField.getText();
                if(teamMember.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please enter a team member name.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int index = Integer.parseInt(modelIndexField.getText());

                if (index != -1) {
                    if (index < 0 || index >= plans.size()) {
                        JOptionPane.showMessageDialog(frame, "Invalid index! Please enter a valid plan index.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    AIModel plan = plans.get(index);
                    if (plan instanceof ProPlan) {
                        ProPlan proPlan = (ProPlan) plan;
                        String result = proPlan.removeTeamMember(teamMember);
                        if (result.startsWith("ERROR")) {
                            JOptionPane.showMessageDialog(frame, result, "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, result);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Team collaboration is only available for Pro Plan subscriptions.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid index number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while removing the team member.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // check plan type button
        checkPlanType.addActionListener(e -> {
            try{
                int index = Integer.parseInt(checkPlanIndexField.getText());
                checkPlanType(index, plans, frame);
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid index number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while checking the plan type.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // prompt button
        promptBtn.addActionListener(e -> {
            try{
                String promptText = promptField.getText();
                int responseTokens = Integer.parseInt(responseLengthField.getText());
                int index = Integer.parseInt(indexField.getText());

                if(index == -1) {
                    JOptionPane.showMessageDialog(frame, "Invalid index! No plan selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(index < 0 || index >= plans.size()) {
                    JOptionPane.showMessageDialog(frame, "Invalid index! Please enter a valid plan index.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(plans.get(index) instanceof PersonalPlan) {
                    PersonalPlan personalPlan = (PersonalPlan) plans.get(index);
                    personalPlan.enterPrompt(promptText, responseTokens);
                } else if(plans.get(index) instanceof ProPlan) {
                    ProPlan proPlan = (ProPlan) plans.get(index);
                    proPlan.enterPrompt(promptText, responseTokens);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid index! Please select a valid plan type.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for prompt tokens and index.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while processing the prompt.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
        });

        // buy prompt button
        buyPromptBtn.addActionListener(e -> {
            try {
                int index = Integer.parseInt(indexField.getText());
                int buyAmount = Integer.parseInt(buyPromptField.getText());

                if (index < 0 || index >= plans.size()) {
                    JOptionPane.showMessageDialog(frame, "Invalid index! Please enter a valid plan index.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (buyAmount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a positive number of prompts to purchase.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AIModel plan = plans.get(index);
                if (plan instanceof PersonalPlan) {
                    PersonalPlan personalPlan = (PersonalPlan) plan;
                    String result = personalPlan.purchasePrompts(buyAmount);
                    if (result.startsWith("ERROR")) {
                        JOptionPane.showMessageDialog(frame, result, "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, result);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Buying prompts is only available for Personal Plans.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid whole numbers for the plan index and prompts to purchase.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while purchasing prompts.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // load button
        loadBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try(BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                        String line;
                        StringBuilder fileContent = new StringBuilder();
                        while ((line = reader.readLine()) != null) {
                            fileContent.append(line).append("\n");
                        }
                        displayArea.setText(fileContent.toString());
                    } catch(IOException ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while loading the file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
        });

        // export button 
        exportBtn.addActionListener(e -> {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("Membership.txt"))) {
                for(AIModel plan: plans) {
                    if (plan instanceof PersonalPlan) {
                         writer.write("=== Personal Plan ===\n");
                     } else if (plan instanceof ProPlan) {
                         writer.write("=== Pro Plan ===\n");
                     }  
                    writer.write(plan.displayOutput() + "\n");
                    writer.write("-------------------\n");
                }
                JOptionPane.showMessageDialog(frame, "Plans exported successfully to Membership.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }catch(IOException ex) {
                JOptionPane.showMessageDialog(frame, "An error occurred while exporting the plans.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        
        // clear button
        clearBtn.addActionListener(e -> {
            modelNameField.setText("");
            priceField.setText("");
            parametersField.setText("");
            contextWindowField.setText("");
            promptsQuotaField.setText("");
            teamSlotsField.setText("");
            displayArea.setText("");
            teamMemberField.setText("");
            promptField.setText("");
            responseLengthField.setText("");
            indexField.setText("");
            modelIndexField.setText("");
            buyPromptField.setText("");
            checkPlanIndexField.setText("");
        });

        // display button
        displayPlans.addActionListener(e -> {
            if(plans.isEmpty()){
                 JOptionPane.showMessageDialog(frame, "No plans to display. Please create a plan first.");
            } else {
                 StringBuilder output = new StringBuilder();
                 for(AIModel plan : plans){
                     if (plan instanceof PersonalPlan) {
                         output.append("=== Personal Plan ===\n");
                     } else if (plan instanceof ProPlan) {
                         output.append("=== Pro Plan ===\n");
                     }
                     output.append(plan.displayOutput()).append("\n-------------------\n");
                 }
                 displayArea.setText(output.toString());
            }
        });
    }

    /**
     * Checks and displays the type of the selected AI model plan (Personal or Pro).
     * Validates the provided index against the list of available plans.
     * 
     * @param index The selected index from the GUI to check.
     * @param plans The list of all currently available AI plans.
     * @param frame The parent JFrame to display the JOptionPane dialogs.
     */
    public static void checkPlanType(int index, ArrayList<AIModel> plans, JFrame frame) {
        if (index < 0 || index >= plans.size()) {
            JOptionPane.showMessageDialog(frame, "Invalid index! Please enter a valid plan index.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AIModel plan = plans.get(index);
        if (plan instanceof PersonalPlan) {
            JOptionPane.showMessageDialog(frame, "Personal Plan");
        } else if (plan instanceof ProPlan) {
            JOptionPane.showMessageDialog(frame, "Pro Plan");
        } else {
            JOptionPane.showMessageDialog(frame, "Neither Personal nor Pro Plan");
        }
    }
}





import java.util.ArrayList;
import javax.swing.*;
/**
 * Represents a professional subscription plan for an AI Model.
 * Inherits from AIModel and allows team collaboration with available slots.
 *
 * @author Konain
 * @version 1.0
 */
public class ProPlan extends AIModel
{
    private int availableSlots;
    private ArrayList<String> teamMember = new ArrayList<>();
    
    /**
     * Constructor for objects of class ProPlan.
     * 
     * @param modelName      The name of the AI model.
     * @param price          The price of the pro plan.
     * @param parameterCount The parameter count of the model.
     * @param contextWindow  The context window size of the model.
     * @param availableSlots The initial number of team slots available.
     */
    ProPlan(String modelName, double price, int parameterCount, int contextWindow, int availableSlots) {
        super(modelName, price, parameterCount, contextWindow);
        this.availableSlots = availableSlots;
    }

    /**
     * Adds a new team member if there are available slots and the member does not already exist.
     * 
     * @param memberName The name of the team member to add.
     * @return A status message indicating success or error.
     */
    public String addTeamMember(String memberName) {
        if (availableSlots > 0) {
            if (!teamMember.contains(memberName)) {
                teamMember.add(memberName);
                availableSlots--;
                return "Team Member added successfully, Slot remaining: " + availableSlots;
            } else {
                return "ERROR: Team member already exists";
            }
        } else {
            return "ERROR: No available team slots";
        }
    }
    
    /**
     * Removes an existing team member and frees up a slot.
     * 
     * @param memberName The name of the team member to remove.
     * @return A status message indicating success or error.
     */
    public String removeTeamMember(String memberName) {
        if(teamMember.contains(memberName)){
            teamMember.remove(memberName);
            availableSlots++;
            return "Team member removed successfully";
        }else {
            return "ERROR: Team member not found";
        }
    }

    // public String usePrompt(String promptText, int expectedTokens, int outputTokens, int systemTokens) {
    //     if(calculateTokenUsage(expectedTokens, systemTokens, outputTokens))
    //         return "Prompt accepted \n"
    //             +  "Prompt: " + promptText + "\n"
    //             +  "Expected Tokens: " + expectedTokens;
    //     else {
    //         return "Context window exceeded. Please reduce the number of tokens in your prompt or expected output.";
    //     }   
    // }

    /**
     * Processes an input prompt for the pro plan.
     * Displays a success message if the token usage is within the context window limit.
     * 
     * @param promptText     The actual text content of the prompt provided by the user.
     * @param responseTokens The expected number of tokens the model will generate.
     */
    @Override
    public void enterPrompt(String promptText, int responseTokens) {
        if (calculateTokenUsage(responseTokens, 0, 0)) {
            JOptionPane.showMessageDialog(null, "Prompt accepted \n"                +  "Prompt: " + promptText + "\n"
                +  "Expected Tokens: " + responseTokens);
        } else {
            JOptionPane.showMessageDialog(null, "Context window exceeded. Please reduce the number of tokens in your prompt or expected output.");
        }
    }
    
    /**
     * Generates a formatted string containing the details of the pro plan.
     * 
     * @return A string representation including available team slots.
     */
    @Override
    public String displayOutput() {
         return "AI Model Name:" + getModelName() + 
            "\nPrice of Model: " + getPrice() 
            + "\nParameter Count: " + getParameterCount() 
            + "\nContext Window Size: " + getContextWindow()
            + "\nAvailable Team Slots: " + availableSlots;
    }

}
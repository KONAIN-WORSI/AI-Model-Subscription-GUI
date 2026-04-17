import javax.swing.*;
/**
 * Represents a personal subscription plan for an AI Model.
 * Inherits from AIModel and manages a specific quota of prompts.
 *
 * @author Konain
 * @version 1.0
 */
public class PersonalPlan extends AIModel
{
    private int promptsRemaining;   
    /**
     * Constructor for objects of class PersonalPlan.
     * 
     * @param modelName      The name of the AI model.
     * @param price          The price of the personal plan.
     * @param parameterCount The parameter count of the model.
     * @param contextWindow  The context window size of the model.
     * @param promptsQuota   The initial quota of prompts available.
     */
    PersonalPlan(String modelName, double price, int parameterCount, int contextWindow, int promptsQuota) {
        super(modelName, price, parameterCount, contextWindow);
        this.promptsRemaining  = promptsQuota;
    }
    /**
     * Retrieves the remaining number of prompts available in the quota.
     * 
     * @return The number of remaining prompts.
     */
    public int getPromptsRemaining() {
        return this.promptsRemaining;
    }    
    /**
     * Purchases additional prompts and adds them to the remaining quota.
     * 
     * @param buyPrompts The number of prompts to purchase.
     * @return A message indicating the purchase status.
     */
    public String purchasePrompts(int buyPrompts) {
        if (buyPrompts <= 0) {
            System.out.println("Please enter a positive number to purchase additional prompts!");
        }

        buyPrompts += this.promptsRemaining;
        this.promptsRemaining = buyPrompts;
        return "You have successfully purchased prompts. Your remaining prompts: " + buyPrompts; 
    }
    /**
     * Processes an input prompt for the personal plan.
     * Decreases the remaining prompts if the token usage is within the context window limit.
     * Displays a corresponding graphical message.
     * 
     * @param promptText     The actual text content of the prompt provided by the user.
     * @param responseTokens The expected number of tokens the model will generate.
     */
    @Override
    public void enterPrompt(String promptText, int responseTokens) {
        if (promptsRemaining <= 0) {
            JOptionPane.showMessageDialog(null, "Monthly plan limit reached. Please upgrade your plan.");
            return;
        }

        if (calculateTokenUsage(responseTokens, 0, 0)) {
            promptsRemaining--;
            JOptionPane.showMessageDialog(null, "Prompt accepted \n"                +  "Prompt: " + promptText + "\n"
                +  "Expected Tokens: " + responseTokens + "\n"
                +  "Remaining prompts: " + promptsRemaining);
        } else {
            JOptionPane.showMessageDialog(null, "Context window exceeded. Please reduce the number of tokens in your prompt or expected output.");
        }
    }   
    /**
     * Generates a formatted string containing the details of the personal plan.
     * 
     * @return A string representation including the remaining prompts.
     */
    @Override
    public String displayOutput() {
        return "AI Model Name:" + getModelName() + 
            "\nPrice of Model: " + getPrice() 
            + "\nParameter Count: " + getParameterCount() 
            + "\nContext Window Size: " + getContextWindow() 
            + "\nRemaining Prompts in Monthly Quota: " + promptsRemaining;
    }
}
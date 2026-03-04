
/**
 * Write a description of class PersonalPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonalPlan extends AIModel
{
    private int promptsRemaining;
    
    PersonalPlan(String modelName, double price, int paramaterCount, int contextWindow, int promptsQuota) {
        super(modelName, price, paramaterCount, contextWindow);
        this.promptsRemaining  = promptsQuota;
    }
    
    public int getPromptsRemaining() {
        return this.promptsRemaining;
    }
    
    public String purchasePrompts(int buyPrompts) {
        if (buyPrompts <= 0) {
            System.out.println("Please enter a positive number to purchase additional prompts!");
        }

        buyPrompts += this.promptsRemaining;
        this.promptsRemaining = buyPrompts;
        return "You have successfully purchased prompts. Your remaining prompts: " + buyPrompts; 
    }
    
    public String usePrompt(String promptText, int expectedTokens, int systemTokens, int outputTokens) {
        if(!calculateTokenUsage(expectedTokens, systemTokens, outputTokens))
            return "Context window exceeded. Please reduce the number of tokens in your prompt or expected output.";

        if (promptsRemaining > 0) {
            promptsRemaining--;
            
            return "Prompt accepted \n"
                +  "Prompt: " + promptText + "\n"
                +  "Expected Tokens: " + expectedTokens + "\n"
                +  "Remaining prompts: " + promptsRemaining;
        }else {
            return "Monthly plan limit reached. Please upgrade your plan.";
        }
    }
    
    @Override
    public String displayOutput() {
        return "AI Model Name:" + getModelName() + 
            "\nPrice of Model: " + getPrice() 
            + "\nParamater Count: " + getParamaterCount() 
            + "\nContext Window Size: " + getContextWindow() 
            + "\nRemaining Prompts in Monthly Quota: " + promptsRemaining;
    }
}
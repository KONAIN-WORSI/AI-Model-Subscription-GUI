
/**
 * Write a description of class PersonalPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonalPlan extends AIModel
{
    private int promptsMonthlyQuota;
    
    PersonalPlan(int promptsMonthlyQuota, String modelName, double price, int paramaterCount, String contextWindow) {
        super(modelName, price, paramaterCount, contextWindow);
        this.promptsMonthlyQuota = promptsMonthlyQuota;
    }
    
    public int getPromptsMonthlyQuota() {
        return this.promptsMonthlyQuota;
    }
    
    public void setPromptsMonthlyQuota(int promptsMonthlyQuota) {
        this.promptsMonthlyQuota = promptsMonthlyQuota;
    }
    
    public String purchaseAdditionalPrompts(int buyPrompts, int promptsMonthlyQuota) {
        if (buyPrompts >= 0) {
            System.out.println("Please enter a positive number to purchase additional prompts!");
        }

        buyPrompts += this.promptsMonthlyQuota;
        return "You have successfully purchased additional prompts. Your remaining prompts: " + promptsMonthlyQuota; 
    }
    
    public String sendPrompt(String promptText, int expectedTokens) {
        if (promptsMonthlyQuota > 0) {
            promptsMonthlyQuota--;
            
            return "Promp accepted \n"
                +  "Prompt: " + promptText + "\n"
                +  "Expected Tokens: " + expectedTokens + "\n"
                +  "Remaining prompts: " + promptsMonthlyQuota;
        }else {
            return "Monthly plan limit reached. Please upgrade your plan.";
        }
    }
    
    @Override
    public String displayOutput() {
        String parentDetails = super.displayOutput();
        
        return "Remaining Prompts in Monthly Quota: " + promptsMonthlyQuota;
    }
    
    
    
}
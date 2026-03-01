import java.util.ArrayList;

/**
 * Write a description of class ProPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProPlan extends AIModel
{
    private int availableSlots;
    private ArrayList<String> teamMember = new ArrayList<>();
    
    ProPlan(int availableSlots, String modelName, double price, int paramaterCount, int contextWindow) {
        super(modelName, price, paramaterCount, contextWindow);
        this.availableSlots = availableSlots;
    }

    public String addTeamMember(String memberName) {
        if(availableSlots > 0){
            teamMember.add(memberName);
            availableSlots--;
            return "Team Member added successfully!";
        }else{
            return "ERROR: No available team slots";
        }
    }
    
    public String removeTeamMember(String memberName) {
        if(teamMember.contains(memberName)){
            teamMember.remove(memberName);
            availableSlots++;
            return "Team member removed successfully";
        }else {
            return "ERROR: Team member not found";
        }
    }

    public String usePrompts(String promptText, int expectedTokens, int systemTokens, int outputTokens) {
        if(calculateTokenUsage(expectedTokens, systemTokens, outputTokens))
            return "Prompt accepted \n"
                +  "Prompt: " + promptText + "\n"
                +  "Expected Tokens: " + expectedTokens;
        else {
            return "Context window exceeded. Please reduce the number of tokens in your prompt or expected output.";
        }   
    }
    
    @Override
    public String displayOutput() {
         return "AI Model Name:" + getModelName() + 
            "\nPrice of Model: " + getPrice() 
            + "\nParamater Count: " + getParamaterCount() 
            + "\nContext Window Size: " + getContextWindow()
            + "\nAvailable Team Slots: " + availableSlots;
    }
}
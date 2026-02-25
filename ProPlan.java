import java.util.ArrayList;

/**
 * Write a description of class ProPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProPlan extends AIModel
{
    private int availableTeamSlots;
    private ArrayList<String> teamMember = new ArrayList<>();
    
    ProPlan(int availableTeamSlots, String modelName, double price, int paramaterCount, String contextWindow) {
        super(modelName, price, paramaterCount, contextWindow);
        this.availableTeamSlots = availableTeamSlots;
    }

    public String addTeamMemeber(String memberName) {
        if(availableTeamSlots > 0){
            teamMember.add(memberName);
            availableTeamSlots--;
            return "Team Member added successfully!";
        }else{
            return "ERROR: No available team slots";
        }
    }
    
    public String removeTeamMember(String memberName) {
        if(teamMember.contains(memberName)){
            teamMember.remove(memberName);
            availableTeamSlots++;
            return "Team member removed successfully";
        }else {
            return "ERROR: Team member not found";
        }
    }
    
    @Override
    public String displayOutput() {
        return super.displayOutput() +
        "\nAvailable Team Slots: " + availableTeamSlots;
    }
}
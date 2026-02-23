
/**
 * Write a description of class ProPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProPlan extends AIModel
{
    private String TeamMember;
    final static int SLOTS_FOR_PROPLAN = 4;
    
    ProPlan(String TeamMember, String modelName, double price, int paramaterCount, String contextWindow) {
        super(modelName, price, paramaterCount, contextWindow);
        this.TeamMember = TeamMember;
    }
    
    public String getTeamMember() {
        return this.TeamMember;
    }
    
    public void setTeamMember(String TeamMember) {
        this.TeamMember = TeamMember;
    }
    
    public String addTeamMemeber(String teamMemeberName) {
        
    }
    
    
}
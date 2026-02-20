
/**
 * Write a description of class PersonalPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonalPlan
{
    private int promptsRemainingMonthlyQuota;
    
    public void PersonalPlan(int promptsRemainingMonthlyQuota) {
        this.promptsRemainingMonthlyQuota = promptsRemainingMonthlyQuota;
    }
    
    public int getPromptsRemainingMonthlyQuota() {
        return this.promptsRemainingMonthlyQuota;
    }
    
    public void setPromptsRemainingMonthlyQuota(int promptsRemainingMonthlyQuota) {
        this.promptsRemainingMonthlyQuota = promptsRemainingMonthlyQuota;
    }
    
    
}
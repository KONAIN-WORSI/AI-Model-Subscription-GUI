
/**
 * Write a description of class AIModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract class AIModel
{
    private String modelName;
    private double price;
    private int paramaterCount;
    private int contextWindow;
    
    AIModel(String modelName, double price, int paramaterCount, int contextWindow) {
       this.modelName = modelName;
       this.price = price;
       this.paramaterCount = paramaterCount;
       this.contextWindow = contextWindow;
    }
    
    public String getModelName() {
        return this.modelName;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public int getParamaterCount() {
        return this.paramaterCount;
    }
    
    public int getContextWindow() {
        return this.contextWindow;
    }

    public boolean calculateTokenUsage(int inputTokens, int outputTokens, int systemTokens) {
        int totalTokens = inputTokens + outputTokens + systemTokens;
        boolean tokenValidation = (totalTokens <= contextWindow) ? true : false;
        return tokenValidation;
    }
    
    public abstract String displayOutput();
}
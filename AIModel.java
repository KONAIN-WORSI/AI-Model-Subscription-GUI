
/**
 * Write a description of class AIModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AIModel
{
    private String modelName;
    private double price;
    private int paramaterCount;
    private String contextWindow;
    
    AIModel(String modelName, double price, int paramaterCount, String contextWindow) {
       this.modelName = modelName;
       this.price = price;
       this.paramaterCount = paramaterCount;
       this.contextWindow = contextWindow;
    }
    
    public String getModelName() {
        return this.modelName;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getParamaterCount() {
        return this.paramaterCount;
    }
    
    public void setParamaterCount(int paramaterCount) {
        this.paramaterCount = paramaterCount;
    }
    
    public String getContextWindow() {
        return this.contextWindow;
    }
    
    public void setContextWindow(String contextWindow) {
        this.contextWindow = contextWindow;
    }
    
    public String displayOutput() {
          return "AI Model Name: " + modelName + "\nPrice of Model: " + price + "\nParamater Count: " + paramaterCount + "\nContext Window Size: " + contextWindow;
    }
    
}
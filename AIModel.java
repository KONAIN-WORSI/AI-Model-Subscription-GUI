
/**
 * Represents an abstract base class for AI Models.
 * Provides common attributes and behaviors such as model name, price, parameter count, and context window size.
 *
 * @author Konain
 * @version 1.0
 */
abstract class AIModel
{
    private String modelName;
    private double price;
    private int parameterCount;
    private int contextWindow;
    
    /**
     * Constructor for objects of class AIModel.
     * 
     * @param modelName      The name of the AI model.
     * @param price          The price of the model.
     * @param parameterCount The parameter count of the model.
     * @param contextWindow  The context window size of the model.
     */
    AIModel(String modelName, double price, int parameterCount, int contextWindow) {
       this.modelName = modelName;
       this.price = price;
       this.parameterCount = parameterCount;
       this.contextWindow = contextWindow;
    }
    
    /**
     * Retrieves the name of the AI model.
     * 
     * @return The model name.
     */
    public String getModelName() {
        return this.modelName;
    }
    
    /**
     * Retrieves the price of the AI model.
     * 
     * @return The price.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Retrieves the parameter count of the AI model.
     * 
     * @return The parameter count.
     */
    public int getParameterCount() {
        return this.parameterCount;
    }
    
    /**
     * Retrieves the context window size of the AI model.
     * 
     * @return The context window size.
     */
    public int getContextWindow() {
        return this.contextWindow;
    }

    /**
     * Calculates if the total token usage is within the allowed context window.
     * 
     * @param inputTokens  The number of tokens in the user's input.
     * @param outputTokens The expected number of tokens in the generated output.
     * @param systemTokens The number of tokens consumed by system instructions.
     * @return true if the total tokens are within the context window, false otherwise.
     */
    public boolean calculateTokenUsage(int inputTokens, int outputTokens, int systemTokens) {
        int totalTokens = inputTokens + outputTokens + systemTokens;
        boolean tokenValidation = (totalTokens <= contextWindow) ? true : false;
        return tokenValidation;
    }

    /**
     * Processes an input prompt and determines if it can be accepted based on specific model constraints.
     * 
     * @param promptText     The actual text content of the prompt.
     * @param responseTokens The expected number of tokens the model will generate.
     */
    public abstract void enterPrompt(String promptText, int responseTokens);
    
    /**
     * Generates a formatted string containing the details of the AI model.
     * 
     * @return A string representation of the model details.
     */
    public abstract String displayOutput();
    
}
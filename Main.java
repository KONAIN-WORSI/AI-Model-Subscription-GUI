public class Main {

    public static void main(String[] args) {

        // Instantiate PersonalPlan and ProPlan
        PersonalPlan personal = new PersonalPlan("GPT Lite", 1000, 7, 1000,  500);

        ProPlan pro = new ProPlan( "GPT Pro", 3000, 70, 2000, 5);

        System.out.println("===== PERSONAL PLAN TEST =====");

        // Exhaust PersonalPlan quota
        for (int i = 0; i < 500; i++) {
            personal.usePrompt("Test prompt " + i, 50, 10, 20);  
        }

        // Attempt one more prompt after quota finished
        System.out.println(personal.usePrompt("After quota", 50, 10, 20));  


        // Purchase additional prompts
        System.out.println(personal.purchasePrompts(50));  // add more prompts

        // Use prompt again after recharge
        System.out.println(personal.usePrompt("After recharge", 50, 10, 20));


        // Context window limit testing (Input + Output + System > context)
        System.out.println("\n===== CONTEXT LIMIT TEST =====");

        int inputTokens = 600;
        int outputTokens = 600;
        int systemTokens = 200;

        int totalTokens = inputTokens + outputTokens + systemTokens;

        int personalContext = personal.getContextWindow();
        int proContext = pro.getContextWindow();

        // PersonalPlan context test
        if (totalTokens > personalContext) {
            System.out.println("PersonalPlan Rejected: Context window exceeded.");
        } else {
            System.out.println(personal.usePrompt("Valid prompt", inputTokens, systemTokens, outputTokens));
        }

        // ProPlan context test
        if (totalTokens > proContext) {
            System.out.println("ProPlan Rejected: Context window exceeded.");
        } else {
            System.out.println("ProPlan Prompt Accepted.");
        }


        // ProPlan test (no quota reduction)
        System.out.println("\n===== PRO PLAN TEST =====");

        System.out.println(pro.addTeamMember("Alice"));
        System.out.println(pro.addTeamMember("Bob"));

        // Run prompts (no quota tracking)
        for (int i = 0; i < 3; i++) {
            System.out.println("ProPlan Prompt " + (i + 1) + " executed successfully.");
        }

        // Display final details
        System.out.println("\n===== FINAL DETAILS =====");
        System.out.println(personal.displayOutput());
        System.out.println("------------------------");
        System.out.println(pro.displayOutput());
    }
}
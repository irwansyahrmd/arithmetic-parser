package arithmeticparser;

import java.util.ArrayList;

/**
 *
 * @author taktik
 */
public class ArithmeticParser {

    private String token;
    private String input;
    private final FiniteAutomata fa;
    private PDA pda = new PDA();

    public ArithmeticParser() {
        fa = new FiniteAutomata();
        pda = new PDA();
    }

    public void setInput(String input) {
        input = input.replaceAll(" ", ""); // Remove White Space
        if (input.length() > 0) {
            this.input = input;
        }
    }

    public String getInput() {
        return input;
    }

    public String getToken() {
        if (input.length() > 0) {
            token = fa.getTokens(input);
        }
        return token;
    }

    public boolean isValid() {
        if (token.length() > 0) {
            return pda.isValid(token);
        } else {
            return false;
        }
    }
    
    public ArrayList<String> getInputString(){
        return fa.getInputStringList();
    }

}

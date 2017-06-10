package arithmeticparser;

import java.util.Stack;

/**
 *
 * @author taktik
 */
public class PDA {

    Stack<String> stack = new Stack();

    public boolean isValid(String tokens) {
        int pointer = 0;
        String terminalOperator = "6789";
        String terminalOperan = "123";
        String terminalBukaKurung = "4";
        String terminalTutupKurung = "5";
        String currentChar;
        stack.push("#");
        stack.push("S");
        loop:
        while (!"#".equals(stack.peek())) {
            switch (stack.peek()) {
                case "S":
                    currentChar = getStringAt(tokens, pointer);
                    stack.pop();
                    stack.push("E");
                    if (terminalOperan.contains(currentChar)) {
                        stack.push("A");
                    } else {
                        stack.push("D");
                    }
                    break;
                case "E":
                    stack.pop();
                    currentChar = getStringAt(tokens, pointer);
                    String nextChar = getStringAt(tokens, pointer + 1);
                    if (terminalOperator.contains(currentChar)
                            && terminalOperan.contains(nextChar)) {
                        stack.push("E");
                        stack.push("A");
                        stack.push("B");
                    } else if (terminalOperator.contains(currentChar)) {
                        stack.push("E");
                        stack.push("D");
                        stack.push("B");
                    }
                    break;
                case "A":
                    stack.pop();
                    currentChar = getStringAt(tokens, pointer);
                    if (terminalOperan.contains(currentChar)) {
                        pointer++;
                    } else {
                        pointer = -1;
                        break loop;
                    }
                    break;
                case "B":
                    stack.pop();
                    currentChar = getStringAt(tokens, pointer);
                    if (terminalOperator.contains(currentChar)) {
                        pointer++;
                    } else {
                        pointer = -1;
                        break loop;
                    }
                    break;
                case "D":
                    stack.pop();
                    stack.push("5");
                    stack.push("S");
                    stack.push("4");
                    break;
                case "4":
                    stack.pop();
                    currentChar = getStringAt(tokens, pointer);
                    if (terminalBukaKurung.contains(currentChar)) {
                        pointer++;
                    } else {
                        pointer = -1;
                        break loop;
                    }
                    break;
                case "5":
                    stack.pop();
                    currentChar = getStringAt(tokens, pointer);
                    if (terminalTutupKurung.contains(currentChar)) {
                        pointer++;
                    } else {
                        pointer = -1;
                        break loop;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        stack.pop();
        return tokens.length() == pointer;
    }

    public String getStringAt(String tokens, int pos) {
        String value = "NULL";
        if (tokens.length() > 0 && tokens.length() > pos) {
            value = String.valueOf(tokens.charAt(pos));
        }
        return value;
    }
}

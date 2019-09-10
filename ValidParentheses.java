package LeetCode;
// 20. Valid Parentheses
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> cstack = new Stack<Character>();
        for(Character c: s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{') {
                cstack.push(c);
            } else {
                if(cstack.empty()) return false;
                switch(c) {
                    case ')':
                        if(cstack.peek() != '(') return false;
                        else cstack.pop();
                        break;
                    case ']':
                        if(cstack.peek() != '[') return false;
                        else cstack.pop();
                        break;
                    case '}':
                        if(cstack.peek() != '{') return false;
                        else cstack.pop();
                        break;

                    default:
                        break;
                }
            }
        }
        if(cstack.empty()) return true;
        else return false;
    }
}

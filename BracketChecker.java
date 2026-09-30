import java.util.ArrayDeque;
import java.util.Deque;

/** Checks whether (), [] and {} are balanced, using a stack. */
public class BracketChecker {
    static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ("([{".indexOf(c) >= 0) stack.push(c);
            else if (")]}".indexOf(c) >= 0) {
                if (stack.isEmpty() || "([{".indexOf(stack.pop()) != ")]}".indexOf(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = args.length > 0 ? args
                : new String[] {"(a + b) * [c - d]", "{[()]}", "((]", "if (x) { y[0] = 1; ", ""};
        for (String t : tests)
            System.out.printf("%-25s -> %s%n", "\"" + t + "\"", isBalanced(t) ? "balanced" : "NOT balanced");
    }
}

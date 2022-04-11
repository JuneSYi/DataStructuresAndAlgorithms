package RandomJavaSandBox;

import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
        StackOperations run = new StackOperations();
        run.stack();
    }

    static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("Apple");
        stack.push("Orange");
        stack.push("peach");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.push("car");
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}

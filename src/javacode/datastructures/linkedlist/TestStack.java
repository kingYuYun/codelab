package javacode.datastructures.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("jack");
        stack.push("tom");
        stack.push("smith");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

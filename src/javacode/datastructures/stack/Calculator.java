package javacode.datastructures.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "70+2*6-4";
        ArrayStack2 numstack = new ArrayStack2(10);
        ArrayStack2 operstack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepnum = "";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operstack.isOper(ch)) {
                if (!operstack.isEmpty()) {
                    if (operstack.priority(ch) <= operstack.priority(operstack.peek())) {
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = operstack.pop();
                        res = numstack.cal(num1, num2, oper);
                        numstack.push(res);
                        operstack.push(ch);
                    } else {
                        operstack.push(ch);
                    }
                } else {
                    operstack.push(ch);
                }
            } else {
                keepnum += ch;
                if (index == expression.length() - 1) {
                    numstack.push(Integer.parseInt(keepnum));
                } else {
                    if (operstack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numstack.push(Integer.parseInt(keepnum));
                        keepnum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {
            if (operstack.isEmpty()) {
                break;
            }
            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = operstack.pop();
            res = numstack.cal(num1, num2, oper);
            numstack.push(res);
        }
        System.out.printf("biaodashi %s = %d", expression, numstack.pop());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.printf("full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n ", i, stack[i]);
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int peek() {
        return stack[top];
    }
}

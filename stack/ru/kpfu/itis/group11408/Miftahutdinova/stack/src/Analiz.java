package ru.kpfu.itis.group11408.Miftahutdinova.stack;

public class Analiz {
    private SuperStak<Character> stack;

    public Analiz(Stack<Character> arrayStack){
        this.stack = arrayStack;
    }

    public boolean check(String str){
        try {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (str.charAt(i) == '{') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                if (str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            }
        } catch (Exception e){
            System.out.println("Null... check pop() and peek() methods");
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
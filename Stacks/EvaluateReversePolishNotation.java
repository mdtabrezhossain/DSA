class EvaluateReversePolishNotation {
    int evalRPN(String[] tokens) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String token : tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c) || (token.length() > 1 && c == '-')) {
                list.add(Integer.parseInt(token));
            } else {
                int b = list.remove(list.size() - 1);
                int a = list.remove(list.size() - 1);

                switch (c) {
                    case '+':
                        list.add(a + b);
                        break;
                    case '-':
                        list.add(a - b);
                        break;
                    case '*':
                        list.add(a * b);
                        break;
                    case '/':
                        list.add(a / b);
                        break;
                }
            }
        }

        return list.get(0);
    }

    int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = { "1", "2", "+", "3", "*", "4", "-" };
        // System.out.println(evalRPN(tokens)); // Output: 5
        System.out.println((int) '+');
        System.out.println((int) '-');
        System.out.println((int) '*');
        System.out.println((int) '/');
        // 43
        // 45
        // 42
        // 47
    }
}

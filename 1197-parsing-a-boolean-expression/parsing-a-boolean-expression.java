class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stk = new Stack<>();  // Stack to hold characters and operators

        // Iterate over each character in the expression
        for (char c : expression.toCharArray()) {
            // Push valid characters (non ')' and non ',') to the stack
            if (c != ')' && c != ',') stk.push(c);
            else if (c == ')') {  // When ')' is encountered, evaluate subexpression
                ArrayList<Boolean> exp = new ArrayList<>();  // List to hold boolean values
                
                // Pop characters until '(' is found, collect 't' or 'f' values
                while (!stk.isEmpty() && stk.peek() != '(') {
                    char t = stk.pop();
                    if (t == 't') exp.add(true);
                    else exp.add(false);
                }
                
                stk.pop();  // Pop the '(' from the stack
                
                if (!stk.isEmpty()) {
                    char t = stk.pop();  // Get the operator before '('
                    boolean v = exp.get(0);  // Initialize result with the first value
                    
                    // Perform the corresponding logical operation
                    if (t == '&') {  // AND operation
                        for (boolean b : exp) v &= b;
                    } else if (t == '|') {  // OR operation
                        for (boolean b : exp) v |= b;
                    } else {  // NOT operation
                        v = !v;
                    }
                    
                    // Push the result back to the stack as 't' or 'f'
                    if (v) stk.push('t');
                    else stk.push('f');
                }
            }
        }

        // Return the final result from the stack
        return stk.peek() == 't';
    }
}
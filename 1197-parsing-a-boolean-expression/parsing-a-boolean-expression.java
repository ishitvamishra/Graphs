class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for(char ch : expression.toCharArray()) {

            // skip commas and opening brackets
            if(ch == ',' || ch == '(') continue;

            // if not closing bracket, push
            if(ch != ')') {
                st.push(ch);
            }
            else {

                // evaluate current expression
                boolean hasTrue = false;
                boolean hasFalse = false;

                // collect operands
                while(st.peek() != '&' &&
                      st.peek() != '|' &&
                      st.peek() != '!') {

                    char val = st.pop();

                    if(val == 't') hasTrue = true;
                    if(val == 'f') hasFalse = true;
                }

                // operator
                char op = st.pop();

                char result;

                if(op == '&') {

                    // AND true only if no false
                    result = hasFalse ? 'f' : 't';

                } else if(op == '|') {

                    // OR true if any true
                    result = hasTrue ? 't' : 'f';

                } else {

                    // NOT
                    result = hasTrue ? 'f' : 't';
                }

                st.push(result);
            }
        }

        return st.peek() == 't';
    }
}
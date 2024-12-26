class Solution {
    public int evalRPN(String[] tokens) {
        // Convert array to a mutable List
        List<String> list = new ArrayList<>(Arrays.asList(tokens));

        // Keep going until there's only one number left in 'list'
        while (list.size() > 1) {
            int ind = -1;
            String op = "";

            // 1) Find the *first* operator
            for (int i = 0; i < list.size(); i++) {
                // Use .equals(...) for string comparison
                if (list.get(i).equals("*") || list.get(i).equals("/") 
                    || list.get(i).equals("+") || list.get(i).equals("-")) {
                    ind = i;
                    op = list.get(i);
                    break;
                }
            }

            // 2) Grab the two operands immediately before the operator
            int val1 = Integer.parseInt(list.get(ind - 2));
            int val2 = Integer.parseInt(list.get(ind - 1));

            // 3) Compute the partial result
            int result = 0;
            if (op.equals("*")) {
                result = val1 * val2;
            } else if (op.equals("/")) {
                result = val1 / val2;  // watch out for integer division
            } else if (op.equals("+")) {
                result = val1 + val2;
            } else { // "-"
                result = val1 - val2;
            }

            // 4) Remove the two operands and the operator
            //    (remove operator at index 'ind', then val2, then val1)
            list.remove(ind);       // remove operator
            list.remove(ind - 1);   // remove second operand
            list.remove(ind - 2);   // remove first operand

            // 5) Put the computed result back in place of the first operand
            list.add(ind - 2, String.valueOf(result));
        }

        // Only one element left; that's your RPN result
        return Integer.parseInt(list.get(0));
    }
}

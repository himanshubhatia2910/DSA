class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            String exp = tokens[i];
            if(exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/"))
            {
                int element1= stack.pop();
                int element2= stack.pop();
                stack.push(solve(element1,element2,exp));
            }
            else
            {
                stack.push(Integer.parseInt(exp));
            }
        }
        return stack.pop();
    }
    public static int solve(int pop1,int pop2, String operator)
    {
        if(operator.equals("+"))
        {
            return pop2+pop1;
        }
        else if(operator.equals("*"))
        {
            return pop2*pop1;
        }
        else if(operator.equals("-"))
        {
            return pop2-pop1;
        }
        else
        {
            return pop2/pop1;
        }
    }
}
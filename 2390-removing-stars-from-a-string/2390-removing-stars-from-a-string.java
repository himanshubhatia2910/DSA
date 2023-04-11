class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='*'){ stack.pop();}
            else
            {
                stack.push(c);
            }
        }
        Iterator<Character> itr= stack.iterator();
        String res="";
        while(itr.hasNext())
        {
            String str=itr.next().toString();
            res+=str;
        }
        return res;
    }
}
class Solution {
    public String interpret(String command) {
        String newString="";
        for(int i=0;i<command.length();i++)
        {
            if(command.charAt(i)=='G') newString+="G";
            else if(command.charAt(i)=='(' && command.charAt(i+1)==')')
            {
                newString+="o";
            }
            else if (command.charAt(i)=='(' && command.charAt(i+1)==
                    'a') newString+="al";
        }
        return newString;
    }
}
class Solution {
    public String defangIPaddr(String address) {
        String newString="";
        
        for(char c: address.toCharArray())
        {
            if(c=='.')
            {
                newString+="[.]";
            }
            else{
                newString+=c;
            }
        }
        return newString;
    }
}
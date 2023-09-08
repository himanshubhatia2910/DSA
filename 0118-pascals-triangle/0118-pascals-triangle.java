class Solution {
      public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        for(int i = 2 ; i <= numRows ; i++) {
            res.add(new ArrayList<>());
            for(int j = 0 ; j < i ; j++) {
                if(j == 0 || j == i-1) {
                    res.get(i-1).add(1);
                } else {
                    res.get(i-1).add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
                }
                System.out.println(i+" "+j);
            }
        } 
        return res;   
    }
}
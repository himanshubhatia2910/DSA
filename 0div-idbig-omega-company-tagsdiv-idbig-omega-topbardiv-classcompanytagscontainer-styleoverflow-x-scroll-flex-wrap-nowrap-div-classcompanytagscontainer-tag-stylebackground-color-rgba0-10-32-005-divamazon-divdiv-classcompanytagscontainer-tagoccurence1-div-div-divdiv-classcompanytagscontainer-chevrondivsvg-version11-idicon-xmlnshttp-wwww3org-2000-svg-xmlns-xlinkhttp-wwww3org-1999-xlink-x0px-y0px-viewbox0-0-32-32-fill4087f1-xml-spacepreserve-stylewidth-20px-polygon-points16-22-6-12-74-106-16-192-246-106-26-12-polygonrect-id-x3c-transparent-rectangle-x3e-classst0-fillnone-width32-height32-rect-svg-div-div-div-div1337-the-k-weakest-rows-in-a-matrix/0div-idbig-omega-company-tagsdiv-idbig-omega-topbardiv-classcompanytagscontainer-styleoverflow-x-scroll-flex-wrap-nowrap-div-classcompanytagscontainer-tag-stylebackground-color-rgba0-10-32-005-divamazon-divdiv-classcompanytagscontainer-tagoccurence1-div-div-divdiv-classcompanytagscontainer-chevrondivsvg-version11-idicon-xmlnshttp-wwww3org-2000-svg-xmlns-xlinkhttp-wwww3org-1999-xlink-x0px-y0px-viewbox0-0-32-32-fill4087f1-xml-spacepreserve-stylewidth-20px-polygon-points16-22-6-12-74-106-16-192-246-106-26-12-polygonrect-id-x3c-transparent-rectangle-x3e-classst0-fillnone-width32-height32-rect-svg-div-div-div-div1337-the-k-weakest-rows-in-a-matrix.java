class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
    Map<Integer,Integer>map=new HashMap<>();
    for(int i=0;i<mat.length;i++)
    {
        int count1=0,count0=0;
        for(int j=0;j<mat[i].length;j++)
        {
            if(mat[i][j]==1)
                count1++;
        }
        map.put(i,count1);
    }
    System.out.println(map);
    int arr[]=new int[k];
    for(int i=0;i<k;i++)
    {
    	for(Integer key:map.keySet())
    	{
    		int min=Collections.min(map.values());
    		if(map.get(key)==min)
    		{
    			arr[i]=key;
    			map.remove(key);
    			break;
    		}
    	}
    }
    return arr;
    }
}
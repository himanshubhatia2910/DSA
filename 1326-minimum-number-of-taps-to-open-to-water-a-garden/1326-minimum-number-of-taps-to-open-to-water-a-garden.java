class Solution {
    public int minTaps(int n, int[] r) {
        int a[] = new int[n+1];
        for(int i = 0; i <= n; i++){
            int l = Math.max(i-r[i], 0);
            a[l] = Math.max(i+r[i], a[l]);
        }
        int c = 0;
        int b = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, a[i]);
            if(i == b){
                c++;
                if(b == max) return -1;
                b = max;
            }
        }
        return c;
    }
}
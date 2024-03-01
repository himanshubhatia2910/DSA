class Solution {
    class UnionFind{
        int[] par;
        public UnionFind(int n){
            par=new int[n];
            // for(int i=0;i<n;i++) par[i]=-1;
        }
        public int find(int n){
            if(par[n]-1<0) return n;
            return par[n]=find(par[n]);
        }
        public boolean Union(int a,int b){
            int a_rep=find(a);
            int b_rep=find(b);
            if(a_rep==b_rep) return false;
            if(par[a_rep]<=par[b_rep]){
                par[a_rep]+=par[b_rep];
                par[b_rep]=a_rep;
            }
            else{
                par[b_rep]+=par[a_rep];
                par[a_rep]=b_rep;
            }
            return true;
        }
    };
    public boolean canTraverseAllPairs(int[] nums) {

        int n=nums.length;
        int[] arr=new int[100001];
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<=100000;i++) arr[i]=1;
        UnionFind obj=new UnionFind(100001);
        for(int i=0;i<n;i++){
            arr[nums[i]]=3;
            st.add(nums[i]);
        }
        int ans=st.size();
        if(arr[1]==3 && n>1) return false;
        for(int i=2;i<=100000;i++){
            if(arr[i]==0 || arr[i]==2) continue;
            int prev=(arr[i]==3) ? i : (-1);
            for(int j=2*i;j<=100000;j+=i){
                if(arr[j]>=2){
                    if(arr[j]==3) arr[j]=2;
                    if(prev==-1) prev=j;
                    else{
                        if(obj.Union(j,prev)) ans--;
                    }
                }
                else arr[j]=0;
            }
        }
        return ans==1;
    }
}
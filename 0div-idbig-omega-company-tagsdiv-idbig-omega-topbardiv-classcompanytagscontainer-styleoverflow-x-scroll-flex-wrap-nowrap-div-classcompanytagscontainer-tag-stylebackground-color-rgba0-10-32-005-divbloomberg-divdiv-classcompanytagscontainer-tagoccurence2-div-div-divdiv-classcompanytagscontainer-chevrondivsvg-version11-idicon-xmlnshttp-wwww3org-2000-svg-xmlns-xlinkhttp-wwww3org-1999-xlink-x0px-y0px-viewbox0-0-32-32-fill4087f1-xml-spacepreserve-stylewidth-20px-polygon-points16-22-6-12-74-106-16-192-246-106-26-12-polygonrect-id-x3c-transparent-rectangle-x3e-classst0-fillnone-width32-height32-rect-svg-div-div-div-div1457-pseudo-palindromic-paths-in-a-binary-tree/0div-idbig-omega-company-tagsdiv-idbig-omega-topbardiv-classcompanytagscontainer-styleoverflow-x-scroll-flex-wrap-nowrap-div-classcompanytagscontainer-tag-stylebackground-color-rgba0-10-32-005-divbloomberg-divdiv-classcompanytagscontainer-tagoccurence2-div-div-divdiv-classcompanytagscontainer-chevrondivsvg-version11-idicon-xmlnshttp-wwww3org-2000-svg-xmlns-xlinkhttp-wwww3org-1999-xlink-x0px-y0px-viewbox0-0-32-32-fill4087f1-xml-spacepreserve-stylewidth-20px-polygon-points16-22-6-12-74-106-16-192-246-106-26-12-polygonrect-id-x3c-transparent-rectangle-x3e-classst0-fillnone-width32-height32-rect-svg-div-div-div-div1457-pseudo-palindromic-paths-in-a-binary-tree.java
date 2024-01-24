class Solution {

// Traversing in Tree-:
    public void traverse(TreeNode root, Stack<Integer> stk, int cnt[], int freq[]){    // store root to leaf node in stack
        if(root == null) return;
        if(root.left == null && root.right == null)      // if we are in leaf node
        {  
            stk.add(root.val);
            freq[root.val]++;
      
// if stack size is odd.
    // so path will be Pseudo-Palindromic Path only if there is only one node with odd frequency(1,3,5,...) 
    int flag = 0;
    int n = stk.size();
        if(n%2 != 0)
        {
            int x = 0;
            for(int i=0; i<10;i++){
                if(freq[i]%2 != 0) x++;
                if(x > 1) flag = 1;     // if there is more then 1 node with odd frequency return false

            }
        }

// if stack size is even.
    // so path will be Pseudo-Palindromic Path only if there is all node with even frequency(2,4,6,...) 
        else{
            for(int i=0; i<10;i++){
                if(freq[i]%2 != 0) flag = 1; // if their exist a node with odd frequency
            }
        }
        if(flag == 0) cnt[0]++;     // increase count by 1
            
            int x = stk.pop();      // pop top element from stack so we can go to other path (from root to leaf)    
            freq[x]--;
            return;
        }

        stk.add(root.val);     // add node in stack
        freq[root.val]++;        // increase its frequency

        traverse(root.left, stk, cnt, freq);     // go left
        traverse(root.right, stk, cnt, freq);        // go right

        int x =stk.pop();     // pop top element from stack so we can go to other path (from root to leaf)
        freq[x]--;               // decrese that element's frequency by 1
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int cnt[] = new int[1];     // to count no. of path
        int freq[] = new int[10];    // to count frequency of each node(0-9)

        traverse(root, new Stack<Integer>(), cnt, freq);  // tarversing in tree

        return cnt[0];
    }
}
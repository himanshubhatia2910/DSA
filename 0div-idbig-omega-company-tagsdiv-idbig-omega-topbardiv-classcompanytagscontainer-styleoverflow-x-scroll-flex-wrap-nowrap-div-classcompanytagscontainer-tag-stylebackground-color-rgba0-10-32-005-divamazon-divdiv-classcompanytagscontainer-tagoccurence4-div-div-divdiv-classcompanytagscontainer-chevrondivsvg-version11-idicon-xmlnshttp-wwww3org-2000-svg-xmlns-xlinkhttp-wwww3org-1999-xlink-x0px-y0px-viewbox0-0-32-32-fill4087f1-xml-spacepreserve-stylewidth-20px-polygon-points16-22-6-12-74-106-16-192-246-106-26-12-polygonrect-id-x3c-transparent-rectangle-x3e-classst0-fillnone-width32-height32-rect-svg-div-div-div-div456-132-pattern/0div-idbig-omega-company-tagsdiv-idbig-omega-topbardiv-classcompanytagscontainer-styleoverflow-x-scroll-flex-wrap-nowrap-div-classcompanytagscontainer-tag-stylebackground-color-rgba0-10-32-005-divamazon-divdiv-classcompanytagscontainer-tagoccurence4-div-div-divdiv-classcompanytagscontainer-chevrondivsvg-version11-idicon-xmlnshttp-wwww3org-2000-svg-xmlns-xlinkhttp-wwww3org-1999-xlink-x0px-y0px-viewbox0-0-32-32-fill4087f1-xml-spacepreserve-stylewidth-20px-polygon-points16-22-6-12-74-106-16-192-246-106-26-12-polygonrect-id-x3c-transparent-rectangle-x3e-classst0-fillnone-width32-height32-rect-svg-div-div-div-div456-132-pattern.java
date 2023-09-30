class Solution {
     public boolean find132pattern(int[] arr) {
        // corner case -> can't possible to create 132 pattern
        if (arr.length < 3) return false;

        Stack<Integer> stk = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            // if(third > first)
            if (third > arr[i]) return true;

            // (stack is not empty) AND (second > third)
            while (!stk.isEmpty() && arr[i] > stk.peek())   third = stk.pop(); // getting third value

            // push current value into stack
            stk.push(arr[i]);
        }

        return false;
     }
}
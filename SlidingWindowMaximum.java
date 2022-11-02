You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int[] res = new int[len - k+1];
        int i;
        
        Deque<Integer> queue = new LinkedList<>();
        for( i=0;i<k;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        
        int idx = 0;
        
        for( ; i<len;i++){
            res[idx++] = nums[queue.peek()];
            
            while(!queue.isEmpty() && queue.peek() <= i-k){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[idx] = nums[queue.peek()];
        return res;
    }
}

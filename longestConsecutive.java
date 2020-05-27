class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num : nums){
            int count = 1;
            int down = num - 1;
            int up = num + 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
                count++;
            } 
            while(set.contains(up)){
                set.remove(up);
                up++;
                count++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
        
    }
}

import java.util.HashMap;
import java.util.Map;

// Function to find number of subarrays with sum exactly equal to k
public class CountSubarraySums {
	public int subarraySum(int[] nums, int k) {
		// HashMap to store number of subarrays
		// starting from index zero having particular value of sum
		HashMap<Integer, Integer> prevSum = new HashMap<>();
		
		int result = 0;
		
		// Sum of elements so far
		int currsum = 0;
		prevSum.put(0,1);
		
		for (int i = 0; i < nums.length; i++) {
			
			// Add current element to sum so far
			currsum += nums[i];
			
			// If currsum exceeds given sum by currsum - k
			// Find number of subarrays having this sum and exclude those subarrays from currsum
			// by increasing count by same amount
			if(prevSum.containsKey(currsum - k)) {
				result += prevSum.get(currsum - k);
			}
			prevSum.put(currsum, prevSum.getOrDefault(currsum, 0)+1);
		
		}
		return result;
	}

}

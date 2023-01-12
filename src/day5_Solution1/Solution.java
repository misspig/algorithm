package day5_Solution1;

import java.util.Arrays;
import java.util.*;

//存在重复元素
class Solution {
	
	public static void main(String[]args) {
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		System.out.println( containsDuplicate(nums));
	}
//    public static boolean containsDuplicate(int[] nums) {
//
//    	Arrays.sort(nums);
//    	for(int i = 0;i < nums.length-1;i ++) {
//    		if(nums[i] == nums[i+1])
//    			return true;;
//    	}
//    	return false;
//    	//我可以先排序，然后如果有相同的话就会挨着，我就可以通过循环去找到
//    }
	/*
	 * 执行用时： 19 ms , 在所有 Java 提交中击败了 39.98% 的用户 内存消耗： 55.2 MB , 在所有 Java 提交中击败了
	 * 23.05% 的用户
	 */
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer>set = new TreeSet<>();
		for(int i : nums) {
			set.add(i);
		}
		if(set.size() == nums.length)
			return false;
		else return true;
	}
	/*
	 * 执行用时： 49 ms , 在所有 Java 提交中击败了 14.40% 的用户 内存消耗： 52.7 MB , 在所有 Java 提交中击败了
	 * 73.44% 的用户
	 */
}














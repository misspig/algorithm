package day5_Solution1;

import java.util.Arrays;
import java.util.*;

//�����ظ�Ԫ��
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
//    	//�ҿ���������Ȼ���������ͬ�Ļ��ͻᰤ�ţ��ҾͿ���ͨ��ѭ��ȥ�ҵ�
//    }
	/*
	 * ִ����ʱ�� 19 ms , ������ Java �ύ�л����� 39.98% ���û� �ڴ����ģ� 55.2 MB , ������ Java �ύ�л�����
	 * 23.05% ���û�
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
	 * ִ����ʱ�� 49 ms , ������ Java �ύ�л����� 14.40% ���û� �ڴ����ģ� 52.7 MB , ������ Java �ύ�л�����
	 * 73.44% ���û�
	 */
}














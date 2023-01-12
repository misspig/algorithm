package day5_Solution3;

import java.util.*;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
public class Solution3 {
	
	public boolean hasCycle(ListNode head) {  
		Set<ListNode> set = new HashSet<>();//关于重复的问题，理解这个重复，想想不能重复的HashSet，最好使用hashSet.
		//TreeSet是使用的compareTo方法判断的，所以说是可以重复的，而是用HashSet，它使用的是equals和hashcode，equals就不能存放相同的了
		ListNode temp = head;
		while(temp != null) {
			if(!set.add(temp)) {//add是有返回值的，添加成功就为true
				return true;
			}
			temp = temp.next;
		}
		return false;
    }
}

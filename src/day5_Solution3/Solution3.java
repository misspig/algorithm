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
		Set<ListNode> set = new HashSet<>();//�����ظ������⣬�������ظ������벻���ظ���HashSet�����ʹ��hashSet.
		//TreeSet��ʹ�õ�compareTo�����жϵģ�����˵�ǿ����ظ��ģ�������HashSet����ʹ�õ���equals��hashcode��equals�Ͳ��ܴ����ͬ����
		ListNode temp = head;
		while(temp != null) {
			if(!set.add(temp)) {//add���з���ֵ�ģ���ӳɹ���Ϊtrue
				return true;
			}
			temp = temp.next;
		}
		return false;
    }
}

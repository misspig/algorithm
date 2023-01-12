package day5_Solution2;


 class ListNode {
	  
	 int val;
	 ListNode next;
	 ListNode() {} 
	 ListNode(int val) { this.val = val; } 
	 ListNode(int val,ListNode next) { this.val = val; this.next = next; } }
 
public class Solution2 {
	//合并两个链表，这道题和之前的就不一样了，首先他是没有头节点的，而且他只是用了一个类就
//弄成了链表，其中list1，list2都是第一个节点，并不是头节点。二是它连接next直接用构造函数就行了，其实不用应该也行。
	public static void main(String[]args) {
		
	}
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    	ListNode list3 = new ListNode();
    	ListNode temp = list3;
    	while(list1 != null && list2 != null) {
    		if(list1.val < list2.val) {
    		    temp.next = new ListNode(list1.val);
    		    list1 = list1.next;
    		    temp = temp.next;
    		}else {
    			 temp.next = new ListNode(list2.val);
     		    list2 = list2.next;
     		    temp = temp.next;
    		}
    	}
    	while(list1 != null) {
    		  temp.next = new ListNode(list1.val);
  		    list1 = list1.next;
  		    temp = temp.next;
    	}
    	while(list2 != null) {
  		  temp.next = new ListNode(list2.val);
		    list2 = list2.next;
		    temp = temp.next;
  	}
    	return list3.next;
    }
    //删除重复节点：
    //需要注意的点：
    public static ListNode deleteDuplicates(ListNode head) {
    	ListNode temp = head;
    	while(true) {
    		if(temp == null||temp.next == null) {//我需要有两个判断条件是因为我中间或者是最后一个删除后两种情况
    			break;
    		}
    	    else if(temp.next.val == temp.val) {
    			temp.next = temp.next.next;
    		}
            else if(temp.next.val != temp.val)
    		     temp = temp.next;//因为我可能会有超过两个的重复
    		//还有一个需要注意的问题，如果他们不需要同时发生，就使用else if，需要同时发生才同时使用if
    	}
    	
    	return head;
    }
}

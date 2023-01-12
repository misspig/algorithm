package day5_Solution2;


 class ListNode {
	  
	 int val;
	 ListNode next;
	 ListNode() {} 
	 ListNode(int val) { this.val = val; } 
	 ListNode(int val,ListNode next) { this.val = val; this.next = next; } }
 
public class Solution2 {
	//�ϲ���������������֮ǰ�ľͲ�һ���ˣ���������û��ͷ�ڵ�ģ�������ֻ������һ�����
//Ū������������list1��list2���ǵ�һ���ڵ㣬������ͷ�ڵ㡣����������nextֱ���ù��캯�������ˣ���ʵ����Ӧ��Ҳ�С�
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
    //ɾ���ظ��ڵ㣺
    //��Ҫע��ĵ㣺
    public static ListNode deleteDuplicates(ListNode head) {
    	ListNode temp = head;
    	while(true) {
    		if(temp == null||temp.next == null) {//����Ҫ�������ж���������Ϊ���м���������һ��ɾ�����������
    			break;
    		}
    	    else if(temp.next.val == temp.val) {
    			temp.next = temp.next.next;
    		}
            else if(temp.next.val != temp.val)
    		     temp = temp.next;//��Ϊ�ҿ��ܻ��г����������ظ�
    		//����һ����Ҫע������⣬������ǲ���Ҫͬʱ��������ʹ��else if����Ҫͬʱ������ͬʱʹ��if
    	}
    	
    	return head;
    }
}

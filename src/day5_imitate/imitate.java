package day5_imitate;

public class imitate {

	public static void main(String[]args) {
		
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		SStack stack = new SStack();
		stack.push(node0);
		stack.push(node1);
		stack.push(node2);
		stack.push(node3);
		stack.push(node4);
		
//		for(int i = 0;i<=5; i++)
//		System.out.println(stack.pop());
		stack.list();
	}
}

class SStack{
	Node top = null;
	Node low = null;
	
	//入栈
	public void push(Node node) {
		if(low == null) {
			low = node;
			top = node;
		}
		node.next = top;
		top = node;
	}
	//出栈
	public int pop() {
		if(top == null) {
			throw new RuntimeException("栈为空");
		}
		int value = top.num;
		top = top.next;
		return value;
	}
	//遍历
	public void list() {
		while(true) {
			System.out.println(top.num);
			if(top == low) {
				return;
			}
			top = top.next;
		}
	}
}

class Node{
	int num;
	Node next;
	
	public Node(int num) {
		this.num = num;
	}
	
	public String toString() {
		return num+"";
	}
}
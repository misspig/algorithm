package day6_compute;

import java.util.Scanner;

//û�����ŵļ���
//�ܽ᣺һ�����˽�������Сʱ��ʵ���������������������û������
//��һ������Ҫ�Ļ�����������������ʵ�ֵģ���ʵ���Ǻܺ����׵ģ���Ҫ��ʵ�ֵ�ʱ���������ָ�����С����
//���ɣ������ַ����ַ����������໥ת��ʱ������ת���ַ��������֣���Ϊ���ǵ�ת�������㣬�ַ���ת�ַ�Ҳ�Ƿ����
//ʱ�仨�Ķ��������������С����ܶ�
public class compute {

	public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);		
		String expression = input.nextLine();
		
		SStack numStack = new SStack();
		SStack operStack = new SStack();
		
		for(int i = 0;i < expression.length();i ++) {
			char temp  = expression.charAt(i);
			if(isOper(temp)) {//�Ƿ���
				Node node = new Node(temp+"");
				if(operStack.top == null) {
				operStack.push(node);
				}
				else {
					if(priority(temp) <= priority(operStack.top.value.charAt(0))) {
						int num1 = Integer.parseInt( numStack.pop());
						int  num2 =Integer.parseInt(  numStack.pop());
						char oper = operStack.pop().charAt(0);
						int res = cal(num1, num2, oper);
						numStack.push(new Node(res+""));
						operStack.push(node);
					}else{
						operStack.push(node);
					}
				}
			}else {//������
				Node node = new Node(temp+"");
				numStack.push(node);
			}
		}
		numStack.list();
		operStack.list();
		//�����Ǵ���ɹ���
		
		while(true) {
			if(operStack.top == null) {
				break;
			}
			int num1 = Integer.parseInt( numStack.pop());
			int  num2 =Integer.parseInt(  numStack.pop());
			String s=operStack.pop();
			char oper = s.charAt(0);
			int res = cal(num1, num2, oper);
			//System.out.println(res);
			numStack.push(new Node(res+""));
		}
		numStack.list();
		operStack.list();
//		Node node0 = new Node("1");
//		Node node1 = new Node("2");
//		
//		SStack stack = new SStack();
//		stack.push(node0);
//		stack.push(node1);
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		
//		stack.list();
//		
//		System.out.println(stack.pop());
	}
	//��������������ȼ������ȼ��ǳ���Աȷ���ģ�����Խ�����ȼ�Խ��
		public static int priority(char oper) {
			if(oper == '*' || oper == '/') {
				return 1;
			}else if(oper == '+' || oper == '-') {
				return 0;
			}else {
				return -1;
			}
		}
		
		//�ж��ǲ���һ�������
		public static  boolean isOper(char val) {
			return val == '+' || val == '-' || val == '*' || val == '/';
		}
		
		//���㷽��
		public static  int cal (int num1, int num2, char oper) {
			int res = 0;
			switch(oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num2 * num1;
				break;
			case '/':
				res = num2 / num1;
				break;
			}
			return res;
		}
}
class SStack{
	Node top = null;
	Node low = null;  
	
	//��ջ
	public void push(Node node) {
		if(top == null) {
			top = node;
			low = node;
			return;
		}
		node.next = top;
		top = node;
	}
	//��ջ
	public String pop() {
		if(top == null) {
			throw new RuntimeException("ջΪ��");
		}
		String value = top.value;
		top = top.next;
		return value;
	}
	//����
	public void list() {
		Node temp = top;
		while(true) {
			if(temp == null) {
				return;
			}
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
}

class Node{
	String value;
	Node next;
	
	public Node(String num) {
		this.value = num;
	}

	public String toString() {
		return value;
	}
}
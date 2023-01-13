package day6_compute;

import java.util.Scanner;

//没有括号的计算
//总结：一共花了将近两个小时才实现了这个计算器，甚至还没有括号
//第一，最重要的还是想明白它是怎样实现的，其实还是很好明白的，主要是实现的时候遇到各种各样的小问题
//技巧，对于字符、字符串、数字相互转换时，可以转到字符串和数字，因为他们的转换更方便，字符串转字符也是方便的
//时间花的多的问题就是里面的小问题很多
public class compute {

	public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);		
		String expression = input.nextLine();
		
		SStack numStack = new SStack();
		SStack operStack = new SStack();
		
		for(int i = 0;i < expression.length();i ++) {
			char temp  = expression.charAt(i);
			if(isOper(temp)) {//是符号
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
			}else {//是数字
				Node node = new Node(temp+"");
				numStack.push(node);
			}
		}
		numStack.list();
		operStack.list();
		//上面是存入成功了
		
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
	//返回运算符的优先级，优先级是程序员确定的，数字越大，优先级越高
		public static int priority(char oper) {
			if(oper == '*' || oper == '/') {
				return 1;
			}else if(oper == '+' || oper == '-') {
				return 0;
			}else {
				return -1;
			}
		}
		
		//判断是不是一个运算符
		public static  boolean isOper(char val) {
			return val == '+' || val == '-' || val == '*' || val == '/';
		}
		
		//计算方法
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
	
	//入栈
	public void push(Node node) {
		if(top == null) {
			top = node;
			low = node;
			return;
		}
		node.next = top;
		top = node;
	}
	//出栈
	public String pop() {
		if(top == null) {
			throw new RuntimeException("栈为空");
		}
		String value = top.value;
		top = top.next;
		return value;
	}
	//遍历
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
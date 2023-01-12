package day5_stack;

//数组实现栈思路分析
//1:定义一个top来表示栈顶，初始化为-1
//2:入栈：当有数据加入式，top++；stack[top} = date;
//3:出栈：int value = stack[top]; top --,return value;
public class day5 {

	public static void main(String[]args) {
		ArrayStack stack = new ArrayStack(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.list();
	}
}
//表示栈
class ArrayStack{
	int maxSize;
	int[] stack;
	int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	//栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	//入栈
	public void push(int value) {
		if(isFull()) {
			return;
		}
		top ++;
		stack[top] = value;
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空");
			//抛出异常就不用return了
		}
		int value = stack[top];
		top --;
		return value;
	}
	//遍历
	public void list() {
		if(isEmpty()) {
			return;
		}
		for(int i = top; i>=0; i--) {
			System.out.println(i +" "+ stack[i]);
		}
	}
}











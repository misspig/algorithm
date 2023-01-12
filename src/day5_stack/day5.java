package day5_stack;

//����ʵ��ջ˼·����
//1:����һ��top����ʾջ������ʼ��Ϊ-1
//2:��ջ���������ݼ���ʽ��top++��stack[top} = date;
//3:��ջ��int value = stack[top]; top --,return value;
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
//��ʾջ
class ArrayStack{
	int maxSize;
	int[] stack;
	int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	//ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	//��ջ
	public void push(int value) {
		if(isFull()) {
			return;
		}
		top ++;
		stack[top] = value;
	}
	
	//��ջ
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ��");
			//�׳��쳣�Ͳ���return��
		}
		int value = stack[top];
		top --;
		return value;
	}
	//����
	public void list() {
		if(isEmpty()) {
			return;
		}
		for(int i = top; i>=0; i--) {
			System.out.println(i +" "+ stack[i]);
		}
	}
}











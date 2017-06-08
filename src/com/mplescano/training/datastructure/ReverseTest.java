package com.mplescano.training.datastructure;

import java.util.Stack;

public class ReverseTest {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
//		while (scanner.hasNext()) {
//			stack.push(scanner.nextInt());
//		}
		
		stack.push(6);
		
		stack.push(9);
		
		stack.push(48);
		
		stack.push(1);
		
		System.out.println("------iter------");
		for (Integer item : stack) {
			System.out.println(item);
		}
		
		System.out.println("------pop------");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

import java.util.Scanner;
public class BanmayAndDeadline{
	public class Node{
		int data;
		Node next;
		
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void AddAtLast(int data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			head=tail=s;
			size++;
//			System.out.println(size);
			check();
//			dis();
		}
		else{
			Node s=new Node();
			s.data=data;
			s.next=null;
			tail.next=s;
			tail=s;
			size++;
			check();
//			dis();
		}
		
	}
	
	public void check() {
		
//		if(size>2) {
//		Node temp1=head;
//		Node temp2=head.next;
//		while(temp2!=tail) {
//			if(temp1.data<tail.data) {
//				temp1=temp2;
//				temp2=temp2.next;
//				size--;
//			}
//			else if(temp2.data<tail.data) {
//				temp1.next=temp2.next;
//				temp2=temp1.next;
//				size--;
//				
//			}
//			else {
//			temp1=temp2;
//			temp2=temp2.next;
//			}
//		}
		
	//}
//		if(head.data<tail.data) {
//			head=head.next;
//			size--;
//		}
//		if(size==2) {
//			if(head.data<tail.data) {
//				head=tail;
//				size--;
//				
//			}
//		}
	
		if(size == 1) {
			
		}
		else if(size == 2) {
			if(head.data < tail.data) {
				head=tail;
				size--;
			}
		}
		else {
			Node temp1=head;
			Node temp2=head.next;
			
			while(temp2!=tail) {
				if(temp2.data<tail.data) {
					temp1.next=temp2.next;
					temp2=temp2.next;
					size--;
				}
				else {
				    temp1=temp2;
				    temp2=temp2.next;
				}
				
			}
			
			if(head.data<tail.data) {
				head=head.next;
				size--;
			}
			
		}
		System.out.println(size);
		
	}
	public void dis() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"  ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BanmayAndDeadline list=new BanmayAndDeadline();
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for(int i=0;i<n;i++) {
			int h=scn.nextInt();
			list.AddAtLast(h);
		}
//		list.dis();
//		list.check();
//		list.dis();
		}
		

	}


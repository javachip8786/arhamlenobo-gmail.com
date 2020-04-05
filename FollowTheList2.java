import java.util.Scanner;
public class FollowTheList2 {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void Add1(int data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			head=tail=s;
			size++;
		}
		else {
			Node temp=new Node();
			temp.data=data;
			temp.next=null;
			tail.next=temp;
			tail=temp;
			size++;
		}
		
	}
	
	public void dis() {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public void del() {
		if(size>1) {
			head=head.next;
			size--;
		}
	}
	public int getindex(int index) {
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp.data;
	}
	
	public void printmiddle() {
		if(size%2==0) {
			System.out.println(getindex((size/2)-1));
			System.out.println(getindex(size/2));
			
		}
		else {
			System.out.println(getindex(size/2));
		}
	}
	

	public static void main(String[] args) {
		FollowTheList2 list=new FollowTheList2();
		list.Add1(1);
		Scanner scn=new Scanner(System.in);
		int s=scn.nextInt();
		for(int i=0;i<s;i++) {
			int h=scn.nextInt();
			if(h==1) {
				int p=scn.nextInt();
				list.Add1(p);
			}
			else if(h==2) {
				list.del();
			}
			else {
				list.printmiddle();
			}
			
		}
	}

}

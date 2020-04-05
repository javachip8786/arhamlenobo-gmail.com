import java.util.*;
public class FollowTheList2New {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	private Node mid1;
	private Node mid2;
	
	public void delete() {
		
			head=head.next;
			
			size--;
			if(size%2==0) {
				mid2=mid2.next;
			}
			else {
				mid1=mid1.next;
			}
			
		
	}
	
	public void AddAtLast(int data){
		if(size==0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			head=tail=s;
			size++;	
			mid1=s;
			mid2=s;
		}
		else {
			Node s=new Node();
			s.data=data;
			s.next=null;
			tail.next=s;
			tail=s;
			size++;
			if(size%2==0) {
				mid2=mid2.next;
			}
			else {
				mid1=mid1.next;
			}
		}
		
	}
	public void midd() {
		if(mid1.data==mid2.data) {
			System.out.println(mid1.data);
		}
		else {
			System.out.print(mid1.data+" ");
			System.out.println(mid2.data);
		}
	}

	public static void main(String[] args) {
		FollowTheList2New s=new FollowTheList2New();
		s.AddAtLast(1);
		Scanner scn=new Scanner(System.in);
		int loop=scn.nextInt();
		for(int i=0;i<loop;i++) {
		
		int h=scn.nextInt();
		if(h==1) {
				int input=scn.nextInt();
				s.AddAtLast(input);
			}
			else if(h==2) {
				s.delete();
			}
			else if(h==3) {
				s.midd();
			}
		}
	}
	}



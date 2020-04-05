
public class DoubleQueue {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	
	public void check() {
		if(q1.size<q2.size) {
			Node s=new Node();
			q1.add(q2.getLast());
			q2.remove();
		}
		
	}
	
	public void remove() {
		Node temp=head;
		Node cur=head.next;
		while(cur!=null) {
			temp=cur;
			cur=cur.next;
		}
		temp.next=null;
		size--;
		
	}
	public void add(int data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			head=tail=s;
			size++;
			
		}
		else {
		Node s=new Node();
		s.data=data;
		s.next=head;
		head=s;
		size++;
		}
		check();
	}
	public int lastLast() {
		return tail.data;
	}
	public int getFirst() {
		return head.data;
	}
	public void middle() {
		int len=q1.size +q2.size;
		if(len%2==0) {
			System.out.print(q1.getFirst+" "+q2.getLast());
		}
		else {
			System.out.print(q1.getFirst);
		}
	}

	public static void main(String[] args) {
		DoubleQueue q1=new DoubleQueue();
		DoubleQueue q2=new DoubleQueue();
		
	}

}

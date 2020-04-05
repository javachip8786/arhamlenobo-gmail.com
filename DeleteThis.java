import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
public class DeleteThis {
	
	public static class Node{
		public int data;
		public int val;
		public Node left;
		public Node right;
		public Node() {
			
		}
		public Node(int deadline,int bore) {
				data=deadline;
				val=bore;
		}
	}
	
	
	public static int N;
	

	public static void downheapify(Node arr[], int i) 
	{ 
		if(N==0) {
			return;
		}
	    int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l].data < arr[largest].data) 
	        largest = l; 
	  
	    if (r <= N && arr[r].data < arr[largest].data) 
	        largest = r; 
	  
	    if (largest != i) { 
	        int temp=arr[i].data;
	        arr[i].data=arr[largest].data;
	        arr[largest].data=temp;
	        downheapify(arr, largest); 
	    } 
	} 
	
	
	public static void upheapify(Node arr[],int i) {
		if(i==0) {
			return;
		}
		int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l].data < arr[largest].data) 
	        largest = l; 
	  
	    if (r <= N && arr[r].data < arr[largest].data) 
	        largest = r;
	    int temp=arr[i].data;
	    arr[i].data=arr[largest].data;
	    arr[largest].data=temp;
	    upheapify(arr,i/2);
	    
	}
	
	public static void insert(Node ar[],Node nn )
    {
        N++;
        ar[N] = nn;
        upheapify(ar,N);
    }
	
	
	 public static Node  popout(Node ar[])
	    {	Node n = ar[1];
	        // swap with leaf
	        ar[1] = ar[N];
	        // disconnect the last node 
	        N--;
	        // downheapify on root
	        downheapify(ar, 1);
	        return n;
	    }

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		N=0;
		Reader.init(System.in);
		Node[] array=new Node[10005];
		int loop=Reader.nextInt();
		for(int i=0;i<loop;i++) {
			Node s=new Node();
			int n=Reader.nextInt();
			int k=Reader.nextInt();
			for(int j=0;j<n;j++) {
				int w=Reader.nextInt();
				s.data=w;
			}
			for(int j=0;j<n;j++) {
				int b=Reader.nextInt();
				s.val=b;
			}
			insert(array,s);
			
	}
		for(int i=0;i<loop;i++) {
			Node d=popout(array);
			System.out.println(d.data+" -- >"+d.val);
		}

	}

}

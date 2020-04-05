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


public class BSTfoobar {
	
	 class Node { 
	        int data; 
	        Node left, right; 
	  
	        public Node(int item) { 
	            data = item; 
	            left = right = null; 
	        } 
	    } 
	  
	    // Root of BST 
	    Node root; 
	  
	    // Constructor 
	    BSTfoobar() {  
	        root = null;  
	    } 
	  
	    // This method mainly calls insertRec() 
	    void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	      
	    /* A recursive function to insert a new key in BST */
	    Node insertRec(Node root, int key) { 
	  
	        /* If the tree is empty, return a new node */
	        if (root == null) { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.data) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.data) 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    } 
	  
	    // This method mainly calls InorderRec() 
	    void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
//	            System.out.println(root.data); 
	            sum(root);
	            inorderRec(root.right); 
	        } 
	    }
	    
	    void sum(Node root) {
	    	 if (root != null) { 
		            inorderRec(root.left); 
//		            System.out.println(root.data); 
		            sum1(root);
		            inorderRec(root.right); 
		        }
	    }
	    
	  
	    // Driver Program to test above functions 
	    public static void main(String[] args) throws IOException{ 
	    	BSTfoobar tree = new BSTfoobar(); 
	    	Reader.init(System.in);
	    	int n = Reader.nextInt(); // To take integer input
	    	for(int i=0;i<n;i++) {
	    		int m = Reader.nextInt(); 
	    		tree.insert(m);
	    	}
	        // print inorder traversal of the BST 
	        tree.inorder(); 
	    } 

	
}

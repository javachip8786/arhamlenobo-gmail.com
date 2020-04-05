import java.util.*;
public class DSA_lab {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int x=scn.nextInt();
		int y=scn.nextInt();
		int k=scn.nextInt();
		int m=scn.nextInt();
		int[] A=new int[x];
		int[] B=new int[y];
		for(int i=0;i<x;i++) {
			A[i]=scn.nextInt();
		}
		for(int i=0;i<y;i++) {
			B[i]=scn.nextInt();
		}
		int[] resultA=new int[x];
		resultA=mergesort(A);
		int[] resultB=new int[y];
		resultB=mergesort(B);
		int finall=question(resultA,resultB,k,m);
		if(finall==1) {
			System.out.print("YES");
			
		}
		else {
			System.out.print("NO");
		}	
	}
	
	
	
	public static int[] mergesort(int[] arr) {
		if(arr.length<=1) {
			return arr;
		}
		int mid=arr.length/2;
		int[] left=new int[mid];
		int[] right;
		if(arr.length%2==0) {
			right=new int[mid];
		}
		else {
			right=new int[mid+1];
			
		}
		for(int i=0;i<left.length;i++) {
			left[i]=arr[i];
			
		}
		for(int j=0;j<right.length;j++) {
			right[j]=arr[mid+j];
		}
		left=mergesort(left);
		right=mergesort(right);
		int[] result=new int[arr.length];
		result=merge(left,right);
		return result;
	}
	public static int[] merge(int[] left,int[] right) {
		int[] result=new int[left.length+right.length];
		int lp,rp,rep;
		lp=rp=rep=0;
		while(lp<left.length || rp<right.length) {
			if(lp<left.length && rp<right.length) {
				if(left[lp]<right[rp]) {
					result[rep++]=left[lp++];
				}
				else {
					result[rep++]=right[rp++];
				}
			}
			else if(lp<left.length) {
				result[rep++]=left[lp++];
			}
			else if(rp<right.length) {
				result[rep++]=right[rp++];
			}
		
	}return result;

}
	public static int question(int[] resultA,int[] resultB,int k,int m) {
		int resB=resultB[resultB.length-m];
		int resA=resultA[k-1];
		if(resB<=resA) {
			System.out.println("resA is "+resA+" and resB is "+resB);
			return -1;
		}
		else {
			System.out.println("resA is "+resA+" and resB is "+resB);
			return 1;
		}
			
		
	}
}

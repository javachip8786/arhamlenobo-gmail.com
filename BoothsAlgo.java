import java.lang.Math;
import java.util.*;
public class BoothsAlgo {
	//return a binary array
	public static int[] binary(int a) {
		int[] arr=new int[8];
		int i=arr.length-1;
		while(a>1) {
			arr[i]=a%2;
			a/=2;
			i--;
		}
//		for(int j=0;j<arr.length;j++) {
//			System.out.print(arr[j]);
//		}
		arr[i]=1;
		
		return arr;
	}
	//returns a shifted a array ASR
	public static int[] shift(int[] arr) {
		int[] brr=new int[arr.length];
		brr[0]=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			brr[i+1]=arr[i];
		}
//		for(int i=0;i<brr.length;i++) {
//			System.out.print(brr[i]);
//		}
		return brr;
	}
	//Add two binary arrays and return the final array
	public static int[] Add(int[] arr,int[] brr) {
		int[] fin=new int[8];
		int i=fin.length-1;
		int carry=0;
		while(i>=0) {
			int sum=arr[i]+brr[i]+carry;
//			System.out.println(sum);
			if(sum==3) {
				fin[i]=1;
				carry=1;
			}
			else if(sum==2){
				fin[i]=0;
				carry=1;
			}
			else if(sum==1){
				fin[i]=1;
				carry=0;
			}
			i--;
		}
//		for(int j=0;j<fin.length;j++) {
//			System.out.print(fin[j]);
//		}
		return fin;
	}
	//returns a 2's compliment of a binary array
	public static int[] convertToNegative(int[] arr) {
		int[] nega=new int[arr.length];
		int last=arr.length-1;
		while(arr[last]!=1 && last>=0) {
			nega[last]=arr[last];
			last--;
		}
		nega[last]=1;
		last--;
		while(last>=0) {
			if(arr[last]==0) {
				nega[last]=1;
			}
			else {
				nega[last]=0;
			}
			last--;
		}
//		for(int j=0;j<nega.length;j++) {
//			System.out.print(nega[j]);
//		}
		return nega;
	}
	
	public static int[] Mshift(int[] Mrr,int AClastBit) {
		int[] dd=new int[8];
		dd[0]=AClastBit;
		for(int i=0;i<Mrr.length-1;i++) {
			dd[i+1]=Mrr[i];
		}
		return dd;
	}
	
	public static int[] result(int[] arr,int[] brr) {
		int[] result=new int[16];
		for(int i=0;i<arr.length;i++) {
			result[i]=arr[i];
		}
		for(int i=0;i<brr.length;i++) {
			result[8+i]=brr[i];
		}
		return result;
	}
	
	//this will convert binary to decimal
	public static int BtoD(int[] result) {
		int sum=0;
		int pow=1;
		for(int i=result.length-1;i>=0;i--) {
			if(result[i]==1) {
				sum+=pow;
			}
			pow*=2;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter multiplier (Q) =" );
		int Q=scn.nextInt(); //this is multiplier
		System.out.println("enter multiplicant (M) =" );
		int M=scn.nextInt(); //this is multiplicant   
		//if one is negative, only M can be negative
		
		System.out.println("   AC   "+"   Q       "+"q*");
		
		
		// when both are positive OR both are negative
		
		if((M>=0 && Q>=0) || (M<0 && Q<0)) {
			int[] Qrr=binary(Q);  //Qrr has binary value of Q
			int[] Mrr=binary(M);  //Mrr has binary value of M
//			for(int j=0;j<Qrr.length;j++) {
//			System.out.print(Qrr[j]);
//		}
//			System.out.println();
			int Qzero=0;
			int[] AC=new int[8];
			for(int i=0;i<8;i++) {
				int Qone=Qrr[7];
//				System.out.println(Qone);
				if(Qone==1 && Qzero==0) {
					int[] negaM=convertToNegative(Mrr);
//					for(int j=0;j<Qrr.length;j++) {
//					System.out.print(negaM[j]);
//				}
//					System.out.println();
					AC=Add(negaM,AC);
	
				}
				else if (Qone==0 && Qzero==1) {
					AC=Add(AC,Mrr);
				}
				int AClastBit=AC[7];
				Qzero=Qrr[7];
	
				AC=shift(AC);
	
				Qrr=Mshift(Qrr,AClastBit);
	
				
				for(int j=0;j<AC.length;j++) {
					System.out.print(AC[j]);
				}
				System.out.print("  ");
				for(int j=0;j<AC.length;j++) {
				System.out.print(Qrr[j]);
			}
				System.out.print(" ");
				System.out.print(Qzero);
				System.out.println();
				
			}
			int[] result=new int[16];
			result=result(AC,Qrr);
			
			for(int j=0;j<result.length;j++) {
				System.out.print(result[j]);
			}
			System.out.println();
			//this is to again get decimal
			System.out.println(BtoD(result));
	//		int[] hrr= {0,0,1,1,1};
	//		int[] pp=convertToNegative(hrr);
	//		for(int j=0;j<pp.length;j++) {
	//		System.out.print(pp[j]);
			}
		
		//when one number is negative
		
		else if(M<0 && Q>0) {
			M=Math.abs(M);
			int[] Qrr=binary(Q);  //Qrr has binary value of Q
			int[] Mrr=binary(M);  //Mrr has binary value of M
			int[] NMrr=convertToNegative(Mrr);
//			for(int j=0;j<Qrr.length;j++) {
//			System.out.print(Mrr[j]);
//		}
//			System.out.println();
			int Qzero=0;
			int[] AC=new int[8];
			for(int i=0;i<8;i++) {
				int Qone=Qrr[7];
				if(Qone==1 && Qzero==0) {
		
					AC=Add(NMrr,AC);
	
				}
				else if (Qone==0 && Qzero==1) {
					AC=Add(AC,Mrr);
				}
				int AClastBit=AC[7];
				Qzero=Qrr[7];
	
				AC=shift(AC);
	
				Qrr=Mshift(Qrr,AClastBit);
	
				
				for(int j=0;j<AC.length;j++) {
					System.out.print(AC[j]);
				}
				System.out.print("  ");
				for(int j=0;j<AC.length;j++) {
				System.out.print(Qrr[j]);
			}
				System.out.print(" ");
				System.out.print(Qzero);
				System.out.println();
				
			}
			int[] result=new int[16];
			result=result(AC,Qrr);
//			result=convertToNegative(result);
			for(int j=0;j<result.length;j++) {
				System.out.print(result[j]);
			}
			System.out.println();
			System.out.println("-"+BtoD(result));
		}
		
		
	}
	}



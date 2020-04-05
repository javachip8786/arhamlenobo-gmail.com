
public class DPRecursonFibo {
	//normal fibonacci
	public static int fibo1(int n) {
		if(n==0 || n==1) {
			return n;
		}
		int nm1=fibo1(n-1);
		int nm2=fibo1(n-2);
		return nm1+nm2;
	}
	//fibonacci with DP
	public static int FiboWithDP(int[] arr,int n) {
		if(n==0 || n==1) {
			return n;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		int nm1=FiboWithDP(arr,n-1);
		int nm2=FiboWithDP(arr,n-2);
		int ans=nm1+nm2;
		arr[n]=ans;
		return ans;
	}
	
	//fibonacci with iterative
	public static int FiboWithDPIter(int n) {
		int[] arr=new int[n+1];
		arr[0]=0;arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
	}

	public static void main(String[] args) {
		int[] arr=new int[47];
		System.out.println(FiboWithDP(arr,46));
		System.out.println(fibo1(10));
		System.out.println(FiboWithDPIter(46));
	}

}

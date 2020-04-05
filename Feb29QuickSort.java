
public class Feb29QuickSort {
	
	public static void quicksort(int arr[],int lo,int hi) {
		if(lo>hi) {
			return;
		}
		int pivot=arr[hi];
		int pivndx=merge(arr,lo,hi,pivot);
		quicksort(arr,lo,pivndx-1);
		quicksort(arr,pivndx+1,hi);
	}
	
	public static int merge(int[] arr,int lo,int hi,int pivot) {
		int i=0;
		int j=0;
		while(i<arr.length) {
			if(arr[i]<=pivot) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j++;
			}
			else {
				i++;
			}
		}
		return j-1;
	}

	public static void main(String[] args) {
		int[] arr= {25,27,14,7,24,3,45,1,6,15};
		int lo=0;
		int hi=arr.length-1;
		quicksort(arr,lo,hi);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}

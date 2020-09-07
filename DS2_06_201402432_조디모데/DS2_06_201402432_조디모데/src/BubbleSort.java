import java.util.Arrays;

public class BubbleSort {

	private int[] data ;

	public BubbleSort(){


	}

	public void sort(int[] data, int dataSize) {

		this.data = Arrays.copyOf(data, dataSize) ;
		
		for(int i = 0 ; i<dataSize ; i++)
			for(int j = 0 ; j<dataSize-i-1 ; j++)
				if(this.data[j]>this.data[j+1])
					swap(j) ;
		
	}

	private void swap(int n){
		int tmp ;
		tmp = this.data[n] ;
		this.data[n] = this.data[n+1] ;
		this.data[n+1] = tmp ;
		
	}
	
	
}

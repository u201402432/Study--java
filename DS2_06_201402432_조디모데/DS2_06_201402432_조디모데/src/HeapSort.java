public class HeapSort {
	
	private int[] data ;

	public HeapSort(){
			

	}
	
	public void sort(int[] data, int dataSize) {

		this.data = data.clone() ;
		for(int i=0 ; i<this.data.length ; i++)
			this.maxHeap(i) ;

	}

	private void maxHeap(int i) {
		int l = i*2+1 ;
		int r = i*2+2 ;
		int largest ;
		
		if( (l <= this.data.length-1) && (this.data[l]>this.data[i]))
			largest = l ;
		else
			largest = i ;
		
		if(r <= this.data.length-1 && this.data[l] > this.data[i])
			largest = r ;
		if(largest != i){
			swap(i, largest) ;
			maxHeap(largest) ;
		}
	}

	private void swap(int i, int largest) {
		int tmp = this.data[i] ;
		this.data[i] = this.data[largest] ;
		this.data[largest] = tmp ;
	}

}

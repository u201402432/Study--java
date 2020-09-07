public class QuickSort{
	int[] _data ;

	public void sort(int[] data, int dataSize){

		this._data = data.clone() ;

		int minLoc = 0 ;

		// 최소값을 원소 구간의 맨 끝으로 옮긴다.
		swap(minLoc, dataSize-1) ;	
		// 정렬을 시작한다.
		quickSortRecursively(this._data, 0,dataSize-2) ;

	}

	private void swap(int positionA, int positionB){
		int temp = this._data[positionA] ;
		this._data[positionA] = this._data[positionB] ;
		this._data[positionB] = temp ;
	}

	public void quickSortRecursively(int[] data, int left, int right){
		if (left < right) /* 구간의크기가2 이상이면*/{
			int mid = partition(this._data, left, right) ; // DIVIDE
			quickSortRecursively(data, left, mid-1) ;// CONQUER
			quickSortRecursively(data, mid+1, right) ; // CONQUER
		}
	}

	private int partition(int data[], int left, int right){
		int pivot = left ;
		int pivotScore = data[pivot] ;
		right++ ;
		do{
			do{
				left++ ;
			}while(data[left] > pivotScore);

			do{
				right--;
			}while(data[right] < pivotScore);

			if(left<right)
				this.swap(left, right);

		}while(left<right);
		this.swap(pivot, right);
		return right ;
	}

}
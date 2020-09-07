

import java.util.Arrays;

public class InsertionSort {

	private int[] _data ;
	private int[] _sorted ;

	public InsertionSort(){

	}

	public void sort(int[] data, int dataSize) {
		int tmp ;

		this._data = Arrays.copyOf(data, dataSize) ;
		this._data[0] = -1 ;

		for(int i=1 ; i<dataSize ; i++){
		
			for(int j=1 ; j<i ; j++)
				if(this._data[i]<this._data[j]){
					tmp = this._data[j] ;
					this._data[j] = this._data[i] ;
					this._data[i] = tmp ;
					break ;
				}
			
		}
		
	}



} // class

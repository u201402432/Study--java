import java.util.* ;
import java.util.Arrays;
public class DataGenerator {
	
	private int[] _data ;
	private int[] _dataArray;
	private int _dataSize ;
	
	public DataGenerator(){
		this._dataSize = -1 ;
		
	}
	
	public void generateSequentialData(int size) {
		this._dataArray = Arrays.copyOf(this._data, size) ;
		Arrays.sort(this._dataArray) ;
	}

	public void generateRevereData(int size) {
		this._dataArray = Arrays.copyOf(this._data, size) ;
		Arrays.sort(this._dataArray) ;
		int tmp[] = this._dataArray.clone() ;
		
		for(int i=0 ; i<size ; i++)
			this._dataArray[i] = tmp[size-i-1] ;
		
		this._dataArray[0] = -1 ;
	}

	public void generateRandomData(int size) {
	 	// 이미 랜덤으로 저장된 Data입니다.
		this._dataArray = Arrays.copyOf(this._data,size) ;
	}
	
	public int[] getData(int size) {
		int[] copyArray = Arrays.copyOf(this._dataArray, size) ;
		
		return copyArray ;
	}
	
	public void setData(int size) {
		Random r = new Random() ;
		this._dataSize = size ;
		this._data = new int[size] ;
		this._data[0] = -1 ;
		for(int i=1 ; i<size ; i++)
			this._data[i] = r.nextInt(1000)+1 ;
		
	}


}

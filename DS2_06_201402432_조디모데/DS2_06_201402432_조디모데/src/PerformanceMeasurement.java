import java.util.* ;

public class PerformanceMeasurement {

	private static final int DURATION_CHECKING = 5000;
	private InsertionSort _insertionSort;
	private QuickSort _quickSort;
	private HeapSort _HeapSort;
	private BubbleSort _bubbleSort;
	private double _beforeTime;
	private int _beforeDataSize;

	public PerformanceMeasurement(){

		this._insertionSort = new InsertionSort() ;
		this._quickSort = new QuickSort() ;
		this._HeapSort = new HeapSort() ;
		this._bubbleSort = new BubbleSort() ;
		this._beforeTime = -1 ; 
		this._beforeDataSize = -1 ;	
	
	}

	public double testInsertionSort(int[] data, int dataSize){
		double insertTime = 0 ;
		long start, end ;
		
		start = System.nanoTime() ;
		this._insertionSort.sort(data, dataSize) ;
		end = System.nanoTime() ;
		insertTime = (double) (end - start) ;
		
		return insertTime ;
	}
	
	public double testQuickSort(int [] data, int dataSize){
		double insertTime = 0 ;
		long start, end ;
		
		start = System.nanoTime() ;
		this._quickSort.sort(data, dataSize) ;
		end = System.nanoTime() ;
		insertTime = (double) (end - start) ;
		
		return insertTime ;
			
	}
	
	public double testHeapSort(int [] data, int dataSize){
		double insertTime = 0 ;
		long start, end ;
		
		start = System.nanoTime() ;
		this._HeapSort.sort(data, dataSize) ;
		end = System.nanoTime() ;
		insertTime = (double) (end - start) ;
		
		return insertTime ;
		
	}
	
	public double testBubbleSort(int [] data, int dataSize){
		double insertTime = 0 ;
		long start, end ;
		
		start = System.nanoTime() ;
		this._bubbleSort.sort(data, dataSize) ;
		end = System.nanoTime() ;
		insertTime = (double) (end - start) ;
		
		return insertTime ; 
		
	}	
	

	
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ExternalSort {

	private int _diskSize;
	private int _memoryBufferSize;
	private String _tfile = "temp";
	private QuickSort _quickSort ;

	public ExternalSort(){
	}

	public ExternalSort(int givenDiskSize, int givenMemorySize) {
		this._diskSize = givenDiskSize ;
		this._memoryBufferSize = givenMemorySize ;
	}

	public void externalSort(String dataName, String resultName){
		// Divide 와 merge작업 수행
		this.divide(dataName);
		this.merge(resultName);
	}

	private void divide(String dataName){
		// 정렬하려는파일을원하는개수만큼잘라서정렬하여저장
		int[] buffer = new int[this._memoryBufferSize < this._diskSize ? this._memoryBufferSize : this._diskSize] ;
		this._quickSort = new QuickSort() ;
		
		try{
			FileReader fileReader = new FileReader(dataName) ;
			BufferedReader bufferedReader = new BufferedReader(fileReader) ;
			int slices = (int)Math.ceil((double)this._diskSize / this._memoryBufferSize) ;

			int i, j ;
			i = j = 0 ;
			for(i = 0 ; i< slices ; i++){

			String str ;
				for(j = 0 ; j < (this._memoryBufferSize < this._diskSize ? this._memoryBufferSize : this._diskSize) ; j++){
					str = bufferedReader.readLine() ;
					if(str==null)
						continue ;
					
					buffer[j] = Integer.parseInt(str) ;
				}
				
				buffer = this._quickSort.Sort(buffer, buffer.length);

				FileWriter fileWriter = new FileWriter (this._tfile + Integer.toString(i) + ".txt") ;
				PrintWriter printWriter = new PrintWriter(fileWriter) ;
				
				for(int k = 0 ; k < buffer.length ; k++)
					printWriter.println(buffer[k]) ;
				
				fileWriter.close();
				printWriter.close();
			}
		
			
		}catch(Exception e){
			e.printStackTrace() ;
		}

	}

	private void merge(String resultName){
		// 정렬되어있는파일들을모아서하나의출력파일을만들어냄
		int slices = (int)Math.ceil((double)this._diskSize / this._memoryBufferSize) ;
		int[] top = new int[slices] ;
		
		FileReader fileReader ;
		BufferedReader[] bufferedReader = new BufferedReader[slices] ;

		try{
			FileWriter fileWriter = new FileWriter ("Result.txt") ;

			@SuppressWarnings({ "unused", "resource" })
			PrintWriter printWriter = new PrintWriter(fileWriter) ;

			for(int i=0 ; i<slices ; i++){
				fileReader = new FileReader("temp"+Integer.toString(i)+".txt") ;
				bufferedReader[i] = new BufferedReader(fileReader) ;				
			}

			String str ;
			
			int min = 0 ;
			for(int i=0 ; i<slices ; i++){
				str = bufferedReader[i].readLine() ;
				if(str==null)
					continue ;
				
				top[i] = Integer.parseInt(str) ;
				if(top[min]!=Math.min(top[i], top[min]))
						min=i ;
			}
			
			while(true){
				
				printWriter.println( Integer.toString(top[min]) ) ;
				
				str = bufferedReader[min].readLine() ;
				
				if(str!=null){
					top[min] = Integer.parseInt(str) ;
					min = this.findMin(top) ;
				}
				else{
					top[min]=Integer.MAX_VALUE ;						
					min = this.findMin(top) ;
				}
				
				boolean end = true ;
				for(int x : top)
					if(x!=Integer.MAX_VALUE)
						end = false ;
				
				if(end){
					printWriter.close() ;
					fileWriter.close() ;
					break ;
				}
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace() ;
		}
	} 
	
	private int findMin(int[] num){
		int min = 0 ;
		for(int i=1 ; i<num.length ; i++){
			if(num[min]>num[i])
				min = i ;
		}
		return min ;
	}
}
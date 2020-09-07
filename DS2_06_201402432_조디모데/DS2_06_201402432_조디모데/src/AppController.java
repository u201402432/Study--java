

public class AppController {

	private AppView _appView ;
	private DataGenerator _dataGenerator ;
	private PerformanceMeasurement _pml ;
	private  double _InsertionSortDuration ;
	private  double _QuickSortDuration ;
	private  double _BubbleSortDuration ;
	private  double _HeapSortDuration ;

	private  int _sortType ;
	private  int _dataTerm ;
	private  int _maxDataSize ;
	private  int[] _data ;
	private int _testSequense ;
	
	AppController(){
		
		this._appView = new AppView() ;
		this._dataGenerator = new DataGenerator() ;
		this._pml = new PerformanceMeasurement() ;
		this._testSequense = 50 ;
		
	}
	
	private void doTest(int dataSize){
		
		this._InsertionSortDuration = 0 ;
		this._QuickSortDuration = 0 ;
		this._BubbleSortDuration = 0 ;
		this._HeapSortDuration = 0 ;
		
		this._data = this._dataGenerator.getData(dataSize) ;

		for(int index = 0 ; index < this._testSequense ; index++){
			this._InsertionSortDuration += this._pml.testInsertionSort(this._data, dataSize);
			this._QuickSortDuration += this._pml.testQuickSort(this._data, dataSize);
			this._BubbleSortDuration += this._pml.testQuickSort(this._data, dataSize);
			this._HeapSortDuration += this._pml.testQuickSort(this._data, dataSize);
		}
		
		this._InsertionSortDuration = this._InsertionSortDuration / this._testSequense ;
		this._QuickSortDuration = this._QuickSortDuration / this._testSequense ;
		this._BubbleSortDuration = this._BubbleSortDuration / this._testSequense ;
		this._HeapSortDuration = this._HeapSortDuration / this._testSequense ;
			
	}

	public void run(){
		
		this.showMessage(MessageID.Notice_StartProgram);
		this._sortType = 0 ;
		
		this._dataTerm = this._appView.inputDataTerm() ;
		this._maxDataSize = this._appView.inputMaxDataSize();
	
		this._dataGenerator.setData(this._maxDataSize) ;
	
		while(this._sortType != 4){
			this.showMessage(MessageID.Notice_Menu);
			this._sortType = this._appView.inputSortType() ;
			
			if(this._sortType == 1){
				this._dataGenerator.generateSequentialData(this._maxDataSize) ;
				this.showMessage(MessageID.Notice_SequentialData);
			}
			else if (this._sortType == 2){
				this._dataGenerator.generateRevereData(this._maxDataSize) ;
				this.showMessage(MessageID.Notice_ReverseData);
			}
			else if (this._sortType == 3){
				this._dataGenerator.generateRandomData(this._maxDataSize) ;
				this.showMessage(MessageID.Notice_RandomData);
			}
			else if (this._sortType == 4){
				break ;
			}
			else {
				this.showMessage(MessageID.Error_WrongMenu);
				continue ;
			}
			
			this.showMessage(MessageID.Notice_ShowTitle) ;
			
			// 메모리 생성 및 테스트의 안정성을 위하여 가장 첫 성능 측정을 미리 한번 진행한다.
			this.doTest(this._dataTerm);
			
			// 실제 테스트 진행
			for(int dataSize = this._dataTerm ; dataSize<=this._maxDataSize ; dataSize += this._dataTerm){
				this.doTest(dataSize);
				this._appView.outputResult(dataSize, this._InsertionSortDuration,this._QuickSortDuration,
						this._HeapSortDuration,this._BubbleSortDuration);		
				System.out.println();
			}
		}
		this.showMessage(MessageID.Notice_EndProgram) ;
 
	}

	private void showMessage(MessageID MessageID) {
		switch(MessageID) {
		case Notice_StartProgram:
			this._appView.outputMessage("< 정렬에 따른 실행 성능 차이 알아보기 >\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("< 성능 측정을 종료합니다 >\n");
			break;
		case Notice_Menu :
			this._appView.outputMessage(  "[1] Sequential Data\n"
										+ "[2] Reverse Data\n"
										+ "[3] Random Data\n"
										+ "[4] End\n") ;
			break;
		case Notice_SequentialData :
			this._appView.outputMessage("=== SEQUENTIAL DATA ===\n");
			break;
		case Notice_ReverseData :
			this._appView.outputMessage("=== REVERSE DATA ===\n");
			break;
		case Notice_RandomData :
			this._appView.outputMessage("=== RANDOM DATA ===\n");
			break;
		case Notice_ShowTitle :
			this._appView.outputMessage("DataSize\tInsertion\tQuick\t\tHeap\t\tBubble\n");
			break;
		
		case Error_WrongMenu:
			this._appView.outputMessage("<<ERROR: 잘못된메뉴입니다.>>\n");
			break;
		
		}
	}


}

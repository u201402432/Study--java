public class QuickSort {
	private int[] _data ;
	
	public int[] Sort(int[] data, int length){
		this._data = data.clone() ;
		QuickSort.Sort(this._data, 0, length-1);
		return this._data ;
	}
	
    public static void Swap(int[] list, int idx1, int idx2) {
        int swapTmp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = swapTmp;
    }

    public static int Partition(int[] list, int left, int right, int pivot_idx) {
        int pivot = list[pivot_idx];
        Swap(list, pivot_idx, right);    //Move to end
        int split_idx = left;
        for(int i=left ; i<right ; i++) {
            if(list[i] <= pivot) {
                Swap(list, split_idx, i);
                ++split_idx;
            }
        }
        Swap(list, right, split_idx); //Move to split index
        return split_idx;
    }
    public static void Sort(int[] list, int left, int right) {
        if(right > left) {
            int pivot_idx = Partition(list, left, right, left);
            Sort(list, left, pivot_idx - 1);
            Sort(list, pivot_idx + 1, right);
        }
    }
}

package gabrielsUtilities;

public interface Sorts
		extends Arrays {
	
	public default int[] selectionSort(int[] array) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			
			int[] partArray = shrinkArrayFromBack(array, i);
			int[] largestAndIndex = getLargest(partArray);
			int temp = array[partArray.length - 1];
			array[partArray.length - 1] = largestAndIndex[Arrays.LARGEST];
			array[largestAndIndex[Arrays.INDEX_OF_LARGEST]] = temp;
			printArray(partArray);
			printArray(array);
//debug			System.out.println(array[partArray.length - 1]);
//debug			System.out.println(array[largestAndIndex[Arrays.INDEX_OF_LARGEST]]);
		}
		
		return array;
		
	}
	
	public default int[] selectionSort(int[] array, int arrayLength) {
		
		int[] partArray = array;
		
		for (int i = 0; i < arrayLength; i++) {
			
			int[] largestAndIndex = getLargest(partArray);
			int temp = array[partArray.length - 1];
			array[partArray.length - 1] = largestAndIndex[Arrays.LARGEST];
			array[largestAndIndex[Arrays.INDEX_OF_LARGEST]] = temp;
			partArray = shrinkArrayFromBack(partArray, 1);
			
		}
		
		return array;
		
	}
	
	public default int[] bubbleSort(int[] array, int arrayLength) {
		
		for (int i = 1; i < arrayLength; i++) {
			for (int n = 1; n < arrayLength; n++) {
				
				if (array[n - 1] > array[n]) {
					int temp = array[n];
					array[n] = array[n - 1];
					array[n - 1] = temp;
				}
				
			}
		}
		
		return array;
		
	}
	
	public default int[] bubbleSort(int[] array) {
		int arrayLength = array.length;
		
		for (int i = 1; i < arrayLength; i++) {
			for (int n = 1; n < arrayLength; n++) {
				
				if (array[n - 1] > array[n]) {
					int temp = array[n];
					array[n] = array[n - 1];
					array[n - 1] = temp;
				}
				
			}
		}
		
		return array;
		
	}
	
	//array can't have any -1s
	public default int[] bogoSort(int[] array) {
		int arrayLength = array.length;
		
		int[] temp = randomizeArray(array, arrayLength);
		
		if (inOrder(temp)) 
			return temp;
		else
			return bogoSort(array);
		
	}
	
	//array can't have any -1s
	public default int[] bogoSort(int[] array, int arrayLength) {
		
		int[] temp = randomizeArray(array, arrayLength);

		if (inOrder(temp)) 
			return temp;
		else
			return bogoSort(array, arrayLength);
		
	}
	
	
	
}

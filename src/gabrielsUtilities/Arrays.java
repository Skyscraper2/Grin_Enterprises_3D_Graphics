package gabrielsUtilities;

public interface Arrays
		extends Numbers {
	
	public static final int LARGEST = 0;
	public static final int INDEX_OF_LARGEST = 1;
	
	public default int[] getLargest(int[] array, int arrayLength) {
		
		int largest = -1;
		int largestIndex = -1;
		
		for (int i = 0; i < arrayLength; i++) {
			
			if (array[i] >= largest) {
				largest = array[i];
				largestIndex = i;
			}
			
		}
		
		return new int[]{largest, largestIndex};
		
	}
	
	public default int[] getLargest(int[] array) {
		int arrayLength = array.length;
		
		int largest = -1;
		int largestIndex = -1;
		
		for (int i = 0; i < arrayLength; i++) {
			
			if (array[i] >= largest) {
				largest = array[i];
				largestIndex = i;
			}
			
		}
		
//debug		System.out.println("Largest:" + largest + " largestIndex:" + largestIndex);
		
		return new int[]{largest, largestIndex};
		
	}
	
	public default int[] setRandoArray(int length, int interval) {
		int[] array = new int[length];
		
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * interval);
		}
		
		return array;
		
	}
	
	public default int[] setRandoArray(int length, int min, int max) {
		
		int[] array = new int[length];
		int interval = max - min;
		
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * interval) + min;
		}
		
		return array;
		
	}
	
	//kinda unwieldy and using polymorphism in a bad way, do not use
	public default int[] setRandoArray(int length, int min, int max, boolean blah) {
//debug		System.out.println("setRandoArray");
		int[] array = setArrayTo(-1, new int[length]);
		int interval = max - min;
		
		for (int i = 0; i < length; i++) {
			array[i] = randomIndex(array, interval, min);
//debug			System.out.println(//"\nnum:" + num + " min:" + min + " max:" + max + 
//debug					" \n" + array[i] + " finished one iteration of randomIndex");
		}
		
//debug		System.out.println("finisehd randomIndex");
		return array;
		
	}
	
	public default boolean inOrder(int[] array, int arrayLength) {
		
		for (int i = 1; i < arrayLength; i++) 
			if (array[i - 1] > array[i]) 
				return false;
		
		return true;
		
	}
	
	public default boolean inOrder(int[] array) {
		int arrayLength = array.length;
		
		for (int i = 1; i < arrayLength; i++) 
			if (array[i - 1] > array[i]) 
				return false;
		
		return true;
		
	}
	
	public default int[] shrinkArrayFromBack(int[] array, int arrayLength, int byWhat) {
		int[] newArray = new int[arrayLength - byWhat];
		
		for (int i = 0; i < arrayLength - byWhat; i++) {
			newArray[i] = array[i];
		}
		
		return newArray;
		
	}
	
	public default int[] shrinkArrayFromBack(int[] array, int byWhat) {
		int arrayLength = array.length;
		int[] newArray = new int[arrayLength - byWhat];
		
		for (int i = 0; i < arrayLength - byWhat; i++) {
			newArray[i] = array[i];
		}
		
		return newArray;
		
	}

	public default int[] shrinkArrayFromFront(int[] array, int arrayLength, int byWhat) {
		int[] newArray = new int[arrayLength - byWhat];
		
		for (int i = 0; i < arrayLength - byWhat; i++) {
			newArray[i] = array[i + byWhat];
		}
		
		return newArray;
		
	}
	
	public default int[] shrinkArrayFromFront(int[] array, int byWhat) {
		int arrayLength = array.length;
		int[] newArray = new int[arrayLength - byWhat];

		for (int i = 0; i < arrayLength - byWhat; i++) {
			newArray[i] = array[i + byWhat];
		}
		
		return newArray;
		
	}
	
	public default int[] randomizeArray(int[] array, int arrayLength) {
		
		int[] temp = setArrayTo(-1, new int[arrayLength]);
		
		for (int i = 0; i < arrayLength; i++) {
//debug			System.out.println(i);
			int rand = (int) (Math.random() * arrayLength);
			while (temp[rand] != -1) 
				rand = (int) (Math.random() * arrayLength);
			
			temp[rand] = 
					array[i];
			
		}
		
		return temp;
		
	}
	
	public default int[] randomizeArray(int[] array) {
		int arrayLength = array.length;
		
		int[] temp = setArrayTo(-1, new int[arrayLength]);
		
		for (int i = 0; i < arrayLength; i++) {
			
			int rand = (int) (Math.random() * arrayLength);
			while (temp[rand] != -1) 
				rand = (int) (Math.random() * arrayLength);
			
			temp[rand] = array[i];
			
		}
		
		return temp;
		
	}
	
	public default String StringFromArray(int[] array) {
		String fromArray = "";
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) {
			fromArray += array[i] + " - ";
		}
		
		return fromArray;
		
	}

	public default String StringFromArray(int[] array, String separator) {
		String fromArray = "";
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) {
			fromArray += array[i] + separator;
		}
		
		return fromArray;
		
	}

	public default void printArray(boolean[] array) {
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) 
			System.out.print(array[i] + " ");
		
		System.out.print("\n");
		
	}
	
	public default void printArray(char[] array) {
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) 
			System.out.print(array[i] + " ");
		
		System.out.print("\n");
		
	}
	
	public default void printArray(double[] array) {
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) 
			System.out.print(array[i] + " ");
		
		System.out.print("\n");
		
	}
	
	public default void printArray(int[] array) {
		
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) 
			System.out.print(array[i] + " ");
		
		System.out.print("\n");
		
	}
	
	public default int getTurnsToFind(int that, int[] here) {
		
		int counter = 0;
		
		int standin = 0;
		while (standin != that) {
			standin = here[counter];
			counter++;
//debug			System.out.println("standin:" + standin + " counter:" + counter);
		}
		
		return counter;
		
	}
	
	public default double getAverage(double[] nums) {

		double sum = 0.0;
		int numsLength = nums.length;
		
		for (int i = 0; i < numsLength; i++) {
			sum += nums[i];
		}
		
		double average = (sum + 0.0) / (numsLength + 0.0);
		
		return roundToDecimals(average, 3);
		
	}
	
	public default double getAverage(int[] nums) {
		
		int sum = 0;
		int numsLength = nums.length;
		
		for (int i = 0; i < numsLength; i++) {
			sum += nums[i];
		}
		
		double average = (sum + 0.0) / (numsLength + 0.0);
		
		return roundToDecimals(average, 3);
		
	}
	
	public default int[] setArrayToZero(int[] array) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = 0;
		}
		
		return array;
	}
	
	public default int[] setArrayTo(int that, int[] array) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = that;
		}
		
		return array;
	}
	
	public default Object[] setArrayTo(Object that, Object[] array) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = that;
		}
		
		return array;
	}

	public default boolean[] setArrayTo(boolean that, boolean[] array) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = that;
		}
		
		return array;
	}
	
	public default int randomIndex(int[] indices, int range, int min) {
		
		int index = -1;
		
		while (arrayContains(indices, index = (int) (Math.random() * range) + min)) {}
		
		return index;
		
	}
	
	public default int randomIndex(int[] indices, int range) {

		int index = -1;

		while (arrayContains(indices, index = (int) (Math.random() * range))) {}
		
		return index;
		
	}
	
	public default int[] addToArrayEnd(int[] pre, int toAdd) {
		
		int preLength = pre.length;
		int[] post = new int[preLength + 1];
		
		for (int i = 0; i < preLength; i++) 
			post[i] = pre[i];
		
		post[preLength] = toAdd;
		
		return post;
	}
	
	public default char[] addToArrayEnd(char[] pre, char toAdd) {
		
		int preLength = pre.length;
		char[] post = new char[preLength + 1];
		
		for (int i = 0; i < preLength; i++) 
			post[i] = pre[i];
		
		post[preLength] = toAdd;
		
		return post;
	}
	
	public default Object[] addToArrayEnd(Object[] pre, Object toAdd) {
		
		int preLength = pre.length;
		Object[] post = new Object[preLength + 1];
		
		for (int i = 0; i < preLength; i++) 
			post[i] = pre[i];
		
		post[preLength] = toAdd;
		
		return post;
	}
	
	public default Object[] addToArrayEnd(Object[] pre, Object[] toAdd) {
		
		int preLength = pre.length;
		int toAddLength = toAdd.length;
		Object[] post = new Object[preLength + toAddLength];
		
		for (int i = 0; i < preLength; i++) 
			post[i] = pre[i];
		
		for (int i = 0; i < toAddLength; i++) 
			post[i] = toAdd[i];
		
		post[preLength] = toAdd;
		
		return post;
	}
	
	public default int[] addToArrayBeginning(int[] pre, int toAdd) {
		
		int preLength = pre.length;
		int[] post = new int[preLength + 1];

		post[0] = toAdd;
		
		for (int i = 1; i <= preLength; i++) 
			post[i] = pre[i - 1];
		
		return post;
	}
	
	public default boolean arrayContains(int[] array, int toCheck) {
		int arrayLength = array.length;
		
		for (int i = 0; i < arrayLength; i++) {
			if (toCheck == array[i]) 
				return true;
		}
		
		return false;
		
	}
	
}

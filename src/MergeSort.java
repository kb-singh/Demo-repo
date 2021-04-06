public class MergeSort {

	void merge(int[] arr, int firstIndex, int middleIndex, int lastIndex) {
		// Find sizes of two subarrays to be merged
		int n1 = middleIndex - firstIndex + 1;
		int n2 = lastIndex - middleIndex;

		/* Create temp arrays */
		int[] LeftHalf = new int[n1];
		int[] RightHalf = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			LeftHalf[i] = arr[firstIndex + i];
		for (int j = 0; j < n2; ++j)
			RightHalf[j] = arr[middleIndex + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = firstIndex;
		while (i < n1 && j < n2) {
			if (LeftHalf[i] <= RightHalf[j]) {
				arr[k] = LeftHalf[i];
				i++;
				k++;
			} else {
				arr[k] = RightHalf[j];
				j++;
				k++;
			}
		}

		/* Copy remaining elements of LeftHalf[] if any */
		while (i < n1) {
			arr[k] = LeftHalf[i];
			i++;
			k++;
		}

		/* Copy remaining elements of RightHalf[] if any */
		while (j < n2) {
			arr[k] = RightHalf[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex) {
			// Find the middle point
			int mid = firstIndex + (lastIndex - firstIndex) / 2;

			// Sort first and second halves
			sort(arr, firstIndex, mid);
			sort(arr, mid + 1, lastIndex);

			// Merge the sorted halves
			merge(arr, firstIndex, mid, lastIndex);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}

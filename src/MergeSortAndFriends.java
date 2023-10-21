import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAndFriends {

	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) { // complete this function

		ArrayList<Integer> elements = new ArrayList<>();
		int a = 0;
		int b = 0;
		lenA = A.length;
		lenB = B.length;

		while ((a < lenA) && (b < lenB)) {
			if (A[a] < B[b]) {
				a++;
			} else if (A[a] > B[b]) {
				b++;
			} else {
				elements.add(A[a]);
				while (a < lenA && A[a] == B[b]) {
					a++;
				}
			}
		}

		return elements;
	}

	private static ArrayList<Integer> binaryMerge(ArrayList<Integer> A, ArrayList<Integer> B) { // complete this function

		ArrayList<Integer> C = new ArrayList<>();
		int lenA = A.size();
		int lenB = B.size();
		int lenC = lenA + lenB;
		int a = 0;
		int b = 0;

		while (a < lenA && b < lenB) {
			if (A.get(a) < B.get(b)) {
				C.add(A.get(a));
				a++;
			} else {
				C.add(B.get(b));
				b++;
			}
		}

		while (a < lenA) {
			C.add(A.get(a));
			a++;
		}

		while (b < lenB) {
			C.add(B.get(b));
			b++;
		}

		return C;
	}

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this function

		ArrayList<ArrayList<Integer>> mergedLists = new ArrayList<>();
		int k = lists.size();

		if (k == 1) {
			return lists.get(0);
		}

		for (int i = 0; i < (k / 2); i++) {
			ArrayList<Integer> merged = binaryMerge(lists.get(2 * i), lists.get(2 * i + 1));
			mergedLists.add(merged);
		}

		if (k % 2 != 0) {
			mergedLists.add(lists.get(k - 1));
		}

		return kWayMerge(mergedLists);
	}

	private static ArrayList<Integer> subList(ArrayList<Integer> array, int left, int right) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = left; i <= right; i++)
			list.add(array.get(i));
		return list;
	}

	public static void mergesort(ArrayList<Integer> array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			ArrayList<Integer> A = subList(array, left, mid);
			ArrayList<Integer> B = subList(array, mid + 1, right);
			ArrayList<Integer> mergedArray = binaryMerge(A, B);
			int i = left;
			int j = 0;
			while (j <= right - left) {
				array.set(i, mergedArray.get(j));
				i++;
				j++;
			}
		}
	}
}
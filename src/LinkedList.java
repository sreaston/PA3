import java.util.List;

public class LinkedList {

	private ListNode head, tail;
	private int size;
	private int mergedArray[];

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void mergesort() {
		mergedArray = new int[size()];
		mergesort(0, size() - 1, head, tail);
	}

	private void mergesort(int left, int right, ListNode leftNode, ListNode rightNode) { // complete this function

		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		ListNode midNode = leftNode;

		for (int i = left; i < mid; i++) {
			midNode = midNode.next;
		}

		mergesort(left, mid, leftNode, midNode);
		mergesort(mid + 1, right, midNode.next, rightNode);

		int k = left;
		ListNode tmp1 = leftNode;
		ListNode tmp2 = midNode.next;

		while (tmp1 != midNode.next && tmp2 != rightNode.next) {
			if (tmp1.value < tmp2.value) {
				mergedArray[k++] = tmp1.value;
				tmp1 = tmp1.next;
			} else {
				mergedArray[k++] = tmp2.value;
				tmp2 = tmp2.next;
			}
		}

		while (tmp1 != midNode.next) {
			mergedArray[k++] = tmp1.value;
			tmp1 = tmp1.next;
		}

		while (tmp2 != rightNode.next) {
			mergedArray[k++] = tmp2.value;
			tmp2 = tmp2.next;
		}
		tmp1 = leftNode;
		k = left;
		while (k <= right) {
			tmp1.value = mergedArray[k];
			tmp1 = tmp1.next;
			k++;
		}
	}




	public ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	public ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	public void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}

	public int size() {
		return size;
	}
}
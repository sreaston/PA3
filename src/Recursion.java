public class Recursion {

	public static int sumEvenDigits(int n) { // complete this function

		int lastDigit = n % 10;

		if (n == 0) {
			return 0;
        }

		if (lastDigit % 2 == 0) {
			return lastDigit + sumEvenDigits(n / 10);
		} else {
			return sumEvenDigits(n / 10);
		}
	}

	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) { // complete this function

		if (str.length() == n && numZeroes < numOnes) {
			System.out.println(str);
			return;
		}

		if (str.length() < n) {
			binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
			binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
		}
	}
}
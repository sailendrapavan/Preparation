
public class maximumPathInArray {

	int findMaxSum(int a[][], int row, int colummn, int n, int m, int sum) {

		for (int i = row; i < n; i++) {
			for (int j = colummn; j < m; j++) {
				sum = sum + a[i][j];
				int bottom = findMaxSum(a, i + 1, j, n, m, sum);
				int right = findMaxSum(a, i, j + 1, n, m, sum);
				int largest = (bottom > right) ? bottom : right;
				sum = (sum > largest) ? sum : largest;
				return sum;
			}
		}
		return sum;
	}

	int findMaxSumSecondApproach(int m, int n, int a[][], int dp[][]) {

		if (m < 0 || n < 0) {

			return Integer.MIN_VALUE;
		}

		else if (m == 0 && n == 0) {
			return a[m][n];
		} else {
			if (dp[m][n] != 0) {
				System.out.println("m value" + m + "n value" + n);
				return dp[m][n];
			}
			int bottom = findMaxSumSecondApproach(m - 1, n, a, dp);
			int right = findMaxSumSecondApproach(m, n - 1, a, dp);
			dp[m][n] = a[m][n] + ((bottom > right) ? bottom : right);
			return a[m][n] + ((bottom > right) ? bottom : right);
		}

	}

	public static void main(String args[]) {

		int[][] a = { { 5, 2 }, { 8, 4 }, { -15, 5 } };
		int[][] dp = new int[3][2];
		maximumPathInArray m = new maximumPathInArray();
//		System.out.println(m.findMaxSumSecondApproach(2, 1, a,dp));

		char[][] mat = { { 'o', 'f', 'a', 's' }, { 'f', 'l', 'q', 'w' }, { 'z', 'o', 'w', 'k' } };
		int[] subseqence = { -1, 98, 100, 4, -8 };
		// System.out.println( m.findtheMaxSubseqenceSumWithnoAdjancentElements(0,
		// subseqence, 0,5));

		// System.out.println(
		// m.findtheMaxSubseqenceSumWithnoAdjancentElementsInShorterWay(subseqence,5));

//		char [] str= {'f','l','o','s'};
		char[] str = { 'z', 'o', 'w', 'k' };
		System.out.println(m.possibiltyOfFormingWords(mat, 2, 0, 0, str));

	}

	// very well written in geeksforgeeks
	int findtheMaxSubseqenceSumWithnoAdjancentElementsInShorterWay(int a[], int n) {
		int excl = 0;
		int inc = a[0];
		int excl_new;
		for (int i = 1; i < n; i++) {
			excl_new = Math.max(inc, excl);
			inc = excl + a[i];
			excl = excl_new;
		}

		return Math.max(excl, inc);

	}

	boolean possibiltyOfFormingWords(char a[][], int m, int n, int i, char str[]) {

		if (!(m >= 0 && m < 3 && n >= 0 && n < 4)) {
			return false;
		}

		if (i == str.length) {
			return true;
		}
		if (a[m][n] == str[i]) {
//			System.out.println(a[m][n]);
//			System.out.println("i value"+i);
//			System.out.println("m and n value"+m+""+n);
			if (possibiltyOfFormingWords(a, m, n - 1, i + 1, str)) {
				return true;
			}
			if (possibiltyOfFormingWords(a, m + 1, n, i + 1, str)) {
				return true;
			}

			if (possibiltyOfFormingWords(a, m, n + 1, i + 1, str)) {
				return true;
			}
			if (possibiltyOfFormingWords(a, m - 1, n, i + 1, str)) {
				return true;
			}

		}

		return false;

	}

	int findtheMaxSubseqenceSumWithnoAdjancentElements(int sum, int a[], int i, int n) {

		if (i >= n) {
			return sum;
		}
		sum = sum + a[i];

		System.out.println("sum value" + sum);
		System.out.println("added index" + i);
		System.out.println("i+1 value" + (i + 1));
		System.out.println("i+2 value" + (i + 2));

		System.out.println("----------------------");

		sum = Math.max(findtheMaxSubseqenceSumWithnoAdjancentElements(sum, a, i + 2, n),
				findtheMaxSubseqenceSumWithnoAdjancentElements(sum - a[i], a, i + 1, n));
		return sum;
	}
}

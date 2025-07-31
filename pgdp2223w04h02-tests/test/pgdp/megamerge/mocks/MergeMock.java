package pgdp.megamerge.mocks;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;

import pgdp.megamerge.MegaMergeSort;

public class MergeMock extends MegaMergeSort {

	private int[][][] expectedSplitsV1, expectedSplitsV2;
	private int idx;

	public void setExpectedSplits(int[][][] expectedSplitsV1, int[][][] expectedSplitsV2) {
		this.expectedSplitsV1 = expectedSplitsV1;
		this.expectedSplitsV2 = expectedSplitsV2;
		idx = 0;
	}

	@Override
	protected int[] merge(int[][] arrays, int from, int to) {
		if (expectedSplitsV1 != null) {
			assertThat("Wrong split.", arrays, Matchers.either(Matchers.equalTo(expectedSplitsV1[idx]))
					.or(Matchers.equalTo(expectedSplitsV2[idx])));
		}
		idx++;
		int[] res = new int[0];
		for (int[] arr : arrays) {
			res = merge(res, arr);
		}
		return res;
	}

	@Override
	protected int[] merge(int[] arr1, int[] arr2) {
		if (arr1 == null) {
			arr1 = new int[0];
		}
		if (arr2 == null) {
			arr2 = new int[0];
		}
		int i = 0;
		int j = 0;
		int[] res = new int[arr1.length + arr2.length];
		for (int x = 0; x < res.length; x++) {
			if (i == arr1.length) {
				res[x] = arr2[j++];
			} else if (j == arr2.length) {
				res[x] = arr1[i++];
			} else if (arr1[i] < arr2[j]) {
				res[x] = arr1[i++];
			} else {
				res[x] = arr2[j++];
			}
		}
		return res;
	}

}

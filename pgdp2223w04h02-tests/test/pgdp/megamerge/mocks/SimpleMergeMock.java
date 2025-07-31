package pgdp.megamerge.mocks;

import pgdp.megamerge.MegaMergeSort;

public class SimpleMergeMock extends MegaMergeSort {

	@Override
	protected int[] merge(int[] arr1, int[] arr2) {
		if (arr1 == null)
			arr1 = new int[0];
		if (arr2 == null)
			arr2 = new int[0];
		int i = 0;
		int j = 0;
		int[] res = new int[arr1.length + arr2.length];
		for (int x = 0; x < res.length; x++)
			if (i == arr1.length)
				res[x] = arr2[j++];
			else if (j == arr2.length)
				res[x] = arr1[i++];
			else if (arr1[i] < arr2[j])
				res[x] = arr1[i++];
			else
				res[x] = arr2[j++];
		return res;
	}

}

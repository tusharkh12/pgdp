package pgdp.megamerge.mocks;

import pgdp.megamerge.MegaMergeSort;

public class Oracle extends MegaMergeSort {

	@Override
	protected int[] megaMergeSort(int[] array, int div) {
		return megaMergeSort(array, div, 0, array.length);
	}

	@Override
	protected int[] megaMergeSort(int[] array, int div, int from, int to) {
		if (to - from < 1)
			return new int[0];
		if (to - from == 1)
			return new int[] { array[from] };
		int minwidth = (to - from) / div;
		int oversized = to - from - (div * minwidth);
		int[][] outs = new int[minwidth != 0 ? div : oversized][];
		for (int offset = from, i = 0; offset < to; i++) {
			int offsetto = offset + minwidth + (oversized-- > 0 ? 1 : 0);
			outs[i] = megaMergeSort(array, div, offset, offsetto);
			offset = offsetto;
		}
		return merge(outs, 0, outs.length);
	}

	@Override
	protected int[] merge(int[][] arrays, int from, int to) {
		int[] res = new int[0];
		for (int[] arr : arrays)
			res = merge(res, arr);
		return res;
	}

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

package pgdp.megamerge;

import org.junit.jupiter.api.DisplayName;

import de.tum.in.test.api.jupiter.HiddenTest;
import de.tum.in.test.api.jupiter.PublicTest;
import org.junit.jupiter.api.Order;
import pgdp.megamerge.mocks.MergeMock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@W04H02
public class MegaMergeSortBehaviorTest {

	private static int points = 0;

	// Test int[] megaMergeSort(int[], int, int, int)

	@HiddenTest
	@DisplayName(value = "Test megaMergeSort(int[], int, int, int) - zero range")
	@Order(1)
	public void testMmsZeroRange() {
		MegaMergeSort impl = new MergeMock();
		int[] out = impl.megaMergeSort(new int[] { 1, 3, 2, 4 }, 2, 3, 3);
		//System.out.println(Arrays.toString(new int[0]));
		assertArrayEquals(new int[0], out);
	}

	@HiddenTest
	@DisplayName(value = "Test megaMergeSort(int[], int, int, int) - no sort")
	@Order(1)
	public void testMmsNoSort() {
		MegaMergeSort impl = new MergeMock();
		int[] out = impl.megaMergeSort(new int[] { 1, 3, 2, 4 }, 2, 3, 4);
		System.out.println(Arrays.toString(out));
		assertArrayEquals(new int[] { 4 }, out);

	}

	@PublicTest
	@DisplayName(value = "Test megaMergeSort(int[], int, int, int) - divisible without overflow")
	@Order(1)
	public void testMmsDivisible() {
		MegaMergeSort impl = new MergeMock();
		int[] out;
		((MergeMock) impl).setExpectedSplits(
				new int[][][] { { { 1 }, { 3 } }, { { 2 }, { 4 } }, { { 1, 3 }, { 2, 4 } } },
				new int[][][] { { { 1 }, { 3 } }, { { 2 }, { 4 } }, { { 1, 3 }, { 2, 4 } } });
		out = impl.megaMergeSort(new int[] { 1, 3, 2, 4 }, 2, 0, 4);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, out);

		((MergeMock) impl).setExpectedSplits(
				new int[][][] { { { 8 }, { 24 }, { 19 } }, { { 1 }, { 16 }, { 25 } }, { { 26 }, { 13 }, { 14 } },
						{ { 8, 19, 24 }, { 1, 16, 25 }, { 13, 14, 26 } }, { { 9 }, { 10 }, { 21 } },
						{ { 11 }, { 12 }, { 22 } }, { { 20 }, { 2 }, { 3 } },
						{ { 9, 10, 21 }, { 11, 12, 22 }, { 2, 3, 20 } }, { { 0 }, { 6 }, { 4 } },
						{ { 18 }, { 15 }, { 23 } }, { { 17 }, { 7 }, { 5 } },
						{ { 0, 4, 6 }, { 15, 18, 23 }, { 5, 7, 17 } },
						{ { 1, 8, 13, 14, 16, 19, 24, 25, 26 }, { 2, 3, 9, 10, 11, 12, 20, 21, 22 },
								{ 0, 4, 5, 6, 7, 15, 17, 18, 23 } } },
				new int[][][] { { { 8 }, { 24 }, { 19 } }, { { 1 }, { 16 }, { 25 } }, { { 26 }, { 13 }, { 14 } },
						{ { 8, 19, 24 }, { 1, 16, 25 }, { 13, 14, 26 } }, { { 9 }, { 10 }, { 21 } },
						{ { 11 }, { 12 }, { 22 } }, { { 20 }, { 2 }, { 3 } },
						{ { 9, 10, 21 }, { 11, 12, 22 }, { 2, 3, 20 } }, { { 0 }, { 6 }, { 4 } },
						{ { 18 }, { 15 }, { 23 } }, { { 17 }, { 7 }, { 5 } },
						{ { 0, 4, 6 }, { 15, 18, 23 }, { 5, 7, 17 } }, { { 1, 8, 13, 14, 16, 19, 24, 25, 26 },
								{ 2, 3, 9, 10, 11, 12, 20, 21, 22 }, { 0, 4, 5, 6, 7, 15, 17, 18, 23 } } });
		out = impl.megaMergeSort(new int[] { 8, 24, 19, 1, 16, 25, 26, 13, 14, 9, 10, 21, 11, 12, 22, 20, 2, 3, 0, 6, 4,
				18, 15, 23, 17, 7, 5 }, 3, 0, 27);

		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
				23, 24, 25, 26 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Test megaMergeSort(int[], int, int, int) - divisible with overflow")
	@Order(1)
	public void testMmsNotDivisible() {
		MegaMergeSort impl = new MergeMock();
		((MergeMock) impl).setExpectedSplits(
				new int[][][] { { { 1 }, { 3 } }, { { 1, 3 }, { 2 } }, { { 4 }, { 5 } }, { { 1, 2, 3 }, { 4, 5 } } },
				new int[][][] { { { 1 }, { 3 } }, { { 1, 3 }, { 2 } }, { { 4 }, { 5 } }, { { 1, 2, 3 }, { 4, 5 } } });
		int[] out = impl.megaMergeSort(new int[] { 1, 3, 2, 4, 5 }, 2, 0, 5);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, out);

		((MergeMock) impl).setExpectedSplits(
				new int[][][] { { { 23 }, { 22 } }, { { 6 }, { 21 } }, { { 11 }, { 17 } },
						{ { 22, 23 }, { 6, 21 }, { 11, 17 }, { 19 } }, { { 20 }, { 8 } }, { { 3 }, { 16 } },
						{ { 14 }, { 24 } }, { { 8, 20 }, { 3, 16 }, { 14, 24 }, { 2 } }, { { 1 }, { 13 } },
						{ { 26 }, { 5 } }, { { 12 }, { 9 } }, { { 1, 13 }, { 5, 26 }, { 9, 12 }, { 10 } },
						{ { 15 }, { 7 } }, { { 0 }, { 4 } }, { { 7, 15 }, { 0, 4 }, { 18 }, { 25 } },
						{ { 6, 11, 17, 19, 21, 22, 23 }, { 2, 3, 8, 14, 16, 20, 24 }, { 1, 5, 9, 10, 12, 13, 26 },
								{ 0, 4, 7, 15, 18, 25 } } },
				new int[][][] { { { 23 }, { 22 }, {}, {} }, { { 6 }, { 21 }, {}, {} }, { { 11 }, { 17 }, {}, {} },
						{ { 22, 23 }, { 6, 21 }, { 11, 17 }, { 19 } }, { { 20 }, { 8 }, {}, {} },
						{ { 3 }, { 16 }, {}, {} }, { { 14 }, { 24 }, {}, {} },
						{ { 8, 20 }, { 3, 16 }, { 14, 24 }, { 2 } }, { { 1 }, { 13 }, {}, {} },
						{ { 26 }, { 5 }, {}, {} }, { { 12 }, { 9 }, {}, {} },
						{ { 1, 13 }, { 5, 26 }, { 9, 12 }, { 10 } }, { { 15 }, { 7 }, {}, {} },
						{ { 0 }, { 4 }, {}, {} }, { { 7, 15 }, { 0, 4 }, { 18 }, { 25 } },
						{ { 6, 11, 17, 19, 21, 22, 23 }, { 2, 3, 8, 14, 16, 20, 24 }, { 1, 5, 9, 10, 12, 13, 26 },
								{ 0, 4, 7, 15, 18, 25 } } });
		out = impl.megaMergeSort(new int[] { 23, 22, 6, 21, 11, 17, 19, 20, 8, 3, 16, 14, 24, 2, 1, 13, 26, 5, 12, 9,
				10, 15, 7, 0, 4, 18, 25 }, 4, 0, 27);
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
				23, 24, 25, 26 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Count Points MegaMergeSort")
	@Order(2)
	public void countPoints() {
		try {
			testMmsDivisible();
		} catch (Throwable t) {
			fail("0 / 3 Punkten auf die Methode 'megaMergeSort()'");
		}

		points++;

		try {
			testMmsNotDivisible();
		} catch (Throwable t) {
			fail("1 / 3 Punkten auf die Methode 'megaMergeSort()'");
		}

		points++;

		try {
			testMmsZeroRange();
			testMmsNoSort();
		} catch (Throwable t) {
			fail("2 / 3 Punkten auf die Methode 'megaMergeSort()'");
		}

		points++;
	}

	@HiddenTest
	@DisplayName(value = "Grading - megaMergeSort() - Erster Punkt")
	@Order(3)
	public void gradingFirstPoint() {
		assertTrue(points >= 1);
	}

	@HiddenTest
	@DisplayName(value = "Grading - megaMergeSort() - Zweiter Punkt")
	@Order(3)
	public void gradingSecondPoint() {
		assertTrue(points >= 2);
	}

	@HiddenTest
	@DisplayName(value = "Grading - megaMergeSort() - Dritter Punkt")
	@Order(3)
	public void gradingThirdPoint() {
		assertTrue(points >= 3);
	}
}

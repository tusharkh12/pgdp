package pgdp.megamerge;

import org.junit.jupiter.api.DisplayName;

import de.tum.in.test.api.jupiter.HiddenTest;
import de.tum.in.test.api.jupiter.PublicTest;
import org.junit.jupiter.api.Order;
import pgdp.megamerge.mocks.SimpleMergeMock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@W04H02
public class MergeBehaviourTest {

	private static int points = 0;

	// Test int[] merge(int[][], int, int)

	@HiddenTest
	@DisplayName(value = "Test merge(int[][], int, int) - zero range")
	@Order(1)
	public void testMergeZeroRange() {
		MegaMergeSort impl = new SimpleMergeMock();
		int[] out = impl.merge(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 1, 1);
		assertArrayEquals(new int[0], out);
	}

	@HiddenTest
	@DisplayName(value = "Test merge(int[][], int, int) - no merge")
	@Order(1)
	public void testMergeNoMerge() {
		MegaMergeSort impl = new SimpleMergeMock();
		int[] out = impl.merge(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 0, 1);
		assertArrayEquals(new int[] { 1, 2, 3 }, out);
	}

	@PublicTest
	@DisplayName(value = "Test merge(int[][], int, int) - merge two")
	@Order(1)
	public void testMergeTwo() {
		MegaMergeSort impl = new SimpleMergeMock();
		int[] out = impl.merge(new int[][] { { 1, 3, 4, 7, 9 }, { 2, 5, 6, 8, 10 } }, 0, 2);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Test merge(int[][], int, int) - merge multiple")
	@Order(1)
	public void testMergeMultiple() {
		MegaMergeSort impl = new SimpleMergeMock();
		int[] out = impl.merge(new int[][] { { 1, 5 }, { 3, 9 }, { 0, 4 }, { 2, 8 }, { 6, 7 } }, 0, 5);
		assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Count Points Merge")
	@Order(2)
	public void countPoints() {
		try {
			testMergeTwo();
			testMergeMultiple();
		} catch(Throwable t) {
			fail("0 / 2 Punkten auf mega 'merge()'");
		}

		points++;

		try {
			testMergeZeroRange();
			testMergeNoMerge();
		} catch(Throwable t) {
			fail("1 / 2 Punkten auf mega 'merge()'");
		}

		points++;
	}

	@HiddenTest
	@DisplayName(value = "Grading - Mega merge() - Erster Punkt")
	@Order(3)
	public void gradingFirstPoint() {
		assertTrue(points >= 1);
	}

	@HiddenTest
	@DisplayName(value = "Grading - Mega merge() - Zweiter Punkt")
	@Order(3)
	public void gradingSecondPoint() {
		assertTrue(points >= 2);
	}
}

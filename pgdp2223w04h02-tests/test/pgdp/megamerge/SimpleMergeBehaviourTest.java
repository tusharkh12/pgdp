package pgdp.megamerge;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;

import de.tum.in.test.api.jupiter.HiddenTest;
import de.tum.in.test.api.jupiter.PublicTest;
import org.junit.jupiter.api.Order;

@W04H02
public class SimpleMergeBehaviourTest {

	// Test int[] merge (int[], int[])

	@PublicTest
	@DisplayName(value = "Test merge(int[], int[]) - alternating values")
	@Order(1)
	public void testSimpleMergeAlternating() {
		MegaMergeSort impl = new MegaMergeSort();
		int[] out = impl.merge(new int[] { 1, 3, 5, 7, 9 }, new int[] { 2, 4, 6, 8 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, out);
	}

	@PublicTest
	@DisplayName(value = "Test merge(int[], int[]) - split values")
	@Order(1)
	public void testSimpleMergeSplit() {
		MegaMergeSort impl = new MegaMergeSort();
		int[] out = impl.merge(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Test merge(int[], int[]) - shuffled values")
	@Order(1)
	public void testSimpleMergeShuffled() {
		MegaMergeSort impl = new MegaMergeSort();
		int[] out = impl.merge(new int[] { 1, 2, 5 }, new int[] { 3, 4, 6, 7 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Test merge(int[], int[]) - non distinct values")
	@Order(1)
	public void testSimpleMergeNonDistinct() {
		MegaMergeSort impl = new MegaMergeSort();
		int[] out = impl.merge(new int[] { 1, 2, 3, 9 }, new int[] { 1, 2, 6, 8, 9 });
		assertArrayEquals(new int[] { 1, 1, 2, 2, 3, 6, 8, 9, 9 }, out);
	}

	@HiddenTest
	@DisplayName(value = "Test merge(int[], int[]) - empty arrays")
	@Order(1)
	public void testSimpleMergeEmpty() {
		MegaMergeSort impl = new MegaMergeSort();
		int[] out = impl.merge(new int[] {}, new int[] { 3, 4, 6, 7 });
		assertArrayEquals(new int[] { 3, 4, 6, 7 }, out);
		out = impl.merge(new int[] { 3, 4, 6, 7 }, new int[] {});
		assertArrayEquals(new int[] { 3, 4, 6, 7 }, out);
		out = impl.merge(new int[] {}, new int[] {});
		assertArrayEquals(new int[] {}, out);
	}

	@HiddenTest
	@DisplayName(value = "Grading - Simple merge()")
	@Order(2)
	public void grading() {
		try {
			testSimpleMergeAlternating();
			testSimpleMergeEmpty();
			testSimpleMergeNonDistinct();
			testSimpleMergeShuffled();
			testSimpleMergeSplit();
		} catch(Throwable t) {
			fail("Kein Punkt auf das einfache 'merge()'");
		}
	}
}

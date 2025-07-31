package pgdp.tests;

import static org.junit.jupiter.api.Assertions.*;
import static pgdp.PinguLib.*;
import static pgdp.array.Array.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ArrayTest {

//	@Test
//	void test() {
//		print(new int[] { 1, 2, 3 });
//		fail();
//	}

	@Test
	void testPrint(){
		setup();
		print(new int[]{1,2,3});
		assertEquals("{1, 2, 3}",getConsoleOutput());
		//assertEquals("{}","{}");
		reset();

		setup();
		print(new int[]{});
		assertEquals("{}",getConsoleOutput());
		reset();

		setup();
		print(new int[]{-1});

		assertEquals("{-1}",getConsoleOutput());
		reset();
	}

	@Test
	void testMinAndMax(){
		setup();
		minAndMax(new int[]{1,2});
		assertEquals("Minimum = 1, Maximum = 2",getConsoleOutput());
		reset();

		setup();
		minAndMax(new int[]{});
		assertEquals("",getConsoleOutput());
		reset();

		setup();
		minAndMax(new int[]{1});
		assertEquals("Minimum = 1, Maximum = 1",getConsoleOutput());
		reset();


	}

//	@Test
//	void testInvert(){
//		setup();
//		invert(new int[]{1,2,3});
//		assertEquals("1",getConsoleOutput());
//		reset();
//
//	}


	@Test
	void testIntersect(){
		setup();
		//intersect(new int[]{1,2,3},3);
		assertEquals(Arrays.toString(new int[]{1,2,3}), Arrays.toString(intersect(new int[]{1,2,3},3)));
		reset();

		//1
		setup();
		//intersect(new int[]{1,2,3},0);
		//System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3}, 0)));
		assertEquals(Arrays.toString(new int[]{}), Arrays.toString(intersect(new int[]{1,2,3},0)));
		reset();

		setup();
		//intersect(new int[]{1,2,3},4);
		assertEquals(Arrays.toString(new int[]{1,2,3,0}), Arrays.toString(intersect(new int[]{1,2,3},4)));
		reset();

		//2
		setup();
		//intersect(new int[]{},2);
		assertEquals(Arrays.toString(new int[]{0,0}), Arrays.toString(intersect(new int[]{},2)));
		reset();

		//3
		setup();
		//intersect(new int[]{1,2},-1);
		assertEquals(Arrays.toString(new int[]{}),Arrays.toString(intersect(new int[]{1,2},-1)));
		reset();

		setup();
		//intersect(new int[]{1,2},-1);
		assertEquals(Arrays.toString(new int[]{}),Arrays.toString(intersect(new int[]{},0)));
		reset();

		//4
		setup();
		//intersect(new int[]{1,2},-1);
		assertEquals(Arrays.toString(new int[]{1,2}),Arrays.toString(intersect(new int[]{1,2,3,4},2)));
		reset();
	}

	@Test
	void testLinearize(){
		setup();
		assertEquals(Arrays.toString(new int[]{}),Arrays.toString(linearize(new int[][]{})));
		reset();

		setup();
		assertEquals(Arrays.toString(new int[]{}),Arrays.toString(linearize(new int[][]{{}})));
		reset();

		setup();
		assertEquals(Arrays.toString(new int[]{1,2,3,4}),Arrays.toString(linearize(new int[][]{{1,2},{},{3,4}})));
		reset();
	}

	@Test
	void testBubbleSort(){
		setup();
		int[] array1=new int[]{};
		bubbleSort(array1);
		//assertEquals((new int[]{}),bubbleSort(new int[]{}));
		assertArrayEquals(new int[]{},array1);
		reset();

		setup();
		int[] array2=new int[]{1,1,1,1};
		bubbleSort(array2);
		assertArrayEquals(new int[]{1,1,1,1},array2);
		reset();

		setup();
		int[] array3 =new int[]{1};
		bubbleSort(array3);
		assertArrayEquals(new int[]{1}, array3);
		reset();

		setup();
		int[] array4 =new int[]{-1,2,-2};
		bubbleSort(array4);
		assertArrayEquals(new int[]{-2,-1,2}, array4);
		reset();

	}

	@Test
	void testInvert(){
		setup();
		int[] array1=new int[]{};
		invert(array1);
		assertArrayEquals(new int[]{},array1);
		reset();

		setup();
		int[] array2 =new int[]{1,1,1,1};
		invert(array2);
		assertArrayEquals(new int[]{1,1,1,1}, array2);
		reset();

		setup();
		int[] array3 =new int[]{1};
		invert(array3);
		assertArrayEquals(new int[]{1}, array3);
		reset();

		setup();
		int[] array4 =new int[]{1,0,-1,2};
		invert(array4);
		assertArrayEquals(new int[]{2,-1,0,1}, array4);
		reset();
	}
}

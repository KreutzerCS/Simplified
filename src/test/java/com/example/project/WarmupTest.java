import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WarmupTest
{

	@Test
	void testCreateRandomIntArray()
	{
		int low = 5, high = 6;
		int[] array = Warmup.createRandomIntArray(100, low, high);

		boolean hasHigh = false, hasLow = false;

		for (int x : array)
		{
			if (x < low || x > high)
				fail("Values not between low and high");
			if (x == low)
				hasLow = true;
			else
				if (x == high)
					hasHigh = true;
		}
		assertTrue(hasLow, "Low value in range not included");
		assertTrue(hasHigh, "High value in range not included");
	}

	@Test
	void testSmallest() throws Exception
	{
		assertEquals(-10, Warmup.smallest(new int[] { -10, 0, 10 }),
				"Did not find smallest when its a negative number");
		assertEquals(5, Warmup.smallest(new int[] { 9, 10, 5 }), "Did not find smallest when its last in the array");
		assertEquals(9, Warmup.smallest(new int[] { 9, 10, 15 }), "Did not find smallest when its first in the array");
	}

	@Test
	void testIndexOfSmallest()
	{
		assertEquals(0, Warmup.indexOfSmallest(new int[] { -10, 0, 10 }),
				"Did not find smallest when its a negative number");
		assertEquals(2, Warmup.indexOfSmallest(new int[] { 9, 10, 5 }),
				"Did not find smallest when its last in the array");
		assertEquals(0, Warmup.indexOfSmallest(new int[] { 9, 10, 15 }),
				"Did not find smallest when its first in the array");
	}

	@Test
	void testEqualIntArrays()
	{
		assertFalse(Warmup.equalIntArrays(new int[] { 1, 2 }, new int[] { 1 }),
				"Arrays of different length are unequal");

		int[] x = Warmup.createRandomIntArray(1000, Integer.MIN_VALUE / 2, 1);
		assertTrue(Warmup.equalIntArrays(x, x));

		assertNotEquals(Warmup.equalIntArrays(new int[] { 1, 2 }, new int[] { 2, 1 }),
				"Arrays must have same order to be equal");
	}

	@Test
	void testEqualStringArrays()
	{
		assertFalse(Warmup.equalStringArrays(new String[] { "AB", "BC" }, new String[] { "AB" }),
				"Arrays of different length are unequal");

		String[] x = new String[100];
		for (int i = 0; i < x.length; i++)
			x[i] = "ABCD" + "abcdefghij".charAt(i % 10);

		assertTrue(Warmup.equalStringArrays(x, x));

		assertNotEquals(Warmup.equalStringArrays(new String[] { "AB", "BC" }, new String[] { "BC", "AB" }),
				"Arrays must have same order to be equal");
	}

	@Test
	void testLinearSearch()
	{
		int[] x = Warmup.createRandomIntArray(1000, 0, Integer.MAX_VALUE / 2);
		assertEquals(0, Warmup.linearSearch(x, x[0]));
		
		assertEquals(x.length - 1, Warmup.linearSearch(x, x[x.length - 1]));
		assertEquals(-1, Warmup.linearSearch(x, Integer.MIN_VALUE));
	}

	@Test
	void testCount()
	{
		int[] x = Warmup.createRandomIntArray(1000, 0, Integer.MAX_VALUE / 2);
		assertEquals(0, Warmup.count(x, Integer.MIN_VALUE));

		Arrays.fill(x, 27);
		assertEquals(x.length, Warmup.count(x, 27));

		x[0] = 0;
		assertEquals(x.length - 1, Warmup.count(x, 27));

		x[x.length - 1] = 99;
		assertEquals(1, Warmup.count(x, 99));
		assertEquals(x.length - 2, Warmup.count(x, 27));
	}

	@Test
	void testDuplicates()
	{
		int[] x = new int[20];
		Arrays.fill(x, 27);
		assertEquals(x.length - 1, Warmup.duplicates(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i;
		assertEquals(0, Warmup.duplicates(x));

		x[x.length - 1] = x[0];
		assertEquals(1, Warmup.duplicates(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;
		assertEquals(x.length - 2, Warmup.duplicates(x));
	}

	@Test
	void testUniques()
	{
		int[] x = new int[20];
		Arrays.fill(x, 27);
		assertEquals(1, Warmup.uniques(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i;
		assertEquals(x.length, Warmup.uniques(x));

		x[x.length - 1] = x[0];
		assertEquals(x.length - 1, Warmup.uniques(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;
		assertEquals(2, Warmup.uniques(x));
	}
	
	public static int[] sorted(int [] a)
	{
		int [] result = a.clone();
		Arrays.sort(result);
		
		return result;
	}

	@Test
	void testReturnSet()
	{
		int[] x = new int[20];
		Arrays.fill(x, 27);
		assertArrayEquals(new int[] { 27 }, Warmup.returnSet(x));

		int[] z = new int[20];
		for (int i = 0; i < z.length; i++)
			z[i] = i;
		
		// returnSet does not guarantee order		
		assertArrayEquals(z, sorted(Warmup.returnSet(z)));

		int[] z1 = Arrays.copyOfRange(z, 0, z.length - 1);
		z[z.length - 1] = z[0];

		assertArrayEquals(sorted(z1), sorted(Warmup.returnSet(z)));

		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;
		assertArrayEquals(new int[] { 0, 1 }, sorted(Warmup.returnSet(x)));
	}

	@Test
	void testMode()
	{
		assertEquals(8, Warmup.mode(new int [] {8}), "Failure with one value");
		
		int [] x = new int [21];
		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;	
		assertEquals(0, Warmup.mode(x));
		
		assertEquals(2, Warmup.mode(new int [] {2,2,2,2, 8,8,8}), "Failure when mode is first value");
		assertEquals(8, Warmup.mode(new int [] {2,2,8,8,8}), "Failure when mode is last value");
		assertEquals(8, Warmup.mode(new int [] {8, 2, 8, 2, 8}));
	}
	

	@Test
	void testAntiMode()
	{
		assertEquals(1, Warmup.antiMode(new int [] {2,2,8,8,8,1}), "Failure when antimode is last value");
		assertEquals(1, Warmup.antiMode(new int [] {1,2,2,8,8,8,2}), "Failure when antimode is first value");
		assertEquals(-11, Warmup.antiMode(new int [] {-11,2,8,2,8,2,8}), "Failure when antimode is negative");
	}
	

	@Test
	void testLongestEqualSequence()
	{
		assertEquals(1, Warmup.longestEqualSequence(new int[] { 8 }), "Failure with one value");

		int[] x = new int[21];
		assertEquals(x.length, Warmup.longestEqualSequence(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;
		assertEquals(1, Warmup.longestEqualSequence(x));

		assertEquals(4, Warmup.longestEqualSequence(new int[] { 2, 2, 2, 2, 8, 8, 8 }),
				"Failure when longestEqualSequence is first value");
		assertEquals(3, Warmup.longestEqualSequence(new int[] { 2, 2, 8, 8, 8 }),
				"Failure when longestEqualSequence is last value");
		assertEquals(3, Warmup.longestEqualSequence(new int[] { 8, -2, -2, -2, 8, 8 }));
	}
	
	@Test
	void testBiggestHill()
	{
		assertEquals(1, Warmup.biggestHill(new int[] { 8 }), "Failure with one value");

		int[] x = new int[21];
		assertEquals(1, Warmup.biggestHill(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i % 2;
		assertEquals(2, Warmup.biggestHill(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i;
		assertEquals(x.length, Warmup.biggestHill(x));
		
		assertEquals(4, Warmup.biggestHill(new int [] {2,3,4,5, 0,8,9}), "Failure when biggestHill is first value");
		assertEquals(4, Warmup.biggestHill(new int [] {2,3, 9, 0, 7,8,9}), "Failure when biggestHill is last value");
		assertEquals(4, Warmup.biggestHill(new int [] {8, 9, 2, 3, 4, 8, 8}), "Hill must be strictly increasing >");	
		}

	@Test
	void testMirrorImage()
	{
		assertTrue(Warmup.mirrorImage("x"), "needs to work for single character string");
		assertTrue(Warmup.mirrorImage(""), "needs to work for empty string");
		assertTrue(Warmup.mirrorImage("xx"), "needs to work for 2 character string");
		assertTrue(Warmup.mirrorImage("xXx"), "needs to work for odd length string");
		assertTrue(Warmup.mirrorImage("xyyx"), "needs to work for 2 character string");

		assertFalse(Warmup.mirrorImage("xy"), "needs to work for 2 character string");
		assertFalse(Warmup.mirrorImage("xxyy"));
	}

	@Test
	void testReverse()
	{		
		int [] x = new int [21];
		assertArrayEquals(x, Warmup.reverse(x));

		for (int i = 0; i < x.length; i++)
			x[i] = i;		
		assertArrayEquals(x, Warmup.reverse(Warmup.reverse(x)));
	}

	@Test
	void testIncreasing()
	{
		int [] x = new int [21];
		assertTrue(Warmup.increasing(x), ">= not >");

		for (int i = 0; i < x.length; i++)
			x[i] = i;		
		assertTrue(Warmup.increasing(x));
		
		x[0] = x.length;
		assertFalse(Warmup.increasing(x), "first value is a problem");

		x[0] = 0;
		x[x.length-1] = -1;
		assertFalse(Warmup.increasing(x), "last value is a problem");

		
		for (int i = 0; i < x.length; i++)
			x[i] = i - x.length;		
		assertTrue(Warmup.increasing(x), "needs to work with negative values");
	}
}
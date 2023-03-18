import java.util.Arrays;
import java.util.Random;

public class Warmup
{
	public static void main(String[] args)
	{
		int[] x = createRandomIntArray(20, 10, 17);
		System.out.println(Arrays.toString(x));

		System.out.println("Mode: " + mode(x));
		System.out.println("Antimode: " + antiMode(x));
		
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));
	}

	public static int[] createRandomIntArray(int N, int low, int high)
	{
		Random rand = new Random();

		int[] a = new int[N];

		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(high - low + 1) + low;

		return a;
	}

	public static int smallest(int[] array)
	{
		return array[indexOfSmallest(array)];
	}

	public static int indexOfSmallest(int[] array)
	{
		int indexOfSmallest = 0;
		for (int i = 1; i < array.length; i++)
			if (array[i] < array[indexOfSmallest])
				indexOfSmallest = i;

		return indexOfSmallest;
	}

	public static boolean equalIntArrays(int[] a, int[] b)
	{
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

	public static boolean equalStringArrays(String[] a, String[] b)
	{
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(b[i]))
				return false;

		return true;
	}

	public static int linearSearch(int[] array, int target)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == target)
				return i;
		return -1;
	}

	public static int count(int[] array, int target)
	{
		int occurrences = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] == target)
				++occurrences;

		return occurrences;
	}

	public static int duplicates(int[] array)
	{
		int dups = 0;
		int[] copyOf = array.clone();
		Arrays.sort(copyOf);

		for (int i = 1; i < copyOf.length; i++)
			if (copyOf[i] == copyOf[i - 1])
				++dups;

		return dups;
	}

	public static int uniques(int[] array)
	{
		return array.length - duplicates(array);
	}

	public static int[] returnSet(int[] arrayOriginal)
	{
		int[] array = arrayOriginal.clone();
		Arrays.sort(array);

		int[] result = new int[uniques(array)];
		result[0] = array[0];

		int j = 1;
		for (int i = 1; i < array.length; i++)
			if (array[i] != array[i - 1])
				result[j++] = array[i];
		return result;
	}

	public static int mode(int[] array)
	{
		int[] x = array.clone();
		Arrays.sort(x);

		int mostFrequentSoFar = x[0];
		int highestFrequencySoFar = 1;

		int frequency = 1;

		for (int i = 1; i < x.length; i++)
		{
			if (x[i] == x[i - 1])
				frequency++;
			else
			{
				if (frequency > highestFrequencySoFar)
				{
					highestFrequencySoFar = frequency;
					mostFrequentSoFar = x[i - 1];
				}
				frequency = 1;
			}
		}

		if (frequency > highestFrequencySoFar)
			mostFrequentSoFar = x[x.length - 1];

		return mostFrequentSoFar;
	}

	public static int antiMode(int[] array)
	{
		int[] x = array.clone();
		Arrays.sort(x);

		int leastFrequentSoFar = x[0];
		int lowestFrequencySoFar = x.length + 1;

		int frequency = 1;

		for (int i = 1; i < x.length; i++)
		{
			if (x[i] == x[i - 1])
				frequency++;
			else
			{
				if (frequency < lowestFrequencySoFar)
				{
					lowestFrequencySoFar = frequency;
					leastFrequentSoFar = x[i - 1];
				}
				frequency = 1;
			}
		}

		if (frequency < lowestFrequencySoFar)
			leastFrequentSoFar = x[x.length - 1];

		return leastFrequentSoFar;
	}

	public static int longestEqualSequence(int[] x)
	{
		int longestLength = 1;

		int length = 1;

		for (int i = 1; i < x.length; i++)
		{
			if (x[i] == x[i - 1])
				length++;
			else
			{
				if (length > longestLength)
					longestLength = length;

				length = 1;
			}
		}

		if (length > longestLength)
			longestLength = length;

		return longestLength;
	}

	public static int biggestHill(int[] x)
	{
		int longestHill = 1;
		int lengthOfHill = 1;

		for (int i = 1; i < x.length; i++)
		{
			if (x[i] > x[i - 1])
				lengthOfHill++;
			else
			{
				if (lengthOfHill > longestHill)
					longestHill = lengthOfHill;

				lengthOfHill = 1;
			}
		}

		if (lengthOfHill > longestHill)
			longestHill = lengthOfHill;

		return longestHill;
	}

	public static boolean mirrorImage(String s)
	{
		for (int left = 0, right = s.length() - 1; left < s.length() / 2; left++, right--)
			if (s.charAt(left) != s.charAt(right))
				return false;

		return true;
	}

	public static int[] reverse(int[] array)
	{
		int[] result = new int[array.length];

		for (int i = 0; i < array.length; i++)
			result[array.length - 1 - i] = array[i];

		return result;
	}

	public static boolean increasing(int[] array)
	{
		for (int i = 1; i < array.length; i++)
			if (array[i] < array[i - 1])
				return false;
		return true;
	}
}

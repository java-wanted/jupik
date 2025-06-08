package jupik.syntax.forch.hints;

import java.util.stream.IntStream;

public class Main
{
	public static void main(String []argv)
	{
		int []nums = new int[100];

		IntStream.range(0, nums.length).forEach(
			i -> nums[i] = i + 100
		);

		for (int e: nums) {
			System.out.printf("%d\n", e);
		};
	}
}

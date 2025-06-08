package jupik.syntax.arrs.rars;

public class Main
{
	public static void main(String []argv)
	{
		int []nums = {4, 1, 2, 10, 15};
		StringBuffer s = new StringBuffer();

		for (int i = nums.length; i > 1; --i) {
			s.append(String.format("%d, ", nums[i - 1]));
		}

		if (nums.length > 0) {
			s.append(String.format("%d.", nums[0]));
			System.out.printf("%s\n", s);
		}
	}
}

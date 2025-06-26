package jupik.advance.strran.firaten;

import java.util.Random;

public class Main
{
	public static void main(String []argv)
	{
		int first = 5;
		int end = 10;

		System.out.printf(
			"Random in [%d, %d]: %d\n", first, end,
			(new Random()).nextInt(first, end + 1)
		);
	}
}

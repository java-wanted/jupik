package jupik.advance.strran.dirols;

import java.util.Random;

public class Main
{
	public static void main(String []argv)
	{
		int first = 1;
		int last = 7;
        int count = 100;

		(new Random()).ints(count, first, last).forEachOrdered(
			i -> System.out.printf("The number is %d.\n", i)
		);
	}
}

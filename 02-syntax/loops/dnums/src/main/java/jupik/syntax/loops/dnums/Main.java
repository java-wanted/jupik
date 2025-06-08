package jupik.syntax.loops.dnums;

public class Main
{
	public static void main(String []argv)
	{
		/*
		 * An integer x is divided by 3 with the zero remainder iff there is an
		 * integer k such that x = k * 3.
		 *
		 * If x is a such number the next such number MUST BE x + 3:
		 * 	   (k + 1) * 3 = k * 3 + 3
		 */

		int num = 1000;

		for (; num >= 0 && num % 3 != 0; --num) {
		}

		for (; num >= 0; num -= 3) {
			System.out.printf("%d\n", num);
		}
	}
}

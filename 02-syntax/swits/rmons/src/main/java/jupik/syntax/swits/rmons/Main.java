package jupik.syntax.swits.rmons;

import java.util.Scanner;

public class Main
{
	public static void main(String []argv)
	{
		String [] months = {
			"January",
			"Febrary",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December",
		};
		int idx = 0;

		System.out.printf("Type a number of a month: ");
		System.out.flush();

		try (Scanner sc = new Scanner(System.in)) {
			idx = sc.nextInt();
		} catch (RuntimeException e) {
			System.err.printf("Failed to receive a number\n");
			System.exit(1);
		}

		if (idx < 1 || idx > months.length) {
			System.err.printf(
				"Invalid number of a month, must be in the range from 1 to %d\n",
				months.length
			);
			System.exit(1);
		}

		System.out.printf("%s\n", months[idx - 1]);
	}
}

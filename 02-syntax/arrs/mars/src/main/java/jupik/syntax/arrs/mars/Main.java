package jupik.syntax.arrs.mars;

import java.util.stream.IntStream;

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

		IntStream.range(0, months.length).forEachOrdered(
			i -> System.out.printf("%2d %s\n", i + 1, months[i])
		);
	}
}

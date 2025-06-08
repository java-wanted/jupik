package jupik.syntax.arrs.omars;

import java.util.Arrays;

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
		StringBuffer s = new StringBuffer();

		Arrays.stream(months, 0, months.length - 1).forEachOrdered(
			m -> s.append(String.format("%s, ", m))
		);

		s.append(String.format("%s.", months[months.length - 1]));

		System.out.printf("%s\n", s);
	}
}

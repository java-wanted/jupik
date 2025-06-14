package jupik.oop.wraps.whums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

public class Main
{
	static record Hum(String name, int age)
	{
	}

	public static void main(String []argv)
	{
		String []data = {
			"This is Abraam. He is 86 years old.",
			"This is Saarah. She is 68 years old.",
			"It is Vasia. It is 58 years old.",
		};
		Pattern hup = Pattern.compile(
			"This is (?<name>\\p{Upper}\\p{Lower}+)\\. " +
			"(He|She) is (?<age>(0|[1-9][0-9]+)) years old\\."
		);
		LinkedList<Hum> hums = new LinkedList<Hum>();
		int nohums = 0;

		for (String d: data)
		{
			Matcher m = hup.matcher(d);
			if (!m.matches())
			{
				++nohums;
			}
			else
			{
				hums.add(
					new Hum(
						m.group("name"),
						Integer.parseInt(m.group("age"))
					)
				);
			}
		}

		if (hums.size() == 0)
		{
			System.out.printf("There are no humans.\n");

			if (nohums > 0)
			{
				System.out.printf(
					"But there are %d other beings.\n",
					nohums
				);
			}
		}
		else
		{
			System.out.printf(
				"There are %d humans:\n", hums.size()
			);

			for (Hum h: hums)
			{
				System.out.printf(
					"    Name: %s, Age: %d\n",
					h.name(), h.age()
				);
			}

			if (nohums > 0) {
				System.out.printf(
					"And there are %d other beings also.\n",
					nohums
				);
			}
		}
	}
}

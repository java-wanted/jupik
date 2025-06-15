package jupik.oop.inher.cafs;

public class Main
{
	static record R(String kind, Cat info)
	{
	}

	public static void main(String []argv)
	{
		R []cats = {
			new R("Domestic Cat", new DomesticCat()),
			new R("Lion", new Lion()),
		};

		for (R r: cats)
		{
			StringBuffer s = new StringBuffer();

			s.append(String.format(
				"%s has %d eyes and %d legs. ",
				r.kind, r.info.eyes(), r.info.legs()
			));

			if (r.info.canEatHumans())
			{
				s.append("It eats humans.");
			}
			else
			{
				s.append("It does not eat humans usually.");
			}

			System.out.printf("%s\n", s);
		}
	}
}

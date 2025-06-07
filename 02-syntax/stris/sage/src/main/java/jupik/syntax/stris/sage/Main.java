package jupik.syntax.stris.sage;

public class Main
{
	public static void main(String []argv)
	{
		String name = "Joe";
		byte age = 89;
		String rem = String.format(
			"Hi, %s! You are %d.", name, age
		);

		System.out.printf("%s\n", rem);
	}
}

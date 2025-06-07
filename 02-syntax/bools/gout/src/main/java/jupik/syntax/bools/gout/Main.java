package jupik.syntax.bools.gout;

public class Main
{
	public static void main(String []argv)
	{
		boolean weather = true;
		boolean night = false;

		if (weather && !night) {
			System.out.printf("You, go out!\n");
		}

		if (!weather && !night) {
			System.out.printf("You, read it!\n");
		}

		if (night) {
			System.out.printf("You, sleep down!\n");
		}
	}
}

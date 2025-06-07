package jupik.syntax.conds.jre;

public class Main
{
	public static void main(String []argv)
	{
		int dollars = 10;

		if (dollars > 10) {
			System.out.printf("You MUST eat a Pizza.\n");
		} else if (dollars > 5) {
			System.out.printf("You MUST eat a Hamburger.\n");
		} else {
			System.out.printf("Jre a Sandwich.\n");
		}
	}
}

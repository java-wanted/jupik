package jupik.syntax.loops.enums;

public class Main
{
	public static void main(String []argv)
	{
		int num = 0;

		while (num < 1000) {
			num += 2;
			System.out.printf("%d\n", num);
		}
	}
}

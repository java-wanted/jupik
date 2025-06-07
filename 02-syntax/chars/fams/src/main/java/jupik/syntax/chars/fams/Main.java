package jupik.syntax.chars.fams;

public class Main
{
	public static void main(String []argv)
	{
		String firstParent = "Abraam";
		String secondParent = "Isya";
		String thirdParent = "Moisha";
		String forthParent = "Vasia";
		char firstAge = 'A';
		char secondAge = 'B';
		char thirdAge = 'C';
		char forthAge = '@';

		System.out.printf("%s: %s\n", firstParent, (byte)firstAge);
		System.out.printf("%s: %s\n", secondParent, (byte)secondAge);
		System.out.printf("%s: %s\n", thirdParent, (byte)thirdAge);
		System.out.printf("%s: %s\n", forthParent, (byte)forthAge);
	}
}

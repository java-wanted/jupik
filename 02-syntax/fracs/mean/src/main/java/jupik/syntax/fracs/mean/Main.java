package jupik.syntax.fracs.mean;

public class Main
{
	public static void main(String []argv)
	{
		int firstParent = 81;
		int secondParent = 82;
		int thirdParent = 83;
		int forthParent = 84;
		int fifthParent = 89;
		float mean = (firstParent + secondParent + thirdParent + forthParent
						+ fifthParent ) / 5.0f;
		
		System.out.printf("The mean is %.2f\n", mean);
	}
}

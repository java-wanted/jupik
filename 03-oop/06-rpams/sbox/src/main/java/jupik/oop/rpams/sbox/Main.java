package jupik.oop.rpams.sbox;

public class Main
{
	public static void main(String []argv)
	{
		Sbox first = new Sbox(10, 20, 30);
		Sbox second = (Sbox)first.clone();

		System.out.printf("First %s\n", first);
		System.out.printf("Second %s\n", second);

		if (first == second) {
			System.out.printf(
				"First and second refer the same object\n"
			);
		} else {
			System.out.printf(
				"First and second are %s\n",
				first.equals(second) ? "equal" : "not equal"
			);
		}
	}
}

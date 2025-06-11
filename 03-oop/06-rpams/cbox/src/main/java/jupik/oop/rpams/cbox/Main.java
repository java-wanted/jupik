package jupik.oop.rpams.cbox;

public class Main
{
	public static void main(String []argv)
	{
		Cbox []boxs = {
			new Cbox(10, 20, 30),
			new Cbox(10),
			new Cbox(),
		};
		String []cres = {
			"lesser than", "equal to", "greater than",
		};

		for (int i = 0; i < boxs.length; ++i) {
			System.out.printf("%d: %s\n", i, boxs[i]);
		}

		for (int i = 0; i < boxs.length - 1; ++i) {
			for (int j = i + 1; j < boxs.length; ++j) {
				System.out.printf(
					"%d is %s %d\n",
					i, cres[boxs[i].compareTo(boxs[j]) + 1], j
				);
			}
		}
	}
}

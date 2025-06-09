package jupik.oop.optro.rdog;

import jupik.oop.optro.dog.Dog;

public class Rdog extends Dog {
	int speed;

	public void run()
	{
		if (speed > 0) {
			System.out.printf("Run");

			for (int i = 1; i < speed; ++i) {
				System.out.printf(", run");
			}

			System.out.printf("!\n");
		}
	}
}

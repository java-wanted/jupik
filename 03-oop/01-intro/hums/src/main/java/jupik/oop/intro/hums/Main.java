package jupik.oop.intro.hums;

public class Main
{
	public static void main(String []argv)
	{
		Human []hums = {
			new Human(){
				{
					name = "Abraam";
					age = 68;
					weight = 168;
				}
			},
			new Human() {
				{
					name = "Moisha";
					age = 78;
					weight = 178;
				}
			},
			new Human() {
				{
					name = "Vasia";
					age = 34;
					weight = 43;
				}
			},
		};

		for (Human hum: hums) {
			System.out.printf(
				"%s is %d. Her weight is %.2f\n", hum.name, hum.age, hum.weight
			);
		}

		float age = 0;

		for (Human hum: hums) {
			age += hum.age;
		}

		age /= hums.length;

		System.out.printf("The mean age is %.2f\n", age);
	}
}

package jupik.oop.optro.dog;

public class Main
{
	public static void main(String []argv)
	{
		Dog dog = new Dog(){
			{
				name = "Abraam";
				kind = "Doggy";
				weight = 168;
			}
		};

		System.out.printf("%s\n", dog);
	}
}

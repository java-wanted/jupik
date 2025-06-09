package jupik.oop.optro.dog;

public class Dog {
	String name;
	String kind;
	float weight;

	@Override
	public String toString()
	{
		return String.format(
			"{\"name\": \"%s\", \"kind\": \"%s\", \"weight\": %.02f}",
			name, kind, weight
		);
	}
}

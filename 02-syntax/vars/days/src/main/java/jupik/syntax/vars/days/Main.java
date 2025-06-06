package jupik.syntax.vars.days;

public class Main
{
	public static void main(String []argv)
	{
		/* It is stated that if the number of days is 365
		 * the result must be one year and zero month and days.
		 */
		int dayYear = 365;
		int dayMonth = dayYear / 12;

		int days = 10000;

		int year = days / dayYear;
		int day = days % dayYear;
		int month = day / dayMonth;

		day %= dayMonth;

		System.out.printf(
			"There are %d years, %d month and %d days in %d days.\n",
			year, month, day, days
		);
	}
}

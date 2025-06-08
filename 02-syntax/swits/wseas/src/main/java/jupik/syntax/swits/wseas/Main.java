package jupik.syntax.swits.wseas;

import java.util.Scanner;

public class Main
{
	public static void main(String []argv)
	{
		String []seasons = {
			"Spring",
			"Summer",
			"Autumn",
			"Winter",
		};
		String month;
		String season;

		System.out.printf("Type a name of a month: ");
		System.out.flush();

		try (Scanner sc = new Scanner(System.in)) {
			month = sc.next();
		} catch (RuntimeException e) {
			System.err.printf("Failed to receive a month\n");
			System.exit(1);
			month = "";
		}

		switch (month) {
		case "December":
		case "January":
		case "Febrary":
			season = "Winter";
			break;
		case "March":
		case "April":
		case "May":
			season = "Spring";
			break;
		case "June":
		case "July":
		case "August":
			season = "Summer";
			break;
		case "September":
		case "October":
		case "November":
			season = "Autmn";
			break;
		default:
			System.err.printf("Invalid name of a month\n");
			System.exit(1);
			season = "";
		}

		System.out.printf("%s\n", season);
	}
}

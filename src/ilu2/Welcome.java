package ilu2;

public class Welcome {

	public static String welcome(String input) {
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		return "Hello, " + input;
	}
}

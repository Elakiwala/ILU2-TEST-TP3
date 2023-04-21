package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder();
		String[] str = null;
		hello.append("Hello, ");
		input = input.trim();
		if(input == null || input.isEmpty()) {
			return EX_2(input, hello);
		}else {
			return EX_1(input, hello);
		}
	}
	
	
	
	private static String EX_1(String input, StringBuilder hello) {
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		return hello.append(input).toString();
	}
	
	private static String EX_2(String input, StringBuilder hello) {
		return hello.append("my friend").toString();
	}
}

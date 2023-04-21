package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder();
		String[] str = null;
		hello.append("Hello, ");
		if(input == null) {
			return EX_2(input, hello);
		}else if(input.isBlank() || input.isEmpty()){
			input = input.trim();
			return EX_2(input, hello);
		}else if(input.length() != 0) {
			if(input.equals(input.toUpperCase())) {
				return EX_3(input, hello);
			}else {
				return EX_1(input, hello);
			}
		}
		return input;
	}
	
	
	
	private static String EX_1(String input, StringBuilder hello) {
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		return hello.append(input).toString();
	}
	
	private static String EX_2(String input, StringBuilder hello) {
		return hello.append("my friend").toString();
	}
	
	private static String EX_3(String input, StringBuilder hello) {
		hello.append(input + " !");
		return hello.toString().toUpperCase();
	}
}

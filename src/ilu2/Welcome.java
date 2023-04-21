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
			}
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == ',') {
					str = input.split(",");
				}
			}if(str != null && str.length != 0) {
				return EX_4(input, hello, str);
			}else {
				return EX_1(input, hello);
			}
		}
		return EX_1(input, hello);
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
	
	private static String EX_4(String input, StringBuilder hello, String[] str) {
		for(int j = 0; j < str.length; j++) {
			String mot = str[j].trim(); 
			mot = mot.substring(0, 1).toUpperCase() + mot.substring(1);
			str[j] = mot;
		}
		for(int i = 0; i<str.length; i++) {
			hello.append(str[i] + ", ");
		}
		return hello.delete(hello.length()-2, hello.length()).toString();
	}
}

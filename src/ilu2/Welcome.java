package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder();
		String[] str = null;
		hello.append("Hello, ");
		if(input == null) return EX_2(input, hello);
		else if(input.isBlank() || input.isEmpty()){
			input = input.trim();
			return EX_2(input, hello);
		}else if(input.length() != 0) {
			if(input.equals(input.toUpperCase())) return EX_3(input, hello);
			for(int i = 0; i < input.length(); i++) if(input.charAt(i) == ',') str = input.split(",");
			if(str != null && str.length != 0) {
				if(str.length == 2) return EX_4(input, hello, str);
				else {
					int countMaj = 0;
					for(int i = 0; i < str.length; i++) if(str[i].equals(str[i].toUpperCase())) countMaj++;
					if(countMaj == 0)return EX_5(hello, str);
					else return EX_6(input, hello, str, countMaj);
				}
			}else return EX_1(input, hello);	
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
		str[0] = str[0].substring(0, 1).toUpperCase() + str[0].substring(1);
		str[1] = str[1].substring(0, 1).toUpperCase() + str[1].substring(1);
		return hello.append(str[0] + " and " + str[1]).toString();
	}
	
	private static String EX_5(StringBuilder hello, String[] str) {
		for(int j = 0; j < str.length; j++) {
			String mot = str[j].trim(); 
			mot = mot.substring(0, 1).toUpperCase() + mot.substring(1);
			str[j] = mot.trim();
		}
		if(str.length > 1) {
			for(int i = 0; i<str.length-1; i++) hello.append(str[i] + ", ");
			return hello.delete(hello.length()-2, hello.length()).append(" and " + str[str.length-1]).toString();
		}else if(str.length == 1) {
			for(int i = 0; i<str.length-1; i++) hello.append(str[i] + ", ");
			return hello.delete(hello.length()-2, hello.length()).append(", " + str[str.length-1]).toString();
		}
		return hello.toString();
	}
	
	private static String EX_6(String input, StringBuilder hello, String[] str, int countMaj) {
		String[] maju = new String[countMaj];
		String[] minu = new String[str.length - countMaj];
		int decountMaj = 0;
		int decountMin = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i].equals(str[i].toUpperCase())) {
				if(decountMaj < countMaj) {
					maju[decountMaj] = str[i].trim();
					decountMaj++;}
			}else if(decountMin < minu.length) {
					minu[decountMin] = str[i].trim();
					decountMin++;}
		}
		StringBuilder hi = new StringBuilder();
		if(countMaj == 1) hi.append("Hello, ");
		else if(countMaj > 1) hi.append("Hello ");
		return EX_5(hello, minu) + ". AND " + EX_5(hi, maju).toUpperCase() + " !";
	}
}

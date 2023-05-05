package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder();
		String[] str = null;
		hello.append("Hello, ");
		if(input == null) return myFriend(hello);
		else if(input.isBlank() || input.isEmpty()){
			input = input.trim();
			return myFriend(hello);
		}else if(input.length() != 0) {
			if(input.equals(input.toUpperCase())) return simpleMaj(input, hello);
			for(int i = 0; i < input.length(); i++) if(input.charAt(i) == ',') str = input.split(",");
			if(str != null && str.length != 0) {
				String[] motDiff = tabNomDistinct(str);
				int[] nb = compteur(str, motDiff);
				if(str.length == 2) {
					if(motDiff.length==2) return deuxMin(hello, str);
					else return hello.append(motDiff.toString() + " (x2)").toString();
				}
				else { 
					if(motDiff.length == str.length) {
						int countMaj = 0;
						for(int i = 0; i < str.length; i++) if(str[i].equals(str[i].toUpperCase())) countMaj++;
						if(countMaj == 0) {
							return plusieursMin(hello, str);
						}
						else return plusieursMinMaj(hello, str, countMaj);
					}/*else{
						int countMaj = 0;
						for(int i = 0; i < motDiff.length; i++) if(motDiff[i].equals(motDiff[i].toUpperCase())) countMaj++;
						return EX_9(hello, motDiff, nb, str, countMaj);
					}*/
				}
			}else return simple(input, hello);	
		}
		return simple(input, hello);
	}
		
	
	
	
	private static String simple(String input, StringBuilder hello) {
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		return hello.append(input).toString();
	}
	
	private static String myFriend(StringBuilder hello) {
		return hello.append("my friend").toString();
	}
	
	private static String simpleMaj(String input, StringBuilder hello) {
		hello.append(input + " !");
		return hello.toString().toUpperCase();
	}
	
	private static String deuxMin(StringBuilder hello, String[] str) {
		str[0] = str[0].trim();
		str[1] = str[1].trim();
		str[0] = (str[0].substring(0, 1).toUpperCase() + str[0].substring(1));
		str[1] = (str[1].substring(0, 1).toUpperCase() + str[1].substring(1));
		return hello.append(str[0] + " and " + str[1]).toString();
	}
	
	private static String plusieursMin(StringBuilder hello, String[] str) {
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
	
	private static String plusieursMinMaj(StringBuilder hello, String[] str, int countMaj) {
		String[] maju = majuscule(str, countMaj);
		String[] minu = minuscule(str, countMaj);
		StringBuilder hi = new StringBuilder();
		if(countMaj == 1) hi.append("Hello, ");
		else if(countMaj > 1) hi.append("Hello ");
		return plusieursMin(hello, minu) + ". AND " + plusieursMin(hi, maju).toUpperCase() + " !";
	}
	
	private static String[] majuscule (String[] str, int countMaj) {
		String[] maju = new String[countMaj];
		int decountMaj = 0;
		for(int i = 0; i<str.length; i++) {
			if(str[i].equals(str[i].toUpperCase())) {
				if(decountMaj < countMaj) {
					maju[decountMaj] = str[i].trim();
					decountMaj++;
				}
			}
		}
		return maju;
	}
	
	private static String[] minuscule (String[] str, int countMaj) {
		String[] minu = new String[str.length - countMaj];
		int decountMin = 0;
		for(int i = 0; i<str.length; i++) {
			if(str[i] != str[i].toUpperCase()) {
				if(decountMin < minu.length) {
					minu[decountMin] = str[i].trim();
					decountMin++;
				}
			}
		}
		return minu;
	}
	
	private static String[] tabNomDistinct(String[] str) {
		String[] tabMotDist = new String[str.length];
		int i = 0;
		for(int j = 0; j<str.length; j++) {
			boolean doublon = false;
			int k = 1;
			while(!doublon && k<=i) {
				if(str[i].equals(tabMotDist[k])) doublon = true;
				k++;
			}
			if(!doublon) {
				tabMotDist[i] = str[i];
				i++;
			}
		}
		String[] tab = new String[i];
		for(int j = 0; j<i; j++) {
			tab[j] = tabMotDist[j];
			System.out.println("tabND\n" + tab[j]);
		}
		return tab;
	}
	
	private static int[] compteur(String[] str, String[] tab) {
		int[] nb = new int[tab.length];
		for(int i = 0; i<nb.length; i++) nb[i] = 0;
		for(int i = 0; i<tab.length; i++) for(int j = 0; j<str.length; j++) {
				if(tab[i].equals(str[j])) nb[i]++;
		}
		return nb;
	}
	
	/*private static String[] maj(String[] motDiff, int[] compteur, int countMaj, StringBuilder hi) {
		String[] maju = new String[countMaj];
		int decountMaj = 0;
		for(int i = 0; i<motDiff.length; i++) {
			if(motDiff[i].equals(motDiff[i].toUpperCase())) {
				if(decountMaj < countMaj) {
					if(compteur[i] == 1) maju[decountMaj] = motDiff[i].trim();
					else if(compteur[i] > 1) maju[decountMaj] = motDiff[i].trim() + " (x" + compteur[i] + ")";
					System.out.println("\n-maju-");
					System.out.println(maju[decountMaj]);
					decountMaj++;
				}
			}
		}
		return maju;
	}
	
	private static String[] min(String[] motDiff, int[] compteur, int countMaj, String[] str, StringBuilder hello) {
		String[] minu = new String[str.length - countMaj];
		int decountMin = 0;
		for(int i = 0; i<motDiff.length; i++) {
			if(motDiff[i] != motDiff[i].toUpperCase()) {
				if(decountMin < minu.length) {
					if(compteur[i] == 1) minu[decountMin] = motDiff[i].trim();
					else if(compteur[i] > 1) minu[decountMin] = motDiff[i].trim() + " (x" + compteur[i] + ")";
					System.out.println("\n-minu-");
					System.out.println(minu[decountMin]);
					decountMin++;
				}
			}
		}
		return minu;
	}
	
	private static String EX_9(StringBuilder hello, String[] motDiff, int[] compteur, String[] str, int countMaj) {
		String[] minu = min(motDiff, compteur, countMaj, str, hello);
		System.out.println("\nminu = ");
		for(int i = 0; i<minu.length; i++) System.out.println(minu[i]);
		StringBuilder hi = new StringBuilder();
		if(countMaj == 1) hi.append("Hello, ");
		else if(countMaj > 1) hi.append("Hello ");
		String[] maju = maj(motDiff, compteur, countMaj, hi);
		return plusieursMin(hello, minu) + ". AND " + plusieursMin(hi, maju).toUpperCase() + " !";
	}*/
}
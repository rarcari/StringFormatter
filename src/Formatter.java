import java.util.Scanner;

public class Formatter {
	public static void main(String[] args) {
		String name = input().nextLine();
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		name = formater(name);
		name = name.replace('-', ' ');
		System.out.println(name);	
	}

	private static String formater(String nameParameter) {
		int counter = 0;
		for( int i=0; i<nameParameter.length(); i++ ) {
		    if( nameParameter.charAt(i) == ' ' ) {
		        counter++;
		    } 
		}
		for(int i = 0;i<counter;i++) {
			nameParameter = nameParameter.substring(0, findingSpace(nameParameter) + 1) + nameParameter.substring(findingSpace(nameParameter)+1,findingSpace(nameParameter)+2).toUpperCase() + nameParameter.substring(findingSpace(nameParameter)+2);
			StringBuilder builderName = new StringBuilder(nameParameter);
			builderName.setCharAt(nameParameter.indexOf(" "), '-');
			nameParameter = builderName.toString();
		}
		return nameParameter;
	}
	private static int findingSpace(String nameParameter) {
		int spaceLocation;
		spaceLocation = nameParameter.indexOf(" ");
		return spaceLocation;
	}

	private static Scanner input() {
		System.out.println("Digite seu nome completo");
		Scanner scan = new Scanner(System.in);		
		return scan;
	}
	
}

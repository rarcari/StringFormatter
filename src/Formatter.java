import java.util.Scanner;

public class Formatter {
	//inicio main
	public static void main(String[] args) {
		String name = input().nextLine();
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		name = formater(name);
		name = name.replace('-', ' ');
		System.out.println(name);	
	}//final main
	//Metodo para formatar a primeira letra do/dos sobrenome/s deixando (e/da/de/do) em LowerCase
	private static String formater(String nameParameter) {
		int counter = 0;
		//Verificando a quantidade de espaços no nome
		for( int i=0; i<nameParameter.length(); i++ ) {
		    if( nameParameter.charAt(i) == ' ' ) {
		        counter++;
		    } 
		}
		//Transformando as primeiras letras dos sobrenomes em UpperCase
		for(int i = 0;i<counter;i++) {
			String testerDa = nameParameter.substring(findingSpace(nameParameter) + 1,findingSpace(nameParameter) + 4);
			String testerE = nameParameter.substring(findingSpace(nameParameter) + 1,findingSpace(nameParameter) + 3);
			if( testerDa(testerDa) || testerE(testerE) == true ){
				
			}
			//Caso não seja (de/da/do/e) depois do espaço esse código é executado
			else{
				nameParameter = nameParameter.substring(0, findingSpace(nameParameter) + 1) + nameParameter.substring(findingSpace(nameParameter)+1,findingSpace(nameParameter)+2).toUpperCase() + nameParameter.substring(findingSpace(nameParameter)+2);
			}
			StringBuilder builderName = new StringBuilder(nameParameter);
			builderName.setCharAt(nameParameter.indexOf(" "), '-');
			nameParameter = builderName.toString();
		}
		return nameParameter;
	}//Final formater
	//Método para testar se o conectivo entre os sobrenomes é "e"
	private static boolean testerE(String e) {
		boolean eResult;
		if (e.equals("e "))
				{
				eResult = true;
			}else{
				eResult = false;
			}
			return eResult;
	}//final testerE
	//Método para testar se o conectivo entre os sobrenomes é "da", "de" ou "do"
	private static boolean testerDa(String da) {
		boolean daResult;
		if (da.equals("da ") ||
			da.equals("de ") ||
			da.equals("do "))
			{
			daResult = true;
		}else{
			daResult = false;
		}
		return daResult;
	}//final testerDa
	//Método para encontrar a posição do espaço no nome
	private static int findingSpace(String nameParameter) {
		int spaceLocation;
		spaceLocation = nameParameter.indexOf(" ");
		return spaceLocation;
	}//final findingSpace
	//Método de Scanner
	private static Scanner input() {
		System.out.println("Digite seu nome completo");
		Scanner scan = new Scanner(System.in);		
		return scan;
	}//final input
	
}

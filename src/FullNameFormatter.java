import java.util.Scanner;

public class FullNameFormatter {
	//inicio main
	public static void main(String[] args) {
		String name = input().nextLine();
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		name = formatter(name);
		name = name.replace('-', ' ');
		System.out.println(name);	
	}//final main
	//Metodo para formatar a primeira letra do/dos sobrenome/s deixando (e/da/de/do) em LowerCase
	private static String formatter(String nameParameter) {
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
			if( testerConjunction(testerDa) || testerConjunction(testerE) == true ){
				
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
	//Método para testar se o conectivo entre os sobrenomes é "e", "de","do" ou "da"
	private static boolean testerConjunction(String conjunctionParameter) {
		boolean conjunctionResult;
		String tester = "e do da de ";
		if (tester.contains(conjunctionParameter))
				{
			conjunctionResult = true;
			}else{
				conjunctionResult = false;
			}
			return conjunctionResult;
	}//final testerConjunction
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
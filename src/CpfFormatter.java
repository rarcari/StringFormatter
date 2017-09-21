import java.util.Scanner;

public class CpfFormatter {

	public static void main(String[] args) {
		String cpf = input();
		cpf = formatter(cpf);
		System.out.println(cpf);
	}
	private static String formatter(String cpfParamatter) {
		String formattedCpf =cpfParamatter.substring(0, 3)+"."+ cpfParamatter.substring(3, 6)+"."+ cpfParamatter.substring(6, 9)+"-"+ cpfParamatter.substring(9);
		return formattedCpf;
	}
	//Método de Scanner
	private static String input() {
		boolean verification;
		System.out.println("Digite seu CPF:");
		Scanner scan = new Scanner(System.in);
		String stringScan = scan.nextLine();
		while (verificationTest(stringScan) == false) {
			scan = null;
			stringScan = null;
			System.out.println("Digite um CPF válido:");
			scan = new Scanner(System.in);
			stringScan = scan.nextLine();
		}
		return stringScan;
	}//final input
	private static boolean verificationTest(String cpfParamatter) {
		boolean cpfVerification = true;
		String nums = "0123456789";
		int cpfLength = cpfParamatter.length();
		if (cpfLength != 11){
			cpfVerification = false;
			System.out.println("ERRO: CPF não contêm 11 digitos");
		}		
		for (int i = 0; i<cpfLength;i++) {
			char tester = cpfParamatter.charAt(i);
			if (nums.indexOf(tester)== -1) {
				cpfVerification = false;
				System.out.println("ERRO: CPF digitado contêm letras");			
			}
		}
		if (cpfVerification == false) {
			return cpfVerification;	
		}
		if (verificationDigit(cpfParamatter) == false) {
			cpfVerification = false;
			System.out.println("CPF inválido");
		}
		return cpfVerification;
	}
	private static boolean verificationDigit(String cpfParamatter) {
	
		boolean verificationResult =true;
		int sum = 0;
		int verifyingDigit;
		int result;
		int k = 10;
		for (int i = 0; i<9; i++) {
			sum = convertToInt(cpfParamatter.substring(i, i+1))*k + sum;
			k--;
		}
		result = 11 - sum % 11;
		if (result > 9) {
			verifyingDigit = 0;
		}else {
			verifyingDigit = result;
		}
		if (verifyingDigit != convertToInt(cpfParamatter.substring(9, 10))) {
			verificationResult = false;
		}//final da verificação do primeiro digito
		k = 11;
		sum = 0;
		for (int i = 0; i<10; i++) {
			sum = convertToInt(cpfParamatter.substring(i, i+1))*k + sum;
			k--;
		}
		result = 11 - sum % 11;
		if (result > 9) {
			verifyingDigit = 0;
		}else {
			verifyingDigit = result;
		}
		if (verifyingDigit != convertToInt(cpfParamatter.substring(10))) {
			verificationResult = false;
		}
		return verificationResult;
	}
	private static int convertToInt(String holderString) {
		int convertedString = Integer.parseInt(holderString);
		return convertedString;
	}
}
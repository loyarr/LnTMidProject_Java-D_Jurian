package midProject1;

public class codeGeneratorTester {

	public codeGeneratorTester() {
		String employeeCode = employeeCodeGenerator.generateCode();
	    System.out.println("Employee Code: " + employeeCode);
	    String employeeCod = employeeCodeGenerator.generateCode();
	    System.out.println("Employee Code: " + employeeCod);
	    String employeeCoe = employeeCodeGenerator.generateCode();
	    System.out.println("Employee Code: " + employeeCoe);
	}

	public static void main(String[] args) {
		
		new codeGeneratorTester();
	}

}

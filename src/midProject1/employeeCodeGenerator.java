package midProject1;

import java.util.*;

public class employeeCodeGenerator {
	private static ArrayList<String> generatedCodes = new ArrayList<>();
    private static Random rand = new Random();
    private static final String AlphabetLists = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
	public static String generateCode() {
		StringBuilder code = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            code.append(AlphabetLists.charAt(rand.nextInt(AlphabetLists.length())));
        }
        code.append("-");

        for (int i = 0; i < 4; i++) {
            code.append(rand.nextInt(10));
        }

        if (generatedCodes.contains(code.toString())) {
            return generateCode();
        } else {
            generatedCodes.add(code.toString());
            return code.toString();
        }
	}
}
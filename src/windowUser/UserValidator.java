package windowUser;

public class UserValidator {
	public static Boolean isFieldEmpty=false;
	public static Boolean isFieldValidationProblem=false;
	
	public static Integer toInteger(String field,String fieldName) {
		Boolean fieldEmpty = field.isEmpty();	
		if(fieldEmpty && !isFieldEmpty) {
			MessageBox.show("Uzupe³nij wszystkie danych");
			isFieldEmpty = true;
		}
		if(!isFieldEmpty && !isFieldValidationProblem) {
			try {
				return Integer.parseInt(field);
			}catch (Exception e) {
				isFieldValidationProblem=true;
				isFieldEmpty = true;
				e.getMessage();
				MessageBox.show("Prosze o poprawne wypelninie danych " +fieldName);
			}
		}
		return null;
	}

	public static String toString(String field,String fieldName) {
		Boolean fieldEmpty = field.isEmpty();	
		if(!fieldEmpty) {
			field = field.trim().substring(0, 1).toUpperCase() + field.substring(1).toLowerCase();
		}
		
		if(fieldEmpty && !isFieldEmpty) {
			MessageBox.show("Uzupe³nij wszystkie pola");
			isFieldEmpty = true;
		}
		
		if(!isFieldEmpty && !isFieldValidationProblem) {
			try {
				for (char x : ((String) field).toCharArray()) {
					if(!Character.isLetter(x)) {
						MessageBox.show("Prosze o poprawne wypelninie danych " +fieldName);
						isFieldValidationProblem=true;
						isFieldEmpty = true;
						return null;
					}	
				}
				return field;
			} catch (Exception e) {
				isFieldValidationProblem=true;
				isFieldEmpty = true;
				e.getMessage();
				MessageBox.show("Prosze o poprawne wypelninie danych " +fieldName);
			}
		}
		return field;
	}	
}


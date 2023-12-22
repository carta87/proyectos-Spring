package co.curso.spring;

import java.lang.reflect.Field;

public class AnnotationTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		User user = new User("Juliana", "12345", "Admin");
		
		//Field[] fieldsToproccess = user.getClass().getDeclaredFields();
		Field[] fieldsToproccess2 = User.class.getDeclaredFields();
		
		Input fileInputAnnotation;
		for (Field field : fieldsToproccess2) {
			//interpretar metodo acceso 
			System.out.println("Campo "+ field);
			
			field.setAccessible(true);//quite la acceso a campos
			
			fileInputAnnotation = field.getAnnotation(Input.class);
			if (fileInputAnnotation != null) {
				if (field.get(user).toString().length() < fileInputAnnotation.min()) {
					System.err.println("Error de validacion en el campo " + field.getName() + " su valor es menor a "
							+ fileInputAnnotation.min());
				} else if (field.get(user).toString().length() > fileInputAnnotation.max()) {
					System.err.println();
				}else {
					System.out.println("el campo "+ field.getName()+ " es corecto" );
				}
			}else {
				System.out.println("el campo " + field.getName() + " no tiene la anotacion de tippo Input.class");
			}
		}
	}
}

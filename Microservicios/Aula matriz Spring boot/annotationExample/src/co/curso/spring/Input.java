package co.curso.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//politica de retencion, por defecto a nivel de class
@Target(ElementType.FIELD)//valida a target clase, atributo, metodo
//@Target({ElementType.FIELD, ElementType.CONSTRUCTOR}) //incluso varios 
public @interface Input {
	
	//int min();solicitara que se ingrese un valor 
	int min()default 0;
	int max()default 10;
	
	//Nota existe Bean validactions librerias  que lo realiza 
	
}

package fr.ing.interview.bank.interfaces;

@FunctionalInterface
public interface CalculInterface {

	 double operation(double a, double b); 
	//void abstractFun(int x); 
	default void abstractFun(double x,double y){
		
	}; 
	
	
}

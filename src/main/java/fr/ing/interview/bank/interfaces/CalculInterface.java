package fr.ing.interview.bank.interfaces;

@FunctionalInterface
public interface CalculInterface {

	double operation(double a, double b);

	default void abstractFun(double x, double y) {

	};

}

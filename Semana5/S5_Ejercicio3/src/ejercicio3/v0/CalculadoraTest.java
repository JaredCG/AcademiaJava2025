package ejercicio3.v0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	Calculadora calculadora;
	
	@BeforeEach
	public void inicializa() {
		calculadora = new Calculadora();
	}
	
	@Test
	@DisplayName("Prueba 1: Suma")
	public void pruebaSuma() {
		 assertEquals(6, calculadora.suma(1,5));
	}
}

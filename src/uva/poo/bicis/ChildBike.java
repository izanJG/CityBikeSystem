package uva.poo.bicis;

import uva.poo.practica2.Talla;

/**
 * Tipo de dato que representa una bici de ni�o, se garantiza que tiene las mismas car�cteristicas que bici
 * ya que es descendiente de ella, pero que a mayores tiene una talla representativa de una bici de ni�o.
 * Esta talla debe estar comprendida entre el 12 y el 26 siendo adem�s un n�mero par.  
 * @author izajime
 * @author asigarc
 */
public class ChildBike extends Bike {
	
	private Talla talla;
	
	/**
	 * Construye una bici de ni�o a partir del constructor de bici y la talla de la bici de ni�o.
	 * @param marca marca de la bici, se admite cualquier marca.
	 * @param modelo modelo de la bici, se admite cualquier modelo.
	 * @param peso peso de la bici, debe ser extrictamente mayor que 0.
	 * @param platos n�mero de platos de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @param piniones n�mero de pi�ones de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @param talla la talla de la bici, solo puede adoptar valores pares entre 12 y 26
	 * @throws IllegalArgumentException cuando {@code talla $ 2 != 0 || @code talla < 12 || @code talla > 26}
	 */
	public ChildBike (String marca, String modelo, double peso, int platos, int piniones, int talla) {
		super(marca, modelo, peso, platos, piniones);
		switch (talla) {
		case 12:
			this.talla = Talla.T12;
			break;
		case 14:
			this.talla = Talla.T14;
			break;
		case 16:
			this.talla = Talla.T16;
			break;
		case 18:
			this.talla = Talla.T18;
			break;
		case 20:
			this.talla = Talla.T20;
			break;
		case 22:
			this.talla = Talla.T22;
			break;
		case 24:
			this.talla = Talla.T24;
			break;
		case 26:
			this.talla = Talla.T26;
			break;
		default:
			throw new IllegalArgumentException("Talla inv�lida");
		}
	}
	
	/**
	 * Consulta el valor del factor de correci�n en una bici de ni�o.
	 * @return un dato tipo double que siempre ser� 0.85, ya que se aplicar� un descuento del 15%.
	 */
	public double getFactorDeCorreccion() {
		return 0.85;
	}
	
	/**
	 * Consulta la talla de la bici de ni�o.
	 * @return un dato tipo String que puede ser los correspondientes a los n�meros pares entre el 12 y el 26
	 */
	public String getTalla() {
		return talla.getTalla();
	}
	
	/**
	 * Consulta la codificaci�n de la bici de ni�o, la cual corresponde a su valor n�merico de talla 
	 * @return un dato tipo entero, se garantiza que este sea par y est� entre el 12 y el 26.
	 */
	public int getCodificacion() {
		return talla.getCodificacion();
	}
	
	/**
	 * Devolver� la informaci�n detallada correspondiente a la bici de ni�o.
	 * @return un dato de tipo String que represente a la informaci�n de la bici.
	 */
	public String toString() {
		return "Bici: " + getIdentificador() + ", marca: " + getMarca() + ", modelo: " + getModelo() 
		+ ", peso: " + getPeso() + ", platos: " + getPlatos() + ", pi�ones: " + getPiniones() + ", talla: " 
		+ getTalla();
	}
}

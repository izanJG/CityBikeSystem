package uva.poo.bicis;

import uva.poo.practica2.Talla;

/**
 * Tipo de dato que representa una bici de adulto, se garantiza que tiene las mismas car�cteristicas que bici
 * ya que es descendiente de ella, pero que a mayores tiene una talla representativa de una bici de adulto.
 * Esta talla puede ser peque�a (S), mediana (M), grande (L), o muy grande (XL).
 * @author izajime
 * @author asigarc
 */
public class AdultBike extends Bike {
	
	private Talla talla;
	
	/**
	 * Construye una bici de adulto a partir del constructor de bici y la talla de la bici de adulto.
	 * @param marca marca de la bici, se admite cualquier marca.
	 * @param modelo modelo de la bici, se admite cualquier modelo.
	 * @param peso peso de la bici, debe ser extrictamente mayor que 0.
	 * @param platos n�mero de platos de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @param piniones n�mero de pi�ones de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @param talla la talla de la bici, solo puede adoptar los valores "S", "M", "L", "XL"
	 * @throws IllegalArgumentException cuando {@code talla != "S", "M", "L", "XL"}
	 */
	public AdultBike(String marca, String modelo, double peso, int platos, int piniones, String talla) {
		super(marca, modelo, peso, platos, piniones);
		
		switch (talla) {
		case "XL":
			this.talla = Talla.XL;
			break;
		case "L":
			this.talla = Talla.L;
			break;
		case "M":
			this.talla = Talla.M;
			break;
		case "S":
			this.talla = Talla.S;
			break;
		default:
			throw new IllegalArgumentException("Talla inv�lida");
		}
	}
	
	/**
	 * Consulta la talla de la bici de adulto.
	 * @return un dato tipo String que puede ser "S", "M", "L", "XL".
	 */
	public String getTalla() {
		return talla.getTalla();
	}
	
	/**
	 * Consulta la codificaci�n de la bici de adulto, la cual corresponde a 1 (S), 2 (M) 3 (L) 4 (XL) 
	 * los cuales son los valores elegidos para codificar las tallas de adulto.
	 * @return un dato tipo entero que puede ser 1, 2, 3 o 4.
	 */
	public int getCodificacion() {
		return talla.getCodificacion();
	}
	
	/**
	 * Consulta el valor del factor de correci�n en una bici de adulto.
	 * @return un dato tipo double que siempre ser� 1.0, ya que no var�a el precio en esta bici.
	 */
	public double getFactorDeCorreccion() {
		return 1.0;
	}
	
	/**
	 * Devolver� la informaci�n detallada correspondiente a la bici de adulto.
	 * @return un dato de tipo String que represente a la informaci�n de la bici.
	 */
	public String toString() {
		return "Bici: " + getIdentificador() + ", marca: " + getMarca() + ", modelo: " + getModelo() 
		+ ", peso: " + getPeso() + ", platos: " + getPlatos() + ", pi�ones: " + getPiniones() + ", talla: " 
		+ getTalla();
	}
}

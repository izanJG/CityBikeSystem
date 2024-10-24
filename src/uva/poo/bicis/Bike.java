package uva.poo.bicis;

import uva.poo.practica2.IResource;

/**
 * Tipo de dato abstracto que representa una bici, ya pueda ser de adulto, ni�o o el�ctrica
 * Se garantiza que cada bici tiene un identificador �nico, as� como unas caracter�sicas generales, 
 * marca, modelo, peso, n�mero de platos y n�mero de pi�ones. Adem�s cada tipo de bici implementar� sus propias car�cteristicas
 * dependiendo del tipo que esta sea.
 * @author izajime
 * @author asigarc
 *
 */
public abstract class Bike implements IResource {
	private String identificador;
	private String marca;
	private String modelo;
	private double peso;
	private int platos;
	private int piniones;

	/**
	 * Construye una nueva bici a partir de unas caracter�sticas dadas (marca, modelo, peso, platos, pi�ones).
	 * El n�mero m�nimo de platos y pi�ones l�gicamente ser� 1, adem�s de que el peso no podr� ser 0 ni menor que 0.
	 * Se crear� un identificador �nico, una vez creado no se podr� cambiar.  
	 * @param marca marca de la bici, se admite cualquier marca.
	 * @param modelo modelo de la bici, se admite cualquier modelo.
	 * @param peso peso de la bici, debe ser extrictamente mayor que 0.
	 * @param platos n�mero de platos de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @param piniones n�mero de pi�ones de la bici, debe ser mayor que 0 (m�nimo 1).
	 * @throws NullPointerException cuando {@code marca == null}
	 * @throws NullPointerException cuando {@code modelo == null}
	 * @throws IllegalArgumentException cuando {@code platos < 1}
	 * @throws IllegalArgumentException cuando {@code piniones < 1}
	 * @throws IllegalArgumentException cuando {@code peso <= 0}
	 */
	protected Bike(String marca, String modelo, double peso, int platos, int piniones) {
		if (marca == null) throw new NullPointerException("Llamada incorrecta: marca == null");
		if (modelo == null) throw new NullPointerException("Llamada incorrecta: modelo == null");
		if (platos < 1) throw new IllegalArgumentException("Llamada incorrecta: platos < 1");
		if (piniones < 1) throw new IllegalArgumentException("Llamada incorrecta: piniones < 1");
		if (peso <= 0) throw new IllegalArgumentException("Llamada incorrecta: peso <= 0");
		this.identificador = java.util.UUID.randomUUID().toString();
		this.marca = marca;
		this.modelo = modelo;
		this.peso = peso;
		this.platos = platos;
		this.piniones = piniones;
	}
	
	/**
	 * Consulta el identificador de la bici.
	 * @return un dato tipo String que representa el identificador de la bici.
	 */
	public String getIdentificador() {
		return identificador;
	}
	
	/**
	 * Consulta la marca de la bici.
	 * @return un dato tipo String que representa la marca de la bici.
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Consulta el modelo de la bici.
	 * @return un dato tipo String que representa el modelo de la bici.
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * Consulta el peso de la bici.
	 * @return un valor double que representa el peso de la bici.
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Consulta el n�mero de platos de la bici.
	 * @return un valor entero que representa el n�mero de platos de la bici.
	 */
	public int getPlatos() {
		return platos;
	}
	
	/**
	 * Consulta el n�mero de pi�ones de la bici.
	 * @return un valor entero que representa el n�mero de pi�ones de la bici.
	 */
	public int getPiniones() {
		return piniones;
	}
	/**
	 * Consulta el precio de la bici dependiendo del tipo de esta, ya que caa una tendr� un factor de correci�n diferente:
	 * ChildBike tendr� un 15% de descuento, AdultBike no se ver� afectada por el factor de correci�n y por �ltimo
	 * ElectricBike habr� que pagar un porcentaje a mayores equivalente al voltaje, es decir, si la bici es de 24V
	 * costar� un 24% m�s si es de 36V un 36% m�s y si es de 48V un 48% m�s. Todo factor de correci�n se aplicar�
	 * a la fianza establecida en el parking en el que est� situada, y se asegura que si esta fianza cambia, los precios
	 * cambiar�n proporcionalmente.
	 */
	public double getDepositToPay(double deposit) {
		return deposit*getFactorDeCorreccion();
	}
	
	/**
	 * Nos indica si una bici es de ni�o o no, se diferencia por la talla, ya que las tallas de ni�o son un valor
	 * numerico par entre el 12 y el 26.
	 * @return un valor l�gico que indica si la bici es de ni�o: true (es de ni�o), false (no lo es).
	 */
	public boolean isChild() {
		return getCodificacion() >= 12;
	}
	
	/**
	 * Nos indica si una bici es de adulto o no, se diferencia por la talla, ya que las tallas de adulto son un valor
	 * String: "S", "M", "L", "XL".
	 * @return un valor l�gico que indica si la bici es de adulto: true (es de adulto), false (no lo es).
	 */
	public boolean isAdult() {
		return getCodificacion() >= 1 && getCodificacion() <= 4;
	}
	
	/**
	 * Nos indica si una bici es el�ctrica o no, se diferencia por la talla, ya que las tallas de bicis el�ctricas
	 * son �nicas.
	 * @return un valor l�gico que indica si la bici es el�ctrica: true (es el�ctrica), false (no lo es).
	 */
	public boolean isElectric() {
		return getCodificacion() == 0;
	}

	/**
	 * Consulta el factor de correci�n de la bicicleta, devolver� valores diferentes para bicis diferentes
	 * para la bici de ni�o devuelve 0.85 (15% de descuento), para la bici de adulto devuelve 1 (neutro), y
	 * para la bici el�ctrica devuelve dependiendo de su voltaje 1.24, 1.36, 1.48 (24%, 36%, 48% m�s respectivamente).
	 * @return un valor double correspondiente al factor de correci�n de la bici.
	 */
	public abstract double getFactorDeCorreccion();
	
	/**
	 * Consulta la talla de la bici
	 * @return un dato tipo String indicando que representa la talla de la bici.
	 */
	public abstract String getTalla();
	
	/**
	 * Consulta la codificaci�n de la talla de la bici, al ser cada talla un tipo de dato necesitamos una
	 * codificaci�n numerica para poder comparar con m�s facilidad
	 * @return un valor entero indicando la codificaci�n de la talla de la bici.
	 */
	public abstract int getCodificacion();

	/**
	 * Compara el objeto de tipo bici con otro cualquiera para saber si son el mismo objeto,
	 * A parte de ver si son instancias de la misma clase comprobaremos tambi�n el identificador,
	 * el cual debe ser el mismo para que las bicis sean las mismas.
	 * @return un valor l�gico indicando si es la misma bici: true (lo es), false (no lo es).
	 */
	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Bike)) return false;
		if (getClass() != objeto.getClass()) return false;
		Bike otraBici = (Bike)objeto;
		if (this.identificador != otraBici.getIdentificador()) return false;
		return true;
	}
	
	/**
	 * Compara el tipo de bici con otra bici para saber si son el mismo tipo de bici (aduta, ni�o o el�ctrica)
	 * @param otraBici un objeto de la clase Bike, el cual, puede ser cualquier tipo de bici
	 * @return un valor l�gico que indica si son el mismo tipo de bici, true (si lo son) y false (si no lo son).
	 */
	public boolean mismoTipoBici(Bike otraBici) {
		if (isChild() && otraBici.isChild()) return true;
		if (isAdult() && otraBici.isAdult()) return true;
		if (isElectric() && otraBici.isElectric()) return true;
		return false;
	}
}

package Rol;

public abstract class PersonajeBase implements Personaje {
	protected String nombre;
	protected double hp;
	protected int defensa;
	protected int fuerza;
	protected int agilidad;
	protected int inteligencia;
	protected int rango;
	
	public PersonajeBase (String nombre,double hp,int fuerza,int agilidad,int inteligencia,int rango,int defensa) {
		this.nombre 		= nombre;
		this.hp 			= hp;
		this.fuerza 		= fuerza;
		this.agilidad 		= agilidad;
		this.inteligencia 	= inteligencia;
		this.rango 			= rango;
		this.defensa		= defensa;
		
	}
	
	
	
	
}

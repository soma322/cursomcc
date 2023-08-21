package Rol;

public class guerrero extends PersonajeBase {
	
	public guerrero() {
		super("", 1, 1, 1, 1, 1,1);
	}
	
	public guerrero(String nombre, double hp,int fuerza) {
		super(nombre, 15, fuerza, 1, 1, 1,3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atacar(Personaje objetivo) {
		int ataque = (int) (super.fuerza + (Math.random()*(super.rango) +1) );
		System.out.println("Guerrero "+super.nombre+" ataca a "+ objetivo.obtenerNombre());
		System.out.println("con "+ataque+" de ataque!");
		
		objetivo.defender(ataque);
		
	}

	@Override
	public void defender(int ataqueRecibido) {
		double dano = (ataqueRecibido - defensa) + Math.round(((Math.random() * super.rango) + 1) * 100.0) / 100.0 ;
		super.hp = (super.hp - dano );
		System.out.println("Guerrero "+obtenerNombre()+" se defiende!");
		System.out.println("Recibe "+dano+" de daño");
		
		
	}

	@Override
	public String obtenerNombre() {
		return super.nombre;
	}

	@Override
	public double obtenerHp() {
		return super.hp;
	}
	

}

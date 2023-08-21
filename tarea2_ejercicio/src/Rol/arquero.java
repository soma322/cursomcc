package Rol;

public class arquero extends PersonajeBase{
	
	public arquero() {
		super("", 1, 1, 1, 1, 1,1);
	}
	public arquero(String nombre, double hp,int agilidad) {
		super(nombre, 10, 1, agilidad, 1, 2,3);

	}

	@Override
	public void atacar(Personaje objetivo) {
		int ataque = (int) (super.fuerza + (Math.random()*(super.rango) +1) );
		System.out.println("Arquero "+super.nombre+" ataca a "+ objetivo.obtenerNombre());
		System.out.println("con "+ataque+" de ataque!");
		
		objetivo.defender(ataque);
		
	}

	@Override
	public void defender(int ataqueRecibido) {
		double dano = (ataqueRecibido - defensa) + (Math.round(((Math.random() * super.rango) + 1) * 100.0) / 100.0 );
		super.hp = (super.hp - dano );
		System.out.println("Arquero "+obtenerNombre()+" se defiende!");
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

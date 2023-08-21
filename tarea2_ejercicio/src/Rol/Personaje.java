package Rol;

public interface Personaje {
	void atacar(Personaje objetivo);
	void defender(int ataque);
	String obtenerNombre();
	double obtenerHp();
}

package juego;

import entorno.*;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private PezGlobo nemo;
	//private Alga alga;
	private Alga[] algas;
	
	Juego()
	{	
		this.nemo= new PezGlobo();

		
		this.algas = new Alga[5]; 
		for(int i = 0; i<this.algas.length; i++) {
			this.algas[i] = new Alga();
		}
		
		//this.alga2=new Alga();
		//this.alga3=new Alga();
		
		/* 
		 * Es fundamental que al final del constructor de la clase Juego se 
		 * construya un objeto entorno de la siguiente manera.
		 */
		entorno = new Entorno(this, "Pez Globo", 800, 600);
	}

	/*
	 * Durante el juego, el método tick() será ejecutado en cada instante y por
	 * lo tanto es el método más importante de esta clase. Aquí se debe
	 * actualizar el estado interno del juego para simular el paso del tiempo
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		if (this.entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			this.nemo.derecha();
		}
		if (this.entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			this.nemo.bajar();
		}
		if (this.entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.nemo.subir();
		}
		if (this.entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.nemo.izquierda();
		}
		
		
		for(int i = 0; i<this.algas.length; i++) {
			this.algas[i].mover();
		}
		for(int i = 0; i<this.algas.length; i++) {
			boolean comio = this.nemo.tratarDeComer(this.algas[i]);
			if (comio){
				this.algas[i] = new Alga();
			} 
		}
		
		for(int i = 0; i<this.algas.length; i++) {
			this.algas[i].corregirPosicion();
			this.algas[i].dibujar(this.entorno);
			
		}
		this.nemo.corregirPosicion();
		this.nemo.dibujar(this.entorno);
			
		/*this.alga2.dibujar(this.entorno);
		this.alga2.moverAlga();
		this.alga3.dibujar(this.entorno);
		this.alga3.moverAlga();
		
		this.alga.pasaMargen();
		this.alga2.pasaMargen();
		this.alga3.pasaMargen();*/
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}

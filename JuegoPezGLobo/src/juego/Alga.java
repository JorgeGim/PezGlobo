package juego;

import java.awt.Color;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Alga {
	private double x;
	private double y;
	private int radio;
	
	private double velocidad;
	private double angulo;
	
	public Alga() {
		Random gen = new Random();
		
		this.x = gen.nextInt(800);
		this.y = gen.nextInt(600);
		this.radio = 1 + gen.nextInt(100); // le sumo 1 para que nunca de tamano 0
		this.velocidad = 1;
		this.angulo = Herramientas.radianes(15);// Math.PI/2;
	}

	public void dibujar(Entorno ent) {
		ent.dibujarCirculo(this.x, this.y, 2*radio, Color.GREEN);
		ent.dibujarTriangulo(this.x, this.y, 2*this.radio, this.radio, this.angulo, Color.LIGHT_GRAY);
	}

	public void mover() { // No me gusta que se llame mover y haga mas cosas que mover.
		Random gen = new Random();
		this.x += Math.cos(angulo) * velocidad;
		this.y += Math.sin(angulo) * velocidad;
		
		this.angulo += Herramientas.radianes(gen.nextInt(11)-5);
		this.velocidad += gen.nextDouble()-0.5;
		
	}
	
	public double dameX(){
		return this.x;
	}

	public double dameY(){
		return this.y;
	}
	
	public double dameRadio(){
		return this.radio;
	}
	
	public void corregirPosicion(){
		if (this.x>800)
			this.x=0;
		if (this.x<0)
			this.x=800;
		if (this.y>600)
			this.y=0;
		if (this.y<0)
			this.y=600;
	}
}

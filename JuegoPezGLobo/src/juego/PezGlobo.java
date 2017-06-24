package juego;

import java.awt.Color;

import entorno.Entorno;

public class PezGlobo {

	private double x;
	private double y;
	private int radio;

	public PezGlobo() {
		this.x = 400;
		this.y = 300;
		this.radio = 50;
	}

	public void dibujar(Entorno ent) {
		ent.dibujarCirculo(this.x, this.y, this.radio * 2, Color.cyan);
	}

	public void subir() {
		this.y = this.y - 4;
	}

	public void bajar() {
		this.y = this.y + 4;
	}

	public void derecha() {
		this.x = this.x + 4;
	}

	public void izquierda() {
		this.x = this.x - 4;
	}

	public void corregirPosicion() {
		if (this.x > 800)
			this.x = 0;
		if (this.x < 0)
			this.x = 800;
		if (this.y > 600)
			this.y = 0;
		if (this.y < 0)
			this.y = 600;
	}

	public boolean tratarDeComer(Alga a) {
		if (Math.sqrt((a.dameX() - this.x) * (a.dameX() - this.x)
				+ (a.dameY() - this.y) * (a.dameY() - this.y))
		< this.radio + a.dameRadio()) {
			if (this.radio >= a.dameRadio()) {
				this.radio += 5;
				return true;
			} else {
				this.morir();
				return false;
			}
		}
		return false;
	}

	private void morir() { // Morir depende del juego, los objetos no pueden
							// morir
		// como truco le ponemos tamaño en 0
		this.radio = 0;

	}

}

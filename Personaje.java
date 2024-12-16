package org.PROYECTOJUEGO;

import java.io.Serializable;

public class Personaje implements Serializable {

    private String tipo ; //tank, base, tirador
    private String elemento; //fuego,agua,planta

    private int vida;
    private int damage;
    private int velocidad;

    public Personaje(String tipo, String elemento) {
        this.tipo = tipo;
        this.elemento = elemento;

        if(tipo == "tank"){

            this.vida=30;
            this.damage=3;
            this.velocidad=3;

        } else if (tipo == "tirador") {

            this.vida=15;
            this.damage=7;
            this.velocidad=7;

        }else {
            this.vida=20;
            this.damage=5;
            this.velocidad=5;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}

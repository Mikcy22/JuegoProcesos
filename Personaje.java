package org.PROYECTOJUEGO;

import java.io.Serializable;

public class Personaje implements Serializable {

    private int id;
    private String tipo ; //tank, base, tirador
    private String elemento; //fuego,agua,planta

    private double vida;
    private double damage;
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

    double atacar(){
        if(this.tipo.equals("tank")){
            return this.damage;
        } else if (this.tipo.equals("tirador")) {
            int numero = (int)Math.random()*2;
            if (numero==0){
                System.out.println("Salió critico..");
                return (this.damage*1.5);
            }else {
                return this.damage;
            }
        }else {
            int numero = (int)Math.random()*4;
            if (numero==0){
                System.out.println("Salió critico..");
                return (this.damage*1.5);
            }else {
                return this.damage;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setDamage(double damage) {
        this.damage = damage;
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

    public double getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDamage() {
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

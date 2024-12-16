package org.PROYECTOJUEGO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int port = 6000;
        try(ServerSocket sv = new ServerSocket(port)){

            System.out.println("Esperando cliente...");
            Socket cliente = sv.accept();


            ObjectInputStream ObjinputStream = new ObjectInputStream(cliente.getInputStream());
            Personaje p1= (Personaje) ObjinputStream.readObject();
            p1.setId(1);

            System.out.println("Esperando cliente...");
            Socket cliente2 = sv.accept();

            ObjectInputStream ObjinputStream2 = new ObjectInputStream(cliente2.getInputStream());
            Personaje p2= (Personaje) ObjinputStream2.readObject();
            p2.setId(2);

            boolean paridaAcabada=false;

            while (!paridaAcabada){

                if (p2.getVelocidad()>p1.getVelocidad()){

                    DataOutputStream outputStream = new DataOutputStream(cliente2.getOutputStream());
                    outputStream.writeUTF("Dime que accion quieres hacer (atacar o defender)");
                    DataInputStream inputStream = new DataInputStream(cliente2.getInputStream());

                    if (inputStream.readUTF()=="atacar"){
                        p1.setVida(p1.getVida()-p2.atacar());
                    } else if (inputStream.readUTF()=="defender") {
                        p2.setVida(p2.getVida()+2);
                    }

                }else {

                    DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
                    outputStream.writeUTF("Dime que accion quieres hacer (atacar o defender)");
                    DataInputStream inputStream = new DataInputStream(cliente.getInputStream());

                    if (inputStream.readUTF()=="atacar"){
                        p2.setVida(p2.getVida()-p1.atacar());
                    } else if (inputStream.readUTF()=="defender") {
                        p1.setVida(p1.getVida()+2);
                    }

                }

                if (p1.getVida()==0 || p2.getVida()==0){
                    paridaAcabada=true;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

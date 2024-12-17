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


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());

            ObjectInputStream ObjinputStream = new ObjectInputStream(cliente.getInputStream());
            Personaje p1= (Personaje) ObjinputStream.readObject();
            p1.setId(1);

            System.out.println("Esperando cliente...");
            Socket cliente2 = sv.accept();

            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(cliente2.getOutputStream());
            ObjectInputStream ObjinputStream2 = new ObjectInputStream(cliente2.getInputStream());
            Personaje p2= (Personaje) ObjinputStream2.readObject();
            p2.setId(2);

            boolean paridaAcabada=false;
            DataOutputStream outputStream = new DataOutputStream(cliente2.getOutputStream());
            DataInputStream inputStream2 = new DataInputStream(cliente2.getInputStream());

            DataOutputStream outputStream2 = new DataOutputStream(cliente.getOutputStream());
            DataInputStream inputStream = new DataInputStream(cliente.getInputStream());
            while (!paridaAcabada){

                if (p2.getVelocidad()>p1.getVelocidad()){


                    outputStream.writeUTF("Dime que accion quieres hacer (atacar o defender)");

                    String cadena = inputStream2.readUTF();

                    if (cadena.equals("atacar")){
                        System.out.println("Personaje 2 ha atacado");
                        p1.setVida(p1.getVida()-p2.atacar());
                    } else if (cadena.equals("defender")) {
                        System.out.println("Personaje 2 se ha defendido");
                        p2.setVida(p2.getVida()+2);
                    }

                    outputStream2.writeUTF("Dime que accion quieres hacer (atacar o defender)");

                    String cadena2 = inputStream.readUTF();

                    if (cadena2.equals("atacar")){
                        System.out.println("Personaje 1 ha atacado");
                        p2.setVida(p2.getVida()-p1.atacar());
                    } else if (cadena2.equals("defender")) {
                        System.out.println("Personaje 1 se ha defendido");
                        p1.setVida(p1.getVida()+2);
                    }

                    objectOutputStream.writeObject(p1);
                    objectOutputStream1.writeObject(p2);

                }else {


                    outputStream2.writeUTF("Dime que accion quieres hacer (atacar o defender)");

                    String cadena2 = inputStream.readUTF();

                    if (cadena2.equals("atacar")){
                        System.out.println("Personaje 1 ha atacado");
                        p2.setVida(p2.getVida()-p1.atacar());
                    } else if (cadena2.equals("defender")) {
                        System.out.println("Personaje 1 se ha defendido");
                        p1.setVida(p1.getVida()+2);
                    }

                    outputStream.writeUTF("Dime que accion quieres hacer (atacar o defender)");

                    String cadena = inputStream2.readUTF();

                    if (cadena.equals("atacar")){
                        System.out.println("Personaje 2 ha atacado");
                        p1.setVida(p1.getVida()-p2.atacar());
                    } else if (cadena.equals("defender")) {
                        System.out.println("Personaje 2 se ha defendido");
                        p2.setVida(p2.getVida()+2);
                    }

                    objectOutputStream.writeObject(p1);
                    objectOutputStream1.writeObject(p2);

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

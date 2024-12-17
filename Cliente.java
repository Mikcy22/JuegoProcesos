package org.PROYECTOJUEGO;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host= "192.168.8.123";

        try(Socket cliente = new Socket(host,6000)){
            //FLUJO DE salida para objetos
            ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
            Personaje p1 = new Personaje("base","agua");
            // Se envía el objeto
            perSal.writeObject(p1);

            ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());

            DataInputStream dataInputStream = new DataInputStream(cliente.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(cliente.getOutputStream());

            try{
                Personaje p2 = null;
                do{
                    System.out.println(dataInputStream.readUTF());
                    dataOutputStream.writeUTF(sc.nextLine());
                    p2 = (Personaje) inputStream.readObject();
                }while (p2.getVida()!=0);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

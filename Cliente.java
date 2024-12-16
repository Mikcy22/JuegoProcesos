package org.PROYECTOJUEGO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {
        String host= "localhost";

        try(Socket cliente = new Socket(host,6000)){
            //FLUJO DE salida para objetos
            ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
            Personaje p1 = new Personaje("tank","agua");
            // Se envía el objeto
            perSal.writeObject(p1);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

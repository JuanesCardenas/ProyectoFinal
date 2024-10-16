package com.proyectofinal.modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdministradorPersistencia {

    public static void serializarObjetoXML(Object objeto, String nombre) throws IOException {
        XMLEncoder codificador = null;
        try {
         // Log al inicio
            codificador = new XMLEncoder(new FileOutputStream(nombre));
            codificador.writeObject(objeto);
            // Log de éxito
        } catch (FileNotFoundException e) {
            // Log de error
        } finally {
            if (codificador != null) {
                codificador.close();
            }
        }
    }

    public static Object deserializarObjetoXML(String nombre) throws IOException, ClassNotFoundException {
        XMLDecoder decodificador = null;
        Object objeto = null;
        try {
            // Log al inicio
            decodificador = new XMLDecoder(new FileInputStream(nombre));
            objeto = decodificador.readObject();
           // Log de éxito
        }catch (IOException e) {
            // Log de error
        }finally {
            if (decodificador != null) {
                decodificador.close();
            }
        }
        return objeto;
    }

    public static void serializarObjetoBinario(Object objeto, String nombre) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(objeto);
            // Log de info
        } catch (IOException e) {
            // Log de error
            throw e;
        }
    }

    public static Object deserializarObjetoBinario(String nombre) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre))) {
            Object objeto = ois.readObject();
            // Log de info
            return objeto;
        } catch (IOException | ClassNotFoundException e) {
            // Log de error
            throw e;
        }
    }
}

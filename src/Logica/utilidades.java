/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author juan
 * Contiene funciones genericas y utiles...
 */
public class utilidades {
    /**
     *
     * Mueve archivos de un lugar a otro, si ya existen los sobreescribe
     * Recibe dos String origen y destino
     * @origen cadena con la ruta de origen del archivo
     * @destino cadena con la ruta de destino del archivo
     */
    public boolean copiarArchivo(String origen, String destino) throws IOException {
        File imagen = new File(origen);
        File va = new File(destino);
        if (imagen.exists()) {
            try {
                InputStream inp = new FileInputStream(imagen);
                OutputStream out = new FileOutputStream(va);
                byte[] bufer = new byte[1024];
                int largo;
                while ((largo = inp.read(bufer)) > 0) {
                    out.write(bufer, 0, largo);
                }
                inp.close();
                out.close();
                return true;
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

}

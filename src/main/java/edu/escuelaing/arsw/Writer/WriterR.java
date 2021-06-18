package edu.escuelaing.arsw.Writer;

import java.io.BufferedReader;
import java.net.Socket;
public interface ResourceWriter {
    /**
     * Permite responder el recurso solicitado.
     * @param file path del archivo
     * @param clientSocket para escribir ahi
     */
    public void write(String file,Socket clientSocket);
    /**
     * @return Devuelve el tipo exacto de ResourceWriter
     */
    public String exactType();
}

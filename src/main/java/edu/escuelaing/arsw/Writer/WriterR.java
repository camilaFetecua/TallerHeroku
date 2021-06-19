package edu.escuelaing.arsw.Writer;

import java.io.BufferedReader;
import java.net.Socket;
public interface WriterR {
    /**
     * Responde el recurso solictado
     * @param file
     * @param clientSocket
     */
    public void write(String file,Socket clientSocket);
    public String exactType();
}

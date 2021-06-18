package edu.escuelaing.arsw.Writer;

import java.io.BufferedReader;
import java.net.Socket;
public interface WriterR {
    /**
     * Responde el recurso solictado
     *
     */
    public void write(String file,Socket clientSocket);
    public String exactType();

}

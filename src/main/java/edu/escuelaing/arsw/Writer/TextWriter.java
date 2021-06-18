package edu.escuelaing.arsw.Writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TextWriter implements WriterR {
    private final String type;

    public TextWriter(String type) {
        this.type = type;
    }

    /**
     * Por medio del socket del cliente escribe un archivo de texto
     * @param clientSocket para dar respuesta
     */
    @Override
    public void write(String file, Socket clientSocket) {
        PrintWriter out;
        try {
            String outputLine;
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader bf = new BufferedReader(new FileReader("www" + file));
            outputLine = "HTTP/1.1 200 OK\r\n";
            outputLine+="Content-Type: text/"+type+"\r\n";
            outputLine+="\r\n\r\n";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                outputLine+=bfRead;
            }
            out.println(outputLine);
            out.close();
        } catch (IOException ex) {
            new WriteE("404 NOT FOUND").write("", clientSocket);
        }
    }

    @Override
    public String exactType() {
        return "text/"+type;
    }
}

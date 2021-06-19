package edu.escuelaing.arsw.Writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteE implements WriterR {
    private final String message;


    public WriteE(String message ){
        this.message=message;
    }

    /**
     * Utiliza el mensaje del constructor al socjet para escribir un Html

     * @param clientSocket socket del cliente.
     */
    @Override
    public void write(String file, Socket clientSocket) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String outputLine = "HTTP/1.1 "+message+"\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>"+message+"</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<h1>Error "+message+ "</h1>"
                    + "</body>"
                    + "</html>";
            out.println(outputLine);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteE.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String exactType() {
        return "noc";
    }
}

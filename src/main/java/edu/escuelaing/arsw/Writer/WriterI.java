package edu.escuelaing.arsw.Writer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class WriterI implements WriterR {
    private final String type;

    public WriterI(String type) {
        this.type = type;
    }

    /**
     * Utiliza el socket del cliente para escribe bits de una imagen.
     * @param file path del archivo
     * @param clientSocket para responder
     */
    @Override
    public void write(String file,Socket clientSocket) {
        FileInputStream inputImage;
        try {
            File graphicResource= new File("resources" +file);
            inputImage = new FileInputStream(graphicResource);
            byte[] bytes = new byte[(int) graphicResource.length()];
            inputImage.read(bytes);
            DataOutputStream binaryOut;
            binaryOut = new DataOutputStream(clientSocket.getOutputStream());
            binaryOut.writeBytes("HTTP/1.1 200 OK \r\n");
            binaryOut.writeBytes("Content-Type: image/"+type+"\r\n");
            binaryOut.writeBytes("Content-Length: " + bytes.length);
            binaryOut.writeBytes("\r\n\r\n");
            binaryOut.write(bytes);
            binaryOut.close();
        } catch (IOException ex) {
            new WriteE("404 NOT FOUND").write("", clientSocket);
        }
    }

    @Override
    public String exactType() {
        return "image/"+type;
    }


}

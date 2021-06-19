package edu.escuelaing.arsw;

import edu.escuelaing.arsw.Writer.ChooserR;
import edu.escuelaing.arsw.Writer.WriterR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient implements Runnable{
    private final Socket socketClient;

    public SocketClient(Socket socketClient){
        this.socketClient = socketClient;
    }

    /**
     * Abre BifferredReader para atrapar la peticion y responde metiante ChooseWriter
     */
    @Override
    public void run() {
        WriterR rw;
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()))){
            String path=getPath(in);
            rw = ChooserR.choose(path);
            rw.write(path, socketClient);
            in.close();
            socketClient.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage()+": Error del proceso en el servidor");
        }
    }

    /**
     * Captura el path de la petcicion
     * @param in del Socket
     * @return path del archivo
     * @throws IOException
     *
     */
    public static String getPath(BufferedReader in) throws IOException, IOException {
        String inputLine,path="";
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (inputLine.contains("GET")) {
                path=inputLine.split(" ")[1];
            }
            if (!in.ready()) {
                break;
            }
        }
        return path;
    }
}

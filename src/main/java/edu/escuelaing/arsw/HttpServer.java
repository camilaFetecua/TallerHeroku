package edu.escuelaing.arsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase donde se implementa el Servidor
 * Desarrollada en clase con el Profesor.
 */

public class HttpServer implements Runnable{

    private static HttpServer instance;
    private static final  Object lock= new Object();
    private ExecutorService executorService;
    private ServerSocket serverSocket=null;

    private HttpServer (){
        executorService = Executors.newCachedThreadPool();

    }
    private HttpServer(int n){
        executorService = Executors.newFixedThreadPool(n);
    }

    /**
     * Corre el servidor hasta qye el ServerSocket se cierra, y por cada uno cre un hilo.
     */
    @Override
    public void run() {
        int port=getPort();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+port);
            System.exit(1);
        }
        System.out.println("Listo para recibir en el puerto: "+ port);
        try {
            while (true) {
                synchronized (lock) {
                    Socket clientSocket = serverSocket.accept();
                    Runnable process = new SocketClient(clientSocket);
                    executorService.execute(process);
                }

            }
        } catch (IOException ex) {
            executorService.shutdown();
            while (!executorService.isTerminated()) {
            }
        }
    }

    /**
     * Para el Socket y el server
     */
    public void Detener() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()+": El socket ni pudo ser inciado");
        }
    }

    public static void main(String[] args) {
        getInstance().run();
    }

    public static HttpServer getInstance(){
        if(instance==null){
            synchronized(HttpServer.class){
                instance=new HttpServer();
            }
        }
        return instance;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3600; //returns default port if heroku-port isn't set (i.e on localhost)
    }


}

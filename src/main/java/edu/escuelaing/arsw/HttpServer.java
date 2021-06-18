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
 */

public class HttpServer {
    private ServerSocket serverSocket;
    private static HttpServer _instance = new HttpServer();
    int port = getPort();
    private HttpServer() {

    }

    private static HttpServer getInstance() {
        return _instance;
    }

    public static void main(String... args) throws IOException {
        HttpServer.getInstance().startServer(args);
    }

    public void startServer(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
        starRequests();
    }

    public void starRequests() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        while (true) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Listo para recibir en el puerto: " + port);
                        Socket clientSocket = serverSocket.accept();
                        processRequest(clientSocket);

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
            boolean running = true;
            while (running) {
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                if (line.contains("Salir")) {
                    executorService.shutdown();
                    running = false;
                }
            }
            executorService.shutdown();
            serverSocket.close();
        }
    }


    public void processRequest(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String method = "";
        String path = "";
        String version = "";
        List<String> headers = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {
            if (method.isEmpty()) {
                String[] requestStrings = inputLine.split(" ");
                method = requestStrings[0];
                path = requestStrings[1];
                version = requestStrings[2];
                System.out.println("reques: " + method + " " + path + " " + version);
            } else {
                System.out.println("header: " + inputLine);
                headers.add(inputLine);
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        String responseMessage = createResponse(path);
        out.println(responseMessage);

        out.close();

        in.close();

        clientSocket.close();
    }

    public String createResponse(String path) {
        String type = "text/html";
        if (path.endsWith(".css")) {
            type = "text/css";
        } else if (path.endsWith(".js")) {
            type = "text/javascript";
        } else if (path.endsWith(".jpeg")) {
            type = "image/jpeg";
        } else if (path.endsWith(".png")) {
            type = "image/png";
        }


        Path file = Paths.get("./www" + path);
        if (path.equals("/") || path.equals("")){
            file= Paths.get("./www/mypage.html");
        }else{
            System.out.println("No es vacio"+ path);
        }
        Charset charset = Charset.forName("UTF-8");
        String outmsg = "";
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                outmsg = outmsg + line;
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type:" + type + "\r\n"
                + "\r\n" + outmsg;
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3600; //returns default port if heroku-port isn't set (i.e on localhost)
    }
}

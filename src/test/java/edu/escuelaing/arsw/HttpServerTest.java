package edu.escuelaing.arsw;
/*
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.BeforeClass;

import org.apache.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Pruebas de la clase HttpServer
 */
/*public class HttpServerTest
{
    /**
     * Metodo que retorna el String del urla
     */
/*
    private String getResult(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    /*@BeforeClass*//*
    public static void setup() throws IOException {
        HttpServer.main(null);
    }
    /**
     * Prueba para comprobar que se este realizando la peticion
     */
/*
    @Test
    public void ComprobarPeticion () throws IOException {
        String result = getResult("http://localhost:35005/mypage.html");
        assertNotNull(result);

    }
    /**
     * Prueba para la validacion de que el recurso no exite
     */
/*
    @Test
    public void RecursoNoExistente() throws IOException{
        String result = getResult("http://localhost:35005/mhola.html");
        assertTrue(result.isEmpty());
    }

    /**
     * Prueba para validar que el html.
     */
/*
    @Test
    public void ProbarHtml() throws IOException {
        String result = getResult("http://localhost:35005/mypage.html");
        assertEquals("<!DOCTYPE html><html lang=\"en\"><head>    <meta charset=\"UTF-8\">    <title>Title</title></head><body>    <img src=\"https://png.pngtree.com/thumb_back/fw800/background/20190223/ourmid/pngtree-plant-flowers-background-design-backgroundpink-image_73306.jpg\" alt=\"flores\"/></body></html>",result);
    }
}*/

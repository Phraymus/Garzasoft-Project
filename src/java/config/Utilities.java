/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author phraymus
 */
public class Utilities {

    public static String getURL(String ruta) throws MalformedURLException, IOException {
        URL url = new URL(ruta);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Throwable t) {
        }

        String inputText = "";
        String inputLine = "";

        while ((inputLine = in.readLine()) != null) {
            inputText = inputText + inputLine;
        }
        return inputText;
    }
    
    public static String getParameter(String cadena) {
        StringBuilder retorno= new StringBuilder(cadena);
        while (retorno.lastIndexOf(" ") != -1) {
            retorno.replace(retorno.lastIndexOf(" "), retorno.lastIndexOf(" ")+1, "+");
        }
        return String.valueOf(retorno);
    }
}

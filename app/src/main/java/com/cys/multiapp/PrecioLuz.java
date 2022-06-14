package com.cys.multiapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PrecioLuz {

    public void AllLight(){
        StringBuilder respuesta;

        try {
            //Solicitar una petición
            URL url = new URL("https://api.preciodelaluz.org/v1/prices/all?zone=PCB"); // generar la url
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //para abrir la conexión
            connection.setRequestMethod("GET"); //establecemos un método de conexión
            connection.connect(); // realizamos la conexión



            int responseCode = connection.getResponseCode(); //codigo de respuesta

            //Comprobar si la petición ha sido correcta (200 OK)
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error: "+responseCode);
            } else {
                //Abrir un scanner que lea el flujo de datos
                StringBuilder informaString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    respuesta = informaString.append(scanner.nextLine());
                }
                scanner.close();
                //Pintar la información por consola
                System.out.println(informaString);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("FIN!!");
        //return respuesta;
    }

}

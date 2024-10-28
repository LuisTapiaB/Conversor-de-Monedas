package Modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

   public static final String APIKEY = "73d58d33860354b2c1092fcd";

   public static ConversionRateRaw pairConversion(String baseCode, String targetCode, Double amount) {
       //Creación de url para busqueda tipo pairConversion
       URI url = URI.create("https://v6.exchangerate-api.com/v6/"+APIKEY+"/pair/"+baseCode+"/"+ targetCode +"/"+amount);

       //conversion de json a objeto record con Gson
       Gson gson = new Gson();
       ConversionRateRaw conversion = gson.fromJson(response(url), ConversionRateRaw.class);

       //sobreescribiendo el monto
       return new ConversionRateRaw(
               conversion.result(),
               conversion.base_code(),
               conversion.target_code(),
               conversion.conversion_rate(),
               conversion.conversion_result(),
               amount
       );
    }
    // función que envia link a la API y devuelve el Response
    private static String response(URI url) {
        HttpResponse<String> response;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}
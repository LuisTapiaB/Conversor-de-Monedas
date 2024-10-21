package Modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

   public static final String APIKEY = "73d58d33860354b2c1092fcd";
   public static ConversionRateRaw pairConversion(String baseCode, String targetCode, Double amount) throws IOException, InterruptedException {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+APIKEY+"/pair/"+baseCode+"/"+ targetCode +"/"+amount);
        String respuesta = response(url);
        Gson gson = new Gson();
        ConversionRateRaw conversion = gson.fromJson(respuesta, ConversionRateRaw.class);
       return new ConversionRateRaw(
               conversion.result(),
               conversion.base_code(),
               conversion.target_code(),
               conversion.conversion_rate(),
               conversion.conversion_result(),
               amount
       );
    }

    private static String response(URI url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
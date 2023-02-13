import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.org.JSONObject;

public class GeocodingAPI {
    private static final String API_KEY = "SUA_CHAVE_AQUI";

    public static String getLocation(String address) throws Exception {
        String urlString = "http://www.mapquestapi.com/geocoding/v1/address?key=" + API_KEY + "&location=" + address;
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject json = new JSONObject(response.toString());
        if (json.getJSONArray("results").length() == 0) {
            throw new Exception("02-Endereço não encontrado para essa localidade.");
        }
        return json.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getString("latLng");
    }

    public static void main(String[] args) {
        try {
            String location = getLocation("Rua Vergueiro, São Paulo, SP");
            System.out.println("Localização: " + location);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

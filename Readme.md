Importante resaltar que eu utilizer a biblioteca JSON e então vocês precisam ter ela instalada em suas maquinas
Para verificar se a biblioteca JSON está disponível no seu projeto, você pode tentar compilar e executar o código.
Se a biblioteca não estiver disponível, você receberá um erro de compilação ou de tempo de execução.

No entanto, se você estiver usando uma IDE como o Eclipse, pode verificar se a biblioteca JSON está presente nas bibliotecas do projeto.
Para fazer isso, siga estas etapas:

Abra o projeto no Eclipse.
Clique com o botão direito do mouse no projeto e selecione "Properties" (Propriedades) no menu.
Na janela Propriedades do projeto, selecione "Java Build Path" (Caminho de construção do Java) no menu à esquerda.
Na guia "Libraries" (Bibliotecas), verifique se a biblioteca JSON está presente na lista.
Se a biblioteca não estiver presente, clique no botão "Add Library" (Adicionar biblioteca) e selecione "User Library" (Biblioteca do usuário) e adicione a biblioteca JSON ao projeto.
Se você estiver usando outra IDE, consulte a documentação para obter informações sobre como verificar e adicionar bibliotecas ao projeto.

Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
Estas são as bibliotecas importadas no início do código.

BufferedReaderé usado para ler a resposta da API.
InputStreamReaderé usado para ler a resposta da API como um fluxo de entrada.
HttpURLConnectioné usado para enviar uma solicitação HTTP à API de geocodificação.
URLé usado para criar uma URL para uma API de geocodificação.
JSONObjecté usado para analisar a resposta da API em um objeto JSON.
Java

//

public class GeocodingAPI {
private static final String API_KEY = "SUA_CHAVE_AQUI";

    public static String getLocation(String address) throws Exception {

Aqui, estamos criando a classe e o GeocodingAPImétodo getLocation(), que irá retornar a localização geográfica do endereço fornecido.
A constante API_KEYé usada para armazenar sua chave de API.

//
Java

        String urlString = "http://www.mapquestapi.com/geocoding/v1/address?key=" + API_KEY + "&location=" + address;
        URL url = new URL(urlString);

Aqui, estamos criando uma string de URL para a API de geocodificação, incluindo sua chave de API e o endereço que desejamos geocodificar.
Em seguida, criamos uma URL a partir dessa string.
//
Java

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        int responseCode = con.getResponseCode();

Aqui, estamos abrindo uma conexão HTTP com a API de geocodificação e definindo o método de solicitação como GET.
Estamos também definindo o tipo de conteúdo da solicitação como JSON.

Java

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

Aqui, estamos lendo a resposta da API usando um BufferedReadere armazenando-a em uma StringBuffer.

Estudei JAVA mais na faculdade voltada para POO, no entando eu gostei bastante do desafio e me esforcei ao maximo para ter um bom resultado.
Fico muito feliz em poder participar desse desafio.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //pagguina a descargar
        List<String> links =  new ArrayList<>();
        links.add("https://www.jw.org/es/");
        links.add("https://www.eltiempo.com/");
        links.add("https://www.jw.org/es/");
        links.add("https://www.eltiempo.com/");

        long timeStart = System.nanoTime();
        links.stream().parallel().forEach(link ->getWebcontent(link));
        long timeEnd = System.nanoTime();
        System.out.println("diference con parrallel "+ (timeStart -timeEnd));

        timeStart = System.nanoTime();
        links.stream().forEach(link ->getWebcontent(link));
        timeEnd = System.nanoTime();
        System.out.println("diference sin parrallel "+ (timeStart -timeEnd));
    }

    public static String getWebcontent(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //obtenemos la informacion de la cabecera
            String encoding = connection.getContentEncoding();

            //desargar la informacion
            InputStream inputStream  = connection.getInputStream();
            Stream<String> lineas =  new BufferedReader(new InputStreamReader(inputStream)).lines();
            return  lineas.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

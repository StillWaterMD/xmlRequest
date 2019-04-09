package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionService {

    private final String url = "http://www.holidaywebservice.com/HolidayService_v2/HolidayService2.asmx?op=GetHolidaysAvailable";

    private HttpURLConnection con;

    private String responseStatus;

    private String response;

    public String getUrl() {

        return this.getUrl();
    }

    public String getResponse() {

        return this.response;

    }


    public ConnectionService(String request) throws IOException {
        createConnection();
        sendRequest(request);
    }

    private void createConnection() throws IOException {

        URL obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        con.setDoOutput(true);

    }


    private void sendRequest(String request) throws IOException {

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(request);
        wr.flush();
        wr.close();
        responseStatus = con.getResponseMessage();
        System.out.println(responseStatus);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        this.response = response.toString();
    }

}

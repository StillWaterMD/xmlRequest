package run;

import freemarker.template.*;
import infoClasses.Request;
import service.ConnectionService;

import java.io.*;
import java.util.HashMap;

public class SendRequest {


    public static void main(String[] args) {

        HashMap<String, String> params = new HashMap<>();
        params.put("country", "UnitedStates");

        sendRequest("template1.ftlh", params);

    }

    private static void sendRequest(String template, HashMap<String, String> params) {

        try {
            Request request = new Request(template, params);
            ConnectionService connection = new ConnectionService(request.getRequest());
            System.out.println(connection.getResponse());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (TemplateException e) {
            System.out.println(e.getMessage());
        }


    }

}

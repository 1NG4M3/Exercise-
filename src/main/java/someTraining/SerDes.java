package someTraining;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SerDes {
    public static void main(String[] args) throws IOException {
//        ArrayList<String> list = new ArrayList<>();
//        someTraining.Client client = new someTraining.Client("Dima", 28, list);
//        list.add("Hello");
//        list.add("I try to");
//        list.add("Serialise");
//        list.add("ArrayList");

        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File("clients.json"), client);
        File file = new File("clients.json");
        Client client = mapper.readValue(file, Client.class);
        System.out.println(client.getAge());
        System.out.println(client.getName());
        System.out.println(client.getList());
        ArrayList<String> list = new ArrayList<>();
        list.add("Nice");
        client.setList(list);
        System.out.println(client);
    }
}

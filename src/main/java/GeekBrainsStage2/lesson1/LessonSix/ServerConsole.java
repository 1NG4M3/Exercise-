package GeekBrainsStage2.lesson1.LessonSix;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerConsole {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is running. Waiting for connection...");
            socket = serverSocket.accept();
            System.out.println("someTraining.Client has connected.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread clientVoice = new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        System.out.println("someTraining.Client request: " + str);
                        if (str.equals("/end")) {
                            break;
                        }
                        if (str.equals("/killme")) {
                            System.out.println("Sending /end to the client.");
                            out.writeUTF("/end");
                        } else {
                            out.writeUTF("someTraining.Client: " + str);
                            System.out.println("Response to client:");
                            System.out.println("someTraining.Client: " + str);
                        }
                    }
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            });

            Thread serverVoice = new Thread(() -> {
                try {
                    while (true) {
                        String serverMessage = scanner.nextLine();
                        if (serverMessage.isEmpty()){
                            out.writeUTF("Server: ");
                            System.out.println("Response from server: ");
                            System.out.println("Sever: ");
                        } else {
                            out.writeUTF("Sever: " + serverMessage);
                            System.out.println("Response from server: ");
                            System.out.println("Sever: " + serverMessage);
                        }
                    }

                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            });

            clientVoice.start();
            serverVoice.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

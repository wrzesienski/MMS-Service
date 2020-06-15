package Connect;

import ASN_1.MyBerNode;
import BerCoding.Coder;
import Building.Builder;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetworkServer {

//    public static void main(String[] args) {
//        awaitRequest();
//    }

    int port = 8180;
    private ServerSocket serverSocket;
    private Socket socket;

    public NetworkServer(){
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(() -> {
            while (true){
                String s = awaitRequest();
                if (s!=null){
                    MyBerNode berNode = Coder.decode(s);
                    Object ob = Builder.process(berNode);
                    berNode = Builder.build(ob);
                    s = Coder.encode(berNode);
                    System.out.println(s);

                }
            }
        });
        thread.start();
    }

    public void answer(String s){
        try {
            socket = serverSocket.accept();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String awaitRequest(){
        try {
            socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("aaa");
            if(scanner.hasNextLine()) {
                return scanner.nextLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
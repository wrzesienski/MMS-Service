package Connect;

import res.IDK;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MmsServer {

//    public static void main(String[] args) {
//        awaitRequest();
//    }

    int port = 8180;
    private ServerSocket serverSocket;
    private Socket socket;

    public MmsServer(){
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
                System.out.println(s);
                if (s!=null){
                    String ob = IDK.mmsPDU.process(s);
                    System.out.println(ob);
                    if(ob !=null){
                        answer(ob);
                    }

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

package Connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MmsClient {

//    public static void main(String[] args) {
//        getRequest();
//    }

    int port = 8180;
    Socket socket;


    public void start(){
        Thread thread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getRequest();

            }
        });
        thread.start();
    }

    public void getRequest(){
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), port), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("20 00 20 00 00 00 00");
            if (scanner.hasNextLine()){
                System.out.println("тут" + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

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

    private int port = 8180;
    private Socket socket;


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
//            printWriter.println("a0 0f 02 02 01 5d a1 09 a0 03 80 01 09 a1 02 80 00               ");
            printWriter.println("a0 0f 02 02 01 a1 09 a0 03 80 01 09 a1 03 80 01 00               ");
            if (scanner.hasNextLine()){
                System.out.println("тут" + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

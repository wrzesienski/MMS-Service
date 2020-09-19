package Connect;

import CodeProcessing.IedConfigurator;
import IecStructure.IED;
import MmsServices.MmsPDU;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SCADAServer {

//    public static void main(String[] args) {
//        awaitRequest();
//    }


    public static void main(String[] args) throws IOException {
         int port = 8000;
         ServerSocket serverSocket = new ServerSocket(port);
         IED ied = new IED();
         String str = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";
        IedConfigurator.configIed(ied, str); // парсинг scl

        MmsPDU mmsPDU = new MmsPDU();
        ied.start();

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("НАШЕЛ КЛИЕНТА");
                Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                if(scanner.hasNextLine()) {
                  String  s = scanner.nextLine();

                    System.out.println(s);
//                    String ob = mmsPDU.process(s, ied);
//                    System.out.println(ob);
//                    ob = mmsPDU.process(ob, ied);
                    printWriter.println("hi");
//                    if(ob !=null){
//                        answer(ob);
//                    }
                }
//                System.out.println(s);

            }
        }

    public void buildMessage(){
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8000), 2000);
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

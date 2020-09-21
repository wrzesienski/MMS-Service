package Connect;

import CodeProcessing.IedConfigurator;
import IedStructure.IED;
import MmsServices.MmsPDU;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

private int serverPort = 8999;
int clientPort = 9000;

    private ServerSocket serverSocket;
    private IED ied;
    PrintWriter printWriter;

    public Server(IED ied) throws IOException {
            setIed(ied);
         serverSocket = new ServerSocket(serverPort);
            String str = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";
        IedConfigurator.configIed(ied); // парсинг scl
        ied.setScadaServer(this);
        ied.start();

        MmsPDU mmsPDU = new MmsPDU();

        Thread thread2 = new Thread(() -> {
            while (true){
                try {
                    Socket socket = serverSocket.accept();

                System.out.println("НАШЕЛ КЛИЕНТА");
                Scanner scanner = new Scanner(socket.getInputStream());
                    System.out.println("aa");
                if(scanner.hasNextLine()) {

                  String  s = scanner.nextLine();
                    System.out.println(s);

                    String ob = mmsPDU.process(s, ied);

                    System.out.println(ob);
                    if(ob !=null){
                        sendEvent(ob);
                    }
                    socket.close();

                }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread2.start();

        }

    public IED getIed() {
        return ied;
    }

    public void setIed(IED ied) {
        this.ied = ied;
    }


    public void sendEvent(String str){
        try {
            System.out.println("init send");
            Socket socket = new Socket("localhost", clientPort);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(str);
            System.out.println("sended");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

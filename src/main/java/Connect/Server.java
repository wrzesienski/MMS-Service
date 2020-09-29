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
    private int clientPort = 9000;
    private ServerSocket serverSocket;
    private IED ied;
    private PrintWriter printWriter;

    public Server(IED ied) throws IOException {
        setIed(ied);
        serverSocket = new ServerSocket(serverPort);
        IedConfigurator.configIED(ied); // парсинг scl
        ied.setScadaServer(this);
        ied.start(); // ied start
        MmsPDU mmsPDU = new MmsPDU();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Connection accepted");
                    Scanner scanner = new Scanner(socket.getInputStream());
                    if (scanner.hasNextLine()) { // got request
                        String s = scanner.nextLine();
                        String ob = mmsPDU.process(s, ied);

                        if (ob != null) {
                            sendMessage(ob);
                        }
                        socket.close();

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }

    public IED getIed() {
        return ied;
    }

    public void setIed(IED ied) {
        this.ied = ied;
    }


    public void sendMessage(String str){
        try {
            Socket socket = new Socket("localhost", clientPort);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(str);
            socket.close();
            System.out.println("Report was send up");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

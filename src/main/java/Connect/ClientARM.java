package Connect;

import MmsServices.RequestServices.GetDataValuesRequest;
import MmsServices.RequestServices.GetNameListRequest;
import MmsServices.RequestServices.SetDataValuesRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientARM {

    public ClientARM(){
//            printWriter.println("a0 0f 02 02 01 5d a1 09 a0 03 80 01 09 a1 02 80 00               ");
//            printWriter.println("a0 0f 02 02 01 a1 09 a0 03 80 01 09 a1 03 80 01 00               ");
        //                printWriter.println("a0 0f 02 02 01 a1 09 a0 03 81 01 01 a1 03 80 01 00               ");

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String link = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt2.scd";

        System.out.println("Приложение клиента запущено");
        Thread thread = new Thread(() -> {
            while (true) {

                Socket socket;
                Scanner Conscanner;
                Scanner ServerScanner;
                PrintWriter printWriter;
                int port = 8000;
                try {

                    Conscanner = new Scanner(System.in);
                    System.out.println("Готов к вводу");
                    socket = new Socket("localhost", port);
                    System.out.println("Соединение с сервером установлено");
                    ServerScanner = new Scanner(socket.getInputStream());
                    printWriter = new PrintWriter(socket.getOutputStream());

                    // парсинг конфигурации файла
                    while (!socket.isClosed()) {

                        if(ServerScanner.hasNextLine())
                            System.out.println("Получено сообщение: " + ServerScanner.nextLine());

                        if (Conscanner.hasNextLine()){
                            String str = processUserCommand(Conscanner.nextLine(), link);

                            printWriter = new PrintWriter(socket.getOutputStream(), true);
                            printWriter.println(str);


                            printWriter.close();
                            socket.close();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

       }

    public static String processUserCommand(String str, String link){
        String name;
        switch (str){
            case "GetNameList":
                System.out.println("Input parentClassOfList$ClassName: ");
                name = (new Scanner(System.in)).nextLine();
                return new GetNameListRequest(link).build(name);
            case "GetDataValuesRequest":
                System.out.println("Input idClass: ");
                name = (new Scanner(System.in)).nextLine();
                return new GetDataValuesRequest(link).build(name);
            case "SetDataValuesRequest":
                System.out.println("Input idClass$mean: ");
                name = (new Scanner(System.in)).nextLine();
                return new SetDataValuesRequest(link).build(name);
            default:
                return "puk";
        }
    }

    public static void processServerResponse(String respStr){

    }

    public void getRequest(){
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8000), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//            printWriter.println("a0 0f 02 02 01 5d a1 09 a0 03 80 01 09 a1 02 80 00               ");
//            printWriter.println("a0 0f 02 02 01 a1 09 a0 03 80 01 09 a1 03 80 01 00               ");
            printWriter.println("a0 0f 02 02 01 a1 09 a0 03 81 01 01 a1 03 80 01 00               ");
            if (scanner.hasNextLine()){
                System.out.println("тут" + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

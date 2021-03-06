package Connect;

import CodeProcessing.ConfigWorker;
import IedStructure.IED;
import MmsServices.AssociationServices.AssociationRequest;
import MmsServices.CancelServices.CancelRequest;
import MmsServices.MmsPDU;
import MmsServices.RequestServices.GetDataValuesRequest;
import MmsServices.RequestServices.GetNameListRequest;
import MmsServices.RequestServices.SetDataValuesRequest;
import CodeProcessing.SclBodies.SCL;
import CodeProcessing.SclBodies.TS;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private int clientPort = 8999;
    private String configLink = "/Users/Alexander/JavaProjects/MMS-Service/src/main/resources/Attempt.scd";
    private Socket socket;
    private MmsPDU mmsPDU;
    private int id = 123; // device id
    private ServerSocket serverSocket;

    public Client() throws IOException {
        int serverPort = 9000;
        serverSocket = new ServerSocket(serverPort);
        mmsPDU = new MmsPDU();
        System.out.println("Приложение клиента запущено\n");

        Thread thread2 = new Thread(() -> {
            while (true) {

                Scanner Conscanner;
                try {
                    System.out.println("available services:\n" +
                            "Req - request making\n" +
                            "Acc - connect initialization\n" +
                            "Can - initialization cancel");

                    Conscanner = new Scanner(System.in);

                    if (Conscanner.hasNext()) { // console is not null

                        System.out.println("connection accepted");
                        PrintWriter printWriter;
                        String str = processUserCommand(Conscanner.nextLine());
                        if (str != null) { // if user command has sense
                            try {
                                socket = new Socket("localhost", clientPort);
                                printWriter = new PrintWriter(socket.getOutputStream(), true);
                                printWriter.println(str); // make request
                                printWriter.close();
                                System.out.println("message sended");
                            }
                            catch (SocketException e){

                            }
                            socket.close();

                        }
                        else {
                            System.out.println("некорректный запрос");
                        }
                    }




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();


        Thread thread = new Thread(() -> {
            while (true) {

                Scanner ServerScanner;
                try {

                    socket = serverSocket.accept();

                    ServerScanner = new Scanner(socket.getInputStream());

                    if (ServerScanner.hasNextLine()) { // got mes
                        String str = ServerScanner.nextLine();
                        System.out.println("u got message" );
                        mmsPDU.process(str, new IED(configLink, id));

                    }

                    socket.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


    }

    /**
     * метод обработки команд пользователя
     * @param str
     * @return
     */
    public String processUserCommand(String str){
        switch (str){
            case "Req":
                return setRequest();
            case "Acc":
                return setAssociation();
            case "Can":
                return new CancelRequest().build(String.valueOf(id));
            default:
                return null;

        }}

//        public String setUnconfirmedReq(){
//
//        }

        public String setAssociation(){
            String ret = "";
            System.out.println("Association");

            boolean boo = true;
            while (boo){
                System.out.println("What kind services u prefer to get: \n" +
                        "GetNameList [0]\n" +
                        "GetDataValues [1]\n" +
                        "SetDataValues [2]\n" +
                        "Enough [3]");

                int i = (new Scanner(System.in)).nextInt();
                switch (i){
                    case 0:
                        ret+="$GetNameList";
                        break;
                    case 1:
                        ret+="$GetDataValues";
                        break;
                    case 2:
                        ret+="$SetDataValues";
                        break;
                    case 3:
                        boo = false;
                        break;

                }
            }
            //lDevice1$SIMG1$SIMG1_Engine
            return new AssociationRequest().build(ret + " " + id);
        }

        public String setRequest(){
        String name;
        String type;
        String link ="";
        int choice;
        ArrayList<String> services = getServices();
        if(services==null){
            System.out.println("There's no services. Make association with IED or" +
                    " set new services before operating");
            return null;
        }
        System.out.println("You can choose next services:");
        int num = 0;
        for(String serv: services){
            System.out.println(serv + " ["+num+"]");
            num++;
        }
        services.add("Back" + " ["+num+"]");
        try{
            choice = Integer.parseInt((new Scanner(System.in)).nextLine());
        } catch (NumberFormatException e){
            System.out.println("U wrote wrong format. Repeat, please");
            return setRequest();
        };

            switch (services.get(choice)){
            case "GetNameList":
                System.out.println("Input parentClassOfList$ClassName: ");
                name = (new Scanner(System.in)).nextLine();
                System.out.println("Set type of class: ");
                type = (new Scanner(System.in)).nextLine();
                return new GetNameListRequest(link).build(name + " " + type);
                case "GetDataValues":

                    System.out.println("Input idClass: ");
                    name = (new Scanner(System.in)).nextLine();
                    return new GetDataValuesRequest(link).build(name);
                case "SetDataValues":
                    System.out.println("Input idClass$mean: ");
                    name = (new Scanner(System.in)).nextLine();
                    return new SetDataValuesRequest(link).build(name);
                case "Back":
                    return null;
                default:
                    return "puk";
            }
        }

    /**
     * получаем из лога информацию о доступных сервисах
     * @return
     */
    public ArrayList<String> getServices() {
        SCL scl = ConfigWorker.unMarshalAny(SCL.class, configLink);
        ArrayList<TS> services = scl.getIED().get(0).getServices().getServices();
        ArrayList<String> ss = new ArrayList<>();
        try{
            for(TS serv: services){
                ss.add(serv.getSs());

            }
        } catch (NullPointerException e){
            return null;
        }
        return ss;
    }



}

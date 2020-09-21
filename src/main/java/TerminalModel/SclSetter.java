package TerminalModel;

import CodeProcessing.ConfigWorker;
import IedStructure.IED;
import IedStructure.RootClass;
import IedStructure.SclClass;
import CodeProcessing.SclBodies.SCL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SclSetter extends RootClass {


    SclSetter(IED ied){
        setDad(ied);
        setType(SclClass.SCL);
    }
    @Override
    public void stop() {

    }

    @Override
    public void start() throws IOException {

            Thread thread = new Thread(() -> {
                while (true) {

                    SCL scl = ConfigWorker.unMarshalAny(SCL.class, ((IED) getDad()).getSclLink());
                    ArrayList<HashMap<String, Object>> arrayMap = getMeasures();
//                    for()
//
//                    for()

                        try {
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            });
            thread.start();
        }

    ArrayList<HashMap<String, Object>> getMeasures(){
        ArrayList<HashMap<String, Object>> aa = new ArrayList<>();
        ArrayList <RootClass> rt = getDad().getChilds(SclClass.LN_BODY);
        for(RootClass a: rt){
            HashMap<String, Object> asd = ((NodeConnector) a).getMeasMap();
            aa.add(asd);
        }
        return aa;
    }
}

package org.galapagos.mcmorning.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    //serialize 직렬화
    public static void save(String path, Object obj) throws Exception{
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(obj);
            oos.flush();
        } //자동으로 oos를 닫기위해 try를 씀
    }

    //deserialize 역직렬화
    public static Object load(String path) throws Exception {
        try (
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return ois.readObject();//인스턴스 복원}
        }
    }
}

package SystemForNationalIdAndPassport.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveListToFile<T> {
    String path ;

    public SaveListToFile(String path) {
        this.path = path;
    }

    @SuppressWarnings("unchecked")
    public List<T> openList() {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream get = new ObjectInputStream(file);
            list = (List<T>) get.readObject();

            file.close();
            get.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + path);
        } catch (IOException e) {
            System.out.println("Error initializing stream"+e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean saveListToFile(List<T> items){
        try{
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(items);
            o.close();
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found Exception."+ path);
            return false;
        } catch (IOException e){
            System.out.println("Error initializing stream."+ path);
            return false;
        }
        return true;
    }
}
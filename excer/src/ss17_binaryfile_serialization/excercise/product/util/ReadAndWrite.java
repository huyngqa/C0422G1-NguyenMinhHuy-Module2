package ss17_binaryfile_serialization.excercise.product.util;

import ss17_binaryfile_serialization.excercise.product.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<Product> readObjectToListProduct(String pathFile) {
        List<Product> products = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length() > 0) {
                inputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(inputStream);
                products = (List<Product>) objectInputStream.readObject();
            }

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file.length() > 0) {
                    inputStream.close();
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    public static void writeObjectToListProduct(String path, List<Product> products) {
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

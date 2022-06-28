package ss17_binaryfile_serialization.excercise.copy;

import java.io.*;

public class CopyFile {

    private static void copyFileUsingStream(File source, File target) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File sourceFile = new File("excer/src/ss17_binaryfile_serialization/excercise/copy/source.dat");
        File target = new File("excer/src/ss17_binaryfile_serialization/excercise/copy/target.dat");
        copyFileUsingStream(sourceFile, target);
        System.out.println("Số byte: " + target.length());
//        Path path = Paths.get("excer/src/ss17_binaryfile_serialization/excercise/copy/target.dat");
//        try {
//            System.out.println("Số byte: " + Files.size(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

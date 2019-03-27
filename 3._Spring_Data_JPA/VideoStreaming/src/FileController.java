import java.io.*;

public class FileController {

    public static void writeToFile(Twitch twitch) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("video.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(twitch);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException error) {
            System.out.println("File not found: " + error);
        } catch (IOException error) {
            System.out.println("IOException: " + error);
        }
    }

    public static void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("video.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Twitch twitch = (Twitch) objectInputStream.readObject();
            System.out.println(twitch);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

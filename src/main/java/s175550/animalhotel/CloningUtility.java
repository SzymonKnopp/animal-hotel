package s175550.animalhotel;

import java.io.*;

public class CloningUtility {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T objectToCopy) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(objectToCopy);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new IllegalStateException(exception);
        }
    }
}

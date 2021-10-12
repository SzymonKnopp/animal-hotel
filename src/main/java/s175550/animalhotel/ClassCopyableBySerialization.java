package s175550.animalhotel;

import java.io.*;

public class ClassCopyableBySerialization<T> implements Serializable {
    @SuppressWarnings("unchecked")
    public T deepCopy() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(this);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new IllegalStateException(exception);
        }
    }
}

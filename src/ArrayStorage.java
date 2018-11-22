import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] tempArray = new Resume[size];

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                do {
                    tempArray[i] = storage[i+1];
                    i++;
                } while (storage[i] != null);
                size--;
            } else {
                tempArray[i] = storage[i];
            }
        }
        storage = Arrays.copyOf(tempArray, tempArray.length);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
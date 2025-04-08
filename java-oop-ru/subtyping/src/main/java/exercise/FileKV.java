package exercise;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String filepath;
    private Map<String, String> storage;

    public FileKV(String filepath, Map<String, String> data) {
        this.filepath = filepath;
        this.storage = new HashMap<>(data);
        loadFromFile();
        saveToFile();
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    private void saveToFile() {
        Utils.writeFile(filepath, Utils.serialize(storage));
    }
    private void loadFromFile() {
        if (new File(filepath).exists()) {
            storage = Utils.deserialize(Utils.readFile(filepath));
        }
    }
}
// END

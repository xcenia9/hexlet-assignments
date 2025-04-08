package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testSetAndGet() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        assertEquals("value1", storage.get("key1", "default"));

        assertEquals("value1", Utils.deserialize(Utils.readFile(filepath.toString())).get("key1"));
    }

    @Test
    public void testGetNonExistingKey() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        assertEquals("default", storage.get("nonExistingKey", "default"));
    }

    @Test
    public void testUnsetKeyValue() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key2", "value2");
        storage.unset("key2");
        assertEquals("default", storage.get("key2", "default"));

        assertEquals(new HashMap<>(), Utils.deserialize(Utils.readFile(filepath.toString())));
    }

    @Test
    public void testMultipleSetsAndGets() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key3", "value3");
        storage.set("key4", "value4");

        assertEquals("value3", storage.get("key3", "default"));
        assertEquals("value4", storage.get("key4", "default"));

        HashMap<String, String> expectedData = new HashMap<>();
        expectedData.put("key3", "value3");
        expectedData.put("key4", "value4");

        assertEquals(expectedData, Utils.deserialize(Utils.readFile(filepath.toString())));
    }

    @Test
    public void testToMap() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key5", "value5");

        HashMap<String, String> expectedMap = new HashMap<>();
        expectedMap.put("key5", "value5");

        assertEquals(expectedMap, storage.toMap());

        assertEquals(expectedMap, Utils.deserialize(Utils.readFile(filepath.toString())));
    }
    // END
}

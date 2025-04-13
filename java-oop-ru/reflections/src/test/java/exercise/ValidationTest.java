package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() {
        // Тестовый случай 1: Все поля валидные
        Address validAddress = new Address("Russia", "Moscow", "Tverskaya", "10", "15");
        Map<String, List<String>> result1 = Validator.advancedValidate(validAddress);
        Map<String, List<String>> expected1 = new HashMap<>();
        assertEquals(expected1, result1);

        // Тестовый случай 2: Неверное значение поля country (длина меньше 4 символов)
        Address invalidCountryAddress = new Address("US", "New York", "Broadway", "20", "25");
        Map<String, List<String>> result2 = Validator.advancedValidate(invalidCountryAddress);
        Map<String, List<String>> expected2 = new HashMap<>();
        expected2.put("country", List.of("length less than 4"));
        assertEquals(expected2, result2);

        // Тестовый случай 3: Поле city пустое (null), остальные поля валидные
        Address emptyCityAddress = new Address("Canada", null, "Queen Street", "30", "35");
        Map<String, List<String>> result3 = Validator.advancedValidate(emptyCityAddress);
        Map<String, List<String>> expected3 = new HashMap<>();
        expected3.put("city", List.of("can not be null"));
        assertEquals(expected3, result3);

        // Тестовый случай 4: Несколько ошибок одновременно
        Address multipleErrorsAddress = new Address("Fr", "Paris", "", "40", "45");
        Map<String, List<String>> result4 = Validator.advancedValidate(multipleErrorsAddress);
        Map<String, List<String>> expected4 = new HashMap<>();
        expected4.put("country", List.of("length less than 4"));
        expected4.put("street", List.of("length less than 3")); // Так как значение пустая строка ""
        assertEquals(expected4, result4);
    }
    // END
}

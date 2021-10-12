package s175550.animalhotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;

@SpringBootTest
class ClassCopyableBySerializationTests {
    @AllArgsConstructor
    class TestClass extends ClassCopyableBySerialization<TestClass> implements Serializable {
        private boolean hasChanged;
    }

    @Test
    void when_originalChanged_expect_deepCopyNotToChange() {
        TestClass original = new TestClass(false);
        TestClass deepCopy = original.deepCopy();

        original.hasChanged = true;

        assert !deepCopy.hasChanged;
    }

}

package dev.sokarau;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AppTest {

    private final String mode;

    public AppTest(String mode) {
        this.mode = mode;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "file" },
                { "console" }
        });
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowErrorIfLaunchedWithoutModeParameter() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Mode parameter is missing");

        App.main(new String[0]);
    }

    @Test
    public void shouldNotThrowErrorWhenLaunchedWithValidMode() {
        assertDoesNotThrow(() -> {
            App.main(new String[] { mode });
        });
    }
}

package dev.sokarau;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AppTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowErrorIfLaunchedWithoutModeParameter() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Mode parameter is missing");

        App.main(new String[0]);
    }
}

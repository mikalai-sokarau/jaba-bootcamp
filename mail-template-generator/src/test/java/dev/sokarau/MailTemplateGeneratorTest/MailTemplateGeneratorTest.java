package dev.sokarau.MailTemplateGeneratorTest;

import java.util.Scanner;
import dev.sokarau.MailTemplateGenerator.MailTemplateGenerator;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MailTemplateGeneratorTest {

  @Test
  public void shouldAcceptInputFromConsoleWhenStartedInConsoleMode() {
    String userInput = "Input from console";
    Scanner scannerMock = mock(Scanner.class);
    when(scannerMock.nextLine()).thenReturn(userInput);

    new MailTemplateGenerator("console");

    assertEquals(userInput, scannerMock.nextLine());
  }
}
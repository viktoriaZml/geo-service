package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

  @Test
  void locale() {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    String message1 = localizationService.locale(Country.RUSSIA);
    Assertions.assertEquals("Добро пожаловать", message1);

    String message2 = localizationService.locale(Country.USA);
    Assertions.assertEquals("Welcome", message2);
  }
}
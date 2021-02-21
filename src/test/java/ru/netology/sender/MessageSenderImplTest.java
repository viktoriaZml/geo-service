package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

  @Test
  void test_send_russian_text() {
    GeoService geoService = Mockito.mock(GeoService.class);
    Mockito.when(geoService.byIp("172.")).thenReturn(new Location(null, Country.RUSSIA, null, 0));

    LocalizationService localizationService = Mockito.mock(LocalizationService.class);
    Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

    MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

    Map<String, String> headers = new HashMap<String, String>();
    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
    String expected = "Добро пожаловать";
    String result = messageSender.send(headers);
    Assertions.assertEquals(expected, result);
  }

  @Test
  void test_send_english_text() {
    GeoService geoService = Mockito.spy(GeoServiceImpl.class);

    LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

    MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

    Map<String, String> headers = new HashMap<String, String>();
    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
    String expected = "Welcome";
    String result = messageSender.send(headers);
    Assertions.assertEquals(expected, result);
  }
}
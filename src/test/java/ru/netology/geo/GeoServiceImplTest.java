package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {

  @Test
  void byIp() {
    GeoServiceImpl geoService = new GeoServiceImpl();
    Location location1 = geoService.byIp("172.193.0.21");
    Assertions.assertEquals(Country.RUSSIA,location1.getCountry());

    Location location2 = geoService.byIp("96.193.0.21");
    Assertions.assertEquals(Country.USA,location2.getCountry());
  }
}
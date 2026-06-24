package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.world.Country;
import java.util.List;

public interface WorldService {

    List<Country> findAllCountries();

}

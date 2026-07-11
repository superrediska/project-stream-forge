package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.domain.world.CountryLanguage;
import io.hammerhall.streamforge.repository.WorldRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class WorldServiceImpl implements WorldService {

    private final Map<String, Country> countries;
    private final Map<Integer, City> cities;
    private final List<CountryLanguage> languages;

    public WorldServiceImpl(WorldRepository worldRepository) {
        countries = worldRepository.getCountries();
        cities = worldRepository.getCities();
        languages = worldRepository.getLanguages();
    }

    @Override
    public Collection<Country> findAllCountries() {
        return new ArrayList<>(countries.values());
    }

    @Override
    public Collection<City> findAllCities() {
        return new ArrayList<>(cities.values());
    }

    @Override
    public Collection<CountryLanguage> findAllLanguages() {
        return new ArrayList<>(languages);
    }
}

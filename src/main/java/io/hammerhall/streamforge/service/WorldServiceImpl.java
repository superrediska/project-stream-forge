package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.repository.WorldRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorldServiceImpl implements WorldService {

    private final Map<String, Country> countries;

    public WorldServiceImpl(WorldRepository worldRepository) {
        countries = worldRepository.getCountries();
    }

    @Override
    public List<Country> findAllCountries() {
        return new ArrayList<>(countries.values());
    }

}

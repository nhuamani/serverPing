package com.nhuamani.serverPing.services.implementation;

import java.util.Collection;

import com.nhuamani.serverPing.models.Server;
import com.nhuamani.serverPing.services.ServerService;


public class ServerServiceImplementation implements ServerService {
    @Override
    public Server create(Server server) {
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}

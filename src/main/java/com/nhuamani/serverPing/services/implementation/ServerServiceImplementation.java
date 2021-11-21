package com.nhuamani.serverPing.services.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nhuamani.serverPing.models.Server;
import com.nhuamani.serverPing.services.ServerService;
import com.nhuamani.serverPing.repository.ServerRepository;
import com.nhuamani.serverPing.enums.Status;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;


@RequiredArgsConstructor
@Service
@Slf4j
public class ServerServiceImplementation implements ServerService {

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by ID: {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by ID: {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = { "Server1.png", "Server2.png", "Server3.png", "Server4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/servers/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }

}

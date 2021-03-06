package com.nhuamani.serverPing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.nhuamani.serverPing.enums.Status;
import com.nhuamani.serverPing.models.Server;
import com.nhuamani.serverPing.repository.ServerRepository;

/**
 * @author nhuamani
 * @version 1.0
 * @since 21/11/2021
 */

@SpringBootApplication
public class ServerPingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerPingApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC","http://localhost:8080/api/servers/image/server1.png", Status.SERVER_UP,null));
			serverRepository.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower","http://localhost:8080/api/servers/image/server2.png", Status.SERVER_DOWN,null));
			serverRepository.save(new Server(null, "192.168.1.21", "MS 2008", "32 GB", "Web Server", "http://localhost:8080/api/servers/image/server3.png", Status.SERVER_UP,null));
			serverRepository.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost:8080/api/servers/image/server4.png", Status.SERVER_DOWN,null));
		};
	}

}

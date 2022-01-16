package com.nhuamani.serverPing.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import com.nhuamani.serverPing.enums.Status;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servers")
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // UUID id
    @Column(unique = true)
    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    // Hibernate
    //@Column(name = "created_at")
    //@CreationTimestamp
    //private Date createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
}

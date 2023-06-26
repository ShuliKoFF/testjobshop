package ru.shrf.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shrf.testjob.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("clientRepositoryBean")
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select distinct c from clients c where c.uuid = ?1")
    Optional<Client> findByUUID(UUID uuid);
}

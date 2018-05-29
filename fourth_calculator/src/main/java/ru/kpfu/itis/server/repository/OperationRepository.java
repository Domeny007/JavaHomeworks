package ru.kpfu.itis.server.repository;

import ru.kpfu.itis.server.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>, Serializable {
}

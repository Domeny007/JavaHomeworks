package ru.itis.kpfu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.kpfu.models.MathOper;
import ru.itis.kpfu.models.User;

@Repository
public interface MathOperRepository extends JpaRepository<MathOper, Long> {
    MathOper findByOwner(User owner);
}

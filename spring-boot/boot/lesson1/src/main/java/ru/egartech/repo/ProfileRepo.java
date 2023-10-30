package ru.egartech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.egartech.entity.Profile;

import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {
    @Query("SELECT p FROM Profile p WHERE p.lastName = :lastName")
    Optional<Profile> findProfileWithMyLastName(String lastName);

    Optional<Profile> findProfileByFirstNameAndAgeGreaterThan(String firstName, Integer ageBound);
}

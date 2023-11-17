package org.example.listener;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepo extends JpaRepository<Profile, UUID> {
}

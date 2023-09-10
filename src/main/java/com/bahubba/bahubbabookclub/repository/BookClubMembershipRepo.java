package com.bahubba.bahubbabookclub.repository;

import com.bahubba.bahubbabookclub.model.entity.BookClubMembership;
import com.bahubba.bahubbabookclub.model.enums.BookClubRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * JPA Repository for the {@link BookClubMembership} entity
 */
@Repository
public interface BookClubMembershipRepo extends JpaRepository<BookClubMembership, UUID> {
    Optional<BookClubMembership> findByBookClubNameAndReaderId(String bookClubName, UUID readerId);

    Optional<BookClubMembership> findByBookClubIdAndReaderId(UUID bookClubId, UUID readerId);

    Boolean existsByBookClubIdAndReaderId(UUID bookClubId, UUID readerId);

    Optional<BookClubMembership> findByBookClubNameAndClubRoleAndReaderId(String bookClubName, BookClubRole role, UUID readerId);

    List<BookClubMembership> findAllByBookClubNameOrderByJoined(String bookClubName);
}

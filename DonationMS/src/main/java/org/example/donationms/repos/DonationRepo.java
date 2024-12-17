package org.example.donationms.repos;

import org.example.donationms.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation,Long> {
}

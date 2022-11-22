package com.batrawy.stc.clinicmanagementsystem.repository;

import com.batrawy.stc.clinicmanagementsystem.model.CancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationReasonRepository extends JpaRepository<CancellationReason, Long> {
}

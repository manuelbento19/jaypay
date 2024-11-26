package com.bentoo.jaypay.repository;

import com.bentoo.jaypay.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITransferRepository extends JpaRepository<Transfer, UUID> {

}

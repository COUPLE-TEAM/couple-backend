package com.couple.love.domain.couple.repository;

import com.couple.love.domain.couple.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long>, CoupleRepositoryCustom {

}

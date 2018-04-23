package com.girl.repository;

import com.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Black
 * @time 2018/4/22.
 */

public interface GirlRepository extends JpaRepository<Girl, Integer> {
}



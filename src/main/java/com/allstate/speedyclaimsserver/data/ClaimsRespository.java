package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimsRespository extends JpaRepository<Claims, Integer> {
    public List<Claims> findAllByCustlname(String custlname);
    public List<Claims> findAllByPolicynumber(Integer policynumber);
}

package com.example.KTGK_LapTrinhJava.Repository;

import com.example.KTGK_LapTrinhJava.Model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan,Long> {

}

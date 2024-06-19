package com.example.KTGK_LapTrinhJava.Repository;

import com.example.KTGK_LapTrinhJava.Model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, Long> {
}

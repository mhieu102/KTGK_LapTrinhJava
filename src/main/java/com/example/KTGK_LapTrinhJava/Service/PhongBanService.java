package com.example.KTGK_LapTrinhJava.Service;

import com.example.KTGK_LapTrinhJava.Model.PhongBan;
import com.example.KTGK_LapTrinhJava.Repository.IPhongBanRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongbanRepository;

    public PhongBan getPhongBanById(Long id){
        return phongbanRepository.findById(id).orElse(null);
    }

    public void addPhongBan(PhongBan phongban){
        phongbanRepository.save(phongban);
    }

    public List<PhongBan> getAllPhongBans(){
        return phongbanRepository.findAll();
    }

    public void deletePhongBan(Long id){
        phongbanRepository.deleteById(id);
    }

    public void updatePhongBan(@NotNull PhongBan phongban) {
        if (phongban == null || phongban.getId() == null) {
            throw new IllegalArgumentException("Phòng ban không hợp lệ");
        }

        PhongBan existingPhongBan = getPhongBanById(phongban.getId());

        existingPhongBan.setMaPhong(phongban.getMaPhong());
        existingPhongBan.setTenPhong(phongban.getTenPhong());

        phongbanRepository.save(existingPhongBan);
    }
}

package com.example.KTGK_LapTrinhJava.Service;

import com.example.KTGK_LapTrinhJava.Model.NhanVien;
import com.example.KTGK_LapTrinhJava.Repository.INhanVienRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanvienRepository;

    public NhanVien getNhanVienById(Long id){
        return nhanvienRepository.findById(id).orElse(null);
    }

    public void addNhanVien(NhanVien nhanvien){
        nhanvienRepository.save(nhanvien);
    }

    public List<NhanVien> getAllNhanViens(){
        return nhanvienRepository.findAll();
    }

    public void deleteNhanVien(Long id){
        nhanvienRepository.deleteById(id);
    }

    public void updateNhanVien(@NotNull NhanVien nhanvien){
        if (nhanvien == null || nhanvien.getId() == null) {
            throw new IllegalArgumentException("Invalid book object");
        }

        NhanVien existingNhanVien = getNhanVienById(nhanvien.getId());

        existingNhanVien.setMaNV(nhanvien.getMaNV());
        existingNhanVien.setTenNV(nhanvien.getTenNV());
        existingNhanVien.setPhai(nhanvien.getPhai());
        existingNhanVien.setNoiSinh(nhanvien.getNoiSinh());
        existingNhanVien.setLuong(nhanvien.getLuong());
        existingNhanVien.setPhongban(nhanvien.getPhongban());


        nhanvienRepository.save(existingNhanVien);
    }
}

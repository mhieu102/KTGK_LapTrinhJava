package com.example.KTGK_LapTrinhJava.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaPhong")
    @NotNull(message = "Price is required")
    private String MaPhong;

    @Column(name = "TenPhong")
    private String TenPhong;

    @OneToMany(mappedBy ="phongban", cascade = CascadeType.ALL)
    private List<NhanVien> nhanviens;
}

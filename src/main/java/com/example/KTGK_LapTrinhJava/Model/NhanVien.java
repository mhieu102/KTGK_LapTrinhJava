package com.example.KTGK_LapTrinhJava.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaNV")
    @NotEmpty(message = "MaNV ?")
    @Size(max = 50, min = 1, message = "Không vượt quá 50 ký tự")
    private String MaNV;

    @Column(name = "TenNV")
    @NotEmpty(message = "Tên NV?")
    @Size(max = 50, min = 1, message = "Không vượt quá 50 ký tự")
    private String TenNV;

    @Column(name = "Phai")
    private String Phai;

    @Column(name = "NoiSinh")
    private String NoiSinh;

    @Column(name = "Luong")
    @NotNull(message = "Price is required")
    private int Luong;


    @ManyToOne
    @JoinColumn(name ="phongban_id")
    private PhongBan phongban;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

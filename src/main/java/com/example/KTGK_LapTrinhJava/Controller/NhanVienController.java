package com.example.KTGK_LapTrinhJava.Controller;


import com.example.KTGK_LapTrinhJava.Model.NhanVien;
import com.example.KTGK_LapTrinhJava.Service.NhanVienService;
import com.example.KTGK_LapTrinhJava.Service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private final NhanVienService nhanvienService;

    @Autowired
    private final PhongBanService phongbanService;


    @GetMapping
    public String showAllNhanViens(Model model){
        List<NhanVien> nhanviens = nhanvienService.getAllNhanViens();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

    @GetMapping("/")
    public String home(){ return "home/index";}

    @GetMapping("/add")
    public String addNhanVienForm(Model model) {
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("phongbans",phongbanService.getAllPhongBans());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("phongbans",phongbanService.getAllPhongBans());
            return "nhanvien/add";
        }
        nhanvienService.addNhanVien(nhanvien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") Long id) {
        nhanvienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NhanVien nhanvien = nhanvienService.getNhanVienById(id);
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongbans", phongbanService.getAllPhongBans());
        return "/nhanvien/edit";
    }

    //test
    @PostMapping("/edit/{id}")
    public String updateNhanVien(@PathVariable("id") Long id, @Valid NhanVien nhanvien,BindingResult result) {
        if (result.hasErrors()) {
            nhanvien.setId(id);
            return "/nhanVien/edit";
        }
        nhanvienService.updateNhanVien(nhanvien);

        return "redirect:/nhanviens";
    }
}

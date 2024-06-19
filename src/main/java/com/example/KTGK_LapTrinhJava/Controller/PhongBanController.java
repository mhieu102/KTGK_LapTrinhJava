package com.example.KTGK_LapTrinhJava.Controller;


import com.example.KTGK_LapTrinhJava.Model.PhongBan;
import com.example.KTGK_LapTrinhJava.Service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phongbans")
public class PhongBanController {
    @Autowired
    private final PhongBanService phongbanService;

    @GetMapping("/add")
    public String addPhongBanForm(Model model) {
        model.addAttribute("phongban", new PhongBan());
        return "phongban/add";
    }
    @PostMapping("/add")
    public String addPhongBan(@Valid PhongBan phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "phongban/add";
        }
        phongbanService.addPhongBan(phongban);
        return "redirect:/phongbans";
    }
    // Hiển thị danh sách danh mục
    @GetMapping
    public String showAllPhongBans(Model model) {
        List<PhongBan> phongbans = phongbanService.getAllPhongBans();
        model.addAttribute("phongbans", phongbans);
        return "phongban/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        PhongBan phongban = phongbanService.getPhongBanById(id);
        model.addAttribute("phongban", phongban);
        return "/phongban/edit";
    }
    // POST request to update category
    @PostMapping("/edit/{id}")
    public String updatePhongBan(@PathVariable("id") Long id, @Valid PhongBan phongban,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            phongban.setId(id);
            return "/phongban/edit";
        }
        phongbanService.updatePhongBan(phongban);
        model.addAttribute("phongbans", phongbanService.getAllPhongBans());
        return "redirect:/phongbans";
    }


    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") Long id) {
        phongbanService.deletePhongBan(id);
        return "redirect:/phongbans";
    }
}

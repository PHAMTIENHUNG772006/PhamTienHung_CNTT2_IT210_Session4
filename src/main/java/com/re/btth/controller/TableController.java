package com.re.btth.controller;

import com.re.btth.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Controller
@RequestMapping("/admin/tables")
public class TableController {

    @Autowired
    @Qualifier("tableServicePractice")
    private TableService tableService;


    @GetMapping("/list")
    public String listTables(@RequestParam(value = "cap", required = false, defaultValue = "0") int cap, ModelMap model) {
        if (cap < 0) {
            model.addAttribute("error", "Sức chứa không được là số âm");
            model.addAttribute("tables", tableService.getAllTables());
        } else {
            model.addAttribute("tables", tableService.getTablesByCapacity(cap));
            model.addAttribute("message", "Đang hiển thị các bàn có sức chứa từ: " + cap);
        }
        return "table-list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("table-detail");

        Object table = tableService.getTableById(id);

        if (table != null) {
            mav.addObject("ban", table);
        } else {
            mav.addObject("error", "Không tìm thấy bàn có ID: " + id);
        }
        return mav;
    }

    @PostMapping("/delete/{id}")
    public String deleteTable(@PathVariable("id") int id) {
        tableService.deleteTable(id);
        return "redirect:/admin/tables/list";
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(ModelMap model) {
        model.addAttribute("error", "Định dạng ID hoặc tham số không hợp lệ. Vui lòng nhập số!");
        return "error-page";
    }
}

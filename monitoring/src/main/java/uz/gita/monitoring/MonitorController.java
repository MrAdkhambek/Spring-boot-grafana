package uz.gita.monitoring;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("api/v1")
public class MonitorController {

    @GetMapping("/monitor")
    public String userRequest(Model model) {
        return "gender";
    }
}

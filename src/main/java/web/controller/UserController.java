package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDaoImp;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDaoImp userDaoImp;

    @Autowired
    public UserController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }


    // получим список всех user и передадим на отображение в представление
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userDaoImp.index());
        return "user/index";
    }

    // получим одно юзера по его id из DAO и передадим на отображение в представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImp.show(id));
        return "user/show";
    }


}

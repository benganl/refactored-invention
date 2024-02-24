package za.co.wyzetect.smartcontract.web;

import java.io.Serializable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(name = "indexController", value = {"/"})
public class IndexController implements Serializable {
  private static final long serialVersionUID = 1L;

  @RequestMapping(name = "siteIndex", path = {"/", "/index", "/home"})
  protected String index(Model model) {
    model.addAttribute("message", "Hello, world!!!");
    return "index";
  }
}

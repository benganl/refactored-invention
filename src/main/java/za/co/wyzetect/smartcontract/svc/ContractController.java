package za.co.wyzetect.smartcontract.svc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/svc")
public class ContractController {

  // @GetMapping("/")
  // @RequestMapping(value = "hello")
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {
    return "Hello, world from Spring Framework!!!";
  }

}

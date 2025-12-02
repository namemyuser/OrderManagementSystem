package ios.ordermanagementsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
        <h2>Order Management System API</h2>
                <ul>
                         <li>GET + POST /customers ...</li>
                         <li>GET + POST /orders ...</li>
                         <li>GET + POST /products ...</li>
                         <li>GET + POST /serviceitems ...</li>
                         <li>GET + POST /contractlines ...</li>
                         <li>GET + POST /contracttypes ...</li>
                         <li>GET + POST /allsellableitems ...</li>
                         <li>GET + POST /units ...</li>
                         <li>GET + POST /orderlines ...</li>
                         <li>GET + POST /contracts ...</li>
                     </ul>
                
        """;
    }
}

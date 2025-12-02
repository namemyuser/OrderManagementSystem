package ios.ordermanagementsystem.Controller;

import ios.ordermanagementsystem.Model.SellableItem;
import ios.ordermanagementsystem.Service.SellableItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sellableitems")
public class SellableItemController {

    private final SellableItemService sellableItemService;

    public SellableItemController(SellableItemService sellableItemService) {
        this.sellableItemService = sellableItemService;
    }

    @GetMapping
    public List<SellableItem> getAllSellableItems() {
        return sellableItemService.getAllItems();
    }
}

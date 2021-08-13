package Good;

import Good.DTOs.CreateGoodDTO;

public class GoodController {
    public static void createGood(String body) {
        System.out.println(body);
        // преобразуем json body в CreateGoodDTO
        // CreateGoodDTO data = {};
        // GoodService.createGood(data);
    }
}

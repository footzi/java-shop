package Good;

import Good.DTOs.CreateGoodDTO;

public class GoodService {
    public static void createGood(CreateGoodDTO data) {
        Good good = new Good(data);

        GoodRepository.saveGood(good);
        // вызываем методы GoodRepository на сохранение товара в БД
    }
}

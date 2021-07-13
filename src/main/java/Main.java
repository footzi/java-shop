import Goods.Good;
import Goods.GoodsController;

public class Main {
    public static void main(String[] args) {
         getAllGoods();
         getGood();
//        saveGood();
    }

    public static void getGood() {
        String json = new GoodsController().getGoodById("1");;
        System.out.println("Найден товар: " + json);
    }

    public static void saveGood() {
        String name = "Chocolate";
        int price = 10000;

        new GoodsController().saveGood(name, price);
    }

    public static void getAllGoods() {
        String json = new GoodsController().getAllGoods();
        System.out.println("Список всех товаров: " + json);
    }

}

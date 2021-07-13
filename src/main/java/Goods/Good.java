package Goods;

public class Good implements IGood {
    int id = 0;
    String name = "";
    int price = 0;

    public Good(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

package com.java_shop.Goods;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsData {
    public void saveGood(Good good) {
        try {
            String path = "./DB/goods/good_" + good.id + ".json";

            Gson gson = new Gson();
            Writer writer = new FileWriter(path);
            gson.toJson(good, writer);
            writer.close();
        } catch (Exception error) {
            System.out.println(error);
        }
    }


    // Возможно это стоит делать прямо в дата а не в контроллере
    public int getLastGoodId() {
        try {
            File folder = new File("./DB/goods");
            File[] listFiles = folder.listFiles();

            long countFiles = Arrays.stream(listFiles).count();

            return (int) countFiles + 1;
        } catch (Exception error) {
            System.out.println(error);

            return 0;
        }
    }

    public Good getGoodById(String id) {
        try {
            String path = "./DB/goods/good_" + id + ".json";
            File file = new File(path);

            if (!file.exists()) {
                throw new Exception("Товар по данному ID не найден");
            }

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Gson gson = new Gson();
            Good good = gson.fromJson(bufferedReader, Good.class);

            fileReader.close();

            return good;

        } catch (Exception error) {
            System.out.println(error);

            return null;
        }
    }

    // List<Good>
    public List<Good> getAllGoods() {
        File folder = new File("./DB/goods");
        File[] listFiles = folder.listFiles();
        List<Good> listGoods = new ArrayList();

        try {
            if (listFiles == null) {
                return listGoods;
            }

            for (File file : listFiles) {
                if (file.isFile() && file.exists()) {
                    String fileName = file.getPath();
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    Gson gson = new Gson();
                    Good good = gson.fromJson(bufferedReader, Good.class);

                    fileReader.close();

                    listGoods.add(good);
                }
            }

            return listGoods;
        } catch (Exception error) {
            System.out.println(error);
            return null;
        }
    }
}

package com.example.aplikasimenumcd;

import java.util.ArrayList;

public class McdData {
    private static String[] mcdfoodName = {
            "Bubur Ayam McD",
            "Chicken Muffin",
            "Egg and Cheese Muffin",
            "Triple Burger with Cheese",
            "Sausage Wrap",
            "PaNas 2 with Fries",
            "Honey Garlic Chicken Rice McD",
            "Lemon Cake",
            "Choco Chip Muffin",
            "Hot Chocolate",
            "Iced Coffee Float",
            "Iced Lychee Tea",
            "McFlurry feat. Oreo",
            "Chocolate Sundae"
    };

    private static String[] mcdfoodPrice = {
            "Rp 11.500",
            "Rp 23.000",
            "Rp 15.000",
            "Rp 43.500",
            "Rp 22.000",
            "Rp 54.000",
            "Rp 17.000",
            "Rp 32.000",
            "Rp 22.000",
            "Rp 24.000",
            "Rp 20.000",
            "Rp 19.500",
            "Rp 11.500",
            "Rp 10.500"
    };

    private static String[] mcdfoodDetail = {
            "Bubur ayam klasik disajikan dengan seledri dan bawang goreng renyah, tersedia jam 5-11 pagi",
            "Setangkup English muffin hangat dilapis saus mayonais dengan daging ayam olahan yang digoreng dengan sempurna. Tersedia dari jam 5-11 pagi.",
            "Perpaduan scrambled egg dan keju gurih dalam setangkup English Muffin hangat. Tersedia dari jam 5-11 pagi.",
            "Perpaduan roti burger dengan 3 Lapisan daging gurih dan 2 lapisan keju, saus tomat, acar, potongan bawang dan mustard.",
            "Perpaduan sosis ayam, scrambled egg, dan keju gurih dalam balutan tortilla yang lembut. Tersedia dari jam 5-11 pagi.",
            "2 pcs Ayam Goreng khas McDonald's dengan kentang goreng dan minuman FruitTea lemon yang menyegarkan. Tersedia dalam pilihan Ayam Krispy atau Spicy",
            "Nasi hangat dengan topping daging ayam disajikan dengan saus honey garlic",
            "Cake vanilla dengan cream rasa lemon segar bertaburkan cake crumbs",
            "Muffin McCafe lembut dengan taburan choco chip",
            "Minuman coklat kaya rasa yang dipadu dengan susu khas McCafe",
            "Es kopi 100% Arabika dengan susu yang segar dan tambahan es krim vanilla khas McDonald's",
            "Iced tea dengan rasa dan sensasi buah leci asli",
            "Es krim vanilla lembut dengan campuran biskuit Oreo Crumbs",
            "Es krim vanilla lembut dengan pilihan topping saus coklat"
    };

    private  static int[] mcdfoodImg = {
            R.drawable.bubur_ayam,
            R.drawable.chicken_muffin,
            R.drawable.egg_cheese_muffin,
            R.drawable.triple_burger_with_cheese,
            R.drawable.sausage_wrap,
            R.drawable.panas2_with_fries,
            R.drawable.honey_garlic_chicken_rice,
            R.drawable.lemon_cake,
            R.drawable.muffin,
            R.drawable.hot_chocolate,
            R.drawable.iced_coffee_float,
            R.drawable.iced_lychee_tea,
            R.drawable.mcflurry,
            R.drawable.sundae
    };

    static ArrayList<Mcd> getListData() {
        ArrayList<Mcd> list = new ArrayList<>();
        for (int position = 0 ; position <mcdfoodName.length; position++) {
            Mcd mcd = new Mcd();
            mcd.setName(mcdfoodName[position]);
            mcd.setPrice(mcdfoodPrice[position]);
            mcd.setDetail(mcdfoodDetail[position]);
            mcd.setPhoto(mcdfoodImg[position]);
            list.add(mcd);

        }
        return list;
    }

}
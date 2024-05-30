package com.hry;

public class Main {
    public static void main(String[] args) {

        // Telescoping Constructor
        NutritionFactsTelescopingCons cocaCola1 =
                new NutritionFactsTelescopingCons(240, 8, 100, 0, 35, 27);

        // JavaBeans
        NutritionFactsJavaBeans cocaCola2 = new NutritionFactsJavaBeans();
        cocaCola2.setServingSize(240);
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setSodium(35);
        cocaCola2.setCarbohydrate(27);

        // Builder pattern
        NutritionFactsBuilder cocaCola3 = new NutritionFactsBuilder.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();

    }
}
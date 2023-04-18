package com.example.firstproject.ioc;

public class Chef {
    //셰프는 식재료 공장을 알고있음
    private IngredientFactory ingredientFactory;
    //셰프가 식재료 공장과 협업하기 위한 DI
    public Chef(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public String cook(String menu) {
        //재료 준비
        Ingredient ingredient = ingredientFactory.get(menu);
        //요리 반환
        return beef.getName() + "으로 만든 " + menu;
    }
}

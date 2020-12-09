package domain.service;

import domain.model.Meals;

import java.util.ArrayList;
import java.util.List;

public class MealsService {

    private static MealsService INSTANCE;
    private List<Meals> meals = new ArrayList<Meals>();

    public MealsService() {
        meals.add(new Meals("Niet-veggie Lasagne","Pasta",4.50,"Met vlees en extra kaas"));
        meals.add(new Meals("Veggie lasagne","Pasta",4.00,"Vegetarisch zonder kaas"));
        meals.add(new Meals("Broodje kaas","Broodje", 2.50, "Met kaas en glutenvrij"));
        meals.add(new Meals("Tonijn Wrap","Wrap", 2.90, "Met tonijn en glutenvrij"));
        meals.add(new Meals("Broodje groenten","Broodje", 2.50, "Met alleen groenten"));
        meals.add(new Meals("Broodje boulet","Broodje", 3.0,"Met boulet en gluten"));
        meals.add(new Meals("Kip Wrap","Wrap", 3.10, "Met kip en gluten"));
        meals.add(new Meals("Spagheti bolongaise","Pasta", 5.00, "Met vlees en gluten"));
        meals.add(new Meals("Tomatensoep", "Soep", 3.75, "Vegetarisch"));
        meals.add(new Meals("Broodje hesp", "Broodje", 3.00, "Met vlees en gluten"));
        meals.add(new Meals("Kippensoep", "Soep", 4.00, "Met vleesballetjes"));
        meals.add(new Meals("Broodje kaas", "Broodje", 2.50, "Vegetarisch, bevat lactose en gluten"));
    }

    public static MealsService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MealsService();
        }
        return INSTANCE;
    }

    public List<Meals> getAllMeals () {
        return meals;
    }

    public void add (Meals meals) {
        this.meals.add(meals);
    }

    public List<Meals> sortMeals(){
        List<Meals> sortedList = new ArrayList<Meals>();

        sortedList.add(new Meals("Broodjes:","",0, ""));
        sortedList.addAll(sort("Broodje"));
        sortedList.add(new Meals("Pastas:","",0, ""));
        sortedList.addAll(sort("Pasta"));
        sortedList.add(new Meals("Wrap:","",0, ""));
        sortedList.addAll(sort("Wrap"));
        sortedList.add(new Meals("Soep:","",0, ""));
        sortedList.addAll(sort("Soep"));
        return sortedList;
    }

    public List<Meals> sort(String typeName){
        List<Meals> sortedList = new ArrayList<Meals>();

        for (Meals b: meals) {
            if (b.getTypeName() == typeName)
                sortedList.add(b);
        }
        sortedList.add(new Meals("","",0, ""));
        return sortedList;
    }
}

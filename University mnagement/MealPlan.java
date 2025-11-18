package universitymanagement;

class MealPlan {
	private String planType;
    private int mealsPerWeek;
    
    public MealPlan(String planType, int mealsPerWeek) {
        this.planType = planType;
        this.mealsPerWeek = mealsPerWeek;
    }
    
    public String getPlanType() { return planType; }
    public int getMealsPerWeek() { return mealsPerWeek; }
}
}

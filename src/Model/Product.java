package Model;

import java.util.Arrays;

public class Product {
	
	private int Menu;
    private int Bread;
    private int Topping[];
    private int Vegetable[];
    private int Sauce[];
    private int Set;
    
    public Product() {
		super();
	}

	public Product(int menu, int bread, int[] topping, int[] vegetable, int[] sauce, int set) {
        Menu = menu;
        Bread = bread;
        Topping = topping;
        Vegetable = vegetable;
        Sauce = sauce;
        Set = set;
    }

    public int getMenu() {
        return Menu;
    }

    public void setMenu(int menu) {
        Menu = menu;
    }

    public int getBread() {
        return Bread;
    }

    public void setBread(int bread) {
        Bread = bread;
    }

    public String getTopping() {
        return Arrays.toString(Topping);
    }

    public void setTopping(int[] topping) {
        Topping = topping;
    }

    public String getVegetable() {
        return Arrays.toString(Vegetable);
    }

    public void setVegetable(int[] vegetable) {
        Vegetable = vegetable;
    }

    public String getSauce() {
        return Arrays.toString(Sauce);
    }

    public void setSauce(int[] sauce) {
        Sauce = sauce;
    }

    public int getSet() {
        return Set;
    }

    public void setSet(int set) {
        Set = set;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Menu: "+ getMenu() + "\t Bread: " + getBread() + "\t Topping:" + getTopping() +  "\t Vegetable:" + getVegetable() + "\t Sauce:" + getSauce() + "Set:" + getSet();
	}

	
}

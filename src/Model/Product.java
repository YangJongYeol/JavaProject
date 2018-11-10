package Model;

public class Product {
    private int Menu;
    private int Bread;
    private int Topping[];
    private int Vegetable[];
    private int Sauce[];
    private int Set;

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

    public int[] getTopping() {
        return Topping;
    }

    public void setTopping(int[] topping) {
        Topping = topping;
    }

    public int[] getVegetable() {
        return Vegetable;
    }

    public void setVegetable(int[] vegetable) {
        Vegetable = vegetable;
    }

    public int[] getSauce() {
        return Sauce;
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
}

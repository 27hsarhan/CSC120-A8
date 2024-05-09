import java.util.ArrayList;

public class Character implements Contract {

    double size;
    int XCoord = 0;
    int YCoord = 0;
    ArrayList<String> itemsList = new ArrayList<>(); 

    public Character() {
    }

    public void grab(String item) {
        this.itemsList.add(item);
        System.out.println(item + " grabbed!");
    }

    public void drop(String item) {
        this.itemsList.remove(item);
        System.out.println(item + " dropped!");
    }

    void examine(String item) {
        System.out.println("Examining " + item);
    }

    void use(String item) {
        System.out.println("Using " + item);
        this.drop(item);
    }

    boolean walk(String direction) {
        System.out.println(direction);
        switch (direction.toLowerCase()) { 
            case "north":
                this.YCoord++;
                break; 
            case "south":
                this.YCoord--;
                break;
            case "east":
                this.XCoord++;
                break;
            case "west":
                this.XCoord--;
                break;
            default:
                System.out.println("Invalid direction.");
                return false;
        }
        return true;
    }

    boolean fly(int x, int y) {
        this.XCoord = x;
        this.YCoord = y;
        int flyingRadius = 3; 
        if (Math.abs(this.XCoord - x) > 3 || Math.abs(this.YCoord - y) > 3) {
            return false;
        }
        return true;
    }

    double shrink() {
        this.size = this.size / 2;
        return this.size; 
    }

    double grow() {
        this.size = this.size * 2;
        return this.size; 
    }

    public void rest() {
        System.out.println("Resting.");
    }

    public void undo() {
        System.out.println("Undoing.");
    }

    public void printInventory() {
        System.out.println("Inventory:");
        for (String item : this.itemsList) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        Character character = new Character();
        System.out.println(character);
    }
}

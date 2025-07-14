public class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}
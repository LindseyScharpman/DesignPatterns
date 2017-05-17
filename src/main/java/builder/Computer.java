package builder;

// Builder模式相对于直接写多个构造器来说更灵活
// 假设有5个成员变量需要设置,并且每个成员变量可选的设置值
// 那么如果通过构造器来设置,那么构造器要么参数过长要么构造器数量太多,这显然不太好....
// 当然也可以提供setter方法,setter相对Builder来说操作略微繁琐
// 并且可能会出现状态不一致的情况,也不便于对集中对参数进行检查
public class Computer {

    private String board;
    private String cpu;
    private double price;
    private double weight;
    private boolean isSSD;


    public static class Builder {

        private String board;
        private String cpu;
        private double price;
        private double weight;
        private boolean isSSD;

        public Builder board(String board) {
            this.board = board;
            return this;
        }

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        // 返回Builder本身便于链式操作
        public Builder isSSD(boolean isSSD) {
            this.isSSD = isSSD;
            return this;
        }

        // Builder模式核心,把自己传过去,避免了构造器参数过长或者构造器数量太多
        public Computer build() {
            return new Computer(this);
        }

    }

    // 设置成private防止通过构造器来构造...:)
    private Computer(Builder builder) {
        this.board = builder.board;
        this.cpu = builder.cpu;
        this.isSSD = builder.isSSD;
        this.price = builder.price;
        this.weight = builder.weight;
    }

    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .board("Dell")
                .cpu("i5")
                .isSSD(false)
                .price(3699)
                .weight(3)
                .build();
        System.out.println(computer);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "board='" + board + '\'' +
                ", cpu='" + cpu + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", isSSD=" + isSSD +
                '}';
    }
}

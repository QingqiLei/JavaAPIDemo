package enumeration;


public enum Color implements Info {
    RED(10) {   // with a parameter, so it needs the constructor with parameter
        public String getColor2() {
            return "red";
        }

        ;}, GREEN(20) {
        public String getColor2() {
            return "green";
        }
    }, BLUE {    // needs the constructor without parameter
        public String getColor2() {
            return "blue";
        }
    };
    private int color;

    private Color() {
        System.out.println("constructor without parameter");
    }

    private Color(int color) {
        this.color = color;
        System.out.println("constructor with parameter");
    }

    public abstract String getColor2();


    @Override
    public int getColor() {
        return color;
    }
}

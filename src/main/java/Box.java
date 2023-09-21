public class Box {
    private final float length;
    private final float width;
    private final float height;
    private String color;
    private BoxState state;
    private String content;

    public Box(float length, float width, float height, String color, BoxState state, String content) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.state = state;
        this.content = content;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BoxState getState() {
        return state;
    }

    public void setState(BoxState state) {
        if (this.state == state) {
            System.out.println("Box is already " + state);
        }

        this.state = state;
        if (state == BoxState.OPEN) {
            System.out.println("Box opened");
        } else {
            System.out.println("Box closed");
        }
    }

    public String getContent() {
        return content;
    }

    public void showInfo() {
        System.out.println("Length: " + length + ", width: " + width + ", height: " + height);
        System.out.println("Color: " + color + ", state: " + state + ", content: " + content);
    }

    public void putItem(String item) {
        if (state == BoxState.CLOSED) {
            System.out.println("You can't put anything in a closed box");
            return;
        }

        if (content != null) {
            System.out.println("You can't put " + item + " because there is already " + this.content + " in the box");
            return;
        }

        content = item;
        System.out.println("You put " + item + " in the box");
    }

    public void throwAwayItem() {
        if (state == BoxState.CLOSED) {
            System.out.println("You can't throw anything out of a closed box");
            return;
        }

        if (content == null) {
            System.out.println("There's nothing in the box");
            return;
        }

        System.out.println("You threw " + this.content + " out of the box");
        content = null;
    }
}

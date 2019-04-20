package lambda1;

import java.awt.*;

public class Apple {
      /** 编号 */
    private long id;
    /** 颜色 */
    private Color color;
    /** 重量 */
    private float weight;
    /** 产地 */
    private String origin;
    public Apple() {
    }
    // 省略getter和setter


    public Apple(long id, Color color, float weight, String origin) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public long getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public float getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return this.id + "==" + this.getColor() + "==" + this.getWeight();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
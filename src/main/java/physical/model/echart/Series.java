package physical.model.echart;

import java.util.List;

/**
 * created by ewang on 2018/7/7.
 */
public class Series<T> {
    public String name;

    public String type;

    public List<T> data;// 这里要用int 不能用String 不然前台显示不正常（特别是在做数学运算的时候）

    public Series(String name, String type, List<T> data) {
        super();
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<T> getData() {
        return data;
    }
}

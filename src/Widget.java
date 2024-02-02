public class Widget implements Comparable<Widget> {
    private int idNum;
    private String name;

    public Widget(int idNum, String name) {
        this.idNum = idNum;
        this.name = name;
    }

    public String toString()    {
        return name + " | " + idNum;
    }

    public int compareTo(Widget other)  {
        int diff = idNum - other.idNum;
        if(diff == 0)
            diff = name.compareTo(other.name);
        return diff;
    }
}

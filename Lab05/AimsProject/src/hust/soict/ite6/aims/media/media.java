package Lab05.AimsProject.src.hust.soict.ite6.aims.media;

import java.util.Comparator;

public abstract class media {
    private String title;
    private String category;
    private float cost;
    private int id;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
    
        if (!(obj instanceof media)) return false;
    
        media other = (media) obj;
    
        return this.title != null && this.title.equals(other.title);
    }

    public abstract String toString();

    public static final Comparator<media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost() ;
    public static final Comparator<media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle() ;

    
}

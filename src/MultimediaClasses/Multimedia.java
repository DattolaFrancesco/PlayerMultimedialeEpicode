package MultimediaClasses;

public abstract class Multimedia {
    private String title;

    public Multimedia(String title) {
        this.title = title;
    }

    // getter e setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


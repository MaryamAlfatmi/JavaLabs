public class Books {
    private String title;
    private double year;
    private double rating;

    public Books(String title, double year, double rating) {
        super();
        this.title = title;
        this.year = year;
        this.rating = rating;
        ;
    }

    public String getTitle() {
        return title;
    }

    public double getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}

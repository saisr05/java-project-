package artgallery;

public class ArtPiece implements Comparable<ArtPiece>, Cloneable {
    private String title;
    private String artist;
    private int year;
    private double price;

    public ArtPiece(String title, String artist, int year, double price) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    // Implementing Comparable to sort by title
    @Override
    public int compareTo(ArtPiece other) {
        return this.title.compareTo(other.title);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("ArtPiece[Title='%s', Artist='%s', Year=%d, Price=%.2f]", title, artist, year, price);
    }
}

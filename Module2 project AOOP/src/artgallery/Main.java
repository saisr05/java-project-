package artgallery;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Gallery gallery = new Gallery();

        // Adding art pieces
        gallery.addArtPiece(new ArtPiece("Starry Night", "Vincent van Gogh", 1889, 1000000));
        gallery.addArtPiece(new ArtPiece("Mona Lisa", "Leonardo da Vinci", 1503, 780000000));
        gallery.addArtPiece(new ArtPiece("The Persistence of Memory", "Salvador Dalí", 1931, 20000000));

        // Displaying art pieces
        System.out.println("Art Pieces in the Gallery:");
        for (ArtPiece piece : gallery) {
            System.out.println(piece);
        }

        // Sorting by title
        Collections.sort(gallery.getArtPieces());
        System.out.println("\nArt Pieces sorted by title:");
        for (ArtPiece piece : gallery) {
            System.out.println(piece);
        }

        // Sorting by price using PriceComparator
        Collections.sort(gallery.getArtPieces(), new PriceComparator());
        System.out.println("\nArt Pieces sorted by price:");
        for (ArtPiece piece : gallery) {
            System.out.println(piece);
        }

        // Cloning an art piece
        try {
            ArtPiece clonedPiece = (ArtPiece) gallery.getArtPieces().get(0).clone();
            System.out.println("\nCloned Art Piece:");
            System.out.println(clonedPiece);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

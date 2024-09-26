package artgallery;

import java.util.Comparator;

public class PriceComparator implements Comparator<ArtPiece> {
    @Override
    public int compare(ArtPiece a, ArtPiece b) {
        return Double.compare(a.getPrice(), b.getPrice());
    }
}

package artgallery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gallery implements Iterable<ArtPiece> {
    private List<ArtPiece> artPieces;

    public Gallery() {
        artPieces = new ArrayList<>();
    }

    public void addArtPiece(ArtPiece piece) {
        artPieces.add(piece);
    }

    public void removeArtPiece(ArtPiece piece) {
        artPieces.remove(piece);
    }

    @Override
    public Iterator<ArtPiece> iterator() {
        return artPieces.iterator();
    }

    public List<ArtPiece> getArtPieces() {
        return artPieces;
    }
}

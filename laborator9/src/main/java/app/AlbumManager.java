
package app;

import entity.Album;
import entity.Artist;
import java.util.List;
import repo.AlbumRepository;
import repo.ArtistRepository;

/**
 *
 * @author mikyqwe
 */
public class AlbumManager {
    public static void main (String[] args)
    {
    //    Artist artist = new Artist("Jonatan","Romania");
    //    ArtistRepository.create(artist);
    //    List<Artist> artist = ArtistRepository.findByName("miky");
     //   System.out.println(artist.get(0).getName());
        Artist artist = ArtistRepository.findByID(1);
      Album album = new Album("Jony",1999,artist) ;
    //  AlbumRepository.create(album);
      album = AlbumRepository.findByID(1);
     
      System.out.println(album.getName());
      List <Album> albums = AlbumRepository.findByName("luceafarul");
      System.out.println(albums.get(0).getName());
      List <Album> albums2 = AlbumRepository.findByArtist(artist);
      System.out.println(albums2.get(0).getName());
    }
}

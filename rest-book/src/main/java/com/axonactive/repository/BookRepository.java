package com.axonactive.repository;

import com.axonactive.enity.BookEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name = "book.genre",defaultValue = "Sci-Fi")
    String genre;
//    public List<BookEntity> getAllBook(){
//        return  List.of(
//                new BookEntity("1","Les miRable","Victor Hugo",2000,genre),
//                new BookEntity("1","The last match","lept stontote",1900,genre),
//                new BookEntity("1","dragonBall","HiroshiMa Hikaru",2010,genre),
//                new BookEntity("1","toi thay hoa vang tren co xanh","Nguyen Nhat Anh",2021,genre)
//        );
//    }

//    public int countAllBooks(){
//        return getAllBook().size();
//    }

//    public Optional<BookEntity> getBook( int id){
//        return getAllBook().stream().filter(bookEntity -> bookEntity.getId()==id).findFirst();
//    }
}

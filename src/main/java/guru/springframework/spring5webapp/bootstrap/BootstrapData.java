package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * Spring vai procurar classe que implementão isso e vai rodar elas.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository; 
    private final PublisherRepository publisherRepository;

    public BootstrapData (AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author valmir = new Author("Valmir", "Junior");
        Book dev = new Book("Dev", "233223");
        valmir.getBooks().add(dev);
        dev.getAuthors().add(valmir);

        authorRepository.save(valmir);
        bookRepository.save(dev);

        Author pedro = new Author("Pedro", "Henrique");
        Book infra = new Book("Infra", "2222222");
        pedro.getBooks().add(infra);
        infra.getAuthors().add(pedro);

        authorRepository.save(pedro);
        bookRepository.save(infra);

        System.out.println("Started in Bootstrap, favela venceu!");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher publisher = new Publisher("Rua Dom Pedro", "São Paulo", "SP", "000000x");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

    }
    
}
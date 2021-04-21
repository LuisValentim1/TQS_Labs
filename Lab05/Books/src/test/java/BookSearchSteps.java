import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSearchSteps{

        private Library l;
        private List<Book> query = new ArrayList<>();
        private Book b1;
        private int counter = 1;

        @Given("An open Library")
        public void setup(){
                l = new Library();
        }

        @Given("a book with the title {string}, written by {string}, published in {int}\\/{int}\\/{int}")
        public void a_book_with_the_title_written_by_published_in(String string, String string2, Integer int1, Integer int2, Integer int3) {
                Calendar c1 = Calendar.getInstance();
                c1.set(int1, int2, int3);
                b1 = new Book(string, string2, c1.getTime());
                l.addBook(b1);
        }

        @When("the customer searches for books published between {int} and {int}")
        public void the_customer_searches_for_books_published_between_and(Integer int1, Integer int2) {
                Calendar c1 = Calendar.getInstance();
                c1.set(int1, 1, 1);
                Calendar c2 = Calendar.getInstance();
                c2.set(int2, 1, 1);
                query = l.findBooks(c1.getTime(), c2.getTime());
        }
        @Then("{int} books should have been found")
        public void books_should_have_been_found(Integer int1) {
                assertEquals(int1, query.size());
        }
        @Then("Book {int} should have the title {string}")
        public void book_should_have_the_title(Integer int1, String string) {
                assertEquals(string, query.get(int1-1).getTitle());
        }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LibraryUpdate libraryUpdate = new LibraryUpdate();
        LibraryDelete libraryDelete = new LibraryDelete();
        LibrarySave librarySave = new LibrarySave();
        LibraryRead libraryRead = new LibraryRead();


        String input = null;

        System.out.println("Jesteś połaczoną z bazą library \n");

        while (true){
            boolean isProperFormat =false;
            System.out.println("Wybierz jedną z poniższych opcji: \n 1 - Dodaj nowy rekord \n 2 - Wyświetl wszystkie ksiązki \n 3 - Usuń rekord \n 4 - Aktualizuj rekord");


            while (!isProperFormat) {
                try {
                    input = br.readLine();



                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (input == "1" || input == "2" || input == "3" || input == "4") {
                isProperFormat = true;

                switch (input){
                    case "1":
                        System.out.println("Podaj tytuł \n");
                        String title = null;
                        try {
                            title = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj autora");
                        String author = null;
                        try {
                            author = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj ISBN");
                        String isbn = null;
                        try {
                            isbn = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj rok wydania");
                        int year = 0;
                        try {
                            year = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Book book = new Book(title,author, isbn, year);

                        librarySave.save(book);
                        System.out.println("\n");
                        break;
                    case "2":
                      System.out.println("Wybrano 2 \n");
                        libraryRead.readAll();
                        System.out.println("\n");
                        break;
                    case "3":
                        System.out.println("Wybrano 3 \n");
                        System.out.println("Podaj id rekordu, który chcesz usunąć");
                        Long id = 0L;
                        try {
                            id = Long.parseLong(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        libraryDelete.delete(id);

                        System.out.println("\n");
                        break;
                    case "4":
                        System.out.println("Wybrano 4 \n");

                        System.out.println("Podaj id \n");
                        id = 0L;
                        try {
                            id = Long.parseLong(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        System.out.println("Podaj tytuł \n");
                        title = null;
                        try {
                            title = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj autora");
                        author = null;
                        try {
                            author = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj ISBN");
                        isbn = null;
                        try {
                            isbn = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Podaj rok wydania");
                        year = 0;
                        try {
                            year = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        book = new Book(id,title,author, isbn, year);

                        libraryUpdate.update(book);

                        System.out.println("\n");
                        break;
                }


            }else{
                isProperFormat = false;
                System.out.println("Podaj wartość od 1 - 4");
            }

            }

        }



    }
}
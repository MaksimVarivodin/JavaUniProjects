package UniLabs.Lab1;

public class Book extends PaperLiterature {

    private int pages;
    private int words;
    private String authorName;
    public Book(final String name, final float price, final int pages, final int words, final String authorName){
        /*
        *
        * в этот конструктор заход происходит из любого другого конструктора в классе,
        * что позволяет расссчитывать статические поля без отдельного метода
        *
        * */
        super(name, price);
        this.pages= pages;
        this.words = words;
        this.authorName = authorName;
    }
    public Book(final int pages, final int words, final String authorName){
        this("", 0, pages, words,authorName);
    }
    public Book (){
        this(0, 0, "");
    }
    public Book(final String name, final float price){
        this(name, price, 0, 0, "");
    }
    public int getPages() {
        return pages;
    }
    public int getWords() {
        return words;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setWords(int words) {
        this.words = words;
    }
    @Override
    public String toString(){ return super.toString() +"|\t" + pages+ " pages, "+ words + " words, Author: "+ authorName;};




}

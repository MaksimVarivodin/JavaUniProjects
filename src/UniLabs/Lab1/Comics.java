package UniLabs.Lab1;

public class Comics extends PaperLiterature {
    private int pages;
    private String Illustrator;
    public Comics (final String name, final float price){
        super(name, price);
    }
    public Comics(final String Illustrator, final int pages){
        super();
        this.Illustrator = Illustrator;
        this.pages = pages;
    }
    public Comics(final String name, final float price, final String Illustrator, final int pages){
        this(name, price);
        this.Illustrator = Illustrator;
        this.pages = pages;
    }
    public Comics(){
        this("", 0);
    }

    public int getPages() {
        return pages;
    }

    public String getIllustrator() {
        return Illustrator;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setIllustrator(String illustrator) {
        this.Illustrator = illustrator;
    }
    @Override
    public String toString(){
        return super.toString()+ "|\t"+ pages + " pages, Illustrator: "+ Illustrator;
    }


}

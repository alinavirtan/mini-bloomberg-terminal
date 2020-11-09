import java.util.*;

class NewsItem{
    private String title;
    private String author;
    private String text;
    private List<String> tags;
    private int noTimesRead;

    public NewsItem(String author, String title, String text, List<String> tags){

        this.title = title;
        this.author = author;
        this.text = text;
        this.tags = tags;


    }

    public void addRead(){
        noTimesRead++;
    }

    public int getnoTimesRead(){
        return noTimesRead;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    @Override
    public String toString(){
        return title + " \n" + author + " \n" + text;
    }

}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class News{

    ArrayList<NewsItem> maxRead = new ArrayList<NewsItem>();
    HashMap<String, List<NewsItem>> tagsNews = new HashMap<String, List<NewsItem>>(); // decide what data str we need to use
    HashMap<String, List<NewsItem>> authorNews = new HashMap<String, List<NewsItem>>();

    private void sortMaxRead(){
        Collections.sort(maxRead, (n1, n2) -> n2.getnoTimesRead() - n1.getnoTimesRead());
    }
    public void addStory(String author, String title, String text, List<String> tags){
        NewsItem newitem = new NewsItem(author, title, text, tags);

        maxRead.add(newitem);

        sortMaxRead();

        for(String tag : tags){
            if(!tagsNews.containsKey(tag)){
                tagsNews.put(tag, new ArrayList<NewsItem>());
            }
            tagsNews.get(tag).add(newitem);
        }

        if(!authorNews.containsKey(author)){
            authorNews.put(author, new ArrayList<NewsItem>());
        }
        authorNews.get(author).add(newitem);


        

    }

    public void markStoryAsRead(String itemTitle){
        for (NewsItem mapElement : maxRead) { 
            if(mapElement.getTitle().equals(itemTitle)){
                mapElement.addRead();
                
                break ;
            }
        }
        sortMaxRead();
    }

    public void displayTopTenNews(){
        int counter = 0;
        for (NewsItem mapElement : maxRead) { 
            System.out.println(mapElement.toString());  
        } 

    }

    public void displayStoriesForAuthor(String author){

        for(NewsItem  item : authorNews.get(author)){
            System.out.println(item.getTitle());
        }

    }



    public void displayStoriesWithTags(List<String> listOfTags){
        HashSet<NewsItem> allTitles = new HashSet<NewsItem>();
        for(String  tag : listOfTags){
            allTitles.addAll(tagsNews.get(tag));
        }

        for(NewsItem item : allTitles){
            System.out.println(item.toString()); 
        }

    }

    public static void main(String[] args) {
        News n = new News();

        n.addStory("author1", "title1" , "text1", new ArrayList<>());
        n.addStory("author2", "title2" , "text2", new ArrayList<>());
        n.addStory("author3", "title3" , "text3", new ArrayList<>());
        n.addStory("author4", "title4" , "text4", new ArrayList<>());
        n.addStory("author5", "title5" , "text1", new ArrayList<>());
        n.addStory("author6", "title6" , "text2", new ArrayList<>());
        n.addStory("author7", "title7" , "text3", new ArrayList<>());
        n.addStory("author8", "title8" , "text4", new ArrayList<>());
        n.addStory("author9", "title9" , "text1", new ArrayList<>());
        n.addStory("author10", "title10" , "text2", new ArrayList<>());
        n.addStory("author11", "title11" , "text3", new ArrayList<>());
        n.addStory("author12", "title12" , "text4", new ArrayList<>());

        n.markStoryAsRead("title7");
        n.displayTopTenNews();
        

    }




    
}
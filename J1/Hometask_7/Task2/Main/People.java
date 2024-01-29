import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class People {
    private HashMap<String, List<String>> people = new HashMap<String, List<String>>();

    public void addMan(Man man){
        if(!people.containsKey(man.getName())){
            people.put(man.getName(), List.copyOf(man.getThings()));
        }
    }

    public List<String> getUniversalFavorites(){
        List<String> universalFavorites = new ArrayList<String>();
        AtomicBoolean check = new AtomicBoolean(true);
        for(String favorit : getAllFavorites()){
            check.set(true);
            people.forEach((name, favorites) -> {
                if(!favorites.contains(favorit))
                    check.set(false);
            });
            if(check.get())
                universalFavorites.add(favorit);
        }
        return universalFavorites;
    }

    public Set<String> getAllFavorites(){
        Set<String> allFavorites = new HashSet<String>();
        people.forEach((name, favorites) -> {
            for(String favorit : favorites){
                allFavorites.add(favorit);
            }
        });
        return allFavorites;
    }

}

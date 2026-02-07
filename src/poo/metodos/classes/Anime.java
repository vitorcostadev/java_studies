package src.poo.metodos.classes;

public class Anime {
    private String type;
    private int episodes;
    private String name;
    private String genre;
    private String studio;

    public Anime(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public Anime(String name, String studio){
        this(name);
        this.studio = studio;
    }

    // Sobrecarga de metodos --------
    public void init(String type, int episodes){
        this.episodes = episodes;
        this.type = type;
    }

    public void init(String type, int episodes, String genre){
        init(type, episodes);
        this.genre = genre;
    }

    // ---------------------------------

    public void setType(String type) { this.type = type; } 
    public String getType() { return this.type; }

    public void setEpisodes(int episodes) { this.episodes = episodes; } 
    public int getEpisodes() { return this.episodes; }

    public void setName(String name) { this.name = name; } 
    public String getName() { return this.name; }


    public void printInfo() 
    {
        System.out.println(this.type); 
        System.out.println(this.episodes);
        System.out.println(this.name);
        System.out.println(this.genre);
        System.out.println(this.studio);
    }
    
}

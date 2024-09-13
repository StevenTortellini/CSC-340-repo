package com.csc340.disneyChars;

public class DisneyCharacter {
    public String name;
    public String sourceUrl;
    public String id;

    public DisneyCharacter(String id,String name, String sourceUrl){
        this.id = id;
        this.name = name;
        this.sourceUrl = sourceUrl;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package hellojpa;


import javax.persistence.Entity;

@Entity
public class Album extends Item {
    private String artisit;
    private String etc;

    public String getArtisit() {
        return artisit;
    }

    public void setArtisit(String artisit) {
        this.artisit = artisit;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}

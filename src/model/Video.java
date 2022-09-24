package model;

public class Video extends Thing{
	private String language;
    private int duration;
    private String typeVideo;

    public Video() {
    }

    public Video(String serialNumber, String name, double cost, int manufacturingYear
                ,String language, int duration, String typeVideo) {
        super(serialNumber, name, cost, manufacturingYear);
        this.language = language;
        this.duration = duration;
        this.typeVideo = typeVideo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTypeVideo() {
        return typeVideo;
    }

    public void setTypeVideo(String typeVideo) {
        this.typeVideo = typeVideo;
    }

    @Override
    public String getDescription() {
        //Format information should be displayed on the console
    	String desc = String.format("%s%9s%2s%37s%5s%10.2f$%s%11d%8s%11s%2s%3d:%02d:%02d%2s%11s%2s",
                    "|",super.getSerialNumber(),"|",super.getName(),
                                "|",super.getCost(),"|",super.getManufacturingYear(),
                                "|",this.language,"|",this.duration/3600,this.duration%3600/60,
                                this.duration%60,"|",this.typeVideo,"|" );

        return desc;
    }
}

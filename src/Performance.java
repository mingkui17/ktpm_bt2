public class Performance {
    private String playId;
    private int audience;

    public Performance(String playId, int audience) {
        this.playId = playId;
        this.audience = audience;
    }

    public int getAudience() {
        return audience;
    }

    public String getPlayId() {
        return playId;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }
}

package filter;

public class Request {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public Request(String content) {
        this.content = content;
    }
}

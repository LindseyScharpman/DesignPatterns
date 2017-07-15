package filter;

public class Response {
    private String content;

    public Response(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Response() {
        content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }


}

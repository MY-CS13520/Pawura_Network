package src.model;

public class NewsArticle {
    private int articleId;
    private int title;
    private String description;
    private String url;
    private String publsihedDate;
    private String fetchedat; //timestam[p of article fetched to the system
   
    public NewsArticle() {
    }

    public NewsArticle(int articleId, int title, String description, String url, String publsihedDate,
            String fetchedat) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.url = url;
        this.publsihedDate = publsihedDate;
        this.fetchedat = fetchedat;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublsihedDate() {
        return publsihedDate;
    }

    public void setPublsihedDate(String publsihedDate) {
        this.publsihedDate = publsihedDate;
    }

    public String getFetchedat() {
        return fetchedat;
    }

    public void setFetchedat(String fetchedat) {
        this.fetchedat = fetchedat;
    }

    @Override
    public String toString() {
        return "NewsArticle [articleId=" + articleId + ", title=" + title + ", description=" + description + ", url="
                + url + ", publsihedDate=" + publsihedDate + ", fetchedat=" + fetchedat + "]";
    }

    

    




}

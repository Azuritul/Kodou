package kodou.model;

import java.io.Serializable;
import java.util.UUID;

public class Site implements Serializable {

    private UUID id;
    private String name;
    private String url;
    private Integer port;
    private long interval;

    public Site(String name, String url, Integer port, long interval) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.url = url;
        this.port = port;
        this.interval = interval;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", port=" + port +
                '}';
    }
}

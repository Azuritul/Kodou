package kodou.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CheckResult implements Serializable {

    private UUID id;
    private Long timestamp;
    private Site site;
    private ResultCode code;
    private long lapse;

    public CheckResult(Site site, ResultCode code) {
        this.id = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis();
        this.site = site;
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public Site getSite() {
        return site;
    }

    public ResultCode getCode() {
        return code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public long getLapse() {
        return lapse;
    }

    public void setLapse(long lapse) {
        this.lapse = lapse;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "id='" + id + '\'' +
                ", timestamp=" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(timestamp))  +
                ", target=" + site +
                ", code=" + code +
                '}';
    }
}

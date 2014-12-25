package kodou;

import kodou.model.CheckResult;
import kodou.model.ResultCode;
import kodou.model.Site;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPCodeStrategy extends Observable implements PingStrategy {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String REQUEST_METHOD = "HEAD";

    @Override
    public void addResultObserver(Observer observer) {
        addObserver(observer);
    }

    @Override
    public void isAlive(final Site site) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(site.getUrl() + ":" + site.getPort()).openConnection();
            con.setRequestMethod(REQUEST_METHOD);

            long start = System.currentTimeMillis();
            CheckResult result = resultByResponseCode(site, con);
            long lapse = System.currentTimeMillis() - start;
            result.setLapse(lapse);
            setChanged();
            notifyObservers(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CheckResult resultByResponseCode(Site site, HttpURLConnection con) throws IOException {
        logger.log(Level.INFO, String.format("%s : %s", site.getUrl(), con.getResponseMessage()));
        return con.getResponseCode() == HttpURLConnection.HTTP_OK ? new CheckResult(site, ResultCode.OK) : new CheckResult(site, ResultCode.FAIL);
    }

}



package kodou;

import kodou.model.Site;

import java.util.Observer;

/**
 * The basic interface for pinging the target website.
 * Implement this class to provide the logic for actual service check.
 */
public interface PingStrategy {
    /**
     * Added observer for the strategy.
     * @param observer
     */
    public void addResultObserver(Observer observer);

    /**
     * Acutal implementation of the check
     * @param site The representation class of the site to be monitored.
     * @return
     */
    public void isAlive(final Site site);

}

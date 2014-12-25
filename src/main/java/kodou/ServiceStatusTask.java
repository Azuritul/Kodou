package kodou;

import kodou.model.CheckResult;
import kodou.model.Site;
import kodou.handler.MailResultHandler;
import kodou.handler.ResultHandler;

import java.util.Observable;
import java.util.Observer;

public class ServiceStatusTask implements Observer, Runnable {

    private Site site;
    private PingStrategy strategy;

    public ServiceStatusTask(Site site, PingStrategy strategy) {
        this.site = site;
        this.strategy =  strategy;
    }

    private void execute() {
        strategy.addResultObserver(this);
        strategy.isAlive(site);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof CheckResult) {
            ResultHandler processor = new MailResultHandler();
            processor.execute((CheckResult) arg);
        }
    }

    @Override
    public void run() {
        execute();
    }
}

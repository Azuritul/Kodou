package kodou;

import kodou.model.Site;
import kodou.service.Service;
import kodou.service.TargetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Service<Site> service = new TargetService();
        List<Site> siteList = service.readAll();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);
        for (Site targetSite : siteList) {
            PingStrategy strategy = new HTTPCodeStrategy();
            scheduledExecutorService.scheduleAtFixedRate(new ServiceStatusTask(targetSite, strategy), 1000, targetSite.getInterval(), TimeUnit.MILLISECONDS);
        }

    }

}

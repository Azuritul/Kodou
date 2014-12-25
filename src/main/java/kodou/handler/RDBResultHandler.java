package kodou.handler;

import kodou.model.CheckResult;
import kodou.service.ResultService;
import kodou.service.Service;

public class RDBResultHandler implements ResultHandler {

    @Override
    public void execute(final CheckResult result) {
        //Todo Implement relational database insertion
        Service<CheckResult> service = new ResultService();
        service.insert(result);
    }
}

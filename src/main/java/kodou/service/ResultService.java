package kodou.service;

import kodou.model.CheckResult;

import java.util.List;

/**
 * Todo implement real backend code
 */
public class ResultService implements Service<CheckResult> {

    @Override
    public CheckResult insert(CheckResult object) {
        return object;
    }

    @Override
    public CheckResult read() {
        return null;
    }

    @Override
    public CheckResult update(CheckResult object) {
        return object;
    }

    @Override
    public void delete(CheckResult object) {

    }

    @Override
    public List<CheckResult> readAll() {
        return null;
    }
}

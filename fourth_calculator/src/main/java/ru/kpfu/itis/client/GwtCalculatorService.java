package ru.kpfu.itis.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.kpfu.itis.server.model.Operation;

@RemoteServiceRelativePath("SpringGwtServices/GwtCalculator")
public interface GwtCalculatorService extends RemoteService {
    void saveOperation(Operation operation);

    Double compute(Double a, Character mathAction);

    Double setResult(Double a, Character mathAction);
}

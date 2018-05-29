package ru.kpfu.itis.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.kpfu.itis.server.model.Operation;

public interface GwtCalculatorServiceAsync {

    void saveOperation(Operation operation, AsyncCallback<Void> async);

    void compute(Double a, Character mathAction, AsyncCallback<Double> async);

    void setResult(Double a, Character mathAction, AsyncCallback<Double> async);
}

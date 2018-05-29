package ru.kpfu.itis.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class GwtCalculatorService_Proxy extends RemoteServiceProxy implements ru.kpfu.itis.client.GwtCalculatorServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "ru.kpfu.itis.client.GwtCalculatorService";
  private static final String SERIALIZATION_POLICY ="A329DF8B3E6BBC1A718FCD66849A2853";
  private static final ru.kpfu.itis.client.GwtCalculatorService_TypeSerializer SERIALIZER = new ru.kpfu.itis.client.GwtCalculatorService_TypeSerializer();
  
  public GwtCalculatorService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "SpringGwtServices/GwtCalculator", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void compute(java.lang.Double a, java.lang.Character mathAction, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GwtCalculatorService_Proxy", "compute");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Double/858496421");
      streamWriter.writeString("java.lang.Character/2663399736");
      streamWriter.writeObject(a);
      streamWriter.writeObject(mathAction);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void saveOperation(ru.kpfu.itis.server.model.Operation operation, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GwtCalculatorService_Proxy", "saveOperation");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("ru.kpfu.itis.server.model.Operation/2055531597");
      streamWriter.writeObject(operation);
      helper.finish(async, ResponseReader.VOID);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void setResult(java.lang.Double a, java.lang.Character mathAction, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GwtCalculatorService_Proxy", "setResult");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Double/858496421");
      streamWriter.writeString("java.lang.Character/2663399736");
      streamWriter.writeObject(a);
      streamWriter.writeObject(mathAction);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}

package ru.kpfu.itis.server.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Operation_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Double getDigit(ru.kpfu.itis.server.model.Operation instance) /*-{
    return instance.@ru.kpfu.itis.server.model.Operation::digit;
  }-*/;
  
  private static native void setDigit(ru.kpfu.itis.server.model.Operation instance, java.lang.Double value) 
  /*-{
    instance.@ru.kpfu.itis.server.model.Operation::digit = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getId(ru.kpfu.itis.server.model.Operation instance) /*-{
    return instance.@ru.kpfu.itis.server.model.Operation::id;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setId(ru.kpfu.itis.server.model.Operation instance, long value) 
  /*-{
    instance.@ru.kpfu.itis.server.model.Operation::id = value;
  }-*/;
  
  private static native java.lang.Character getMathAction(ru.kpfu.itis.server.model.Operation instance) /*-{
    return instance.@ru.kpfu.itis.server.model.Operation::mathAction;
  }-*/;
  
  private static native void setMathAction(ru.kpfu.itis.server.model.Operation instance, java.lang.Character value) 
  /*-{
    instance.@ru.kpfu.itis.server.model.Operation::mathAction = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.server.model.Operation instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setDigit(instance, (java.lang.Double) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setMathAction(instance, (java.lang.Character) streamReader.readObject());
    
  }
  
  public static ru.kpfu.itis.server.model.Operation instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ru.kpfu.itis.server.model.Operation();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.server.model.Operation instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeObject(getDigit(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeObject(getMathAction(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.server.model.Operation_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.server.model.Operation_FieldSerializer.deserialize(reader, (ru.kpfu.itis.server.model.Operation)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.server.model.Operation_FieldSerializer.serialize(writer, (ru.kpfu.itis.server.model.Operation)object);
  }
  
}

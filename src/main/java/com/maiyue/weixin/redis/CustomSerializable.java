package com.maiyue.weixin.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;


public class CustomSerializable<T> implements RedisSerializer<T>{

    private static final byte[] EMPTY_ARRAY = new byte[0];
   
    public CustomSerializable(){
    }
    @Override
    public byte [] serialize(Object t) throws SerializationException {
        if (t == null) {
            return EMPTY_ARRAY;
        }
        byte[] bytes = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);
            bytes = baos.toByteArray();
            baos.close();
            oos.close();
        } catch (Exception e) {
            throw new SerializationException( "Cannot serialize" , e);
        }
        return bytes;
    }

    @SuppressWarnings("unchecked")
	@Override
    public T deserialize( byte [] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        Object object = null;
        try {
            ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(bais);
            object = ois.readObject();
            return (T)object;
        } catch (Exception ex) {
            throw new SerializationException( "Cannot deserialize" , ex);
        }
    }

    static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }
}

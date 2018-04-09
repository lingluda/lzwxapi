package com.maiyue.weixin.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

/**
 * Created by huang on 2018/01/19.
 */
public class CustomSerializable<T> implements RedisSerializer<T>{

    private static final byte[] EMPTY_ARRAY = new byte[0];
   
    
	@Override
    public byte [] serialize(Object t) throws SerializationException {
        if (t == null) {
            return EMPTY_ARRAY;
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);
            byte[] bytes = baos.toByteArray();
            baos.close();
            oos.close();
            return bytes;
        } catch (IOException e) {
            throw new SerializationException( "Cannot serialize" , e);
        }
    }

	@Override
	@SuppressWarnings("unchecked")
    public T deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T)ois.readObject();
        } catch (Exception ex) {
            throw new SerializationException( "Cannot deserialize" , ex);
        }
    }

	private static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }
}

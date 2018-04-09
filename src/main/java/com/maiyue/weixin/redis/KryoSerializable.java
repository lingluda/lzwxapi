package com.maiyue.weixin.redis;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoSerializable<T> implements RedisSerializer<T> {
    
	
	private static Logger logger = Logger.getLogger(KryoSerializable.class);

	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        try (
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return EMPTY_BYTE_ARRAY;
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        try 
        	(Input input = new Input(bytes)) {
            return (T) kryo.readClassAndObject(input);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


}

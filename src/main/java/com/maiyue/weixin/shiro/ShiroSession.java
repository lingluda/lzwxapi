package com.maiyue.weixin.shiro;

import org.apache.shiro.session.mgt.SimpleSession;
import java.io.*;

/**
 * Created by huang on 2018/01/19.
 * @param <T>
 */
public class ShiroSession extends SimpleSession implements Serializable {
   
	private static final long serialVersionUID = 3166152053355824055L;
	
	/*private static final byte[] EMPTY_ARRAY = new byte[0];

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
            baos.flush();
			baos.close();
			oos.flush();
			oos.close();
        } catch (IOException e) {
            throw new SerializationException( "Cannot serialize" , e);
        }
        return bytes;
    }

	@Override
	@SuppressWarnings("unchecked")
    public T deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        Object object = null;
        try {
            ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(bais);
            object = ois.readObject();
        } catch (Exception ex) {
            throw new SerializationException( "Cannot deserialize" , ex);
        }
		return (T)object;
    }

    private static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }*/
	

}

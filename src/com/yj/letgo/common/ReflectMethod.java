package com.yj.letgo.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectMethod {
	static String TAG = "ReflectMethod";
	private LoadMethodEx methodEx = null;

    public ReflectMethod() {
        methodEx = new LoadMethodEx();
    }
    
    private class LoadMethodEx {
        public Object loadReflectMethod(String cName,Object obj,  String MethodName, Object[] params) {
            Object retObject = null;
            Object obj_tmp = obj;
            try {
                Class<?> cls = Class.forName(cName);
                if(obj == null)
                {
    	            Constructor<?> ct = cls.getConstructor(new Class<?>[0]);
    	            obj_tmp = ct.newInstance(new Object[0]);    
    	        }
                Class<?> paramTypes[] = this.getParamTypes(cls, MethodName);
                
                Method meth = cls.getMethod(MethodName, paramTypes);
                meth.setAccessible(true);
                
                retObject = meth.invoke(obj_tmp, params);  
            } catch (Exception e) {
                System.err.println(e);
            }
            
            return retObject;
        }
        
        private Class<?>[] getParamTypes(Class<?> cls, String mName) {
            Class<?>[] cs = null;
            
            Method[] mtd = cls.getDeclaredMethods();    
            for (int i = 0; i < mtd.length; i++) {
                if (!mtd[i].getName().equals(mName)) {
                    continue;
                }
                
                cs = mtd[i].getParameterTypes();
            }
            return cs;
        }
    }

	public Object invokeStaticMethod(String className, String methodName, Object[] args){
		return methodEx.loadReflectMethod(className,null,methodName,args); 
	}

	public Object invokeCommMethod(String className, Object obj, String methodName, Object[] args){
		return methodEx.loadReflectMethod(className,obj, methodName,args);
	}
}

package com.yj.letgo.aidl;
import com.yj.letgo.aidl.ITaskCallBack;
import com.yj.letgo.aidl.Person;
interface ITaskBinder {
   void commonCall();
   void callback();
   String objectCall(in Person person);
   void registerCallBack(ITaskCallBack cb);
   void unregisterCallBack();
}
실행시 instrument module에서 manifest를 포함시키지 못해서 아래와 같은 에러가 발생하는 것으로 보임

Exception in thread "main" java.lang.reflect.InvocationTargetException
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.base/java.lang.reflect.Method.invoke(Method.java:568)
at java.instrument/sun.instrument.InstrumentationImpl.loadClassAndStartAgent(InstrumentationImpl.java:491)
at java.instrument/sun.instrument.InstrumentationImpl.loadClassAndCallPremain(InstrumentationImpl.java:503)
Caused by: java.lang.NoClassDefFoundError: javassist/NotFoundException
at com.inst.Main.premain(Main.java:19)
... 6 more
Caused by: java.lang.ClassNotFoundException: javassist.NotFoundException
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
... 7 more
*** java.lang.instrument ASSERTION FAILED ***: "result" with message agent load/premain call failed at src/java.instrument/share/native/libinstrument/JPLISAgent.c line: 422
FATAL ERROR in native method: processing of -javaagent failed, processJavaStart failed

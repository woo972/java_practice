package com.inst;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class CustomTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(
            ClassLoader loader,
            String className,
            Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain,
            byte[] classfileBuffer) {
        System.out.println("Transforming: " + className);
        System.out.println("classBeingRedefined: " + classBeingRedefined);
        return instrumentMethods(className, classfileBuffer);
    }

    private byte[] instrumentMethods(String className, byte[] classfileBuffer) {
        // Implement bytecode transformation logic to instrument methods
        // Here, you can use libraries like ASM or Byte Buddy to modify the bytecode
        // and instrument the methods according to your requirements

        byte[] byteCodes = classfileBuffer;

        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(className);
            CtMethod[] ctMethods = ctClass.getMethods();
            for(CtMethod method : ctMethods) {
                // annotation check
                Object[] annotations = method.getAnnotations();
                if(annotations != null) {
                    for (Object annotation : annotations) {
                        if(annotation == Deprecated.class) {
                            System.out.println("deprecated method is invoked");
                        }
                    }
                }
                // method check
                method.addLocalVariable("startTime", CtClass.longType);
                method.insertBefore("startTime = System.currentTimeMillis();");

                method.addLocalVariable("endTime", CtClass.longType);
                method.addLocalVariable("opTime", CtClass.longType);

                String endBlock = "endTime = System.currentTimeMillis();";
                endBlock += "opTime = (endTime-startTime)/1000;";
                endBlock += "System.out.println(\"[Application] Withdrawal operation completed in:\" + opTime + \" seconds!\");";

                method.insertAfter(endBlock);

                byteCodes = ctClass.toBytecode();
                ctClass.detach();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return byteCodes;
    }
}
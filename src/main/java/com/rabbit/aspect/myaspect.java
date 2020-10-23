package com.rabbit.aspect;

import jdk.vm.ci.meta.Value;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class myaspect {
    @AfterReturning(value = "execution(* *(..))")
    public void myaspect() {

    }
}

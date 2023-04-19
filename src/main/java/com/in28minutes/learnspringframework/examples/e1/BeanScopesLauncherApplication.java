package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
class NormalClass {
	
}
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}
@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		try(
			var context = 
					new AnnotationConfigApplicationContext
						(BeanScopesLauncherApplication.class)){
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			//com.in28minutes.learnspringframework.examples.e1.NormalClass@53f3bdbd
			//same instance returned howmany time we called
			//Singleton - One object instance per Spring IoC Container
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@34129c78
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@7d61eb55
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@222a59e6
			//each time different instance is created
			//prototype - Possibly many object instances per Spring IoC Container
		}

	}

}

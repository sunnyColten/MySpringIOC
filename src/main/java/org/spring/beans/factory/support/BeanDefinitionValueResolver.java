package org.spring.beans.factory.support;

import org.spring.beans.factory.BeanFactory;
import org.spring.beans.factory.config.RuntimeBeanReference;
import org.spring.beans.factory.config.TypedStringValue;

public class BeanDefinitionValueResolver {
	private final BeanFactory beanFactory;
	
	public BeanDefinitionValueResolver(
			BeanFactory beanFactory) {

		this.beanFactory = beanFactory;
	}
	
	public Object resolveValueIfNecessary(Object value) {
		
		if (value instanceof RuntimeBeanReference) {
			RuntimeBeanReference ref = (RuntimeBeanReference) value;			
			String refName = ref.getBeanName();			
			Object bean = this.beanFactory.getBean(refName);				
			return bean;
			
		}else if (value instanceof TypedStringValue) {
			return ((TypedStringValue) value).getValue();
		} else{
			//TODO
			throw new RuntimeException("the value " + value +" has not implemented");
		}		
	}
}

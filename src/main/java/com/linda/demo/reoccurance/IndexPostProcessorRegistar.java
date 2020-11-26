package com.linda.demo.reoccurance;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class IndexPostProcessorRegistar implements ImportBeanDefinitionRegistrar {
  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
      BeanDefinitionRegistry registry) {
    BeanDefinitionBuilder builder =
        BeanDefinitionBuilder.genericBeanDefinition(IndexPostProcessor.class);
    registry.registerBeanDefinition("indexPostProcessor", builder.getBeanDefinition());
  }
}

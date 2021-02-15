# Building a CDI 2 standalone Java application

[building-a-cdi-2-standalone-java-application](http://www.mastertheboss.com/jboss-frameworks/cdi/building-a-cdi-2-standalone-java-application)

In the second article about CDI 2 we will learn how to create a standalone J2SE application featuring CDI2. Let's get started!
Using Context Dependency Injection for J2SE application is something not totally new to developers. 
For example, before CDI 2 you could start-up the Weld CDI container using the specific classes provided by it. This needed to include at first the correct dependencies:


```
<dependency>
    <groupId>org.jboss.weld.se</groupId>
    <artifactId>weld-se</artifactId>
    <version>2.4.1.Final</version>
</dependency>
```

Then you could startup the container with like this:

```
public static void main(String[] args) throws IOException {
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();
    Application application = container.instance().select(Application.class).get();
    application.run();
    weld.shutdown();
}
```

Although that does work, it was needed to have a **standard way to boot your CDI containers**, once that you have available in your classpath the right dependencies. As CDI 2 is progressing quickly [JSR 365](https://jcp.org/aboutJava/communityprocess/pr/jsr365/index.html) to the version 2.0 let's see how you can bootstrap the Weld container with a J2SE project.

The class we will use for this purpose is javax.enterprise.inject.se.SeContainerInitializer which is a CDI container initializer for Java SE. By using it, we will be able to create an instance of a **javax.enterprise.inject.se.SeContainer** which is your gate for accessing the container in Java SE.

Let's see an HelloWorld CDI 2 example:

```
package com.mastertheboss;

import javax.enterprise.inject.spi.*;
import javax.enterprise.inject.se.*;

public class CDI2Demo {
	public static void main(String... args) {
		SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
		SeContainer container = containerInit.initialize();

		// Fire synchronous event that triggers the code in App class.
		container.getBeanManager().fireEvent(new SimpleEvent());

		container.close();
	}
}
```

So, once we have inited the SeContainer we fire a synchronous event that triggers the code in App class:









*Context and Dependency Injection* (CDI) is a specification. That means it defines an API only and does not provide an implementation. That's why you have to include an implementation such as *Weld* in order to actually use the API. The ***WeldContainer*** class is vendor-specific whereas the ***SeContainer*** interface is part of the specification. The former implements the latter.

The ***SeContainerInitializer*** class, which is part of the API, will delegate to the implementation included with the application. So if you use *Weld* as the implementation then ultimately using ***SeContainerInitializer*** and ***SeContainer*** is the same as using ***Weld*** and ***WeldContainer*** "under the hood".



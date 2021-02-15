# Building a CDI 2 standalone Java application

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

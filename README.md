## Automation test framework

For basic window launch only selenium dependency is needed.
Later create a object of webdriver interface, once done, it standalone would create a broswer session.

Mostly, the window is minimized, to maximze add function
`wd.manage().window().maximize();`

### challenges faced  
- what about stale element exception
evaded by re declaring xpath

- no element found,
scroll into view

- hardcoding
- duplicate
- test data in script, no tdd
- naming convention
- exception Handling
- synchronization: wd.findElements is not synchronized
- assertion 
- abstraction


can add sonar qube for this

## Post optimization phase
- creating page object resolved stale element exception as find element was created everytime

## testNg
It is annotation based library, where annotation is extra info attached to a class or method

add @Test to the method you want to run.
- @Test(description = "Login flow", groups = {"e2e","sanity"}), here desc is self-description and groups are a way to categorize tests.

### Script practices 
Test methods
- Test script must be small.
- Should not have conditions loops or try catch.
- Reduce use of local variables.
- At least one assertion.

### Properties
One can use Properties class and set *.properties file.
```java
File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ui\\config\\QA.properties");
FileReader fileReader = new FileReader(propFile);

Properties prop = new Properties();
prop.load(fileReader);
return prop.getProperty(key);
```

However, one can also read properties from JSON, for that gson dependency can be used.
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.

- error encountered for gson
- Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.Map.get(Object)" because the return value of "com.ui.pojo.Config.getEnvironmentMap()" is null

at com.ui.utility.JSONUtility.main(JSONUtility.java:19)

- fix
```java
// The @SerializedName annotation tells Gson to map the JSON key "environment"
    // to this field. The field name is also updated to match the getter/setter.
    @SerializedName("environment")
    Map<String,Environment> environment;

```

gson is preferred as it isolated different env without having to create different files.




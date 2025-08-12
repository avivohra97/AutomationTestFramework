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



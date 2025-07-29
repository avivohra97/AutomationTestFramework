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
- duplicacy
- test data in script, no tdd
- naming convention
- exception Handling
- syncronization: wd.findElements is not synchronized
- assertion 
- abstraction


can add sonar qube for this

# TodoMVC Test Automation Project
Browser used for testing: Chrome

Variants being tested: React, Preact

## Methods in TodoChromeTest.java, and what they're testing:

### addValidItemsAndCountTest
Assertions: 3  
First assert: When an incomplete item is added, TodoMVC correctly updates the number of items left in the status bar.  
Second assert: When an item is added, its name correctly appears in the items list.
Third assert: When all items are incomplete and the down arrow in the left of the "What needs to be done?" box is clicked, the items left in the status bar becomes 0.  



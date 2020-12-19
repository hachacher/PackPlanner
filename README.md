Hello!
The technical test was to make a pack planner dividing the items into packages as requested.
My design structure was to create an Object class for item where you can find the (id,length,quantity and weight) of each item object.
Also created a class object called Pack found in it an arraylist of the Item object with the rest of the required fields for a pack.
the package class is responsible of sorting the items inside each pack class and generating the packages sorted.
The packplanner class is the main class where it either uses the test data passed from the test or either requests
the user to input them.

#Input format:
[Sort order],[max pieces per pack],[max weight per pack]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
...
#Output format:
Pack number: [pack number]
[item id],[item length],[item quantity],[piece weight]
[item id],[item length],[item quantity],[piece weight]
...
Pack Length: [pack length], Pack Weight: [pack weight]
#STD input example: (input ends when an empty line is received or you reach the end of the input stream)
NATURAL,40,500.0
1001,6200,30,9.653
2001,7200,50,11.21
#Example output for the above input:
Pack Number: 1
1001,6200,30,9.653
2001,7200,10,11.21
Pack Length: 7200, Pack Weight: 401.69
Pack Number: 2
2001,7200,40,11.21
Pack Length: 7200, Pack Weight: 448.4
# Warmup
Edit the Warmup class.  Implement all of the methods below.  Please make sure that the signatures of all of the methods exactly match the specifications of the assignment.  The signature includes the method name, the return type, and the number of parameters and their types.

### The assignment
Method Signature 	  | Description
|----------------------------------------------------------|---|
int [] createRandomIntArray(int N, int low, int high) |	This method will create and return the address of an array of N random integers between low and high (inclusive).
int smallest(int [] array) |	This method will return the smallest value in an integer array.
int indexOfSmallest(int [] array) |	This method will return the index of the smallest value in an integer array.
boolean equalIntArrays(int [] a, int[] b) |	This method will return true if two arrays of integers that are passed to it are equal.
boolean equalStringArrays(String [] a, String[] b) |	This method will return true if two arrays of strings are equal.
int linearSearch(int [] array, int target) |	This method searches the array starting at index 0 and return the index of the first occurrence of target or -1 if target is not found in the array
int count(int [] array, int target) |	This method returns a count of the number of times target appears in the array. For example, 8 ears twice in [2, 3, 3, 3, 4, 6, 7, 8, 8, 9].   
int duplicates(int [] array) |	This method returns a count of the number of duplicate values in an array of integers.  For example, if your array is [3, 2, **3**, 8, **3**, 4, 6, 7, **8**, 9], there are three duplicates (two duplicate 3’s and one duplicate 8).
int uniques(int [] array) |	This method returns a count of the number of unique values in an array.  For example, there are seven unique values in [3, 2, 3, 8, 3, 4, 6, 7, 8, 9]
int [] returnSet(int [] array) |	This method returns a new array containing the unique values from an array of integers.  For example, if you pass the array is [3, 2, 3, 8, 3, 4, 6, 7, 8, 9], your method will return a new array containing the values (2, 3, 4, 6, 7, 8, 9) | but the order does not matter.
int mode(int [] array) |	This method returns the value that appears most frequently in an array.
int antiMode(int [] array) |	This method returns the value that appears least frequently in an array.
int longestEqualSequence(int [] array) |	This method returns the length of the longest sequence of numbers that are equal.  For example, in [6, 7, 4, 4, 8, 7, 1, 3, 3, 4, 1, 4, 4, 4, 2, 9, 1, 8, 2, 7], the longest sequence is length three: 4, 4, 4 
int biggestHill(int [] array) |	This method returns the length of the longest sequence of numbers that are strictly increasing in value (> not >=).  For example, in [6, 6, 4, 2, 9, 7, 4, 7, 2, 6, 5, 7, 5, 2, 4, 6, 9, 7, 5, 3], the longest sequence is length four: 2, 4, 6, 9
boolean mirrorImage(String s) |	This method determines whether the String s is spelled the same forward and backward.  For example, radar, mom, and abba are the same forward and backward.
int [] reverse(int [] a) |	This method returns the address of an array that contains the same values as a but in reverse order.
boolean increasing(int [] array) |	This method returns true if the values in the array are in increasing order (>=).
 
### Setup command
N/A

### Run command
`gradle test`

### Notes
- The JDK is installed on GitHub Actions machines, so you're also able to directly invoke `javac`, `java`, or any other CLI command included in the JDK. 



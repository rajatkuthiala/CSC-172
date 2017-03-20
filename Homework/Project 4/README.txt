/*
 * Rajat Kuthiala
 * Project 4
 * CSC-172
 * TA: Shuyang Liu
 * 
 */


For this lab we had to create a program that could read in a list of points and edges from a file and create a graph from them. It then had to be able to find the minimum weight spanning tree, find the shortest path between two points, and choose whether to display it graphically or just print the results. For the creation of the graph and for the shortest path, I used code from some of the previous labs, and modified it slightly. To improve runtime I put the nodes and the edges into a hash map so they could be accessed faster then if they were in a list that had to be traversed. I also ended up storing the edges in a adjacency list form as well, that was used when the nodes needed to be accessed based off one of its nodes. After I decided how to go about storing the data, I rewrote the import from file method to add the information to these data structures. After that I updated Dijkstra's algorithm to use the new data structures. I found that the way I had done it before had a terrible runtime to the point where it took over 50 minutes to run through New York State. I ended up going with a queue and this improved my runtime drastically. Once that was done, I moved on to building the minimum weight spanning tree. I once again tried consulting the book on how I might go about this, and found that it was not very helpful. I did however, end up using the wikipedia page for Prim's algorithm. This one did not have any sudo code, however I found that it gave a clearer explanation of how to approach the problem (http://en.wikipedia.org/wiki/Prim%27s_algorithm). While i believe in the end my implementation is correct, and it works for all of the smaller test cases that I made, and it appears to work correctly for the U of R map, I am honestly not sure of it works for the other given cases as it is hard to visualize at that point. Once these were done I moved on to working on the graphics. This ended up not being too hard. I created a scaling factor by dividing the width and height by the change in latitude and longitude. Then I plotted each line multiplying the latitude and longitude by the scaling factor.

Compile: javac *.java
run: java Mapping (Map name) -show -meridianmap


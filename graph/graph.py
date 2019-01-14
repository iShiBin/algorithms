from collections import deque, OrderedDict

class Graph:
    '''
    In order to implement a Graph as an Adjacency List what we need to do is define the methods our Adjacency List object will have:
    Graph() creates a new, empty graph.
    '''
    def __init__(self):
#         self.nodes = set() # all the vertexes in the graph -- could be done in the edges part
        self.connections = {} # all the connections start_vertex:{end_vertex:weigth}
        
#     def add_node(self, node):
#         self.nodes.add(node)
    
    def contains(self, v):
        return v in self.connections.keys()
        
    def connect(self, start, end, weight=1):
#         v = self.get_vertex(str(from_vertex)) or Vertex(str(from_vertex))
        if start not in self.connections:
            self.connections[start] = {end:weight} 
        else:
            self.connections[start][end] = weight
            
        if end not in self.connections:
            self.connections[end] = {}

    def get_nodes(self):
        return list(self.connections.keys())
        
#     assume there is one and only one start node (no one points to it) in the directed graph
    def get_start_node(self):
        cadidates = set(self.get_nodes())
        for end in self.connections.values():
            for k in end.keys():
                if k in cadidates:
                    cadidates.remove(k)
#         return set(self.get_nodes()) - set(end_nodes)
        if len(cadidates) != 1:
            raise LookupError
        return cadidates
        
    def paint(self):
        print(self.connections)
    
    '''
    Graph traversal: https://en.wikipedia.org/wiki/Graph_traversal
    '''
#     breadth first search
    def bfs(self, target=None):
        breadth = OrderedDict()
        visiting = deque()
        visiting.extend((self.get_start_node()))
        while visiting:
            node = visiting.popleft()
            if not breadth or node not in breadth:
                breadth[node] = None
                visiting.extend(self.connections[node].keys())
            if node == target: break
        return breadth.keys()
    
    # depth first search (DFS)
    def dfs(self, target=None):
        depth = OrderedDict()
        for start in self.get_start_node():
            self._dfs(start, depth, target)
        if not target:
            return depth.keys()
        else:
            path = list(depth.keys())
            return path[:path.index(target)+1]
     
    def _dfs(self, start, depth, target=None):
        depth[start] = None
        for next in ( self.connections[start].keys()-depth.keys() ):
            self._dfs(next, depth, target)
 

# Here comes the test code in the end           
g = Graph()
# v1 = Node(1)
g.connect(1, 2)

g.connect(1,3)
g.connect(1,4)
g.connect(2,4)
g.connect(2,5)
g.connect(3,5)
g.connect(5,4)
g.paint()

# breadth first search (BFS)

print('BFS:', g.bfs(), '. The path to node 4 is: ', g.bfs(4))

print('DFS:', g.dfs(), '. The path to node 5 is: ', g.dfs(5))
class Node():
    def __init__(self, value):
        self.value = str(value)
        self.left = None
        self.right = None
        self.height = 1
         
class AVLTree():
    def __init__(self):
        self.root = None
        
        

    def search(self, root, value):
        value = str(value)
        if(root == None):
            return None
        elif root.value == value:
            return root
        elif root.value < root.value:
            return self.search(root.left,value)
        else:
            return self.search(root.right, value)

        

    def insert(self, root, value):
        
        value = str(value)
        temp = self.search(root,value)
        if temp != None and temp.value == value:
        	return root
        
        if not root:
            return Node(value)
        elif value < root.value:
            root.left = self.insert(root.left, value)
        else:
            root.right = self.insert(root.right, value)
        root.height = 1 + max(self.getHeight(root.left),self.getHeight(root.right))
        bFactor = self.balance(root)
        if bFactor > 1:
            if value < root.left.value:
                return self.rightRotate(root)
            else:
                root.left = self.leftRotate(root.left)
                return self.rightRotate(root)
        if bFactor < -1:
            if value > root.right.value:
                return self.leftRotate(root)
            else:
                root.right = self.rightRotate(root.right)
                return self.leftRotate(root)
        return root


    
    def getHeight(self, root):
        if not root:
            return 0
        return root.height
 
    def balance(self, root):
        if not root:
            return 0
        return self.getHeight(root.left) - self.getHeight(root.right)
     
 
    def preOrder(self, root):
        if not root:
            return
        left = ""
        right = ""
        leftText = "None,"
        rightText = "None"
        if root.left:
            left = str(root.left.value)
            leftText = left + "(" + str(root.left.height) + "," + str(self.balance(root.left)) + "), "
        if root.right:
            right = str(root.right.value)
            rightText = right + "(" +str(root.right.height) + "," + str(self.balance(root.right)) + ")"
        print(str(root.value) + "(" +str(root.height) + "," + str(self.balance(root)) + "): " + leftText + rightText )
        self.preOrder(root.left)
        self.preOrder(root.right)
        return root

         
    def leftRotate(self, b):
        a = b.right
        temp = a.left
        a.left = b
        b.right = temp
        b.height = 1 + max(self.getHeight(b.left),
                           self.getHeight(b.right))
        a.height = 1 + max(self.getHeight(a.left),
                           self.getHeight(a.right))
        return a
 
     
    def rightRotate(self, b):
        a = b.left
        temp = a.right
        a.right = b
        b.left = temp
        b.height = 1 + max(self.getHeight(b.left),
                           self.getHeight(b.right))
        a.height = 1 + max(self.getHeight(a.left),
                           self.getHeight(a.right))
        return a

    def minValue(self, root):
        if root is None or root.left is None:
            return root
        return self.minValue(root.left)

    def edit(self, root, oldValue, newValue):
        temp = self.search(root, oldValue)
        print(temp != None)

        if (temp != None):
            root = self.delete(root,oldValue)
            root = self.insert(root, newValue)
            return root
        return root


         
    def delete(self, root, value):
        value = str(value)
        if not root:
            return root
        elif value < root.value:
            root.left = self.delete(root.left, value)
        elif value > root.value:
            root.right = self.delete(root.right, value)
        else:
            if root.left is None:
                temp = root.right
                root = None
                return temp
            elif root.right is None:
                temp = root.left
                root = None
                return temp
            temp = self.minValue(root.right)
            root.value = temp.value
            root.right = self.delete(root.right, temp.value)
        if root is None:
            return root
        root.height = 1 + max(self.getHeight(root.left), self.getHeight(root.right))
        bFactor = self.balance(root)
        if bFactor > 1:
            if self.balance(root.left) >= 0:
                return self.rightRotate(root)
            else:
                root.left = self.leftRotate(root.left)
                return self.rightRotate(root)
        if bFactor < -1:
            if self.balance(root.right) <= 0:
                return self.leftRotate(root)
            else:
                root.right = self.rightRotate(root.right)
                return self.leftRotate(root)
        return root




def menu():
    Tree = AVLTree()
    root = None
    while(True):
        print("""
Insert:  1
Delete:  2
Edit     3
Ausgabe: 4
      """)
        inp = input("Eingabe: ")
        if(inp == "1"):
            print("\nInsert")
            root = Tree.insert(root, input("Eingabe: "))
        elif(inp == "2"):
            print("\nDelete")
            root = Tree.delete(root, input("Eingabe: "))
        elif(inp == "3"):
            print("\nEdit")
            root = Tree.edit(root, input("Eingabe oldValue: "), input("Eingabe newValue: "))
        elif(inp == "4"):
            print("\nAusgabe")
            root = Tree.preOrder(root)
            if(root == None):
                print("None")
        else:
            print("Falsche Eingabe")



menu()


    

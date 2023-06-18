import time
import datetime
from random import choice
from string import ascii_lowercase, digits

logname = None

def quickSort(arr,log=False):
    writeLog(log,"[ENTRY] QuickSort")
    if len(arr) <= 10:
        writeLog(log,"[QuickSort] Elemente < 10  -> GOTO InsertSort")
        return insertSort(arr,log)
    return _quickSort(arr,0,len(arr) - 1,log)
    

def _quickSort(arr,u,o,log):
    if o > u:
        temp =  o - u
        if (temp >= 3):
            p = u + 2
        else: 
            p = o
        writeLog(log, "[QuickSort] Partitioniere Array von Index " + str(u) + " zu " + str(o) + " mit Pivot Index " + str(p))
        pn = zerlege(arr, u, o, p, log)
        writeLog(log, "[QuickSort] Rek. Call -> Linke Partition")
        _quickSort(arr, u, pn-1,log)
        writeLog(log, "[QuickSort] Rek. Call -> Rechte Partition")
        _quickSort(arr, pn+1, o,log)
    return arr
        

def zerlege(arr, u, o, p, log):
    writeLog(log, "[Quicksort][Entry] Zerlege")
    writeLog(log, "[Quicksort][Zerlege] Array old: " + str(arr))
    pn = u
    pv = arr[p]
    writeLog(log, "[Quicksort][Zerlege] Pivot Element: " + str(pv))
    writeLog(log, "[Quicksort][Zerlege] Tausche Pivot Element mit letztem Element ()" + str(arr[o]))
    arr[p],arr[o] = arr[o],arr[p]
    i = u
    for i in range(u, o, 1):
        writeLog(log, "[Quicksort][Zerlege] Vergleiche " + str(arr[i]) + " mit Pivot Element " + str(pv))
        if arr[i] <= pv:
            writeLog(log, "[Quicksort][Zerlege] Tausche " + str(arr[pn]) + " mit " + str(arr[i]))
            arr[pn],arr[i] = arr[i],arr[pn]
            pn += 1
    writeLog(log, "[Quicksort][Zerlege] Tausche " + str(arr[o]) + " mit " + str(arr[pn]))
    arr[o],arr[pn] = arr[pn],arr[o]
    writeLog(log, "[Quicksort][Zerlege] Array new: " + str(arr))
    writeLog(log, "[Quicksort][Zerlege] Ende")
    return pn


def insertSort(arr, log=False):
    writeLog(log,"[ENTRY] InsertSort")
    writeLog(log,"[InsertSort] OLD arr = " + str(arr))
    for i in range(1,len(arr)):
        writeLog(log,"[InsertSort] Iteration = " + str(i))
        m = arr[i]
        j = i
        fertig = False
        while not(fertig):
            writeLog(log,"[InsertSort] Vergleich || " + arr[j-1] + " > " + m)
            if arr[j-1] > m:
                writeLog(log,"[InsertSort] Tausche " + arr[j-1] + " mit " + m)
                arr[j] = arr[j-1]
                j -= 1
                if j <= 0:
                    fertig = True
            else:
                fertig = True
        arr[j] = m
    writeLog(log,"[InsertSort] NEW arr = " + str(arr))
    writeLog(log,"[InsertSort] END")
    return arr


def getMaxIndex(arr, bis):
    maxIndex = 0
    for i in range(0,bis + 1):
        if arr[i] > arr[maxIndex]:
            maxIndex = i
    return maxIndex

def selectionSort(arr, log=False):
    writeLog(log,"[ENTRY] SelectionSort")
    p = len(arr) - 1
    while p > 0:
        writeLog(log,"[SelectionSort] p = " + str(p))
        g = getMaxIndex(arr,p)
        writeLog(log,"[SelectionSort] MaxIndex = " + str(g))
        writeLog(log,"[SelectionSort] OLD arr = " + str(arr))
        arr[p],arr[g] = arr[g],arr[p]
        writeLog(log,"[SelectionSort] NEW arr = " + str(arr))
        p -= 1
    writeLog(log,"[SelectionSort] END")
    return arr


def create_logfile_name():
    current_time = datetime.datetime.now()
    timestamp = current_time.strftime("%Y-%m-%d_%H-%M-%S")
    logfile_name = f"logfile_{timestamp}.txt"
    return logfile_name

def writeLog(log: bool, txt):
    if log != True:
        return
    global logname
    if logname == None:
        logname = create_logfile_name()
    log_file = open(logname,"a")
    log_file.write(time.strftime("%d.%m.%Y %H:%M:%S", time.localtime()) + " " + txt + "\n")

def menu():
    chars = ascii_lowercase + digits
    a = [''.join(choice(chars) for _ in range(5)) for _ in range(11)]
    log = False
    text = """List
1: quickSort Timer
2: insertSort Timer
3: selectionSort Timer
4: quickSort Print
5: insertSort Print
6: selectionSort Print
7: Log On/Off
8: List"""
    
    
    while(True):
        print("Log", log)
        print(text)
        
        inp = input("Input: ")
        if(inp=="1"):
            test = list(a)
            timeStart = time.time()
            test = quickSort(test)
            timeEnd = time.time()
            print("quickSort\nLaufzeit:" + str(timeEnd - timeStart))
            input("Press Enter to continue...")
        elif(inp=="2"):
            test = list(a)
            timeStart = time.time()
            test = insertSort(test)
            timeEnd = time.time()
            print("insertSort\nLaufzeit:" + str(timeEnd - timeStart))
            input("Press Enter to continue...")
            
        elif(inp=="3"):
            test = list(a)
            timeStart = time.time()
            test = selectionSort(test)
            timeEnd = time.time()
            print("selectionSort\nLaufzeit:" + str(timeEnd - timeStart))
            input("Press Enter to continue...")

        elif(inp=="4"):
            test = list(a)
            print("quickSort")
            print(quickSort(test,log))
            input("Press Enter to continue...")
        elif(inp=="5"):
            test = list(a)
            print("insertSort")
            print(insertSort(test,log))
            input("Press Enter to continue...")
        elif(inp=="6"):
            test = list(a)
            print("selectionSort")
            print(selectionSort(test,log))
            input("Press Enter to continue...")
        elif(inp=="7"):
            if log == False:
                log = True
            else:
                log = False
        elif(inp=="8"):
            print("List")
            print(a)
            input("Press Enter to continue...")
        else:
            print("Falsche Eingabe")
            input("Press Enter to continue...")
        print("")
        
menu()


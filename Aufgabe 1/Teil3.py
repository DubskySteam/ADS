import time
import sys

values = []
_from = 0
_to = 0

def readFile():
    try:
        path = input("Enter file name >> ")
        with open(path, mode="r", encoding="utf8") as file:
            for line in file:
                values.append(line.rstrip())
        print(values)
    except(IOError):
        print("Data file not found")
        exit()

def processValues():
    n = len(values)
    additions = 0
    # Integer in Python kann abhängig von der Ram Verfügbarkeit größer werden.
    max_sum = -sys.maxsize
    try:
        t1 = time.time()
        for i in range(0, n):
            for j in range(i, n):
                sum = 0
                for k in range(i, j):
                    sum += int(values[k])
                    additions += 1
                if sum > max_sum:
                    max_sum = sum
                    _from = i
                    _to = j
        t2 = time.time()
        print("max. Teilsumme: {}".format(max_sum))
        print("erster Index: {}".format(_from))
        print("letzter Index: {}".format(_to))
        print("Additions: {}".format(additions))
        print("Runtime: {} ms".format((t2 - t1) * 1000))
    except:
        print("Data faulty")
        exit(-1)


if "__main__" == __name__:
    inp = "y"
    while inp == "y":
        values = []
        readFile()
        processValues()
        inp = input("Run again? y/n\n>> ")

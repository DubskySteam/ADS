from random import randint

coins = {
        "100e": 100.00,
        "50e": 50.00,
        "20e": 20.00,
        "10e": 10.00,
        "5e": 5.00,
        "2e": 2.00,
        "1e": 1.00,
        "50c": 0.50,
        "20c": 0.20,
        "10c": 0.10,
        "5c": 0.05,
        "2c": 0.02,
        "1c": 0.01,
    }

inventory = {
    "100e": 0,
    "50e": 0,
    "20e": 0,
    "10e": 0,
    "5e": 0,
    "2e": 0,
    "1e": 0,
    "50c": 0,
    "20c": 0,
    "10c": 0,
    "5c": 0,
    "2c": 0,
    "1c": 0,
}

def fill():
    for i in inventory:
        inventory[i] = randint(20, 30)

def greedy(toPay, given):
    change = round(given - toPay, 2)
    result = {}

    for c in coins:
        if change >= coins[c]:
            count = min(inventory[c], int(change // coins[c]))
            result[c] = count
            change -= count * coins[c]

    if change > 0:
        return "Error: Not enough coins or bills in the inventory."
    else:
        print("Change: " + result.__str__())


def main():
    fill()
    print("Inventory:")
    for i in inventory:
        print(i, inventory[i])
    print("________________")
    i = input("To pay: ")
    g = input("Payment: ")
    greedy(float(i), float(g))


if __name__ == "__main__":
    main()

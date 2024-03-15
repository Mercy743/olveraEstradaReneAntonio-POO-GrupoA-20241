import random

class Books:
    def __init__(self, title):
        self.title = title
        self.isRented = False
        self.r = random.Random()
        self.ID = self.generateBookID()
        self.rentCounter = 0
        self.owner = None

    def setRented(self, isRented):
        self.isRented = isRented

    def getTitle(self):
        return self.title

    def isRented(self):
        return self.isRented

    def getID(self):
        return self.ID

    def getRentCounter(self):
        return self.rentCounter

    def increaseCounter(self):
        self.rentCounter += 1

    def setOwner(self, owner):
        self.owner = owner

    def getOwner(self):
        return self.owner

    def rentBook(self, owner):
        self.setOwner(owner)
        self.setRented(True)
        self.rentCounter += 1
        print("El libro ha sido rentado correctamente")

    def returnBook(self):
        self.setOwner(None)
        self.setRented(False)

    def generateBookID(self):
        car = "abcdefghijklmnopqrstuvwxyz0123456789"
        com = ""
        for i in range(6):
            com += car[self.r.randint(0, len(car)-1)]
        return com


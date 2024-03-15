import random

class Users:
    def __init__(self, name, lastName, age):
        self.rentedBooks = []
        self.name = name
        self.lastName = lastName
        self.age = age
        self.ID = self.generateUserID()
        self.rentCounter = 0

    def userID(self):
        return self.ID

    def getName(self):
        return self.name

    def getLastName(self):
        return self.lastName

    def getAge(self):
        return self.age

    def getRentCounter(self):
        return self.rentCounter

    def increaseCounter(self):
        self.rentCounter += 1

    def getRentedBooks(self):
        return self.rentedBooks

    def rentBook(self, book):
        self.rentedBooks.append(book)
        self.rentCounter += 1

    def returnBook(self, book):
        self.rentedBooks.remove(book)

    def generateUserID(self):
        characters = "abcdefghijklmnopqrstuvwxyz0123456789"
        combination = "".join(random.choice(characters) for _ in range(6))
        return combination


